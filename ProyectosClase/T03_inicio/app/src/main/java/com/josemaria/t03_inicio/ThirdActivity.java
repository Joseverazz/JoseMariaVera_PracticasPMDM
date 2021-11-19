package com.josemaria.t03_inicio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.josemaria.t03_inicio.utils.Persona;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editApellido,editNombre,editTelefono;
    private CheckBox checkExperiencia;
    private Button botonRegistro;
    private ImageView imagenExperiencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        instancias();
        acciones();
    }

    private void acciones() {
        botonRegistro.setOnClickListener(this);
    }

    private void instancias(){
        editApellido = findViewById(R.id.edit_apellido);
        editNombre = findViewById(R.id.edit_nombre);
        editTelefono = findViewById(R.id.edit_telefono);
        checkExperiencia = findViewById(R.id.check_experiencia);
        botonRegistro = findViewById(R.id.boton_registrar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_registrar:
                String nombre,apellido;
                int telefono;
                boolean experiencia;

                if (!editNombre.getText().toString().isEmpty() &&
                        !editApellido.getText().toString().isEmpty() &&
                        !editTelefono.getText().toString().isEmpty()) {

                    nombre = editNombre.getText().toString();
                    apellido = editApellido.getText().toString();
                    telefono = Integer.parseInt(editTelefono.getText().toString());
                    experiencia = checkExperiencia.isChecked();

                    Intent intent = new Intent(getApplicationContext(), ForthActivity.class);
                    /*
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("apellido",apellido);
                    intent.putExtra("telefono",telefono);
                    intent.putExtra("experiencia",experiencia);*/
                    intent.putExtra("persona", new Persona(nombre, apellido, telefono, experiencia));

                    //startActivity(intent);
                    if (experiencia) {
                        startActivityForResult(intent, 1);
                    }
                    else {
                        startActivityForResult(intent, 1);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Falta algo",
                            Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*
        if (requestCode == 1){
            Persona recuperada = (Persona) data.getExtras().getSerializable("persona");
            Log.v("text",recuperada.getApellido());
        }
        else{
            Log.v("text","no tienes experiencia");
        }*/
        if (resultCode == 1){
            imagenExperiencia.setImageResource(R.drawable.experienciasi);

        }else{
            imagenExperiencia.setImageResource(R.drawable.experienciano);
        }
    }
}