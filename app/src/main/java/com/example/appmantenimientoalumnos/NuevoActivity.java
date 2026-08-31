package com.example.appmantenimientoalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmantenimientoalumnos.db.Dbalumno;

public class NuevoActivity extends AppCompatActivity {

    // Asignar nuestras variables
    private EditText txtnombre, txtTelefono, txtCorreoElectronico;
    private Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        // añadiendo las variables los elementos de la vista.
        txtnombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dbalumno dbalumno = new Dbalumno(NuevoActivity.this);

                long id = dbalumno.insertarContactos(
                        txtnombre.getText().toString(),
                        txtTelefono.getText().toString(),
                        txtCorreoElectronico.getText().toString());

                if (id > 0) {
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    Limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void Limpiar() {
        txtnombre.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
    }
}