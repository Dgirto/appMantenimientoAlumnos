package com.example.appmantenimientoalumnos.db;
import android.content.ContentValues;
import android.content.Context;
import  android.database.sqlite.SQLiteDatabase;
import  androidx.annotation.Nullable;

public class dbAlumnos extends DbHelper{

    Context context;
    public dbAlumnos(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarContactos(String nombre,String apellido,String telefono,String correo_electronico,String direccion ,String fechaNacimiento,String dni,String carrera ,String ciclo, String estado){



        
        return id;
    }
}
