package com.example.angel.fiagualid.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angel.fiagualid.Entidades.Ventas;
import com.example.angel.fiagualid.R;

import java.util.List;


public class AdaptadorListarVentas extends RecyclerView.Adapter<AdaptadorListarVentas.ViewHolderAdaptadorListarVentas> {

    List<Ventas> listaVentas;

    public AdaptadorListarVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @NonNull
    @Override
    public AdaptadorListarVentas.ViewHolderAdaptadorListarVentas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //crea la vista  del layout item_list_ventas_layout
        View vista =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_ventas_layout,parent,false);

        RecyclerView.LayoutParams layoutParams=
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new ViewHolderAdaptadorListarVentas(vista);
    }
    /**
     *Este metodo se asigna los valores obtenidos en la lista a los view o componentes en el item_list_ventas_layout
     * @param holder envia la  informacion a los campos o view de  item_list_ventas_layout
     * @param position posicion del item
     */
    @Override
    public void onBindViewHolder(@NonNull AdaptadorListarVentas.ViewHolderAdaptadorListarVentas holder, int position) {
            holder.campoCodigoVenta.setText("Codigo de venta: "+listaVentas.get(position).getIdventas().toString());
            holder.campoCodigoCliente.setText("Codigo Cliente: "+listaVentas.get(position).getIdcliente().toString());
            holder.campoCodigoArticulo.setText("Codigo Articulo: "+listaVentas.get(position).getIdarticulos().toString());
            holder.campoTipoPago.setText("Tipo Pago: "+listaVentas.get(position).getIdventas().toString());
            holder.campoSerieComprobante.setText("Serie Comprobante: "+listaVentas.get(position).getSerie_comprobante().toString());
            holder.campoNroComprobante.setText("Serie Comprobante: "+listaVentas.get(position).getNro_comprobante().toString());
            holder.campoFecha.setText("Fecha: "+listaVentas.get(position).getFecha_hora().toString());
            holder.campoTotalVentas.setText("Total_Venta: "+listaVentas.get(position).getTotal_venta().toString());
            holder.campoEstado.setText("Fecha: "+listaVentas.get(position).getEstado().toString());

    }

    @Override
    public int getItemCount() {
        return listaVentas.size();
    }

    public class ViewHolderAdaptadorListarVentas extends RecyclerView.ViewHolder {

        TextView campoCodigoVenta, campoCodigoCliente,
                campoCodigoArticulo, campoTipoPago,
                campoSerieComprobante, campoNroComprobante,
        campoFecha,campoTotalVentas, campoEstado;

        public ViewHolderAdaptadorListarVentas(View itemView) {
            super(itemView);
            campoCodigoVenta = (TextView) itemView.findViewById(R.id.idTVItemIdVentasVentas);
            campoCodigoCliente= (TextView) itemView.findViewById(R.id.idTVItemIdClienteVentas);
            campoCodigoArticulo=(TextView)  itemView.findViewById(R.id.idTVItemIdArticulosVentas);
            campoTipoPago=(TextView)  itemView.findViewById(R.id.idTVItemTipo_PagoVentas);
            campoSerieComprobante=(TextView)  itemView.findViewById(R.id.idTVItemSerie_ComprobanteVentas);
            campoNroComprobante=(TextView)  itemView.findViewById(R.id.idTVItemNro_ComprobanteVentas);
            campoFecha=(TextView)  itemView.findViewById(R.id.idTVItemFecha_HoraVentas);
            campoTotalVentas=(TextView)  itemView.findViewById(R.id.idTVItemTotal_VentaVentas);
            campoEstado=(TextView)  itemView.findViewById(R.id.idTVItemEstadoVentas);

        }
    }
}
