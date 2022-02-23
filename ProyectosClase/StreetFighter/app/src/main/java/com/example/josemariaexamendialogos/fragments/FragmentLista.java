package com.example.josemariaexamendialogos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.josemariaexamendialogos.R;
import com.example.josemariaexamendialogos.utils.AdaptadorRecycler;
import com.example.josemariaexamendialogos.utils.Jugador;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private View view;
    private Context context;
    AdaptadorRecycler adaptadorRecycler;
    ArrayList<Jugador> listaJugadores;
    RecyclerView recycler;

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void rellenarLista() {
        listaJugadores.add(new Jugador(R.drawable.vision, "Mr. Vision", "Psicopoderes", "Alemania"));
        listaJugadores.add(new Jugador(R.drawable.blanka, "Blanka", "Electricidad", "Brasil"));
        listaJugadores.add(new Jugador(R.drawable.chunli, "Chun Li", "Karate", "China"));
        listaJugadores.add(new Jugador(R.drawable.dalsim, "Dalsim", "Elasticidad", "India"));
        listaJugadores.add(new Jugador(R.drawable.guile, "Guille", "Boomerang", "EEUU"));
        listaJugadores.add(new Jugador(R.drawable.honda, "Honda", "Sumo", "Japón"));
        listaJugadores.add(new Jugador(R.drawable.ken, "Ken", "Judo", "Japon"));
        listaJugadores.add(new Jugador(R.drawable.ryu, "Ryu", "Karate", "Japón"));
        listaJugadores.add(new Jugador(R.drawable.vega, "Vega", "Garras", "España"));
        listaJugadores.add(new Jugador(R.drawable.zang, "Zangief", "Fuerza", "Rusia"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista_layout,container,false);

        listaJugadores = new ArrayList<>();
        recycler = view.findViewById(R.id.recycler);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        rellenarLista();
        adaptadorRecycler = new AdaptadorRecycler(listaJugadores,context);
        recycler.setAdapter(adaptadorRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }
}
