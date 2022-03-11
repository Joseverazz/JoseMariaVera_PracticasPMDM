package com.example.luchorepaso1ev;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luchorepaso1ev.utils.Elemento;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder>{
    private ArrayList<Elemento> lista;
    private Context context;

    public AdaptadorRecycler(ArrayList<Elemento> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre, caracteristica;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.nombre_item);
            caracteristica = itemView.findViewById(R.id.caracteristica_item);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Elemento elemento =  lista.get(position);
        holder.imagen.setImageResource(elemento.getFoto());
        holder.nombre.setText(elemento.getNombre());
        holder.caracteristica.setText(elemento.getCaracteristica());
    }

}