package com.example.fragmentinicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fragmentinicio.fragments.FragmentDinamico1;
import com.example.fragmentinicio.fragments.FragmentDinamico2;
import com.example.fragmentinicio.utils.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentDinamico1.OnFragmentUnoListener {

    private Button bF1, bF2;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bF1 = findViewById(R.id.boton_f1);
        bF2 = findViewById(R.id.boton_f2);

        bF1.setOnClickListener(this);
        bF2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        switch (view.getId()){
            case R.id.boton_f1:
                ft.replace(R.id.sitio_fragments, new FragmentDinamico1(), "uno");
                ft.addToBackStack("uno");
                break;
            case R.id.boton_f2:
                ft.replace(R.id.sitio_fragments, new FragmentDinamico2(), "dos");
                ft.addToBackStack("dos");
                break;
        }
        ft.commit();
    }


    @Override
    public void onUsuarioSelected(Usuario usuario) {
        //Toast.makeText(getApplicationContext(),usuario.getEdad() +" " + usuario.getApellido() + " " + usuario.getEdad(), Toast.LENGTH_SHORT).show();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.sitio_fragments,FragmentDinamico2.newInstance(usuario));
        ft.commit();
    }
}