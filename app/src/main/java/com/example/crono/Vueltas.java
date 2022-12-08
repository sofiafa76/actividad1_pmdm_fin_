package com.example.crono;

public class Vueltas {
    //Creo una clase para poder almacenar las vueltas
    private int numero;
    private String lapso;
    private String tiempo;

    public Vueltas(int numero, String lapso, String tiempo) {
        this.numero = numero;
        this.lapso = lapso;
        this.tiempo = tiempo;
    }

    public int getNumero() {
        return numero;
    }

    public String getLapso() {
        return lapso;
    }

    public String getTiempo() {
        return tiempo;
    }
}

