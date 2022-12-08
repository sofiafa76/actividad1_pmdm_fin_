package com.example.crono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton crono=findViewById(R.id.botonCrono);
        ImageButton cont=findViewById(R.id.botonContador);
        this.setTitle(R.string.inicioapp);
        crono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c=new Intent(getApplicationContext(), IntroCronometro.class);
                startActivity(c);
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cambioCont=new Intent(getBaseContext(),Contador.class);
                startActivity(cambioCont);
            }
        });
    }
}