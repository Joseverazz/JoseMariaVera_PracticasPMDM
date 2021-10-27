package com.josemaria.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.v("ciclo-vida","pasando por OnCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v("ciclo-vida","pasando por OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ciclo-vida","pasando por OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ciclo-vida","pasando por OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ciclo-vida","pasando por OnResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ciclo-vida","pasando por OnDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ciclo-vida","pasando por OnStop");
    }
}