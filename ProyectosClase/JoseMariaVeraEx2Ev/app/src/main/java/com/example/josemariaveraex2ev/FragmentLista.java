package com.example.josemariaveraex2ev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.josemariaveraex2ev.utils.Pregunta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentLista extends Fragment {
    private View view;
    private Context context;
    private RecyclerView recycler;
    private ArrayList<Pregunta> listaPreguntas;
    private AdaptadorRecycler adapter;
    private String url;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    public static FragmentLista newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);

        FragmentLista fragment = new FragmentLista();
        fragment.setArguments(args);
        return fragment;
    }

    public void anadirPreguntas(ArrayList<Pregunta> preguntas){
        adapter.setPreguntas(preguntas);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        recycler = view.findViewById(R.id.recycler);
        adapter = new AdaptadorRecycler(context);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));
        JsonObjectRequest jsonRequest = new JsonObjectRequest(1,
                getArguments().getString("url"),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray array = null;
                        try {
                            array = response.getJSONArray("results");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject preguntaJSON = array.getJSONObject(i);
                                if (preguntaJSON.getString("type").equalsIgnoreCase("Boolean")){
                                    String question = preguntaJSON.getString("question");
                                    Boolean correct = Boolean.parseBoolean(preguntaJSON.getString("correct_answer"));
                                    adapter.addPregunta(new Pregunta(question,correct));
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });        Volley.newRequestQueue(context).add(jsonRequest);

    }
}
