package com.example.budgetheld;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    TextView tvPercentageHaushaltswaren;
    TextView tvPercentageElektronik;
    TextView tvPercentageKleidung;
    TextView tvPercentageUnterhaltung;
    TextView tvPercentageEssenTrinken;
    TextView tvPercentageSport;
    TextView tvPercentageAussergewoehnliches;
    TextView tvPercentageSonstiges;

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

        tvPercentageHaushaltswaren = findViewById(R.id.tvPercentageHaushaltswaren);
        tvPercentageElektronik = findViewById(R.id.tvPercentageElektronik);
        tvPercentageKleidung = findViewById(R.id.tvPercentageKleidung);
        tvPercentageUnterhaltung = findViewById(R.id.tvPercentageUnterhaltung);
        tvPercentageEssenTrinken = findViewById(R.id.tvPercentageEssenTrinken);
        tvPercentageSport = findViewById(R.id.tvPercentageSport);
        tvPercentageAussergewoehnliches = findViewById(R.id.tvPercentageAussergewoehnliches);
        tvPercentageSonstiges = findViewById(R.id.tvPercentageSonstiges);



        int PercentageHaushaltswaren = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(1))/(dbHandler.getBudgetByKategorie(1))*100)));
        tvPercentageHaushaltswaren.setText(String.valueOf(PercentageHaushaltswaren) + " %");
        pgbCustomHaushaltswaren.setProgress(PercentageHaushaltswaren);
        int PercentageElektronik = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(2))/(dbHandler.getBudgetByKategorie(2))*100)));
        tvPercentageElektronik.setText(String.valueOf(PercentageElektronik) + " %");
        pgbCustomElektronik.setProgress(PercentageElektronik);
        int PercentageKleidung = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(3))/(dbHandler.getBudgetByKategorie(3))*100)));
        tvPercentageKleidung.setText(String.valueOf(PercentageKleidung) + " %");
        pgbCustomKleidung.setProgress(PercentageKleidung);
        int PercentageUnterhaltung = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(4))/(dbHandler.getBudgetByKategorie(4))*100)));
        tvPercentageUnterhaltung.setText(String.valueOf(PercentageUnterhaltung) + " %");
        pgbCustomUnterhaltung.setProgress(PercentageUnterhaltung);
        int PercentageEssenTrinken = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(5))/(dbHandler.getBudgetByKategorie(5))*100)));
        tvPercentageEssenTrinken.setText(String.valueOf(PercentageEssenTrinken) + " %");
        pgbCustomEssenTrinken.setProgress(PercentageEssenTrinken);
        int PercentageSport = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(6))/(dbHandler.getBudgetByKategorie(6))*100)));
        tvPercentageSport.setText(String.valueOf(PercentageSport) + " %");
        pgbCustomSport.setProgress(PercentageSport);
        int PercentageAussergewoehnliches = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(7))/(dbHandler.getBudgetByKategorie(7))*100)));
        tvPercentageAussergewoehnliches.setText(String.valueOf(PercentageAussergewoehnliches) + " %");
        pgbCustomAussergewoehnliches.setProgress(PercentageAussergewoehnliches);
        int PercentageSonstiges = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(8))/(dbHandler.getBudgetByKategorie(8))*100)));
        tvPercentageSonstiges.setText(String.valueOf(PercentageSonstiges) + " %");
        pgbCustomSonstiges.setProgress(PercentageSonstiges);


    }
}