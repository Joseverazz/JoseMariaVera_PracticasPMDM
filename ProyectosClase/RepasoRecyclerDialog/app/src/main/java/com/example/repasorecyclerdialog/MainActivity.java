package com.example.repasorecyclerdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.repasorecyclerdialog.dialogos.DialogoLogin;
import com.example.repasorecyclerdialog.utils.AdaptadorRecycler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerContactoListener, DialogoLogin.OnDialogoListener {
    private RecyclerView recycler;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Contactos> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();

        listaContactos.add(new Contactos("borja","martin"));
        listaContactos.add(new Contactos("coke","martin"));
        listaContactos.add(new Contactos("adrian","martin"));
        listaContactos.add(new Contactos("juanlu","martin"));
        listaContactos.add(new Contactos("chema","martin"));
        listaContactos.add(new Contactos("cokfsdf","martin"));
        listaContactos.add(new Contactos("afsd","martin"));
        listaContactos.add(new Contactos("jhtth","martin"));
        listaContactos.add(new Contactos("gdf","martin"));

        recycler.findViewById(R.id.recycler);

        adaptadorRecycler = new AdaptadorRecycler(listaContactos,MainActivity.this);
        recycler.setAdapter(adaptadorRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void instancias() {
        recycler = findViewById(R.id.recycler);
        listaContactos = new ArrayList<Contactos>();
        adaptadorRecycler = new AdaptadorRecycler(listaContactos,MainActivity.this);
    }

    @Override
    public void onContactoSelected(Contactos contacto) {
        Toast.makeText(getApplicationContext(),contacto.getTexto(),Toast.LENGTH_SHORT).show();
        DialogoLogin dialogoLogin = new DialogoLogin();
        dialogoLogin.show(getSupportFragmentManager(), "login");
    }

    @Override
    public void onDialogoSelected(String usuario, String password, boolean check) {
        Toast.makeText(getApplicationContext(), usuario+password+check,Toast.LENGTH_SHORT).show();
    }
}