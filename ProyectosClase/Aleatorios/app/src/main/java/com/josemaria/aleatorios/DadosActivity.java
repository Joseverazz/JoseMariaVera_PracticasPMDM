package com.josemaria.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DadosActivity extends AppCompatActivity {

    Button btnTirada;

    ImageView imagenDados;

    int[] dados = {R.drawable.dado_uno,R.drawable.dado_dos,R.drawable.dado_tres,
            R.drawable.dado_cuatro,R.drawable.dado_cinco,R.drawable.dado_seis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instancias();
        acciones();
    }

    private void acciones() {
        btnTirada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nAux = (int) (Math.random() * 6);
                imagenDados.setImageResource(dados[nAux]);
            }
        });
    }

    private void instancias() {
        btnTirada = findViewById(R.id.boton_tirada);
        imagenDados = findViewById(R.id.image_dados);
    }
}