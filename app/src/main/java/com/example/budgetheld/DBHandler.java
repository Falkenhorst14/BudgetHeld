package com.example.budgetheld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper {


    private static final String DB_Name = "BudgetHeld";
    private static final int DB_Version = 1;
    private static final String Table_FIRST = "Budgets";
    private static final String col_ID = "id";
    private static final String col_Beschreibung = "beschreibung";
    private static final String col_HOEHE = "hoehe";
    private static final String col_KATEGORIE = "kategorie";


    public DBHandler (Context context)
    {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_FIRST + " ("
                + col_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_Beschreibung + " TEXT,"
                + col_HOEHE + " REAL,"
                + col_KATEGORIE + " INTEGER)";

        db.execSQL(query);
    }

    public void addNewBudget(String beschreibung, float hoehe, int kategorie)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(col_Beschreibung, beschreibung);
        values.put(col_HOEHE, hoehe);
        values.put(col_KATEGORIE, kategorie);

        db.insert(Table_FIRST, null, values);

        db.close();
    }

    public ArrayList<Einzelbudget> getAllBudgets() {
        ArrayList<Einzelbudget> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + Table_FIRST;

        Cursor cursor = db.rawQuery(query, null);

        //Schleife iteriert durch alle Zeilen, waehrend die Daten in List geladen werden
        if(cursor.moveToFirst())
        {
            do {
                Einzelbudget einzelbudget = new Einzelbudget();
                einzelbudget.setId(cursor.getInt(0));
                einzelbudget.setBeschreibung(cursor.getString(1));
                einzelbudget.setHoehe(cursor.getFloat(2));
                einzelbudget.setKategorie(cursor.getInt(3));
                arrayList.add(einzelbudget);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return arrayList;
    }

}
