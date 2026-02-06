 package com.example.listazakupw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ZakupyAdapter zakupyAdapter;
    private Button usunZaznaczone, dodaj;
    private ArrayList<Produkt> listaZakupowArrayList = new ArrayList<>();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        usunZaznaczone = findViewById(R.id.zaznaczenie);
        dodaj = findViewById(R.id.dodaj);
        editText = findViewById(R.id.editTextText);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listaZakupowArrayList.add(new Produkt("mąka"));
        listaZakupowArrayList.add(new Produkt("platki"));
        listaZakupowArrayList.add(new Produkt("jajka"));
        zakupyAdapter = new ZakupyAdapter(MainActivity.this,listaZakupowArrayList);
        recyclerView.setAdapter(zakupyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        usunZaznaczone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zakupyAdapter.usuwanieZaznaczone();
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zakupyAdapter.dodajProdukt(new Produkt(editText.getText().toString()));
            }
        });
    }
}