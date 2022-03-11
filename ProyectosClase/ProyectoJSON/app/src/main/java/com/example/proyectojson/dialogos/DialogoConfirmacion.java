package com.example.proyectojson.dialogos;

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

import com.example.proyectojson.utils.Equipo;

public class DialogoConfirmacion extends DialogFragment {
    private Context context;
    private OnDialogoListener listener;

    public static DialogoConfirmacion newInstance(Equipo equipo) {

        Bundle args = new Bundle();
        args.putSerializable("equipo",equipo);
        DialogoConfirmacion fragment = new DialogoConfirmacion();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (OnDialogoListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(context);
        Equipo equipo = (Equipo) this.getArguments().getSerializable("equipo");
        dialogoBuilder.setTitle(equipo.getNombre());
        dialogoBuilder.setMessage("¿Estas seguro que "+equipo.getNombre()+" es tu equipo?");
        dialogoBuilder.setPositiveButton("si",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSelected(equipo, true);
            }
        });
        dialogoBuilder.setNegativeButton("no",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSelected(equipo, false);
            }
        });
        return dialogoBuilder.create();
    }

    public interface OnDialogoListener{
        void onDialogoSelected(Equipo equipo, Boolean bool);
    }

}
