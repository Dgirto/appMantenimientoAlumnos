package com.example.appmantenimientoalumnos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    // definimos variables con las cuales vamos a controlar los cambios en la base de datos
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "appmantenimientoalumnos.db";
    public static final String TABLE_ALUMNOS = "alumnos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    // Evento que se ejecuta para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ALUMNOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT," +
                "direccion TEXT," +
                "fechaNacimiento TEXT," +
                "dni TEXT NOT NULL," +
                "carrera TEXT," +
                "ciclo TEXT," +
                "estado TEXT)");
    }

    // Evento que se ejecuta cuando cambia la version de la base de datos.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // primero eliminamos la tabla que tenemos y luego se agrega una nueva tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUMNOS);
        onCreate(sqLiteDatabase);
    }
}
