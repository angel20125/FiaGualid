package com.example.angel.fiagualid.Interfaces;
import com.example.angel.fiagualid.Fragmentos.BienvenidaFragment;
import com.example.angel.fiagualid.Fragmentos.ListarArticulosFragment;
import com.example.angel.fiagualid.Fragmentos.ListarArticulosPorCoincidenciaFragment;
import com.example.angel.fiagualid.Fragmentos.ListarVentasFragment;
import com.example.angel.fiagualid.Fragmentos.ListarVentasPorCoincidenciaFragment;
import com.example.angel.fiagualid.Fragmentos.RegistrarArticulosFragment;
import com.example.angel.fiagualid.Fragmentos.UbicacionFragment;

//SOLO PARA IMPLEMNTAR  LOS OnFragmentInteractionListener de
public interface IFragment extends
        RegistrarArticulosFragment.OnFragmentInteractionListener,
        ListarArticulosFragment.OnFragmentInteractionListener,
        BienvenidaFragment.OnFragmentInteractionListener,
        UbicacionFragment.OnFragmentInteractionListener,
        ListarArticulosPorCoincidenciaFragment.OnFragmentInteractionListener,
        ListarVentasFragment.OnFragmentInteractionListener,
        ListarVentasPorCoincidenciaFragment.OnFragmentInteractionListener {


}
