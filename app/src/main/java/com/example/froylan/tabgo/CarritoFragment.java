package com.example.froylan.tabgo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CarritoFragment extends Fragment {

    ConstraintLayout contenedor;
    View view;
    TextView unTexto;

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

        unTexto = new TextView(getContext());

        unTexto.setText(nombreCliente);

        unTexto.setTextSize(20);

        unTexto.setX(90);
        unTexto.setY(350);



        contenedor.addView(unTexto);

        return view;

    }
}
