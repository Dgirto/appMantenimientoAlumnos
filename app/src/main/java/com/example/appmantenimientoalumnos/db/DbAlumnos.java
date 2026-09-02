package com.example.appmantenimientoalumnos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

public class DbAlumnos extends DbHelper {

    Context context;

    public DbAlumnos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContactos(String nombre, String apellido, String telefono, String correo_electronico,
                                   String direccion, String fechaNacimiento, String dni, String carrera,
                                   String ciclo, String estado) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // agregamos la funcion insertar los registros
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);
            values.put("direccion", direccion);
            values.put("fechaNacimiento", fechaNacimiento);
            values.put("dni", dni);
            values.put("carrera", carrera);
            values.put("ciclo", ciclo);
            values.put("estado", estado);

            // nos va a regresar el id insertado
            id = db.insert(TABLE_ALUMNOS, null, values);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
}
