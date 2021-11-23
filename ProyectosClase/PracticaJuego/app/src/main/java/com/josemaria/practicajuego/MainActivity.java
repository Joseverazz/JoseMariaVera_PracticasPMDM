package com.josemaria.practicajuego;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                if (practica){
                    startActivityForResult(intent,1);
                }else
                {
                    startActivityForResult(intent,0);
                }


                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        int nRecord = data.getExtras().getInt("puntos");
        if (requestCode == 0){
            textContador.setText(String.valueOf(Math.max(nRecord, Integer.parseInt(textContador.getText().toString()))));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}