package com.example.proyectojson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectojson.utils.Equipo;
import com.example.proyectojson.dialogos.DialogoConfirmacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnItemListener, DialogoConfirmacion.OnDialogoListener {

    private AdaptadorRecycler adaptadorRecycler;
    private RecyclerView recycler;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
        adaptadorRecycler = new AdaptadorRecycler(MainActivity.this);
        recycler = findViewById(R.id.recycler);
        recycler.setAdapter(adaptadorRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));

        JsonObjectRequest jsonRequest = new JsonObjectRequest(1,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray arrayEquipos = response.getJSONArray("results");
                            for (int i = 0; i < arrayEquipos.length(); i++) {
                                JSONObject equipo =  arrayEquipos.getJSONObject(i);
                                String id = equipo.getString("idTeam");
                                String nombre = equipo.getString("strTeam");
                                String anio = equipo.getString("intFormedYear");
                                String estadio = equipo.getString("strStadium");
                                String escudo = equipo.getString("strTeamBadge");
                                adaptadorRecycler.agregarEquipo(new Equipo(id, nombre, anio, estadio, escudo));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Log.v("resultado",response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });        Volley.newRequestQueue(getApplicationContext()).add(jsonRequest);
    }

    @Override
    public void onEquipoSelected(Equipo equipo) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        DialogoConfirmacion dialogoConfirmacion = DialogoConfirmacion.newInstance(equipo);
        dialogoConfirmacion.show(fm,"confirmacion");
    }

    @Override
    public void onDialogoSelected(Equipo equipo, Boolean bool) {
        if (bool){
            Intent intent = new Intent(getApplicationContext(),DetallesActivity.class);
            intent.putExtra("equipo",equipo);
            startActivity(intent);
        }
    }
}