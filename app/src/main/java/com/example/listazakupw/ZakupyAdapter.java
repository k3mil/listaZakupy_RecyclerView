package com.example.listazakupw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder> {
    private ArrayList<Produkt> listaZakopow;
    private LayoutInflater inflater;

    public ZakupyAdapter(Context context, ArrayList<Produkt> listaZakopow) {
        this.listaZakopow = listaZakopow;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.produkt_layout,parent,false);
        return new ProduktViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {
        holder.checkBoxProdukt.setText(listaZakopow.get(position).toString());
        holder.checkBoxProdukt.setChecked(listaZakopow.get(position).getCzyZakupiono());

    }

    @Override
    public int getItemCount() {
        return listaZakopow.size();
    }

    public class ProduktViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBoxProdukt;
        ZakupyAdapter zakupyAdapter;
        public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            zakupyAdapter = adapter;
            checkBoxProdukt = itemView.findViewById(R.id.checkBox);
        }
    }
}
