package com.example.dodawanie_danych;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Asystent extends SQLiteOpenHelper {
    public Asystent(Context context) {
        super(context, "szkola.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase bd1) {
        bd1.execSQL("CREATE TABLE UCZEN (id INTEGER PRIMARY KEY AUTOINCREMENT, " + "IMIE text,"
                + "NAZWISKO text, " + "KLASA text);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase bd1, int nowa, int stara) {

    }
    public void dodaj(String imie, String nazwisko, String klasa) {
        SQLiteDatabase bd1 = getWritableDatabase();
        ContentValues dane = new ContentValues();
        dane.put("imie",imie);
        dane.put("nazwisko",nazwisko);
        dane.put("klasa",klasa);
        bd1.insertOrThrow("UCZEN",null,dane);
    }
    public Cursor wypiszCalosc() {
        SQLiteDatabase bd1 = getReadableDatabase();
        Cursor kursor = bd1.rawQuery("SELECT * from UCZEN ", null);
        return kursor;
    }



}
