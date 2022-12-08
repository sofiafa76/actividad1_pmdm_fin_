package com.example.crono;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Vueltas> vueltas;

    public Adapter(List<Vueltas> lista) {
        vueltas = lista;
    }

    //Método para añadir las vueltas
    @SuppressLint("NotifyDataSetChanged")
    public void add(Vueltas v) {
        vueltas.add(0, v);
        //Método para notificar los cambios
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //Este método hace que en cada vuelta se use el Layout llamado item.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.laps, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(vueltas.get(position));
    }


    public int getItemCount() {
        return vueltas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView numero;
        private final TextView lapso;
        private final TextView tiempo;

        public ViewHolder(View v) {
            super(v);
            numero = v.findViewById(R.id.numero);
            lapso = v.findViewById(R.id.lapso);
            tiempo = v.findViewById(R.id.tiempo);
        }

        public void bind(Vueltas vuelta) {
            numero.setText(Integer.toString(vuelta.getNumero()));
            lapso.setText(vuelta.getLapso());
            tiempo.setText(vuelta.getTiempo());
        }
    }
}



