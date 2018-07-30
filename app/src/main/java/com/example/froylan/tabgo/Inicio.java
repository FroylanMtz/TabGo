package com.example.froylan.tabgo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;


import android.support.v7.app.AppCompatActivity;


public class Inicio extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        //toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //setSupportActionBar(toolbar);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new RestaurantFragment());
        //navigation.setSelectedItemId(R.id.navigation_restaurantes);


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
                break;

        }

        return loadFragment(fragment);
    }
}
