package com.josemaria.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.josemaria.listas.utils.Marca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerMarcas;
    private ArrayAdapter adapterSpinner;
    private ArrayList listaOpcionesSpinner;
    private ImageView imagenMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        asociarElementos();
        rellenarListas();
        acciones();
    }

    private void acciones() {
        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), adapterSpinner.getItem(position).toString(), Toast.LENGTH_SHORT).show();
                imagenMarca.setImageResource(((Marca) adapterSpinner.getItem(position)).getImagen());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarListas() {
        listaOpcionesSpinner.add(new Marca("Defecto",R.drawable.defecto));
        listaOpcionesSpinner.add(new Marca("Audi",R.drawable.audi));
        listaOpcionesSpinner.add(new Marca("Bmw",R.drawable.bmw));
        listaOpcionesSpinner.add(new Marca("Mercedes",R.drawable.mercedes));
        listaOpcionesSpinner.add(new Marca("VolksWagen",R.drawable.vw));
        adapterSpinner.notifyDataSetChanged();
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adapterSpinner);
    }

    private void instancias() {
        spinnerMarcas = this.findViewById(R.id.spinner_marcas);
        listaOpcionesSpinner = new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,listaOpcionesSpinner);
        imagenMarca = findViewById(R.id.imagen_marca);
    }

}