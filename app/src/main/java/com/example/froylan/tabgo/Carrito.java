package com.example.froylan.tabgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class Carrito extends Activity {

    Intent i;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_restaurantes:
                    i = new Intent(getBaseContext(), Restaurantes.class);
                    startActivity(i);
                    return true;


                case R.id.navigation_buscar:
                    i = new Intent(getBaseContext(), Buscar.class );
                    startActivity(i);
                    return true;

                case R.id.navigation_carrito:
                    i = new Intent(getBaseContext(), Carrito.class);
                    startActivity(i);
                    return true;


                case R.id.navigation_cuenta:
                    i = new Intent(getBaseContext(), Cuenta.class);
                    startActivity(i);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //navigation.setSelectedItemId(R.id.navigation_carrito);
    }

}
