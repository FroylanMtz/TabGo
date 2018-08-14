package com.example.froylan.tabgo;

import android.content.ContentValues;
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
    int cantidad = 0;
    String platillo;
    int precio;

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

                insertar_datos_orden();

                fragment = new CarritoFragment(); //Cambiar por otro Fragment

                Bundle bundle = new Bundle();
                bundle.putString("nombreCliente", nombreCliente);
                bundle.putString("direccionCliente", direccionCliente);
                fragment.setArguments(bundle);

                break;

        }

        return loadFragment(fragment);
    }

    public void insertar_datos_orden(){
        AdminSQLiteOpenHelper admin  = new AdminSQLiteOpenHelper(this, "tabgo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues registroOrden = new ContentValues();
        registroOrden.put("id", nombreCliente);
        registroOrden.put("nombre", nombreCliente);
        registroOrden.put("direccion", direccionCliente);
        BaseDeDatos.insert("ordenes", null, registroOrden);

        BaseDeDatos.close();
    }

    public void insertar_datos_platillo(){
        AdminSQLiteOpenHelper admin  = new AdminSQLiteOpenHelper(this, "tabgo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues registroPlatillo = new ContentValues();
        registroPlatillo.put("id", nombreCliente);
        registroPlatillo.put("nombre", platillo);
        registroPlatillo.put("precio", precio);
        registroPlatillo.put("cantitad", cantidad);
        BaseDeDatos.insert("platillos", null, registroPlatillo);

        Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_SHORT).show();

        BaseDeDatos.close();
    }

    public void agregar_tacos_carrito(View view){


        platillo = "Orden de tacos";
        precio = 80;
        cantidad = cantidad + 1;
        insertar_datos_platillo();

    }

    public void agregar_limonada_carrito(View view){


        platillo = "Limonada de 1 lt";
        precio = 20;
        cantidad = cantidad + 1;
        insertar_datos_platillo();

    }

    public void agregar_arroz_carrito(View view){

        platillo = "Arroz con leche";
        precio = 20;
        cantidad = cantidad + 1;
        insertar_datos_platillo();

    }

}
