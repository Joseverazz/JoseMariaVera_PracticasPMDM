package com.josemaria.josemariavera.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.josemaria.josemariavera.R;
import com.josemaria.josemariavera.Utils.Restaurante;

import java.util.ArrayList;

public class AdaptadorRestaurante extends BaseAdapter {
    ArrayList<Restaurante> listaRestaurantes;
    Context context;

    public AdaptadorRestaurante(ArrayList<Restaurante> listaRestaurantes, Context context) {
        this.listaRestaurantes = listaRestaurantes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaRestaurantes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaRestaurantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.lista_layout,parent,false);
        Restaurante restauranteActual = listaRestaurantes.get(position);

        TextView textoNombre = convertView.findViewById(R.id.text_lista_nombre);
        TextView textoLocalidad = convertView.findViewById(R.id.text_lista_localidad);

        textoNombre.setText(restauranteActual.getNombre());
        textoLocalidad.setText(restauranteActual.getLocalidad());

        return convertView;
    }
}