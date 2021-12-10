package com.josemaria.listas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.josemaria.listas.adapters.AdaptadorSpinner;
import com.josemaria.listas.utils.Marca;
import com.josemaria.listas.utils.Modelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerMarcas;
    private ArrayAdapter adapterSpinner;
    private AdaptadorSpinner adaptadorAvanzadoSpinner;
    private ArrayList listaOpcionesSpinner;
    private ArrayList<Modelo> listaModelos;
    private ImageView imagenMarca;
    private Button btnAnadir;
    private TextView textoModelo, textoPotencia;

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
                /*Toast.makeText(getApplicationContext(),
                        adapterSpinner.getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Marca marcaSeleccionada = (Marca) adaptadorAvanzadoSpinner.getItem(position);
                /*imagenMarca.setImageResource(marcaSeleccionada.getImagen());*/
                for (Modelo itemModelo :listaModelos) {
                    if(marcaSeleccionada.getNombre().equalsIgnoreCase(itemModelo.getMarca())){
                        imagenMarca.setImageResource(itemModelo.getImagen());
                        textoPotencia.setText(String.valueOf(itemModelo.getPotencia()));
                        textoModelo.setText(String.valueOf(itemModelo.getNombre()));
                    }
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //listaOpcionesSpinner.add(new Marca("Defecto",R.drawable.defecto));
                adaptadorAvanzadoSpinner.addMarca(new Marca("Defecto",R.drawable.defecto));
            }
        });
    }

    private void rellenarListas() {
        listaModelos.add(new Modelo("I8", "Bmw", R.drawable.i8, 300));
        listaModelos.add(new Modelo("EQC", "Mercedes", R.drawable.eqc, 400));
        listaModelos.add(new Modelo("A5", "Audi",R.drawable.a5, 500));
        listaModelos.add(new Modelo("Arteon", "Volkswagen", R.drawable.arteon, 200));

        listaOpcionesSpinner.add(new Marca("Audi",R.drawable.audi));
        listaOpcionesSpinner.add(new Marca("Bmw",R.drawable.bmw));
        listaOpcionesSpinner.add(new Marca("Mercedes",R.drawable.mercedes));
        listaOpcionesSpinner.add(new Marca("Volkswagen",R.drawable.vw));
        adaptadorAvanzadoSpinner.notifyDataSetChanged();
    }

    private void asociarElementos() {
        spinnerMarcas.setAdapter(adaptadorAvanzadoSpinner);
    }

    private void instancias() {
        textoModelo = findViewById(R.id.texto_modelo);
        textoPotencia = findViewById(R.id.texto_potencia);
        listaModelos = new ArrayList<>();
        spinnerMarcas = this.findViewById(R.id.spinner_marcas);
        btnAnadir = findViewById(R.id.btn_anadir);
        listaOpcionesSpinner = new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,listaOpcionesSpinner);
        imagenMarca = findViewById(R.id.imagen_marca);
        adaptadorAvanzadoSpinner = new AdaptadorSpinner(listaOpcionesSpinner,getApplicationContext());
    }

}