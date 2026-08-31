package com.example.appmantenimientoalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appmantenimientoalumnos.db.Dbhelper;

public class MainActivity extends AppCompatActivity {

    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);

        // Para que detecte en el momento que hagamos clic en el botón
        // OnClickListener implementando el metodo
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamamos a nuestra clase dbHelper
                Dbhelper dbHelper = new Dbhelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // creamos un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // "menu_principal" es el nombre del XML
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
}