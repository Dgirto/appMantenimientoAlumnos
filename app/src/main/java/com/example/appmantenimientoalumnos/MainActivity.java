package com.example.appmantenimientoalumnos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import com.example.appmantenimientoalumnos.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnCrear;
    private Button btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCrear = findViewById(R.id.btnCrear);
        btnNuevo = findViewById(R.id.btnNuevo);

        // Para que detecte en el momento que hagamos clic en el boton
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamamos a nuestra clase DbHelper
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoRegistro();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuAjustes || id == R.id.menuAcercaDe) {
            mostrarEnConstruccion();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarEnConstruccion() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.mensaje_en_construccion)
                .setPositiveButton(R.string.btn_entendido, null)
                .show();
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(MainActivity.this, NuevoActivity.class);
        startActivity(intent);
    }
}
