package com.example.dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dialogos.dialogos.DialogoConfirmacion;
import com.example.dialogos.dialogos.DialogoInformacion;
import com.example.dialogos.dialogos.DialogoListas;
import com.example.dialogos.dialogos.DialogoLogin;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoListener {

    private FragmentManager fragmentManager; // gestor para poder quitar y poner cosas dentro de la actividad
    private FragmentTransaction fragmentTransaction; // si ya tengo acceso a la pila con el puedo buscar en la pila

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        switch (item.getItemId()) {
            case R.id.menu_op1:
                //Toast.makeText(getApplicationContext(),"Opcion 1", Toast.LENGTH_SHORT).show();
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(fragmentManager, "info");
                break;
            case R.id.menu_op2:
                //Toast.makeText(getApplicationContext(),"Opcion 2", Toast.LENGTH_SHORT).show();
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(fragmentManager, "confirm");
                break;
            case R.id.menu_op3:
                //Toast.makeText(getApplicationContext(),"Opcion 3", Toast.LENGTH_SHORT).show();
                DialogoListas dialogoListas = new DialogoListas();
                dialogoListas.show(fragmentManager, "listas");
                break;
            case R.id.menu_op4:
                //Toast.makeText(getApplicationContext(),"Opcion 4", Toast.LENGTH_SHORT).show();
                DialogoLogin dialogoLogin = new DialogoLogin();
                dialogoLogin.show(fragmentManager, "login");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogoSelected(String usuario, String password, boolean check) {

    }
}