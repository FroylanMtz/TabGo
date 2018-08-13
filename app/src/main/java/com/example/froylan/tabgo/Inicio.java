package com.example.froylan.tabgo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Inicio extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    //private Toolbar toolbar;
    String correo;
    String contrasena;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        Bundle datos = getIntent().getExtras();

        correo = datos.getString("correo");
        contrasena = datos.getString("contrasena");



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new RestaurantFragment());

    }

    private boolean loadFragment(Fragment fragment){

        if(fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }

        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){

            case R.id.navigation_restaurantes:
                fragment = new RestaurantFragment();
                break;

            case R.id.navigation_buscar:
                fragment = new BuscarFragment();
                break;

            case R.id.navigation_carrito:
                fragment = new CarritoFragment();
                break;

            case R.id.navigation_cuenta:
                fragment = new CuentaFragment();
                Bundle bundle = new Bundle();
                bundle.putString("correo", correo);
                bundle.putString("contrasena", contrasena);
                fragment.setArguments(bundle);
                break;

        }

        return loadFragment(fragment);
    }


    public void ejecutar_inicio_negocio(View view){

        Intent i = new Intent(this, Inicio_negocio.class);

        startActivity(i);

    }

    public void cerrar_sesion(View view){

        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);

    }


}
