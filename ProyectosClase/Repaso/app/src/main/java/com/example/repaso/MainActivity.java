package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerContactoListener {

    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<>();
        contactos.add(new Contacto("borja","martin","pozuelo",1234567,R.drawable.imagen));
        contactos.add(new Contacto("coke","martin","pozuelo",1234567,0));
        contactos.add(new Contacto("adrian","martin","pozuelo",1234567,R.drawable.imagen));
        contactos.add(new Contacto("juanlu","martin","pozuelo",1234567,0));
        contactos.add(new Contacto("chema","martin","pozuelo",1234567,R.drawable.imagen));

        recyclerView= findViewById(R.id.recycler);
        adaptadorRecycler = new AdaptadorRecycler(contactos,MainActivity.this);
        // esto enlaza el adapter con el recycler
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onContactoSelected(Contacto contacto) {
        Toast.makeText(getApplicationContext(), contacto.getDireccion(), Toast.LENGTH_SHORT).show();
    }
}