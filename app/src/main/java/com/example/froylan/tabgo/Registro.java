package com.example.froylan.tabgo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText et_nombre, et_correo, et_telefono, et_contrasena, et_direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        et_nombre = (EditText) findViewById(R.id.txt_nombre_registro);
        et_correo = (EditText) findViewById(R.id.txt_correo_registro);
        et_telefono = (EditText) findViewById(R.id.txt_telefono_registro);
        et_contrasena = (EditText) findViewById(R.id.txt_contrasena_registro);
        et_direccion = (EditText) findViewById(R.id.txt_direccion_registro);

    }

    public void guardarDatos(View view){

        AdminSQLiteOpenHelper admin  = new AdminSQLiteOpenHelper(this, "tabgo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String correo = et_correo.getText().toString();
        String telefono = et_telefono.getText().toString();
        String contrasena = et_contrasena.getText().toString();
        String direccion = et_direccion.getText().toString();

        if(!nombre.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !contrasena.isEmpty() && !direccion.isEmpty()){

            if (!estaRegistrado(correo)){

                ContentValues registro = new ContentValues();
                registro.put("nombre", nombre);
                registro.put("correo", correo);
                registro.put("telefono", telefono);
                registro.put("contrasena", contrasena);
                registro.put("direccion", direccion);

                BaseDeDatos.insert("usuarios", null, registro);

                BaseDeDatos.close();

                et_nombre.setText("");
                et_correo.setText("");
                et_telefono.setText("");
                et_contrasena.setText("");
                et_direccion.setText("");

                Toast.makeText(this, "Registro realizado con exito", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "No se realizo el registro", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean estaRegistrado(String correo){

        AdminSQLiteOpenHelper admin  = new AdminSQLiteOpenHelper(this, "tabgo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        Cursor fila = BaseDeDatos.rawQuery("SELECT * FROM usuarios WHERE TRIM(correo) = '"+correo.trim()+"'", null);

        if(fila.moveToFirst()){
            Toast.makeText(this, "Ya existe un usuario con ese correo", Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
            return true;

        }else{
            BaseDeDatos.close();
            return false;
        }

    }

}
