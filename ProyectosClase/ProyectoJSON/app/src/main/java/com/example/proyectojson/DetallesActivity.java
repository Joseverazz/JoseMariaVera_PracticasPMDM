package com.example.proyectojson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectojson.utils.Equipo;

public class DetallesActivity extends AppCompatActivity {
    TextView nombre, anio, estadio;
    ImageView imagen;
    Equipo equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        instancias();
        if (getIntent().getExtras()!=null){
            recuperarDatos();
            setearDatos();
        }
    }

    
    private void setearDatos() {
        nombre.setText(equipo.getNombre());
        anio.setText("El equipo se fundo el año: "+equipo.getAnio());
        estadio.setText("Su estadio es: "+equipo.getEstadio());
        Glide.with(getApplicationContext()).load(equipo.getEscudo()).into(imagen);
    }

    private void instancias() {
        nombre = findViewById(R.id.nombre_detalle);
        anio = findViewById(R.id.anio_detalle);
        estadio = findViewById(R.id.estadio_detalle);
        imagen = findViewById(R.id.imagen_detalle);
    }

    private void recuperarDatos() {
        equipo = (Equipo) getIntent().getExtras().get("equipo");
    }
}