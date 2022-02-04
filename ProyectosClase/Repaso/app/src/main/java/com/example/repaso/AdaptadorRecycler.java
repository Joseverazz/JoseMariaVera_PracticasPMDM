package com.example.repaso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {
    // para abajo tenemos que crearnos esto
    private ArrayList<Contacto> listacontactos;
    // aqui abajo creamos el aspecto de la lista
    private Context context;
    OnRecyclerContactoListener listener;


// creamos el constructor


    public AdaptadorRecycler(ArrayList<Contacto> listacontactos, Context context) {
        this.listacontactos = listacontactos;
        this.context = context;
        listener = (OnRecyclerContactoListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // para aqui nos teemos que crear el context arriba para poder hacer el view bien
        View view = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    // este metodo pinta cada una de las filas
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Contacto contacto = listacontactos.get(position);
        holder.imagen.setImageResource(contacto.getImagen());
        holder.nombre.setText(contacto.getNombre());

        // esto al clicar el nombre nos pasa el contacto al main
        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onContactoSelected(contacto);
            }
        });
    }

    public interface OnRecyclerContactoListener{
        void onContactoSelected(Contacto contacto);
    }

// para que la lista sea como nosotros digamos nos tenemos que crear la lista de arriba
    @Override
    public int getItemCount() {
        return listacontactos.size();
    }
// primero hay que crearse esta clase y luego añadimos las cosas que tiene
    class MyHolder extends RecyclerView.ViewHolder{
        // te creas esto
        TextView nombre;
        ImageView imagen;
    // esto es lo que te creas primero
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            // esto lo añades despues
            nombre= itemView.findViewById(R.id.texto_item);
            imagen = itemView.findViewById(R.id.imagen_item);
        }
    }


}
