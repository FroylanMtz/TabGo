package com.example.froylan.tabgo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class Inicio_negocio extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_negocio);


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
                fragment = new CarritoFragment(); //Cambiar por otro Fragment
                break;

        }

        return loadFragment(fragment);
    }

    public void agregar_tacos_carrito(View view){

    }

    public void agregar_limonada_carrito(View view){

    }

    public void agregar_arroz_carrito(View view){

    }

}
