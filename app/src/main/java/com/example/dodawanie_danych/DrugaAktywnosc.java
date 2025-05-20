package com.example.dodawanie_danych;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DrugaAktywnosc extends AppCompatActivity {
    Asystent pm = new Asystent(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_druga_aktywnosc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tekst = findViewById(R.id.tekst1);
        Bundle bundle = getIntent().getExtras();
        String imie = bundle.getString("imie");
        String nazwisko = bundle.getString("nazwisko");
        String klasa = bundle.getString("klasa");
        pm.dodaj(imie, nazwisko, klasa);
        Cursor k = pm.wypiszCalosc();
        while(k.moveToNext()) {
            int id = k.getInt(0);
            String imie2 = k.getString(1);
            String nazwisko2 = k.getString(2);
            String klasa2 = k.getString(3);
            tekst.setText(tekst.getText() + "\n" + id + ". " + imie2 + " " + nazwisko2 + " " + klasa2);
        }
        k.close();
    }
    public void powrot(View view) {
        Intent intencja = new Intent(this, MainActivity.class);
        startActivity(intencja);
    }
}