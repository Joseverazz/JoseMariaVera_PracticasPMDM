package com.josemaria.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GanadorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGenerarGanador, btnAgregarConcursante;

    private EditText nombreParticipante;

    private TextView textoPremioFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        instancias();
        acciones();
    }

    private void acciones() {
        btnAgregarConcursante.setOnClickListener(this);
        btnGenerarGanador.setOnClickListener(this);
    }

    private void instancias() {
        btnAgregarConcursante = findViewById(R.id.btnAgregarConcursante);
        btnGenerarGanador = findViewById(R.id.btnGenerarGanador);
        nombreParticipante = findViewById(R.id.nombreParticipante);
        textoPremioFinal = findViewById(R.id.textoPremioFinal);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarConcursante){
            textoPremioFinal.append(nombreParticipante.getText()+"\n");
        }
        else if (v.getId() == R.id.btnGenerarGanador){
            String[] aux = textoPremioFinal.getText().toString().split("\n");

            Toast toast1 = Toast.makeText(getApplicationContext(),
                            aux[(int) (Math.random() * aux.length)], Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
}