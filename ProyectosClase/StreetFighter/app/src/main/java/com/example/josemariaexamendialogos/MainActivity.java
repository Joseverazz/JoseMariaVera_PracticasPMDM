package com.example.josemariaexamendialogos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.josemariaexamendialogos.fragments.FragmentDetalle;
import com.example.josemariaexamendialogos.fragments.FragmentLista;
import com.example.josemariaexamendialogos.utils.AdaptadorRecycler;
import com.example.josemariaexamendialogos.utils.Jugador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerAdaptadorListener{
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments, new FragmentLista(), "lista");
        ft.addToBackStack("lista");
        ft.commit();
    }
    @Override
    public void onJugadorSelected(Jugador jugador) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments,FragmentDetalle.newInstance(jugador), "detalle");
        ft.addToBackStack("detalle");
        ft.commit();
        Log.v("hola",jugador.getNombre());
    }
}