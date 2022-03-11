package com.example.luchorepaso1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.boton_main);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
/*listaElementos.add(new Elemento("Romario", "FC. Barcelona", R.drawable.romario,"Fútbol"));
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
        listaElementos.add(new Elemento("La casa de papel", "Accion", R.drawable.papel,"Series"));*/

