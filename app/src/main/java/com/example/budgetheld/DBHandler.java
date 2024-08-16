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


    private static final String Table_SECOND = "Ausgaben";


    public DBHandler (Context context)

    {
        super(context, DB_Name, null, DB_Version);
        SQLiteDatabase db = this.getWritableDatabase();
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

        String queryAusgaben = "CREATE TABLE " + Table_SECOND + " ("
                + col_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_Beschreibung + " TEXT,"
                + col_HOEHE + " REAL,"
                + col_KATEGORIE + " INTEGER)";

        db.execSQL(queryAusgaben);
    }

    public void addNewBudget(float hoehe, int kategorie)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(col_HOEHE, hoehe);
        values.put(col_KATEGORIE, kategorie);

        db.insert(Table_FIRST, null, values);

        db.close();
    }

    public void addNewAusgabe(String beschreibung, float hoehe, int kategorie)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(col_Beschreibung, beschreibung);
        values.put(col_HOEHE, hoehe);
        values.put(col_KATEGORIE, kategorie);

        db.insert(Table_SECOND, null, values);

        db.close();
    }

    public ArrayList<Einzelbudget> getAllBudgets() {
        ArrayList<Einzelbudget> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + Table_FIRST;

        Cursor cursor = db.rawQuery(query, null);

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

    public ArrayList<Ausgabe> getAllAusgaben() {
        ArrayList<Ausgabe> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + Table_SECOND;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do {
                Ausgabe ausgabe = new Ausgabe();
                ausgabe.setId(cursor.getInt(0));
                ausgabe.setBeschreibung(cursor.getString(1));
                ausgabe.setHoehe(cursor.getFloat(2));
                ausgabe.setKategorie(cursor.getInt(3));
                arrayList.add(ausgabe);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return arrayList;
    }

    public int checkCategoryExistence(int kategorie)
    {
        int ergebnis = -1;
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT COUNT(*) FROM " + Table_FIRST + " WHERE " + col_KATEGORIE + " = " + kategorie + ";";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do
            {
                ergebnis = cursor.getInt(0);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return ergebnis;
    }


    public void deleteBudget(int ID)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(Table_FIRST, "ID=" + Integer.toString(ID),null);
        sqLiteDatabase.close();
    }

    public void deleteAusgabe(int ID)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(Table_SECOND, "ID=" + Integer.toString(ID),null);
        sqLiteDatabase.close();
    }


}
