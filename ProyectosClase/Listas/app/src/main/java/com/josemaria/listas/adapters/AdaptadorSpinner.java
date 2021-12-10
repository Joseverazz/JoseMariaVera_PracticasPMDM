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
import com.josemaria.listas.utils.Marca;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {
    private List<Marca> listaMarcas;
    private Context context;

    public AdaptadorSpinner(List<Marca> listaMarcas, Context context) {
        this.listaMarcas = listaMarcas;
        this.context = context;
    }

    public void addMarca(Marca marca){
        listaMarcas.add(marca);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listaMarcas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMarcas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner,parent,false );
        Marca marcaActual = listaMarcas.get(position);
        ImageView imagen = convertView.findViewById(R.id.imagen_item_spinner);
        TextView texto = convertView.findViewById(R.id.texto_item_spinner);
        imagen.setImageResource(marcaActual.getImagen());
        texto.setText(marcaActual.getNombre());

        return convertView;
    }
}
