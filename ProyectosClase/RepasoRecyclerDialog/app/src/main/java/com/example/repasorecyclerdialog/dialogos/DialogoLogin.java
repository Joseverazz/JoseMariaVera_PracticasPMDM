package com.example.repasorecyclerdialog.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.repasorecyclerdialog.R;

public class DialogoLogin extends DialogFragment {
    private Context context;
    private View view;
    private Button botonLogin;
    private EditText editNombre, editPass;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_login, null, false);
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();
    }

    private void acciones() {
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNombre.getText().toString().equalsIgnoreCase("user")
                        && editPass.getText().toString().equalsIgnoreCase("pass")
                        && checkPass.isChecked()){
                    Toast.makeText(context,"Login CORRECTO", Toast.LENGTH_SHORT).show();
                    listener.onDialogoSelected(editNombre.getText().toString(),editPass.getText().toString(),checkPass.isChecked());
                    dismiss();
                }
                else{
                    Toast.makeText(context,"Login INCORRECTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface OnDialogoListener{
        void onDialogoSelected(String usuario, String password, boolean check);
    }


    private void instancias() {
        botonLogin = view.findViewById(R.id.boton_login);
        editNombre = view.findViewById(R.id.edit_nombre_login);
        editPass = view.findViewById(R.id.edit_password_login);
        checkPass = view.findViewById(R.id.edit_check_login);
    }
}
