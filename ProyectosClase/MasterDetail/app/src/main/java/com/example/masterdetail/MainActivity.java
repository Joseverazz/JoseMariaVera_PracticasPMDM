package com.example.masterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.masterdetail.fragments.FragmentDetalle;
import com.example.masterdetail.fragments.FragmentLista;

public class MainActivity extends AppCompatActivity implements FragmentLista.OnItemListaListener {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.replace(R.id.sitio_master, new FragmentLista(), "lista");
        ft.commit();
    }


    @Override
    public void onItemSelected(String item) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        if (findViewById(R.id.sitio_detalle)==null){
            ft.replace(R.id.sitio_master, FragmentDetalle.newInstance(item),"detalle");
            ft.addToBackStack("lista");
            ft.addToBackStack("detalle");
        }
        else{
            ft.replace(R.id.sitio_detalle, FragmentDetalle.newInstance(item),"detalle");
        }
        ft.commit();
    }
}