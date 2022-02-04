package com.example.t06_recicler.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t06_recicler.MainActivity;
import com.example.t06_recicler.R;
import com.example.t06_recicler.utils.Contacto;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {
    private ArrayList<Contacto> listaContactos;
    private Context context;
    private OnContactoRecyclerListener listener;

    public AdaptadorRecycler(ArrayList<Contacto> listaContactos, Context context) {
        this.listaContactos = listaContactos;
        this.context = context;
        this.listener = (OnContactoRecyclerListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Contacto contacto = listaContactos.get(position);
        holder.textoNombre.setText(contacto.getNombre());
        holder.textoTelefono.setText(String.valueOf(contacto.getTelefono()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, contacto.getDireccion().toString(), Toast.LENGTH_SHORT).show();
                listener.onContactoSelected(contacto);
            }
        });
        if(contacto.getImagen() != 0){
            holder.imagen.setImageResource(contacto.getImagen());
        }
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public interface OnContactoRecyclerListener{
        void onContactoSelected(Contacto contactos);
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textoNombre, textoTelefono;
        ImageView imagen;
        LinearLayout linearLayout;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textoNombre = itemView.findViewById(R.id.nombre_fila);
            textoTelefono = itemView.findViewById(R.id.telefono_fila);
            imagen = itemView.findViewById(R.id.imagen_fila);
            linearLayout = itemView.findViewById(R.id.linear);
        }
    }
}