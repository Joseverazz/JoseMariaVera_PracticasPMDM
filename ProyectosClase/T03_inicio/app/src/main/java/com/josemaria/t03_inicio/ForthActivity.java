package com.josemaria.t03_inicio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.josemaria.t03_inicio.utils.Persona;

public class ForthActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textNombre, textApellido, textTelefono;
    private CheckBox checkExperiencia;
    private String nombre,apellido;
    private int telefono;
    private boolean experiencia;
    private Persona personaRecuperada;
    private Button botonContestar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        instancias();
        if (getIntent().getExtras() != null) {
            recuperarDatos();
            setearDatos();
        }
        acciones();

    }

    private void acciones() {
        botonContestar.setOnClickListener(this);
    }

    private void setearDatos(){
        textNombre.setText(personaRecuperada.getNombre());
        textApellido.setText(personaRecuperada.getApellido());
        textTelefono.setText(String.valueOf(personaRecuperada.getTelefono()));
        checkExperiencia.setChecked(personaRecuperada.isExperiencia());
        personaRecuperada.getNombre();
    }


    private void instancias() {
        textNombre = findViewById(R.id.text_nombre_recuperado);
        textApellido = findViewById(R.id.text_apellido_recuperado);
        textTelefono = findViewById(R.id.text_telefono_recuperado);
        checkExperiencia = findViewById(R.id.check_experiencia_recuperado);
        botonContestar = findViewById(R.id.boton_contestar);
    }

    private void recuperarDatos() {
        /*
        nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        telefono = getIntent().getExtras().getInt("telefono");
        experiencia = getIntent().getExtras().getBoolean("experiencia");
        */

        personaRecuperada = (Persona) getIntent().getExtras().get("persona");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        personaRecuperada.setApellido("Apellido Modificado");
        intent.putExtra("persona",personaRecuperada);
        if (experiencia){
            setResult(1,intent);
        }
        else{
            setResult(0,intent);
        }

        finish();
    }


}