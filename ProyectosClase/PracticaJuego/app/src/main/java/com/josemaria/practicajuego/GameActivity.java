package com.josemaria.practicajuego;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imagenCarta;
    private ImageButton botonUp, botonDown;
    private int[] cartas;
    private int contador = 0;
    private int alAux = (int) (Math.random()*12);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        instancias();
        iniciarElementos();
        acciones();
    }

    private void iniciarElementos() {
        imagenCarta.setImageResource(cartas[alAux]);
    }

    private void acciones() {
        botonUp.setOnClickListener(this);
        botonDown.setOnClickListener(this);
    }

    private void instancias() {
        cartas = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
                R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9,
                R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13};
        imagenCarta = findViewById(R.id.imagen_carta);
        botonDown = findViewById(R.id.boton_abajo);
        botonUp = findViewById(R.id.boton_arriba);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton_arriba:
                int aleatorio = (int) (Math.random() * 12);
                imagenCarta.setImageResource(cartas[aleatorio]);
                if (aleatorio < alAux) {
                    retocederPantalla();
                }
                else{
                    alAux = aleatorio;
                    contador++;
                }
                break;

            case R.id.boton_abajo:
                int aleatorio2 = (int) (Math.random() * 12);
                imagenCarta.setImageResource(cartas[aleatorio2]);
                if (aleatorio2 > alAux) {
                    retocederPantalla();
                }
                else{
                    alAux = aleatorio2;
                    contador++;
                }
                break;
        }
    }


    public void retocederPantalla() {
        Intent intent = new Intent();
        intent.putExtra("puntos", contador);

        if (getIntent().getExtras().getBoolean("practica")) {
            setResult(0,intent);
        } else {
            setResult(1,intent);
        }
        finish();
    }
}