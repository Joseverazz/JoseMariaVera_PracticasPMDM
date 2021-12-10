package com.josemaria.listas.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.josemaria.listas.R;
import com.josemaria.listas.utils.Modelo;

import java.util.List;

public class AdaptadorLista extends BaseAdapter {
    List<Modelo> listaModelos;
    Context context;

    public AdaptadorLista(List<Modelo> listaModelos, Context context) {
        this.listaModelos = listaModelos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaModelos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaModelos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false);
        Modelo modeloActual = listaModelos.get(position);

        ImageView imagen = convertView.findViewById(R.id.imagen_item_lista);
        TextView texto = convertView.findViewById(R.id.texto_item_lista);

        texto.setText(modeloActual.getNombre());
        imagen.setImageResource(modeloActual.getImagen());

        return convertView;
    }
}
