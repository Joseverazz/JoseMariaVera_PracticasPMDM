package com.josemaria.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class AleatoriosActivity extends AppCompatActivity {
    RadioButton radioCon, radioSin;

    EditText rangoMinimo, rangoMaximo, textoDecimales, textoTotales;

    CheckBox checkDecimales;

    ToggleButton toggleRepetir;

    ImageButton btnGenerar;

    TextView textoFinal;

    boolean toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorios);
        instancias();
        acciones();
    }

    private void acciones() {
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decimales = 0, veces = 0, min = 0, max = 0;

                List<Double> listaNumeros = new ArrayList<>();

                if (radioCon.isChecked()){
                    if (String.valueOf(rangoMaximo.getText()).equals("") || String.valueOf(rangoMinimo.getText()).equals("")){
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Tienes que rellenar los rangos maximos y el minimos", Toast.LENGTH_SHORT);
                        toast1.show();
                        return;
                    }
                    min = Integer.parseInt(String.valueOf(rangoMinimo.getText()));
                    max = Integer.parseInt(String.valueOf(rangoMaximo.getText()));
                }
                else if (radioSin.isChecked()){
                    min = 1;
                    max = 100;
                }
                else{
                    Toast toast2 = Toast.makeText(getApplicationContext(),
                            "Tienes que selecionar sin rango o con rango", Toast.LENGTH_SHORT);
                    toast2.show();
                    return;
                }

                if (checkDecimales.isChecked()){
                    if (textoDecimales.getText().toString().equals("")){
                        Toast toast3 = Toast.makeText(getApplicationContext(),
                                "Tienes que poner el numero de decimales", Toast.LENGTH_SHORT);
                        toast3.show();
                        return;
                    }
                    else {
                        decimales = Integer.parseInt(String.valueOf(textoDecimales.getText()));
                    }
                }

                if (textoTotales.getText().toString().equals("")){
                    Toast toast4 = Toast.makeText(getApplicationContext(),
                            "Tienes que poner el numero de totales", Toast.LENGTH_SHORT);
                    toast4.show();
                    return;
                }
                else {
                    veces = Integer.parseInt(String.valueOf(textoTotales.getText()));
                }

                for (int i = 0; i < veces; i++) {
                    double numero;
                    numero = Math.random() * (min - (max))+max;
                    numero = Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);

                    if (toogle){
                        listaNumeros.add(numero);
                    }
                    else{
                        boolean repe = false;
                        for (int j = 0; j < listaNumeros.size(); j++) {
                            if (numero == listaNumeros.get(j)){
                                repe = true;
                            }
                        }
                        if (repe){
                            i--;
                        }
                        else{
                            listaNumeros.add(numero);
                        }
                    }
                }
                textoFinal.setText("");

                for (int i = 0; i < listaNumeros.size(); i++) {
                    if (checkDecimales.isChecked()){
                        if (decimales== 0){
                            textoFinal.append((int)(Math.round(listaNumeros.get(i)*Math.pow(10,decimales))/Math.pow(10,decimales))+"\n");
                        }
                        else{
                            textoFinal.append((Math.round(listaNumeros.get(i)*Math.pow(10,decimales))/Math.pow(10,decimales))+"\n");
                        }
                    }
                    else{
                        textoFinal.append((int)(Math.round(listaNumeros.get(i)*Math.pow(10,decimales))/Math.pow(10,decimales))+"\n");
                    }

                }
            }
        });

        toggleRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toogle){
                    toogle = false;
                }
                else{
                    toogle = true;
                }
            }
        });
    }

    private void instancias() {
        radioCon = findViewById(R.id.radioCon);
        radioSin = findViewById(R.id.radioSin);
        rangoMaximo = findViewById(R.id.rangoMaximo);
        rangoMinimo = findViewById(R.id.rangoMinimo);
        textoDecimales = findViewById(R.id.textoDecimales);
        checkDecimales = findViewById(R.id.checkDecimales);
        textoTotales = findViewById(R.id.textoTotales);
        toggleRepetir = findViewById(R.id.botonRepetirNumeros);
        btnGenerar = findViewById(R.id.botonGenerar);
        textoFinal = findViewById(R.id.textoFinal);
    }
}