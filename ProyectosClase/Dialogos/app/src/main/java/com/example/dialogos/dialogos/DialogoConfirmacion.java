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

public class DialogoConfirmacion extends DialogFragment {
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(context);

        dialogoBuilder.setTitle("Dialogo confirmacion");
        dialogoBuilder.setMessage("¿Estas seguro que quieres continuar?");
        dialogoBuilder.setPositiveButton("si",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "pulsado SI", Toast.LENGTH_SHORT).show();
            }
        });
        dialogoBuilder.setNegativeButton("no",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Pulsado NO", Toast.LENGTH_SHORT).show();
            }
        });
        dialogoBuilder.setNeutralButton("Cancelar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Pulsado CANCELAR", Toast.LENGTH_SHORT).show();
            }
        });
        return dialogoBuilder.create();
    }

}
