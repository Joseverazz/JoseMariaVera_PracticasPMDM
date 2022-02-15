package com.example.dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dialogos.dialogos.DialogoComunicacion;
import com.example.dialogos.dialogos.DialogoConfirmacion;
import com.example.dialogos.dialogos.DialogoFecha;
import com.example.dialogos.dialogos.DialogoHora;
import com.example.dialogos.dialogos.DialogoInformacion;
import com.example.dialogos.dialogos.DialogoListas;
import com.example.dialogos.dialogos.DialogoLogin;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (item.getItemId()){
            case R.id.menu_Op1:
                //Toast.makeText(getApplicationContext(), "opcion1", Toast.LENGTH_SHORT).show();
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(fragmentManager, "info");
                break;
            case R.id.menu_Op2:
                //Toast.makeText(getApplicationContext(), "opcion2", Toast.LENGTH_SHORT).show();
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(fragmentManager, "Confirm");
                break;
            case R.id.menu_Op3:
               // Toast.makeText(getApplicationContext(), "opcion3", Toast.LENGTH_SHORT).show();
                DialogoListas dialogoListas = new DialogoListas();
                dialogoListas.show(fragmentManager, "Listas");
                break;
            case R.id.menu_Op4:
                DialogoLogin dialogoLogin = new DialogoLogin();
                dialogoLogin.show(fragmentManager, "Login");
                break;
            case R.id.menu_Op5:
                DialogoComunicacion comunicacion = DialogoComunicacion.newInstance("Jorge");
                comunicacion.show(fragmentManager, "comunicacion");
                break;
            case R.id.menu_Op6:
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(fragmentManager,"hora");
                break;
            case R.id.menu_Op7:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(fragmentManager,"fecha");
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void OnDialogoSelected(String n, String p) {
        //escribo lo que quiera
        Toast.makeText(getApplicationContext(), "toast desde el main "+n, Toast.LENGTH_SHORT).show();
       /* Intent intent = new Intent(getApplicationContext(), segundactiviti)
                intent.putExtra("nombre",n);
                intent.putExtra("pass", p);
                startActivity(intent);*/
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(getApplicationContext(), hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Toast.makeText(getApplicationContext(), dayOfMonth+"/"+month+"/"+year,Toast.LENGTH_SHORT).show();
    }
}