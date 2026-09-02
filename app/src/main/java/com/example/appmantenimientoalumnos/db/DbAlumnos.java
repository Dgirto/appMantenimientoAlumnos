package com.example.appmantenimientoalumnos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.appmantenimientoalumnos.model.Alumno;

import java.util.ArrayList;

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
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<Alumno> mostrarAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT id, nombre, apellido, telefono, correo_electronico, direccion, " +
                        "fechaNacimiento, dni, carrera, ciclo, estado " +
                        "FROM " + TABLE_ALUMNOS + " ORDER BY id DESC",
                null
        );

        if (cursor.moveToFirst()) {
            do {
                Alumno alumno = new Alumno(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10)
                );
                listaAlumnos.add(alumno);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaAlumnos;
    }
}
