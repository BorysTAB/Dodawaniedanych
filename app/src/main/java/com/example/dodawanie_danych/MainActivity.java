package com.example.dodawanie_danych;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void dodaj(View view) {
        EditText im = findViewById(R.id.imie);
        EditText naz = findViewById(R.id.nazwisko);
        EditText kl = findViewById(R.id.klasa);

        String im2 = im.getText().toString();
        String naz2 = naz.getText().toString();
        String kl2 = kl.getText().toString();

        Intent nowaIntencja = new Intent(this, DrugaAktywnosc.class);

        nowaIntencja.putExtra("imie", im2);
        nowaIntencja.putExtra("nazwisko", naz2);
        nowaIntencja.putExtra("klasa", kl2);
        startActivity(nowaIntencja);
    }
}