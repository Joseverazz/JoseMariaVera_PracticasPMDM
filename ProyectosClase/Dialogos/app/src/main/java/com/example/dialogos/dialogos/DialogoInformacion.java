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

public class DialogoInformacion extends DialogFragment {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogoBuilder = new AlertDialog.Builder(getActivity());

        dialogoBuilder.setTitle("Dialogos de la informacion");
        dialogoBuilder.setMessage("Informacion general de la aplicaicon");
        dialogoBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Accion completada", Toast.LENGTH_SHORT).show();
            }
        });

        return  dialogoBuilder.create();
    }
}
