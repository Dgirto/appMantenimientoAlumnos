package com.example.appmantenimientoalumnos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmantenimientoalumnos.model.Alumno;

import java.util.ArrayList;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private final ArrayList<Alumno> listaAlumnos;

    public AlumnoAdapter(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alumno, parent, false);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        Alumno alumno = listaAlumnos.get(position);
        holder.txtNombreCompleto.setText(alumno.getNombre() + " " + alumno.getApellido());
        holder.txtDni.setText("DNI: " + alumno.getDni());
        holder.txtTelefono.setText("Teléfono: " + alumno.getTelefono());
        holder.txtCorreo.setText("Correo: " + valor(alumno.getCorreoElectronico()));
        holder.txtDireccion.setText("Dirección: " + valor(alumno.getDireccion()));
        holder.txtFechaNacimiento.setText("Fecha de nacimiento: " + valor(alumno.getFechaNacimiento()));
        holder.txtCarrera.setText("Carrera: " + valor(alumno.getCarrera()));
        holder.txtCicloEstado.setText("Ciclo: " + valor(alumno.getCiclo()) +
                "  |  Estado: " + valor(alumno.getEstado()));
    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    private String valor(String texto) {
        return texto == null || texto.trim().isEmpty() ? "Sin datos" : texto;
    }

    static class AlumnoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreCompleto, txtDni, txtTelefono, txtCorreo, txtDireccion,
                txtFechaNacimiento, txtCarrera, txtCicloEstado;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreCompleto = itemView.findViewById(R.id.txtNombreCompleto);
            txtDni = itemView.findViewById(R.id.txtDniAlumno);
            txtTelefono = itemView.findViewById(R.id.txtTelefonoAlumno);
            txtCorreo = itemView.findViewById(R.id.txtCorreoAlumno);
            txtDireccion = itemView.findViewById(R.id.txtDireccionAlumno);
            txtFechaNacimiento = itemView.findViewById(R.id.txtFechaNacimientoAlumno);
            txtCarrera = itemView.findViewById(R.id.txtCarreraAlumno);
            txtCicloEstado = itemView.findViewById(R.id.txtCicloEstado);
        }
    }
}
