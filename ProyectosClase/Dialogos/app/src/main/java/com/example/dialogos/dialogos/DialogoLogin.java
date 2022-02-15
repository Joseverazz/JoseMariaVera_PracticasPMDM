package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos.R;

public class DialogoLogin extends DialogFragment {
    private Context context;
    private View view;
    private Button btnlogin;
    private EditText editnombre, editPass;
    private CheckBox checkPass;
    private OnDialogoListener listener;

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
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_login, null,false);
        dialogoBuilder.setView(view);
        /*dialogoBuilder.setTitle("Dialogo confirmacion");
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
        });*/
        return dialogoBuilder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();
    }

    private void acciones() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editnombre.getText().toString().equalsIgnoreCase("user")
                && editPass.getText().toString().equalsIgnoreCase("pass")
                && checkPass.isChecked()){
                    Toast.makeText(context, "login correcto", Toast.LENGTH_SHORT).show();
                    listener.OnDialogoSelected(editnombre.getText().toString(),editPass.getText().toString() );
                    dismiss();
                }
                else{
                    Toast.makeText(context, "login incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface  OnDialogoListener{
        void OnDialogoSelected(String nombre, String pass);
    }

    private void instancias() {
        btnlogin = view.findViewById(R.id.btn_login);
        editnombre = view.findViewById(R.id.texto_usuario_login);
        editPass = view.findViewById(R.id.texto_contraseña_login);
        checkPass = view.findViewById(R.id.check_contraseña_login);
        //al pulsar el boton, si el usuario y pass coinciden con user y pass y ademas el check esta el true que saque un toast con login
        //correcto en caso contrario login incorrecto

    }
}
