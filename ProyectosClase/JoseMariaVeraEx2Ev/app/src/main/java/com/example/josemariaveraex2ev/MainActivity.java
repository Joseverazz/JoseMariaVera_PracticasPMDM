package com.example.josemariaveraex2ev;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.josemariaveraex2ev.utils.Pregunta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnItemListener {
    FragmentManager fm;
    FragmentTransaction ft;
    ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_main, FragmentLista.newInstance(""), "lista");
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (item.getItemId()) {
            case R.id.menu_op_sports:
                ft.replace(R.id.frame_main, FragmentLista.newInstance("https://opentdb.com/api.php?amount=10&category=21&type=boolean"), "lista");
                ft.commit();
                break;
            case R.id.menu_op_videogames:
                ft.replace(R.id.frame_main, FragmentLista.newInstance("https://opentdb.com/api.php?amount=10&category=15&type=boolean"), "lista");
                ft.commit();
                break;
            case R.id.menu_op_television:
                ft.replace(R.id.frame_main, FragmentLista.newInstance("https://opentdb.com/api.php?amount=10&category=11&type=boolean"), "lista");
                ft.commit();
                break;
            case R.id.menu_op_salir:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void OnitemSelected(Pregunta pregunta) {
        DialogoPregunta dialogoPregunta = DialogoPregunta.newInstance(pregunta);
        dialogoPregunta.show(getSupportFragmentManager(),"dialog");
    }
}