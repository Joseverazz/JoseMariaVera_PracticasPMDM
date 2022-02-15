package com.example.josemariaexamendialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josemariaexamendialogos.utils.Jugador;

public class JugadorActivity extends AppCompatActivity {
    TextView nombre, habilidad, pais;
    ImageView foto;
    Jugador jugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);
        instancias();
        recuperarDatos();
        setearDatos();
    }

    private void setearDatos() {
        nombre.setText(jugador.getNombre());
        habilidad.setText(jugador.getHabilidad());
        pais.setText(jugador.getNacionalidad());
        foto.setImageResource(jugador.getFoto());
    }

    private void instancias() {
        nombre = findViewById(R.id.nombre_jugador);
        habilidad = findViewById(R.id.habilidad_jugador);
        pais = findViewById(R.id.nacionalidad_jugador);
        foto = findViewById(R.id.imagen_jugador);
    }

    private void recuperarDatos() {
        jugador = (Jugador) getIntent().getExtras().get("jugador");
    }
}