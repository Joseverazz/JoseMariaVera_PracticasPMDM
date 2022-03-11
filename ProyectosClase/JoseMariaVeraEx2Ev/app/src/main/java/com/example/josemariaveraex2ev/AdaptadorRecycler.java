package com.example.josemariaveraex2ev;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.josemariaveraex2ev.utils.Pregunta;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder>{
    private ArrayList<Pregunta> lista;
    private Context context;
    private OnItemListener listener;

    public AdaptadorRecycler(Context context) {
        lista = new ArrayList<>();
        this.context = context;
        listener = (OnItemListener) context;
    }
    public void setPreguntas(ArrayList<Pregunta> preguntas){
        lista = preguntas;
        this.notifyDataSetChanged();
    }

    public void addPregunta(Pregunta pregunta){
        lista.add(pregunta);
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
        Pregunta pregunta = lista.get(position);
        holder.textoPregunta.setText(pregunta.getPregunta());
        if (position%2 == 0){
            holder.linearLayout.setBackgroundColor(context.getColor(R.color.orange));
        }
        else{
            holder.linearLayout.setBackgroundColor(context.getColor(R.color.teal_200));
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnitemSelected(pregunta);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textoPregunta;
        LinearLayout linearLayout;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textoPregunta = itemView.findViewById(R.id.texto_item);
            linearLayout = itemView.findViewById(R.id.linear_item);
        }
    }

    public interface OnItemListener{
        void OnitemSelected(Pregunta pregunta);
    }
}