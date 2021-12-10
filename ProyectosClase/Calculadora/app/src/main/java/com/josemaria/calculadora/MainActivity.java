package com.josemaria.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnBorrar, btnMas, btnMenos,btnMultiplicar, btnDividir, btnMasMenos, btnModulo, btnIgual, btnCos,btnSen,btnTan,btnLog;

    private TextView textResultado;
    private String operacion;
    private int n1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            accionesLand();
        }
    }

    private void accionesLand() {
        btnCos.setOnClickListener(this);
        btnSen.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnLog.setOnClickListener(this);
    }

    private void acciones() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnMas.setOnClickListener(this);
        btnMasMenos.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnModulo.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
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
        textResultado = findViewById(R.id.text_resultado);
        btnCos = findViewById(R.id.btnCos);
        btnSen = findViewById(R.id.btnSen);
        btnTan = findViewById(R.id.btnTan);
        btnLog = findViewById(R.id.btnLog);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnModulo || v.getId() == R.id.btnMas ||
                v.getId() == R.id.btnMenos|| v.getId()== R.id.btnMultiplicacion ||
                v.getId() == R.id.btnDividir){
            operacion = String.valueOf(((Button) findViewById(v.getId())).getText());
            n1 = Integer.parseInt(String.valueOf(textResultado.getText()));
            textResultado.setText("");
        }
        else if (v.getId() == R.id.btnBorrar){
            operacion = "";
            textResultado.setText("");
        }
        else if (v.getId() == R.id.btnMasMenos){
            textResultado.setText(String.valueOf(Integer.parseInt(textResultado.getText()+"")*-1));
        }
        else if (v.getId() == R.id.btnCos) {
            int res = Integer.parseInt(String.valueOf(textResultado.getText()));
            textResultado.setText(String.valueOf(Math.cos(res)));
        }
        else if (v.getId() == R.id.btnSen) {
            int res = Integer.parseInt(String.valueOf(textResultado.getText()));
            textResultado.setText(String.valueOf(Math.sin(res)));
        }
        else if (v.getId() == R.id.btnLog) {
            int res = Integer.parseInt(String.valueOf(textResultado.getText()));
            textResultado.setText(String.valueOf(Math.log(res)));
        }
        else if (v.getId() == R.id.btnTan) {
            int res = Integer.parseInt(String.valueOf(textResultado.getText()));
            textResultado.setText(String.valueOf(Math.tan(res)));
        }
        else if (v.getId() == R.id.btnIgual){
            int n2 = Integer.parseInt(String.valueOf(textResultado.getText()));
            switch (operacion) {
                case "+": {
                    int res = n1 + n2;
                    textResultado.setText(String.valueOf(res));
                    break;
                }
                case "-": {
                    int res = n1 - n2;
                    textResultado.setText(String.valueOf(res));
                    break;
                }
                case "x": {
                    int res = n1 * n2;
                    textResultado.setText(String.valueOf(res));
                    break;
                }
                case "/": {
                    int res = n1 / n2;
                    textResultado.setText(String.valueOf(res));
                    break;
                }
                case "%": {
                    int res = n1 % n2;
                    textResultado.setText(String.valueOf(res));
                    break;
                }
            }
        }
        else{
            textResultado.append(String.valueOf(((Button) findViewById(v.getId())).getText()));
        }
    }

}