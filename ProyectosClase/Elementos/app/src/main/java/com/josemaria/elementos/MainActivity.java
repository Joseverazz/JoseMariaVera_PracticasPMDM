package com.josemaria.elementos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton toggle;
    private TextView textToggle,textCheck;
    private CheckBox check;
    private Button btnComprobar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToggle.setText(String.valueOf(toggle.isChecked()));
                textCheck.setText(String.valueOf(check.isChecked()));
            }
        });
        toggle.setOnCheckedChangeListener(this);
        check.setOnCheckedChangeListener(this);
    }

    private void instancias() {

        toggle = findViewById(R.id.toggle);
        textToggle = findViewById(R.id.text_toggle);
        textCheck = findViewById(R.id.text_check);
        check = findViewById(R.id.check);
        btnComprobar = findViewById(R.id.btn_comprobar);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.check:
                textCheck.setText(String.valueOf(check.isChecked()));
                break;
            case R.id.toggle:
                textToggle.setText(String.valueOf(toggle.isChecked()));
                break;
        }
    }
}