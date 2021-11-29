package com.josemaria.elementos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener {

        private ToggleButton boton;
        private TextView textoBtn,textoCheck,textoGrupoRadios;
        private CheckBox check;
        private Button BtnComprobar;
        private RadioGroup grupoRadios;
        private RadioButton radioSeleccionado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            instancias();
            acciones();
        }

        private void acciones() {

            BtnComprobar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textoBtn.setText(String.valueOf(boton.isChecked()));
                    textoCheck.setText(String.valueOf(check.isChecked()));
                    radioSeleccionado = findViewById(grupoRadios.getCheckedRadioButtonId());//selecciona el radio que esta seleccionado
                    if(radioSeleccionado!=null)
                    {
                        textoGrupoRadios.setText(radioSeleccionado.getText());
                    }

                }
            });
            boton.setOnCheckedChangeListener(this);
            check.setOnCheckedChangeListener(this);
            grupoRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    radioSeleccionado = (RadioButton)findViewById(checkedId);
                    textoGrupoRadios.setText(radioSeleccionado.getText());
                    /*switch (checkedId)
                    {
                        case R.id.radio_uno:
                            textoGrupoRadios.setText("Opcion 1");
                            break;
                        case R.id.radio_dos:
                            textoGrupoRadios.setText("Opcion 2");
                            break;
                        case R.id.radio_tres:
                            textoGrupoRadios.setText("Opcion 3");
                            break;
                    }*/
                }
            });



        }

        private void instancias() {

            boton = findViewById(R.id.toggle);
            textoBtn = findViewById(R.id.textBoton);
            check = findViewById(R.id.check);
            BtnComprobar = findViewById(R.id.btnComprobar);
            textoCheck = findViewById(R.id.textCheck);
            grupoRadios = findViewById(R.id.grupo_radios);
            textoGrupoRadios = findViewById(R.id.texto_grupo);


        }


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId())
            {
                case R.id.check:
                    if(check.isChecked())
                        textoCheck.setText("Esta checkeado");
                    else
                        textoCheck.setText("NO Esta checkeado");
                    break;
                case R.id.toggle:
                    if(check.isChecked())
                        textoBtn.setText("Boton encendido");
                    else
                        textoBtn.setText("Boton apagado");
                    break;
            }
        }
    }