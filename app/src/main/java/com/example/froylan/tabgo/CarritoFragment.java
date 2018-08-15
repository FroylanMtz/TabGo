package com.example.froylan.tabgo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CarritoFragment extends Fragment {

    ConstraintLayout contenedor;
    View view;
    int posX = 60;
    int posY = 350;

    String nombreCliente;
    String direccionCliente;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_carrito, parent, false);

        Bundle datos = this.getArguments();

        nombreCliente = datos.getString("nombreCliente");
        direccionCliente = datos.getString("direccionCliente");

        contenedor = (ConstraintLayout) view.findViewById(R.id.contenedor_carrito);


        if(datos.getInt("cantidadTacos") != 0)
            imprimir_platillo(datos.getInt("cantidadTacos"), datos.getString("descripcionTacos") , datos.getInt("precioTacos"));

        if(datos.getInt("cantidadLimonada") != 0)
            imprimir_platillo(datos.getInt("cantidadLimonada"), datos.getString("descripcionLimonada"), datos.getInt("precioLimonada"));

        if(datos.getInt("cantidadArroz") != 0)
            imprimir_platillo(datos.getInt("cantidadArroz"), datos.getString("descripcionArroz"), datos.getInt("precioArroz"));

        imprimir_platillo(1, "Envio a domicilio", 49);


        return view;

    }

    public void imprimir_platillo(int cantidad ,String descripcion, int precio){

        TextView platillo = new TextView(getContext());
        platillo.setText(" " + cantidad + "      " + descripcion + "       " + precio * cantidad);
        platillo.setTextSize(25);
        platillo.setX(posX);
        platillo.setY(posY);
        contenedor.addView(platillo);

        posY = posY + 70;

    }


}
