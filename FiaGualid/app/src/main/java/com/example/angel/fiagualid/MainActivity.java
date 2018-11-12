package com.example.angel.fiagualid;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.angel.fiagualid.Fragmentos.BienvenidaFragment;
import com.example.angel.fiagualid.Fragmentos.ListarArticulosFragment;
import com.example.angel.fiagualid.Fragmentos.ListarArticulosPorCoincidenciaFragment;
import com.example.angel.fiagualid.Fragmentos.ListarVentasPorCoincidenciaFragment;
import com.example.angel.fiagualid.Fragmentos.RegistrarArticulosFragment;
import com.example.angel.fiagualid.Fragmentos.UbicacionFragment;
import com.example.angel.fiagualid.Interfaces.IFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fav icon- ubicado en app_bar_main.xml
        /**
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        **/
        // evita que el fragmento de bienvenida se sobre ponga
        if(getSupportFragmentManager().getFragments().isEmpty()){

            //cargamos el fragmento por defecto que es el de BienenidaFragment
            android.support.v4.app.Fragment fragmentBienvenida = new BienvenidaFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,fragmentBienvenida).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //elimana la tinta que opaca los iconos
        navigationView.setItemIconTintList(null);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //fragmento
        android.support.v4.app.Fragment mfragment=null;
        boolean booleanFragment=false;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {//Registrar Articulo
            mfragment= new RegistrarArticulosFragment();
            booleanFragment=true;
        } else if (id == R.id.nav_gallery) {//Listar Todos los Aritculos
            mfragment= new ListarArticulosFragment();
            booleanFragment=true;
        } else if (id == R.id.nav_manage) {//Ubiquenos
            mfragment= new UbicacionFragment();
            booleanFragment=true;
        } else if (id == R.id.nav_slideshow) {//
            mfragment=new ListarArticulosPorCoincidenciaFragment();
            booleanFragment=true;

        } else if (id == R.id.nav_share) {
            mfragment=new ListarVentasPorCoincidenciaFragment();
            booleanFragment=true;

        }
        /**
         else if (id == R.id.nav_slideshow) {//

         } else if (id == R.id.nav_send) {

        }
             **/

        //llama el fragmento y lo reemplaza
        if(booleanFragment==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,mfragment).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
/// implements de  IFragment
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
