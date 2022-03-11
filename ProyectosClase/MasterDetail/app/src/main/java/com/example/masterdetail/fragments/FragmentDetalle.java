package com.example.masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.masterdetail.R;

public class FragmentDetalle extends Fragment {

    private View view;
    TextView texto;

    public static FragmentDetalle newInstance(String item) {

        Bundle args = new Bundle();
        args.putString("item",item);

        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle, container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        texto = view.findViewById(R.id.texto_fragment);
        if (this.getArguments()!=null){
            texto.setText(getArguments().getString("item"));
        }
    }
}
