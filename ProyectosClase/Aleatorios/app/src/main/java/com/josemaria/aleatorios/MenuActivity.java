package com.josemaria.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.EventListener;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnDados, btnGanador, btnAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        instancias();
        acciones();
    }

    private void acciones() {
        btnAleatorio.setOnClickListener(this);
        btnGanador.setOnClickListener(this);
        btnDados.setOnClickListener(this);
    }

    private void instancias() {
        btnAleatorio = findViewById(R.id.boton_aleatorio);
        btnDados = findViewById(R.id.boton_dados);
        btnGanador = findViewById(R.id.boton_ganador);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boton_aleatorio){
            Intent intent = new Intent(getApplicationContext(),AleatoriosActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.boton_ganador){
            Intent intent = new Intent(getApplicationContext(),GanadorActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.boton_dados){
            Intent intent = new Intent(getApplicationContext(),DadosActivity.class);
            startActivity(intent);
        }
    }
}