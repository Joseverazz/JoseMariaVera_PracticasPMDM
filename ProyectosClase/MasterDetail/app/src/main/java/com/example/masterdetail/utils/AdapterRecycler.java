package com.example.masterdetail.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterdetail.R;

import java.util.ArrayList;


public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder>{
    private ArrayList<Jugador> lista;
    private Context context;
    private OnRecyclerAdaptadorListener listener;

    public AdapterRecycler(ArrayList<Jugador> lista, Context context) {
        this.lista = lista;
        this.context = context;
        listener = (OnRecyclerAdaptadorListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_recycler,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Jugador jugador = lista.get(position);
        holder.imagen.setImageResource(jugador.getFoto());
        holder.nombre.setText(jugador.getNombre());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onJugadorSelected(jugador);
            }
        });
    }

    public interface OnRecyclerAdaptadorListener{
        void onJugadorSelected(Jugador jugador);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre;
        LinearLayout linearLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_item_jugador);
            nombre = itemView.findViewById(R.id.nombre_item_jugador);
            linearLayout = itemView.findViewById(R.id.linear_item);
        }
    }
}