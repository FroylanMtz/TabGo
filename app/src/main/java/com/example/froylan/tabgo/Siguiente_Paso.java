package com.example.froylan.tabgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Siguiente_Paso extends AppCompatActivity {

    int precioTacos;
    int precioLimonada;
    int precioArroz;
    int precioEnvio = 49;
    String nombreCliente;
    String direccionCliente;

    TextView total;
    TextView direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.siguiente_paso_carrito);

        Bundle datos = getIntent().getExtras();

        precioTacos = datos.getInt("precioTacos");
        precioLimonada = datos.getInt("precioLimonada");
        precioArroz = datos.getInt("precioArroz");
        nombreCliente = datos.getString("nombreCliente");
        direccionCliente = datos.getString("direccionCliente");

        total = (TextView) findViewById(R.id.txt_total);
        direccion = (TextView) findViewById(R.id.txt_direccion);

        total.setText( "$" + ( precioTacos + precioLimonada + precioArroz + precioEnvio ) + " Pesos" );

        direccion.setText(direccionCliente);

    }

    public void ejecutar_pagar_cuenta(View view){

        Intent i = new Intent(this, Pagar_Cuenta.class);
        startActivity(i);

    }




}
