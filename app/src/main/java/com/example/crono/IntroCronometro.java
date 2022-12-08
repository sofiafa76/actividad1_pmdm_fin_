package com.example.crono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IntroCronometro extends AppCompatActivity {

    ImageButton iniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_cronometro);
        iniciar = findViewById(R.id.inicioButton);
        iniciar.setOnClickListener(this::iniciar);
        this.setTitle(R.string.titulo_cronometro);
    }
    public void iniciar(View v) {
        Intent intent2 = new Intent(this, cronofuncional.class);
        startActivity(intent2);
    }
}