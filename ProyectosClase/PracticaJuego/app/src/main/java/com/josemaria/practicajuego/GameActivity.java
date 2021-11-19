package com.josemaria.practicajuego;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imagenCarta;
    private ImageButton botonUp, botonDown;
    private int[] cartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        instancias();
        iniciarElementos();
        acciones();
    }

    private void iniciarElementos() {
        imagenCarta.setImageResource(cartas[(int) (Math.random()*12)]);
    }

    private void acciones() {
        botonUp.setOnClickListener(this);
        botonDown.setOnClickListener(this);
    }

    private void instancias() {
        cartas = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9,
                R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13};
        imagenCarta = findViewById(R.id.imagen_carta);
        botonDown = findViewById(R.id.boton_abajo);
        botonUp = findViewById(R.id.boton_arriba);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton_up:
                int aleatorio = (int) (Math.random()*12);
                imagenCarta.setImageResource(cartas[aleatorio]);
            case R.id.boton_down:
                int aleatorio2 = (int) (Math.random()*12);
                imagenCarta.setImageResource(cartas[aleatorio2]);
        }
    }
}