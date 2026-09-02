package com.example.appmantenimientoalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import com.example.appmantenimientoalumnos.db.DbAlumnos;

public class NuevoActivity extends AppCompatActivity {

    // Asignar nuestras variables
    private EditText txtNombre, txtApellido, txtTelefono, txtCorreoElectronico, txtDireccion,
            txtFechaNacimiento, txtDni, txtCarrera, txtCiclo, txtEstado;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(view -> finish());

        // añadiendo las variables a los elementos de la vista
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
        btnGuardar = findViewById(R.id.btnGuardar);

        // autoformatea la fecha a DD-MM-AAAA mientras el usuario escribe los numeros
        txtFechaNacimiento.addTextChangedListener(new FechaTextWatcher(txtFechaNacimiento));

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbAlumnos dbAlumnos = new DbAlumnos(NuevoActivity.this);

                long id = dbAlumnos.insertarContactos(
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
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar() {
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

    // Va agregando los guiones automaticamente mientras el usuario escribe: DD-MM-AAAA
    private static class FechaTextWatcher implements TextWatcher {
        private final EditText editText;
        private boolean actualizando;

        FechaTextWatcher(EditText editText) {
            this.editText = editText;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (actualizando) {
                return;
            }

            String soloDigitos = s.toString().replaceAll("[^\\d]", "");
            if (soloDigitos.length() > 8) {
                soloDigitos = soloDigitos.substring(0, 8);
            }

            StringBuilder formateado = new StringBuilder();
            for (int i = 0; i < soloDigitos.length(); i++) {
                if (i == 2 || i == 4) {
                    formateado.append("-");
                }
                formateado.append(soloDigitos.charAt(i));
            }

            actualizando = true;
            editText.setText(formateado.toString());
            editText.setSelection(formateado.length());
            actualizando = false;
        }
    }
}
