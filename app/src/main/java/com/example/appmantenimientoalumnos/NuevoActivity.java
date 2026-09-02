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
    private EditText txtNombre, txtApellido, txtTelefono, txtCorreoElectronico, txtDireccion,
            txtFechaNacimiento, txtDni, txtCarrera, txtCiclo, txtEstado;
    private Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        // añadiendo las variables los elementos de la vista.
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtDni = findViewById(R.id.txtDni);
        txtCarrera = findViewById(R.id.txtCarrera);
        txtCiclo = findViewById(R.id.txtCiclo);
        txtEstado = findViewById(R.id.txtEstado);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dbalumno dbalumno = new Dbalumno(NuevoActivity.this);

                long id = dbalumno.insertarContactos(
                        txtNombre.getText().toString(),
                        txtApellido.getText().toString(),
                        txtTelefono.getText().toString(),
                        txtCorreoElectronico.getText().toString(),
                        txtDireccion.getText().toString(),
                        txtFechaNacimiento.getText().toString(),
                        txtDni.getText().toString(),
                        txtCarrera.getText().toString(),
                        txtCiclo.getText().toString(),
                        txtEstado.getText().toString());

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
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
        txtDni.setText("");
        txtCarrera.setText("");
        txtCiclo.setText("");
        txtEstado.setText("");
    }
}
