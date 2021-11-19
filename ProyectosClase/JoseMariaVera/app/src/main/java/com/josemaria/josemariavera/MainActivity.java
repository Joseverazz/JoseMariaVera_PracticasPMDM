package com.josemaria.josemariavera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editOperando1, editOperando2;
    private Button botonSuma,botonResta,botonMultiplicacion,
            botonDivision,botonModulo,botonResultado;

    private String tipo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonSuma.setOnClickListener(this);
        botonResta.setOnClickListener(this);
        botonMultiplicacion.setOnClickListener(this);
        botonDivision.setOnClickListener(this);
        botonModulo.setOnClickListener(this);
        botonResultado.setOnClickListener(this);
    }


    private void instancias() {
        editOperando1 = findViewById(R.id.edit_operando1);
        editOperando2 = findViewById(R.id.edit_operando2);
        botonSuma = findViewById(R.id.boton_suma);
        botonResta = findViewById(R.id.boton_resta);
        botonMultiplicacion = findViewById(R.id.boton_multiplicacion);
        botonDivision = findViewById(R.id.boton_division);
        botonModulo = findViewById(R.id.boton_modulo);
        botonResultado = findViewById(R.id.boton_resultado);
    }

    @Override
    public void onClick(View v) {

        if (!(v.getId() == R.id.boton_resultado)) {
                tipo = ((Button) v).getText().toString();
        }
        else{
            if (!editOperando1.getText().toString().isEmpty()
                    && !editOperando2.getText().toString().isEmpty()) {
                int operando1 = Integer.parseInt(editOperando1.getText().toString());
                int operando2 = Integer.parseInt(editOperando2.getText().toString());

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("operando1", operando1);
                intent.putExtra("operando2", operando2);
                intent.putExtra("tipo", tipo);
                startActivity(intent);

            }
            else {
                Toast.makeText(getApplicationContext(),R.string.fallo, Toast.LENGTH_SHORT).show();
            }
        }
    }
}