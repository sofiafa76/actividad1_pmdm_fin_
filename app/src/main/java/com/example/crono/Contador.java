package com.example.crono;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Contador extends AppCompatActivity {

    TextView general, c1, cont2, c3;
    Button suma1, suma2, suma3;
    Button resetgen, reset1, reset2, reset3;
    int cgeneralValue=0, c1Value=0, c2Value=0, c3Value=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        this.setTitle(R.string.titulo_contador);

        general = findViewById(R.id.contgen);
        c1 = findViewById(R.id.cont1);
        cont2 = findViewById(R.id.cont2);
        c3 = findViewById(R.id.cont3);

        suma1 = findViewById(R.id.suma1);
        suma2 = findViewById(R.id.suma2);
        suma3 = findViewById(R.id.suma3);

        resetgen = findViewById(R.id.resetgen);
        reset1 = findViewById(R.id.reset1);
        reset2 = findViewById(R.id.reset2);
        reset3 = findViewById(R.id.reset3);

        suma1.setOnClickListener(this::contador1);
        suma2.setOnClickListener(this::contador2);
        suma3.setOnClickListener(this::contador3);
        reset1.setOnClickListener(this::reset1);
        reset2.setOnClickListener(this::reset2);
        reset3.setOnClickListener(this::reset3);
        resetgen.setOnClickListener(this::resetgen);


    }
    public void contador1(View v) {
        cgeneralValue++;
        c1Value++;
        c1.setText(Integer.toString(c1Value));

        general.setText(Integer.toString(cgeneralValue));
    }

    public void contador2(View v) {
        cgeneralValue++;
        c2Value++;
        cont2.setText(Integer.toString(c2Value));
        // cgeneralValue = cgeneralValue + c2Value;
        general.setText(Integer.toString(cgeneralValue));
    }

    public void contador3(View v) {
        cgeneralValue++;
        c3Value++;
        c3.setText(Integer.toString(c3Value));
        // cgeneralValue = cgeneralValue + c3Value;
        general.setText(Integer.toString(cgeneralValue));
    }

    public void reset1(View v) {

        cgeneralValue = cgeneralValue - c1Value;
        general.setText(Integer.toString(cgeneralValue));
        c1Value = 0;
        c1.setText(Integer.toString(c1Value));

    }

    public void reset2(View v) {
        cgeneralValue = cgeneralValue - c2Value;
        general.setText(Integer.toString(cgeneralValue));
        c2Value = 0;
        cont2.setText(Integer.toString(c2Value));
    }

    public void reset3(View v) {
        cgeneralValue = cgeneralValue - c3Value;
        general.setText(Integer.toString(cgeneralValue));
        c3Value = 0;
        c3.setText(Integer.toString(c3Value));
    }

    public void resetgen(View v) {
        cgeneralValue = 0;
        c1Value = 0;
        c2Value = 0;
        c3Value = 0;
        general.setText(Integer.toString(cgeneralValue));
        c1.setText(Integer.toString(c1Value));
        cont2.setText(Integer.toString(c1Value));
        c3.setText(Integer.toString(c1Value));

    }
}