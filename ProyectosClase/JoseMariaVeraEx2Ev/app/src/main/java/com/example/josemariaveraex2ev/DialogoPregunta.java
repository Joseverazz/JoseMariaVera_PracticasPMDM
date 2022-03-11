package com.example.josemariaveraex2ev;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.josemariaveraex2ev.utils.Pregunta;

public class DialogoPregunta extends DialogFragment {

    public static DialogoPregunta newInstance(Pregunta pregunta) {

        Bundle args = new Bundle();
        args.putSerializable("pregunta",pregunta);
        DialogoPregunta fragment = new DialogoPregunta();
        fragment.setArguments(args);
        return fragment;
    }
    private Context context;
    private View view;
    private ImageView imagenVerdadero, imagenFalso;
    private TextView textoPregunta;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_pregunta, null,false);
        dialogoBuilder.setView(view);
        return dialogoBuilder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();
    }

    private void acciones() {
        imagenVerdadero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((Pregunta)getArguments().get("pregunta")).getRespuesta()){
                    Toast.makeText(context, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });
        imagenFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!((Pregunta)getArguments().get("pregunta")).getRespuesta()){
                    Toast.makeText(context, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });
        textoPregunta.setText(((Pregunta)getArguments().get("pregunta")).getPregunta());
    }
    private void instancias() {
        imagenFalso = view.findViewById(R.id.imagen_pregunta_falso);
        imagenVerdadero = view.findViewById(R.id.imagen_pregunta_verdadero);
        textoPregunta = view.findViewById(R.id.texto_pregunta);
    }
}
