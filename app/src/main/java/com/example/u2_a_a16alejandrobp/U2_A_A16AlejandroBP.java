package com.example.u2_a_a16alejandrobp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

import androidx.appcompat.app.AppCompatActivity;

public class U2_A_A16AlejandroBP extends AppCompatActivity {

    int tempoPeche = 15;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Chronometer crono = (Chronometer) findViewById(R.id.cronometro);
        crono.setOnChronometerTickListener(new OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                // TODO Auto-generated method stub

                long tempoPasado = SystemClock.elapsedRealtime()
                        - chronometer.getBase();
                int tempoSeg = (int) tempoPasado / 1000;
                if (tempoSeg == tempoPeche)
                    finish();
            }
        });

        Spinner spinProvincias = (Spinner) findViewById(R.id.spin_provincias);
        spinProvincias.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // TODO Auto-generated method stub

                if (pos == 4) {
                    Toast.makeText(U2_A_A16AlejandroBP.this, getString(R.string.provinceno), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(U2_A_A16AlejandroBP.this, getString(R.string.provinceyes), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        final Switch boton_sw = (Switch) findViewById(R.id.boton_sw);
        boton_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crono.setBase(SystemClock.elapsedRealtime());
                if(boton_sw.isChecked()){
                    crono.start();
                } else{
                    crono.stop();
                }
            }
        });
        final TextView textApp = (TextView) findViewById(R.id.textApp);
        final EditText et = (EditText) findViewById(R.id.et);
        final CheckBox chk = (CheckBox) findViewById(R.id.chk);
        Button add_clear = (Button) findViewById(R.id.add_clear);
        add_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isChecked()){
                    textApp.setText("");
                }else{
                    textApp.setText(textApp.getText() + " " + et.getText());
                }
                et.setText("");
            }
        });

    }

    public void cambiarColor(View v){
        TextView textApp = findViewById(R.id.textApp);
        if (v.getId()==R.id.rbtn_red) {
            textApp.setTextColor(getResources().getColor(R.color.red));
        }else{
            textApp.setTextColor(getResources().getColor(R.color.blue));
        }
    }
    public void imageClick(View v) {
        Toast.makeText(this, getString(R.string.cathedral), Toast.LENGTH_LONG).show();
    }


}

