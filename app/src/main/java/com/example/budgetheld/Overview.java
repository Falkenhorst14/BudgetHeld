package com.example.budgetheld;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Overview extends AppCompatActivity {

    ProgressBar pgbCustomHaushaltswaren;
    ProgressBar pgbCustomElektronik;
    ProgressBar pgbCustomKleidung;
    ProgressBar pgbCustomUnterhaltung;
    ProgressBar pgbCustomEssenTrinken;
    ProgressBar pgbCustomSport;
    ProgressBar pgbCustomAussergewoehnliches;
    ProgressBar pgbCustomSonstiges;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_overview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pgbCustomHaushaltswaren = findViewById(R.id.pgb_customHaushaltswaren);
        pgbCustomElektronik = findViewById(R.id.pgb_customElektronik);
        pgbCustomKleidung = findViewById(R.id.pgb_customKleidung);
        pgbCustomUnterhaltung = findViewById(R.id.pgb_customUnterhaltung);
        pgbCustomEssenTrinken = findViewById(R.id.pgb_customEssenTrinken);
        pgbCustomSport = findViewById(R.id.pgb_customSport);
        pgbCustomAussergewoehnliches = findViewById(R.id.pgb_customAussergewoehnliches);
        pgbCustomSonstiges = findViewById(R.id.pgb_customSonstiges);
        dbHandler = new DBHandler(this);



        pgbCustomHaushaltswaren.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(1))/(dbHandler.getBudgetByKategorie(1))*100))));
        pgbCustomElektronik.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(2))/(dbHandler.getBudgetByKategorie(2))*100))));
        pgbCustomKleidung.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(3))/(dbHandler.getBudgetByKategorie(3))*100))));
        pgbCustomUnterhaltung.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(4))/(dbHandler.getBudgetByKategorie(4))*100))));
        pgbCustomEssenTrinken.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(5))/(dbHandler.getBudgetByKategorie(5))*100))));
        pgbCustomSport.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(6))/(dbHandler.getBudgetByKategorie(6))*100))));
        pgbCustomAussergewoehnliches.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(7))/(dbHandler.getBudgetByKategorie(7))*100))));
        pgbCustomSonstiges.setProgress
                (Math.toIntExact(
                        Math.round(100-((dbHandler.sumAllAusgabenByKategorie(8))/(dbHandler.getBudgetByKategorie(8))*100))));

    }
}