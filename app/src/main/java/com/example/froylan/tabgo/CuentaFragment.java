package com.example.froylan.tabgo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class CuentaFragment extends Fragment {

    EditText tv_nombre;
    EditText tv_correo;
    EditText tv_direccion;
    EditText tv_telefono;
    String correo;
    String contrasena;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cuenta, parent, false);

        Bundle datos = this.getArguments();

        correo = datos.getString("correo");
        contrasena = datos.getString("contrasena");

        tv_nombre = (EditText) view.findViewById(R.id.txt_nombre_cuenta);
        tv_correo = (EditText) view.findViewById(R.id.txt_correo_cuenta);
        tv_direccion = (EditText) view.findViewById(R.id.txt_direccion_cuenta);
        tv_telefono = (EditText) view.findViewById(R.id.txt_telefono_cuenta);

        mostrarDatos();

        return view;

    }

    public void mostrarDatos(){

        AdminSQLiteOpenHelper admin  = new AdminSQLiteOpenHelper(getActivity(), "tabgo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery(
                "SELECT correo, nombre, telefono, direccion FROM usuarios WHERE TRIM(correo) = '"+correo.trim()+"' AND TRIM(contrasena) = '"+contrasena.trim()+"'", null);

        if(fila.moveToFirst()){

            tv_correo.setText(fila.getString(0));
            tv_nombre.setText(fila.getString(1));
            tv_telefono.setText(fila.getString(2));
            tv_direccion.setText(fila.getString(3));
            BaseDeDatos.close();

        }else{
            Toast.makeText(getActivity(), "No se pudo cargar la informacion", Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
        }

    }


}