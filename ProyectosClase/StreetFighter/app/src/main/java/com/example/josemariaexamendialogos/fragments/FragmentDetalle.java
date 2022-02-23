package com.example.josemariaexamendialogos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.josemariaexamendialogos.R;
import com.example.josemariaexamendialogos.utils.Jugador;

public class FragmentDetalle extends Fragment {
    private View view;
    private Context context;
    private TextView textoNombre, textoHabilidad, textoPais;
    private ImageView foto;
    private Jugador jugador;

    public static FragmentDetalle newInstance(Jugador jugador) {

        Bundle args = new Bundle();
        args.putSerializable("jugador",jugador);

        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (this.getArguments()!=null){
            this.jugador = (Jugador) getArguments().get("jugador");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle_layout, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textoNombre = view.findViewById(R.id.nombre_jugador);
        textoHabilidad = view.findViewById(R.id.habilidad_jugador);
        textoPais = view.findViewById(R.id.nacionalidad_jugador);
        foto = view.findViewById(R.id.imagen_jugador);

        textoNombre.setText(jugador.getNombre());
        textoHabilidad.setText(jugador.getHabilidad());
        textoPais.setText(String.valueOf(jugador.getNacionalidad()));
        foto.setImageResource(jugador.getFoto());

    }
}