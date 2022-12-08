package com.example.crono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class cronofuncional extends AppCompatActivity {

    ImageButton pause,playbutton;
    ImageButton lap,resetcrono;
    TextView texto;
    int ms=0,s=0,min=0,h=0;
    RecyclerView rv;
    boolean running=false;
    int ultimo=0,tiempo;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(R.string.titulo_cronometro);
        setContentView(R.layout.activity_cronofuncional);
        lap = findViewById(R.id.lapbutton);
        lap.setOnClickListener(this::laps);
        texto = findViewById(R.id.texto);
        rv=findViewById(R.id.rv);
        pause = findViewById(R.id.pause);
        pause.setOnClickListener(this::pause);
        playbutton = findViewById(R.id.playbutton);
        playbutton.setOnClickListener(this::play);
        resetcrono= findViewById(R.id.resetcrono);
        runTimer();
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(new ArrayList<>());
        rv.setAdapter(adapter);
    }

    private void play(View view) {
        runTimer();
        pause.setVisibility(View.VISIBLE);
        lap.setVisibility(View.VISIBLE);
        playbutton.setVisibility(View.GONE);
        resetcrono.setVisibility(View.GONE);
    }

    private void runTimer() {
        Thread hilo = new Thread(){
            @Override
            public void run() {
                running = true;
                try {
                    while (!isInterrupted()){
                        if (running){
                            tiempo++;
                            ms++;
                            if (ms==1000){
                                s++;
                                ms=0;
                            }
                            if (s==60){
                                min++;
                                s=0;
                            }
                            if (min==60){
                                h++;
                                min=0;
                            }
                            String time = String.format(Locale.getDefault(),"%02d:%02d:%02d.%03d",h,min,s,ms);
                            texto.post(() -> texto.setText(time));
                            sleep(1);
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
    }

    private void laps(View view) {
       adapter.add(new Vueltas(adapter.getItemCount()+1,obtenerLapso(tiempo-ultimo), String.format(Locale.getDefault(),"%02d:%02d:%02d.%03d",h,min,s,ms)));
        ultimo=tiempo;
    }

    public void pause(View view) {
        pause.setVisibility(View.GONE);
        playbutton.setVisibility(View.VISIBLE);
        lap.setVisibility(View.GONE);
        resetcrono.setVisibility(View.VISIBLE);
        running=false;
    }
    public void reset(View view){
        pause.setVisibility(View.GONE);
        playbutton.setVisibility(View.VISIBLE);
        lap.setVisibility(View.GONE);
        resetcrono.setVisibility(View.VISIBLE);
        ms=0;
        s=0;
        min=0;
        h=0;
        String time = String.format(Locale.getDefault(),"%02d:%02d:%02d.%03d",h,min,s,ms);
        texto.setText(time);
       

    }
    public String obtenerLapso(long t){
        long ms,min,h,s;
        ms=t%1000;
        s=(t/1000)%60;
        min=(s%3600)/60;
        h=s/3600;
        s=(s%3600)%60;
        return String.format(Locale.getDefault(),"%02d:%02d:%02d.%03d",h,min,s,ms);

    }
}