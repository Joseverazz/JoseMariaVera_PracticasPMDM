package com.example.ejerciciosdialogos.Dialogos;

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

public class Dialogo2 extends DialogFragment {
    private Context context;
    private OnDialogoListener listener;
    private String nNombre;

    public static Dialogo2 newInstance(String nombre){
        Dialogo2 dialogo2 = new Dialogo2();
        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombre);//tantos como quiera
        dialogo2.setArguments(bundle);
        return dialogo2;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if(this.getArguments() != null){
            this.nNombre = this.getArguments().getString("nombre");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(context);

        dialogoBuilder.setTitle("Dialogo 1");
        dialogoBuilder.setMessage("Bienvenido al exámen ¿Estas seguro que quieres continuar?");

        dialogoBuilder.setPositiveButton("si",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.OnDialogo1Si();
            }
        });
        dialogoBuilder.setNegativeButton("no",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        return dialogoBuilder.create();
    }

    public interface  OnDialogoListener{
        void OnDialogo1Si();
    }

}
