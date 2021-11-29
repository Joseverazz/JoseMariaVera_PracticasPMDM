package com.josemaria.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnBorrar, btnMas, btnMenos,btnMultiplicar, btnDividir, btnMasMenos, btnModulo, btnIgual;

    private TextField TextResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnIgual = findViewById(R.id.btnIgual);
        btnMas = findViewById(R.id.btnMas);
        btnMasMenos = findViewById(R.id.btnMasMenos);
        btnMenos = findViewById(R.id.btnMenos);
        btnMultiplicar = findViewById(R.id.btnMultiplicacion);
        btnModulo = findViewById(R.id.btnModulo);
        btnDividir = findViewById(R.id.btnDividir);
    }
}