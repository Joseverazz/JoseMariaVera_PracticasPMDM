package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogoListas extends DialogFragment {
    private Context context;
    private int seleccionado = -1;
    private ArrayList<CharSequence> listaSeleccionados = new ArrayList<>();


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] opciones = new String[]{"opcion1", "opcion2", "opcion3"};

        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(context);

        dialogoBuilder.setTitle("Dialogo Lista");
        /*dialogoBuilder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, opciones[i], Toast.LENGTH_SHORT).show();
            }
        });*/
       /* dialogoBuilder.setSingleChoiceItems(opciones, -1,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                seleccionado = i;
                Toast.makeText(context, opciones[seleccionado], Toast.LENGTH_SHORT).show();
                dismiss();//desaparece el dialogo
            }
        });
        dialogoBuilder.setPositiveButton("ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, opciones[seleccionado], Toast.LENGTH_SHORT).show();
            }
        });
        */

        dialogoBuilder.setMultiChoiceItems(opciones, new boolean[]{false, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b){
                    listaSeleccionados.add(opciones[i]);
                }else{
                    listaSeleccionados.remove(opciones[i]);
                }
            }
        });


        dialogoBuilder.setPositiveButton("ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, String.valueOf(listaSeleccionados.size()), Toast.LENGTH_SHORT).show();
            }
        });

        return dialogoBuilder.create();
    }
}
