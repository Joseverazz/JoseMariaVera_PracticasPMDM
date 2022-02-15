package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoComunicacion extends DialogFragment {

    private String nNombre;

    public static DialogoComunicacion newInstance(String nombre){
        DialogoComunicacion dcomunicacion = new DialogoComunicacion();
        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombre);//tantos como quiera
        dcomunicacion.setArguments(bundle);
        return dcomunicacion ;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(this.getArguments() != null){
            this.nNombre = this.getArguments().getString("nombre");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage(nNombre);

        return builder.create();
    }
}
