package com.example.angel.fiagualid.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angel.fiagualid.Entidades.ArticuloL;
import com.example.angel.fiagualid.R;

import java.util.List;

public class AdaptadorListarArticulos extends RecyclerView.Adapter<AdaptadorListarArticulos.ViewHolderAdaptadorListarArticulos> {

    List<ArticuloL> listaArticulos;

    /**
     *
     * @param listaArticulos por este paramatro se recibe la lista para poder llenar la vista
     */
    public AdaptadorListarArticulos(List<ArticuloL> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    @NonNull
    @Override
    public ViewHolderAdaptadorListarArticulos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //crea la vista  del layout item_list_articulo_layout
        View vista =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_articulo_layout,parent,false);
        //crea la  vista de  RecyclerView
        RecyclerView.LayoutParams layoutParams=
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new ViewHolderAdaptadorListarArticulos(vista);
    }

    /**
     *Este metodo se asigna los valores obtenidos en la lista a los view o componentes en el item_list_articulo_layout.xml
     * @param holder envia la  informacion a los campos o view de  item_list_articulo_layout
     * @param position posicion del item
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdaptadorListarArticulos holder, int position) {
        //se limpia los campos al iniciar
        holder.campoCodigoArticulo.setText("");
        holder.campoNombreArticulo.setText("");
        holder.campoCategoriaArticulo.setText("");
        holder.campoCantidadArticulo.setText("");
        holder.campoPrecioArticulo.setText("");
        holder.campoEstadoArticulo.setText("");
        // se obtiene el titulo del valor del campo y luego se imprime
        holder.campoCodigoArticulo.setText("Codigo: "+listaArticulos.get(position).getCod_articulo().toString());
        holder.campoNombreArticulo.setText("Nombre: "+listaArticulos.get(position).getNombre().toString());
        holder.campoCategoriaArticulo.setText("Categoria: "+ listaArticulos.get(position).getIdcategoria().toString());
        holder.campoCantidadArticulo.setText("Cantidad: "+ listaArticulos.get(position).getStock().toString());
        holder.campoPrecioArticulo.setText("Precio: "+ listaArticulos.get(position).getPrecio_venta().toString());
        holder.campoEstadoArticulo.setText("Estado: "+ listaArticulos.get(position).getEstado().toString());
        /**
        holder.campoCodigoArticulo.setText(listaArticulos.get(position).getCod_articulo().toString());
        holder.campoNombreArticulo.setText(listaArticulos.get(position).getNombre().toString());
        holder.campoCategoriaArticulo.setText(listaArticulos.get(position).getIdcategoria().toString());
        holder.campoCantidadArticulo.setText(listaArticulos.get(position).getStock().toString());
        holder.campoPrecioArticulo.setText(listaArticulos.get(position).getStock().toString());
        holder.campoEstadoArticulo.setText(listaArticulos.get(position).getEstado().toString());
        **/

    }

    /**
     *
     * @return int retorna el tamaño de la lista necesario para saber cuantos item_list_articulos_se va pintar
     */
    @Override
    public int getItemCount() {
        return listaArticulos.size();
    }
    //Esta clase nos permite enlazar los elementos graficos del layout: item_list_articulo a los componentes java correpondiente
    public class ViewHolderAdaptadorListarArticulos extends RecyclerView.ViewHolder {

        TextView    campoCodigoArticulo, campoNombreArticulo,
                    campoCategoriaArticulo, campoCantidadArticulo,
                    campoPrecioArticulo, campoEstadoArticulo;

        public ViewHolderAdaptadorListarArticulos(View itemView) {
            super(itemView);
            campoCodigoArticulo =       (TextView) itemView.findViewById(R.id.idTVItemCodigoArticulo);
            campoNombreArticulo =       (TextView) itemView.findViewById(R.id.idTVItemNombreArticulo);
            campoCategoriaArticulo =    (TextView) itemView.findViewById(R.id.idTVItemCategoriaArticulo);
            campoCantidadArticulo =     (TextView) itemView.findViewById(R.id.idTVItemCantidadArticulo);
            campoPrecioArticulo =       (TextView) itemView.findViewById(R.id.idTVItemPrecioArticulo);
            campoEstadoArticulo=        (TextView) itemView.findViewById(R.id.idTVItemEstadoArticulo);

        }
    }


}
