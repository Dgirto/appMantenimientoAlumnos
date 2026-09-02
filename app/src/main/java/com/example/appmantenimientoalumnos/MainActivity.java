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

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import com.example.appmantenimientoalumnos.db.DbAlumnos;
import com.example.appmantenimientoalumnos.db.DbHelper;
import com.example.appmantenimientoalumnos.model.Alumno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnCrear;
    private Button btnNuevo;
    private Button btnVerRegistros;
    private RecyclerView rvRegistros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCrear = findViewById(R.id.btnCrear);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnVerRegistros = findViewById(R.id.btnVerRegistros);
        rvRegistros = findViewById(R.id.rvRegistros);

        rvRegistros.setLayoutManager(new LinearLayoutManager(this));

        // Para que detecte en el momento que hagamos clic en el boton
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamamos a nuestra clase DbHelper
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                    db.close();
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

        btnVerRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rvRegistros.getVisibility() == View.VISIBLE) {
                    rvRegistros.setVisibility(View.GONE);
                    btnVerRegistros.setText("Ver Registros");
                } else {
                    cargarRegistros();
                    rvRegistros.setVisibility(View.VISIBLE);
                    btnVerRegistros.setText("Ocultar Registros");
                }
            }
        });
    }

    private void cargarRegistros() {
        DbAlumnos dbAlumnos = new DbAlumnos(this);
        ArrayList<Alumno> listaAlumnos = dbAlumnos.mostrarAlumnos();

        AlumnoAdapter adapter = new AlumnoAdapter(listaAlumnos);
        rvRegistros.setAdapter(adapter);

        if (listaAlumnos.isEmpty()) {
            Toast.makeText(this, "NO HAY REGISTROS GUARDADOS", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (rvRegistros != null && rvRegistros.getVisibility() == View.VISIBLE) {
            cargarRegistros();
        }
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
