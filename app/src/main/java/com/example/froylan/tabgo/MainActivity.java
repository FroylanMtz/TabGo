package com.example.froylan.tabgo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_correo, et_contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et_correo = (EditText) findViewById(R.id.txt_correo);
        et_contrasena = (EditText) findViewById(R.id.txt_contrasena);

    }

    public void iniciar_sesion(View view){

        AdminSQLiteOpenHelper admin  = new AdminSQLiteOpenHelper(this, "tabgo", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String correo = et_correo.getText().toString();
        String contrasena = et_contrasena.getText().toString();

        Cursor fila = BaseDeDatos.rawQuery(
                "SELECT * FROM usuarios WHERE TRIM(correo) = '"+correo.trim()+"' AND TRIM(contrasena) = '"+contrasena.trim()+"'", null);

        if(fila.moveToFirst()){

            ejecutar_inicio();
            BaseDeDatos.close();

        }else{
            Toast.makeText(this, "Error al iniciar, verifique los datos", Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
        }

    }


    public void ejecutar_inicio(){

        Intent i = new Intent(this, Inicio.class);

        startActivity(i);

    }

    public void ejecutar_registro(View view){

        Intent i = new Intent(this, Registro.class);

        startActivity(i);

    }

    public void ejecutar_inicio_repartidor(View view){

        Intent i = new Intent(this, Inicio_Repartidor.class);

        startActivity(i);

    }

    public void  ejecutar_inicio_restaurante(View view){

        Intent i = new Intent(this, Inicio_Restaurante.class);

        startActivity(i);

    }

}
