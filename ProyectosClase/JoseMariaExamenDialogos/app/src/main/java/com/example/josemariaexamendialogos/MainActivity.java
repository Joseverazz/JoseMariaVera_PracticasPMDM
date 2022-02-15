package com.example.josemariaexamendialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.josemariaexamendialogos.utils.AdaptadorRecycler;
import com.example.josemariaexamendialogos.utils.Jugador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerContactoListener{
    AdaptadorRecycler adaptadorRecycler;
    ArrayList<Jugador> listaJugadores;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarLista();


        adaptadorRecycler = new AdaptadorRecycler(listaJugadores,MainActivity.this);
        recycler.setAdapter(adaptadorRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

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

    private void instancias() {
        listaJugadores = new ArrayList<>();
        recycler = findViewById(R.id.recycler);
    }

    @Override
    public void onJugadorSelected(Jugador jugador) {
        Intent intent = new Intent(getApplicationContext(),JugadorActivity.class);
        intent.putExtra("jugador",jugador);
        startActivity(intent);
        finish();
    }
}