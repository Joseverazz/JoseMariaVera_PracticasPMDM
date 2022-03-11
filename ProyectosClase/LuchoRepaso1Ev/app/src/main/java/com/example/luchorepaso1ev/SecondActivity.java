package com.example.luchorepaso1ev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.luchorepaso1ev.utils.Elemento;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<Elemento> listaElementos, listaMuestra;
    ArrayList<String> listaCategorias;
    RecyclerView recyclerView;
    Spinner spinner;
    ArrayAdapter adapter;
    AdaptadorRecycler adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listaElementos = new ArrayList<>();
        listaCategorias = new ArrayList<>();
        listaMuestra = new ArrayList<>();
        listaElementos = new ArrayList<Elemento>();
        recyclerView = findViewById(R.id.recycler);
        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaCategorias);
        adaptador = new AdaptadorRecycler(listaMuestra,getApplicationContext());


        listaCategorias.add("Fútbol");
        listaCategorias.add("Juegos");
        listaCategorias.add("Series");

        listaElementos.add(new Elemento("Romario", "FC. Barcelona", R.drawable.romario,"Fútbol"));
        listaElementos.add(new Elemento("Ronaldo", "Brasil", R.drawable.ronaldo,"Fútbol"));
        listaElementos.add(new Elemento("Maradona", "Argentina", R.drawable.maradona,"Fútbol"));
        listaElementos.add(new Elemento("Zidane", "Francia", R.drawable.zidane,"Fútbol"));
        listaElementos.add(new Elemento("Metal Gear", "Sigilo", R.drawable.metal,"Juegos"));
        listaElementos.add(new Elemento("Gran Turismo", "Coches", R.drawable.gt,"Juegos"));
        listaElementos.add(new Elemento("God Of War", "Plataformas", R.drawable.god,"Juegos"));
        listaElementos.add(new Elemento("Final Fantasy X", "Rol", R.drawable.ffx,"Juegos"));
        listaElementos.add(new Elemento("Stranger Things", "Fantastica", R.drawable.stranger,"Series"));
        listaElementos.add(new Elemento("Juego de tronos", "Histórica", R.drawable.tronos,"Series"));
        listaElementos.add(new Elemento("Lost", "Fantastica", R.drawable.lost,"series"));
        listaElementos.add(new Elemento("La casa de papel", "Accion", R.drawable.papel,"Series"));


        spinner.setAdapter(adapter);

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listaMuestra.clear();
                for (Elemento elemento:listaElementos) {
                    if (elemento.getCategoria().equalsIgnoreCase(listaCategorias.get(i))){
                        listaMuestra.add(elemento);
                    }
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}