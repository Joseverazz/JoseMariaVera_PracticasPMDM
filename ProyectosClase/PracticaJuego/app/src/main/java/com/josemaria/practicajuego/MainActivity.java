package com.josemaria.practicajuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textContador;
    private CheckBox checkPractica;
    private Button botonInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonInicio.setOnClickListener(this);
        textContador.setText("0");
        checkPractica.setChecked(true);
    }

    private void instancias(){
        textContador = findViewById(R.id.text_contador);
        checkPractica = findViewById(R.id.check_practica);
        botonInicio = findViewById(R.id.boton_inicio);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_inicio:
                boolean practica;
                practica = checkPractica.isChecked();

                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("practica",practica);

                //startActivity(intent);

                break;
        }
    }
}