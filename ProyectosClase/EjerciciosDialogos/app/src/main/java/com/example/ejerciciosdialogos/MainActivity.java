package com.example.ejerciciosdialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ejerciciosdialogos.Dialogos.Dialogo1;

public class MainActivity extends AppCompatActivity implements Dialogo1.OnDialogoListener{

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
            case R.id.menu_OpStart:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnDialogo1Si() {

    }
}