package com.example.angel.fiagualid.Fragmentos;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.angel.fiagualid.Adaptador.AdaptadorListarArticulos;
import com.example.angel.fiagualid.Adaptador.AdaptadorListarVentas;
import com.example.angel.fiagualid.Entidades.ArticuloL;
import com.example.angel.fiagualid.Interfaces.IConstante;
import com.example.angel.fiagualid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListarArticulosPorCoincidenciaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListarArticulosPorCoincidenciaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarArticulosPorCoincidenciaFragment extends Fragment
        implements Response.Listener<JSONObject>, Response.ErrorListener,IConstante {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    EditText campoNombreArticulo, campoCodigoArticulo,
            campoCategoriaArticulo, campoEstadoArticulo,
            campoPrecio, campoCantidad;
    Button botonBuscar;
    RecyclerView recyclerViewListarArticulosPorCoincidencias;//ordena los datos de forma grafica de lista
    ProgressDialog progressDialog;//muestra una barra de carga cuando se esta ejecutando la tarea

    ArrayList<ArticuloL> listaArticulos;//en este objetos se guardan los datos
    //datos que permiten recuperar el Objeto JSONObject que nos retorna el servicio Web
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public ListarArticulosPorCoincidenciaFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListarArticulosPorCoincidenciaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListarArticulosPorCoincidenciaFragment newInstance(String param1, String param2) {
        ListarArticulosPorCoincidenciaFragment fragment = new ListarArticulosPorCoincidenciaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //se cre la vista de este fragment
        View vista =inflater.inflate(R.layout.fragment_listar_articulos_por_coincidencia, container, false);
        //Enlazamos nuestro componentes view como boton y editText
        campoNombreArticulo = vista.findViewById(R.id.idEdiTextNombreArticuloBuscar);
        campoCodigoArticulo=     vista.findViewById(R.id.idEditTextCodigoArticuloBuscar);
        campoCategoriaArticulo=  vista.findViewById(R.id.idEditTextCategoriaArticuloBuscar);
        campoEstadoArticulo =    vista.findViewById(R.id.idEditTextEstadoBuscar);
        campoPrecio=             vista.findViewById(R.id.idEditTextPrecioBuscar);
        campoCantidad=           vista.findViewById(R.id.idEditTextCantidadBuscar);
        botonBuscar=          vista.findViewById(R.id.idBotonBuscar);

        //Enlazamos nuestro recycler ubicado en layout fragament_listar_articulos_por_coincidencia.xml
        recyclerViewListarArticulosPorCoincidencias= vista.findViewById(R.id.idRecyclerListarAritculosPorCoincidencia);
        recyclerViewListarArticulosPorCoincidencias.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewListarArticulosPorCoincidencias.setHasFixedSize(true);


        listaArticulos= new ArrayList<>();//inicializamos la lista, que guardara cada objeto Obtenido del JSONOBject



        requestQueue = Volley.newRequestQueue(getContext());//indicamosa volley una nueva peticion y el contexto  que sera en este fragment

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cargaWebServices();
            }
        });
        return vista;
    }

    private void cargaWebServices() {
        //Se muestra una barra de progreso mientras se realiza la operacion
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Consultando...");
        progressDialog.show();

        //indicamos la direccion de nuestro servicio, y cargamos  la nueva peticion

       // String url="http://192.168.1.5/servicioWeb/wsJSONConsultaPorArticulo.php?nombre="+campoNombreArticulo.getText().toString();
        String url="http://"+HOSTNAME+"/servicioWeb/wsJSONConsultaPorArticulo.php?nombre="+campoNombreArticulo.getText().toString()+"&cod_articulo="+campoCodigoArticulo.getText().toString()+"&idcategorias="+campoCategoriaArticulo.getText().toString()+"&estado="+campoEstadoArticulo.getText().toString()+"&stok="+campoCantidad.getText().toString()+"&precio_venta="+campoPrecio.getText().toString();
        url=url.replace(" ","%20");

        // se construye una peticion solicitando el JSONOBject que nos retornar nuestro servicio
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);

        requestQueue.add(jsonObjectRequest);//enviamos la peticion


    }

    //este metodo se ejecuta si se pudo hacer la consulta
    @Override
    public void onResponse(JSONObject response) {

        ArticuloL articulo= null;   //este objeto articulo nos servira para a los datos del JSONArray que nos envia el webservices
        JSONObject jsonObject =null; //Este objeto sirve para obtener el valor  de cada campo del obejto JSONObject que se encuentra en cada posicion del JSONArray
        JSONArray jsonArray = response.optJSONArray("articulos"); // obtenemos el JSONObject enviado de nuestra bases de datos

        listaArticulos.clear();
        try{
            for (int i=0; i<jsonArray.length();i++){
                articulo = new ArticuloL();                  // instanciamo un nuevo articulo en cada iteracion, y luego lo agregamos a lista de arreglos "ArrayList<ArticuloL> listaArticulos"
                jsonObject= jsonArray.getJSONObject(i);      // se recorre  el JSONArray en cada una de sus posiciones para obetener el objeto json (OBJECTJson) nos da el servicio Web

                //se asigna el valor que contiene JSONObject a  nuestra instancia articulo, con el fin de asignarlo luego nuestros componentes para visualizar
                articulo.setIdcategoria(jsonObject.optInt("idcategorias"));
                articulo.setNombre(jsonObject.optString("nombre"));
                articulo.setCod_articulo(jsonObject.optString("cod_articulo"));
                articulo.setPrecio_venta(jsonObject.optDouble("precio_venta"));
                articulo.setStock(jsonObject.optInt("stock"));
                articulo.setEstado(jsonObject.optString("estado"));
                listaArticulos.add(articulo);
            }
            progressDialog.hide();
            AdaptadorListarArticulos adaptadorListarArticulos =new AdaptadorListarArticulos(listaArticulos);
            recyclerViewListarArticulosPorCoincidencias.setAdapter(adaptadorListarArticulos);

        }catch (JSONException e){
            e.printStackTrace();
            Toast.makeText(getContext(),"NO SE PUDO ESTABLECER CONEXION, MOTIVOS: "+response,Toast.LENGTH_LONG).show();
            progressDialog.hide();
        }




            /**
            Toast.makeText(getContext(),"Mensaje"+response,Toast.LENGTH_LONG).show();
            progressDialog.hide();
             **/
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"NO SE PUDO CONSULTAR LA LISTA ARTICULOS, MOTIVOS: "+error.toString(),Toast.LENGTH_LONG).show();
        Log.d("ServicioWebError",error.toString());
        progressDialog.hide();

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
