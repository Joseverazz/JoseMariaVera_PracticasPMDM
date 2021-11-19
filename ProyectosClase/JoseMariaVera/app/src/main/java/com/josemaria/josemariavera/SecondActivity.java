package com.josemaria.josemariavera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textOperando1, textOperando2, textTipo, textResultado;
    private Button botonVolver;
    private String tipo;
    private int operando1, operando2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        if (getIntent().getExtras() != null ){
            recuperarDatos();
            setearDatos();
        }
        acciones();
    }

    private void acciones() {
        botonVolver.setOnClickListener(this);
    }

    private void setearDatos() {
        textOperando1.setText(String.valueOf(operando1));
        textOperando2.setText(String.valueOf(operando2));
        textTipo.setText(tipo);
        if (tipo.equals("suma"))
            textResultado.setText(String.valueOf(operando1+operando2));
        else if (tipo.equals("resta"))
            textResultado.setText(String.valueOf(operando1-operando2));
        else if (tipo.equals("multiplicacion"))
            textResultado.setText(String.valueOf(operando1*operando2));
        else if (tipo.equals("division"))
            textResultado.setText(String.valueOf(operando1/operando2));
        else if (tipo.equals("modulo"))
            textResultado.setText(String.valueOf(operando1%operando2));
    }

    private void instancias() {
        textOperando1 = findViewById(R.id.operando1_recuperado);
        textOperando2 = findViewById(R.id.operando2_recuperado);
        textTipo = findViewById(R.id.tipo_recuperado);
        textResultado = findViewById(R.id.resultado_recuperado);
        botonVolver = findViewById(R.id.boton_volver);
    }

    private void recuperarDatos() {
         operando1 = getIntent().getExtras().getInt("operando1");
         operando2 = getIntent().getExtras().getInt("operando2");
         tipo = getIntent().getExtras().getString("tipo");
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
