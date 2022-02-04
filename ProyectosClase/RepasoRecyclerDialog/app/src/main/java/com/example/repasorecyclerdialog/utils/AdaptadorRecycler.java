package com.example.repasorecyclerdialog.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasorecyclerdialog.Contactos;
import com.example.repasorecyclerdialog.R;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder>{
    private ArrayList<Contactos> lista;
    private Context context;
    private OnRecyclerContactoListener listener;

    public AdaptadorRecycler(ArrayList<Contactos> lista, Context context) {
        this.lista = lista;
        this.context = context;
        listener = (OnRecyclerContactoListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Contactos contacto = lista.get(position);
        System.out.println(contacto);
        holder.texto.setText(contacto.getTexto());
        holder.titulo.setText(contacto.getTitulo());

        holder.titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onContactoSelected(contacto);
            }
        });
    }

    public interface OnRecyclerContactoListener{
        void onContactoSelected(Contactos contacto);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView texto;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            texto = itemView.findViewById(R.id.texto);
        }
    }
}
/*
1) primero vista del recycler
2) vista de la lista del recycler
3) instancias recycler
4) creas la clase de utils
5) creas el adaptador
6) extiendes recyclerview.adapter
	 y pones la clase myHolder extiende de recyclerview.viewholder
7) sacas los metodos
8) en la clase te sacas los textview o imagenview creada en el xml de item-lista
9)te creas la lista arriba del tipo utils
10) te creas tambien el contexto
	-creas el constructor con la lista y el contexto
11) igualas el metodo getItem a lista.size
12) oncreateview = te creas un view(inflate) para cargar el xml del item_lista
13) onbindview = te creas un tipo de la clase creada y lo igualas a la lista.get(position)
	- con el holder coges los elementos creados en el xml y le das set lo que sea y le das valor
14)te vas al main creas un adaptador lo instancias y te creeas la lista
15) rellenas la lista
16)asocias la lista con el set adapter y le tienes que dAR el setlayourManager
17) creas la interfaz en el adaptador
18) creas el tipo de la interfaz arriba
19) dentro del oncreate dices que si pulsas algo llamas al metodo de la ointerfaz y le pasas lo que quieras
20) igualas la variable de arriba creada de la interfaz dentro del constructor a context
21) implementas interfaz y dentro del metodo haces algo
*/