package com.example.angel.fiagualid.Fragmentos;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.angel.fiagualid.Interfaces.IConstante;
import com.example.angel.fiagualid.R;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrarArticulosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrarArticulosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarArticulosFragment extends Fragment
        implements Response.Listener<JSONObject>,Response.ErrorListener, IConstante{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    /**/
    EditText campoNombreArticulo, campoCodigoArticulo,
            campoCategoriaArticulo, campoEstadoArticulo,
            campoPrecio, campoCantidad;
    Button botonRegistro;
    ProgressDialog progressDialog;

    //Nos permite hacer la conexion con nuestro web services.
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public RegistrarArticulosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrarArticulosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrarArticulosFragment newInstance(String param1, String param2) {
        RegistrarArticulosFragment fragment = new RegistrarArticulosFragment();
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
        // Inflate the layout for this fragment
        View vistaRegistrarArticulos=inflater.inflate(R.layout.fragment_registrar_articulos, container, false);
        //Instancias de los componente  de la vista RegistarArticulosFragment
        campoNombreArticulo=     vistaRegistrarArticulos.findViewById(R.id.idEdiTextNombreArticulo);
        campoCodigoArticulo=     vistaRegistrarArticulos.findViewById(R.id.idEditTextCodigoArticulo);
        campoCategoriaArticulo=  vistaRegistrarArticulos.findViewById(R.id.idEditTextCategoriaArticulo);
        campoEstadoArticulo =    vistaRegistrarArticulos.findViewById(R.id.idEditTextEstado);
        campoPrecio=             vistaRegistrarArticulos.findViewById(R.id.idEditTextPrecio);
        campoCantidad=           vistaRegistrarArticulos.findViewById(R.id.idEditTextCantidad);
        botonRegistro=          vistaRegistrarArticulos.findViewById(R.id.idBotonRegistrar);

        requestQueue = Volley.newRequestQueue(getContext());

        //Evento del boton para cargar el servicio que lee en la bases de datos
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(campoNombreArticulo.getText().toString().isEmpty() ||
                        campoCodigoArticulo.getText().toString().isEmpty() ||
                        campoCategoriaArticulo.getText().toString().isEmpty() ||
                        campoEstadoArticulo.getText().toString().isEmpty() ||
                        campoPrecio.getText().toString().isEmpty()||
                        campoCantidad.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Todos los campos son necesarios",Toast.LENGTH_LONG).show();
                }
                else{
                    cargarWebServices();
                }


            }
        });


        return vistaRegistrarArticulos;
    }

    private void cargarWebServices() {

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        //URL de nuestro servicio Web, tambien este objeto contiene la petición que se la hará al servicio web
       // String url="http://192.168.1.5/servicioWeb/wsJSONRegistrarArticulo.php?idcategorias="+campoCategoriaArticulo.getText()+"&nombre="+campoNombreArticulo.getText().toString()+"&cod_articulo="+campoCodigoArticulo.getText().toString()+"&precio_venta="+campoPrecio.getText()+"&stock="+campoCantidad.getText()+"&estado="+campoEstadoArticulo.getText().toString();
        String url="http://"+HOSTNAME.toString()+"/servicioWeb/wsJSONRegistrarArticulo.php?idcategorias="+campoCategoriaArticulo.getText()+"&nombre="+campoNombreArticulo.getText().toString()+"&cod_articulo="+campoCodigoArticulo.getText().toString()+"&precio_venta="+campoPrecio.getText()+"&stock="+campoCantidad.getText()+"&estado="+campoEstadoArticulo.getText().toString();
        //se envia la url a volley para que la lea y  para que procese la información
        /**jsonObjectRequest intentan conectarse al servicio web y si tiene existo llama al metodo  "public void onResponse(JSONObject response)"
         * si no llama al metodo "public void onErrorResponse(VolleyError error)"
         * */
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        requestQueue.add(jsonObjectRequest);

    }

    //interfeaces de Volley
    //Sí todo esta corrceto, este metodo muestra un mensaje y limpia los campos
    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(getContext(),"Se ha registrado el articulo",Toast.LENGTH_LONG).show();
        progressDialog.hide();
        campoNombreArticulo.setText("");
        campoCodigoArticulo.setText("");
        campoEstadoArticulo.setText("");
        campoCantidad.setText("");
        campoPrecio.setText("");

        campoCategoriaArticulo.setText("");
    }
    //No logro conectarse a la bases de datos el servicio, se ejecuta este método
    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.hide();
        Toast.makeText(getContext(),"NO se ha registrado el articulo"+error.toString(),Toast.LENGTH_LONG).show();
        Log.i("ServicioWebError",error.toString());
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
