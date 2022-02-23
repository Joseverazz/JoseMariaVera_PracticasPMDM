package com.example.fragmentinicio.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentinicio.R;
import com.example.fragmentinicio.utils.Usuario;

public class FragmentDinamico2 extends Fragment {
    private View view;
    private Context context;
    private TextView textoNombre, textoApellido, textoEdad;
    private Usuario usuario;

    public static FragmentDinamico2 newInstance(Usuario usuario) {

        Bundle args = new Bundle();
        args.putSerializable("usuario",usuario);

        FragmentDinamico2 fragment = new FragmentDinamico2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (this.getArguments()!=null){
            this.usuario = (Usuario) getArguments().get("usuario");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dinamico_2_layout, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textoNombre = view.findViewById(R.id.texto_nombre);
        textoApellido = view.findViewById(R.id.texto_apellido);
        textoEdad = view.findViewById(R.id.texto_edad);

        textoNombre.setText(usuario.getNombre());
        textoApellido.setText(usuario.getApellido());
        textoEdad.setText(String.valueOf(usuario.getEdad()));

    }
}