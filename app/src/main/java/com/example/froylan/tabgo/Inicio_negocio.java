package com.example.froylan.tabgo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Inicio_negocio extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener  {

    String id;

    //Datos a agregar de cada uno de los platillos
    int cantidadTacos = 0;
    String descripcionTacos;
    int precioTacos = 0;

    int cantidadLimonada = 0;
    String descripcionLimonada;
    int precioLimonada = 0;

    int cantidadArroz = 0;
    String descripcionArroz;
    int precioArroz = 0;

    //Datos a pasar en el Bundle
    String direccionCliente;
    String nombreCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_negocio);

        Bundle datos = getIntent().getExtras();

        nombreCliente = datos.getString("nombreCliente");
        direccionCliente = datos.getString("direccionCliente");

        BottomNavigationView navigation = findViewById(R.id.navigation_restaurant);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeResFragment() );

    }


    private boolean loadFragment(Fragment fragment){

        if(fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_restaurant, fragment)
                    .commit();

            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){

            case R.id.menu_home:
                fragment = new HomeResFragment();
                break;

            case R.id.menu_carta:
                fragment = new MenuResFragment(); //Cambiar por otro Fragment
                break;

            case R.id.menu_like:
                fragment = new ResenaResFragment(); //Cambiar por otro Fragment
                break;

            case R.id.menu_carrito:

                Bundle bundle = new Bundle();

                if(cantidadTacos != 0){
                    //insertar_datos_platillo(descripcionTacos, precioTacos, cantidadTacos);
                    bundle.putString("descripcionTacos", descripcionTacos);
                    bundle.putInt("precioTacos", precioTacos);
                    bundle.putInt("cantidadTacos", cantidadTacos);
                }

                if(cantidadLimonada != 0){
                    //insertar_datos_platillo(descripcionLimonada, precioLimonada, cantidadLimonada);
                    bundle.putString("descripcionLimonada", descripcionLimonada);
                    bundle.putInt("precioLimonada", precioLimonada);
                    bundle.putInt("cantidadLimonada", cantidadLimonada);
                }

                if(cantidadArroz != 0){
                    //insertar_datos_platillo(descripcionArroz, precioArroz, cantidadArroz);
                    bundle.putString("descripcionArroz", descripcionArroz);
                    bundle.putInt("precioArroz", precioArroz);
                    bundle.putInt("cantidadArroz", cantidadArroz);
                }

                fragment = new CarritoFragment(); //Cambiar por otro Fragment

                bundle.putString("nombreCliente", nombreCliente);
                bundle.putString("direccionCliente", direccionCliente);
                fragment.setArguments(bundle);

                break;

        }

        return loadFragment(fragment);
    }


    public void agregar_tacos_carrito(View view){

        descripcionTacos = "Orden de tacos";
        precioTacos = 80;
        cantidadTacos = cantidadTacos + 1;


        Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_SHORT).show();

        //insertar_datos_platillo();


    }

    public void agregar_limonada_carrito(View view){


        descripcionLimonada = "Limonada de 1 lt";
        precioLimonada = 20;
        cantidadLimonada = cantidadLimonada + 1;

        Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_SHORT).show();
        //insertar_datos_platillo();

    }

    public void agregar_arroz_carrito(View view){

        descripcionArroz = "Arroz con leche";
        precioArroz = 20;
        cantidadArroz = cantidadArroz + 1;

        Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_SHORT).show();
        //insertar_datos_platillo();

    }

}
