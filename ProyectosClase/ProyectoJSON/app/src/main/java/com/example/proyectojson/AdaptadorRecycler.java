package com.example.proyectojson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectojson.utils.Equipo;

import java.util.ArrayList;


public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder>{
    private ArrayList<Equipo> lista;
    private Context context;
    private OnItemListener listener;

    public AdaptadorRecycler(Context context) {
        lista = new ArrayList<>();
        this.context = context;
        listener = (OnItemListener) context;
    }
    public void agregarEquipo(Equipo equipo){
        lista.add(equipo);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Equipo equipo = lista.get(position);
        holder.nombre.setText(equipo.getNombre());
        Glide.with(context).load(equipo.getEscudo()).into(holder.imagen);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEquipoSelected(equipo);
            }
        });
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
            nombre = itemView.findViewById(R.id.nombre_item);
            imagen = itemView.findViewById(R.id.imagen_item);
            linearLayout = itemView.findViewById(R.id.linear_item);
        }
    }

    interface OnItemListener{
        void onEquipoSelected(Equipo equipo);
    }
}