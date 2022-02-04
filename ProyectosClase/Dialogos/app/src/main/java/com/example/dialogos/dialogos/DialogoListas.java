package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogoListas extends DialogFragment {

    private Context context ;
    private int selecionado = -1;
    private ArrayList<CharSequence> listaSeleccionados = new ArrayList<>();//elementos que voy a ir agregando

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] opciones = new String[]{"opcion 1","opcion 2","opcion 3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Dialogo de lista");

        /*builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,opciones[which],Toast.LENGTH_SHORT).show();
            }
        });*/

        /*
        builder.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selecionado = which;
                Toast.makeText(context,opciones[selecionado],Toast.LENGTH_SHORT).show();
                dismiss();// oculta el dialogo
            }
        });
        */

        builder.setMultiChoiceItems(opciones, new boolean[]{false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    listaSeleccionados.add(opciones[which]);
                } else {
                    listaSeleccionados.remove(opciones[which]);
                }

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context,String.valueOf(listaSeleccionados.size()),Toast.LENGTH_SHORT).show();

            }
        });
        return builder.create();
    }
}
