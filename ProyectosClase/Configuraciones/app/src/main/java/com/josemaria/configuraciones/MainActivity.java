package com.josemaria.configuraciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUno, btnDos, btnTres, btnCuatro, btnLand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        //getResources().getConfiguration().orientation;
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            accionesLand();
        }
    }

    private void accionesLand(){
        btnLand.setOnClickListener(this);
    }

    private void acciones() {
        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
    }

    private void instancias() {
        btnUno = findViewById(R.id.boton_uno);
        btnDos = findViewById(R.id.boton_dos);
        btnTres = findViewById(R.id.boton_tres);
        btnCuatro = findViewById(R.id.boton_cuatro);
        btnLand = findViewById(R.id.boton_land);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton_uno:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.texto_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton_dos:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.texto_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton_tres:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.texto_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton_cuatro:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.texto_toast),Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton_land:
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.texto_toast),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
