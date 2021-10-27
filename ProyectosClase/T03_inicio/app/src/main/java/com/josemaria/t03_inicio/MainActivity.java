package com.josemaria.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonSaludar, botonDespedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        botonSaludar.setOnClickListener(this);
        botonDespedida.setOnClickListener(this);
    }

    private void instancias(){
        botonSaludar = findViewById(R.id.botonSaludar);
        botonDespedida = findViewById(R.id.botonDespedida);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonSaludar:{
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.hola) , Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.botonDespedida:{
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.adios) , Toast.LENGTH_SHORT).show();
            }
        }

    }
}