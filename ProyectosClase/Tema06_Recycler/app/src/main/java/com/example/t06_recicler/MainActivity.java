package com.example.t06_recicler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.example.t06_recicler.adaptadores.AdaptadorRecycler;
import com.example.t06_recicler.utils.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnContactoRecyclerListener{

    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Contacto> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        asociarListas();
        rellenarLista();
        acciones();
    }

    private void acciones() {

    }

    private void asociarListas() {
        recyclerView.setAdapter(adaptadorRecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recyclerView.setLayoutManager(new LinearLayoutManager(
                    getApplicationContext(),LinearLayoutManager.HORIZONTAL, false));
            //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
            //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new LinearLayoutManager(
                    getApplicationContext(),LinearLayoutManager.VERTICAL, false));
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private void rellenarLista() {
        listaContactos.add(new Contacto("Jose","Vera","Madrid",1234, R.drawable.usuario_hombre));
        listaContactos.add(new Contacto("Pepe","Martin","Mad",126534, R.drawable.usuario_hombre2));
        listaContactos.add(new Contacto("Joselito","Gonzalez","Adsadrid",1234432, R.drawable.usuario_mujer));
        listaContactos.add(new Contacto("Alvion","Alejo","Madera",12534));
        listaContactos.add(new Contacto("Alejandro","Garcia","Mallorca",124634, R.drawable.usuario_mujer2));
        listaContactos.add(new Contacto("Juan","Juan","Valencia",122434));
        adaptadorRecycler.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_view);
        listaContactos = new ArrayList<>();
        adaptadorRecycler = new AdaptadorRecycler(listaContactos,MainActivity.this);
    }

    @Override
    public void onContactoSelected(Contacto contacto) {
        Toast.makeText(getApplicationContext(), String.valueOf(contacto.getTelefono()), Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        //intent.putExtra("contacto", contacto);
    }
}