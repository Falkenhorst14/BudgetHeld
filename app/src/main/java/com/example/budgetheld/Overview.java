package com.example.budgetheld;

import android.graphics.Color;
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
        if (PercentageHaushaltswaren == 0)
        {
            tvPercentageHaushaltswaren.setText("Leer");
            tvPercentageHaushaltswaren.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageHaushaltswaren < 0)
        {
            tvPercentageHaushaltswaren.setText("Überschritten");
            tvPercentageHaushaltswaren.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageHaushaltswaren.setText(String.valueOf(PercentageHaushaltswaren) + " %");
        }
        pgbCustomHaushaltswaren.setProgress(PercentageHaushaltswaren);
        int PercentageElektronik = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(2))/(dbHandler.getBudgetByKategorie(2))*100)));
        if (PercentageElektronik == 0)
        {
            tvPercentageElektronik.setText("Leer");
            tvPercentageElektronik.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageElektronik < 0)
        {
            tvPercentageElektronik.setText("Überschritten");
            tvPercentageElektronik.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageElektronik.setText(String.valueOf(PercentageElektronik) + " %");
        }
        pgbCustomElektronik.setProgress(PercentageElektronik);
        int PercentageKleidung = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(3))/(dbHandler.getBudgetByKategorie(3))*100)));
        if (PercentageKleidung == 0)
        {
            tvPercentageKleidung.setText("Leer");
            tvPercentageKleidung.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageKleidung < 0)
        {
            tvPercentageKleidung.setText("Überschritten");
            tvPercentageKleidung.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageKleidung.setText(String.valueOf(PercentageKleidung) + " %");
        }
        pgbCustomKleidung.setProgress(PercentageKleidung);
        int PercentageUnterhaltung = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(4))/(dbHandler.getBudgetByKategorie(4))*100)));
        if (PercentageUnterhaltung == 0)
        {
            tvPercentageUnterhaltung.setText("Leer");
            tvPercentageUnterhaltung.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageUnterhaltung < 0)
        {
            tvPercentageUnterhaltung.setText("Überschritten");
            tvPercentageUnterhaltung.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageUnterhaltung.setText(String.valueOf(PercentageUnterhaltung) + " %");
        }
        pgbCustomUnterhaltung.setProgress(PercentageUnterhaltung);
        int PercentageEssenTrinken = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(5))/(dbHandler.getBudgetByKategorie(5))*100)));
        if (PercentageEssenTrinken == 0)
        {
            tvPercentageEssenTrinken.setText("Leer");
            tvPercentageEssenTrinken.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageEssenTrinken < 0)
        {
            tvPercentageEssenTrinken.setText("Überschritten");
            tvPercentageEssenTrinken.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageEssenTrinken.setText(String.valueOf(PercentageEssenTrinken) + " %");
        }
        pgbCustomEssenTrinken.setProgress(PercentageEssenTrinken);
        int PercentageSport = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(6))/(dbHandler.getBudgetByKategorie(6))*100)));
        if (PercentageSport == 0)
        {
            tvPercentageSport.setText("Leer");
            tvPercentageSport.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageSport < 0)
        {
            tvPercentageSport.setText("Überschritten");
            tvPercentageSport.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageSport.setText(String.valueOf(PercentageSport) + " %");
        }
        pgbCustomSport.setProgress(PercentageSport);
        int PercentageAussergewoehnliches = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(7))/(dbHandler.getBudgetByKategorie(7))*100)));
        if (PercentageAussergewoehnliches == 0)
        {
            tvPercentageAussergewoehnliches.setText("Leer");
            tvPercentageAussergewoehnliches.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageAussergewoehnliches < 0)
        {
            tvPercentageAussergewoehnliches.setText("Überschritten");
            tvPercentageAussergewoehnliches.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageAussergewoehnliches.setText(String.valueOf(PercentageAussergewoehnliches) + " %");
        }
        pgbCustomAussergewoehnliches.setProgress(PercentageAussergewoehnliches);
        int PercentageSonstiges = Math.toIntExact(Math.round(100-((dbHandler.sumAllAusgabenByKategorie(8))/(dbHandler.getBudgetByKategorie(8))*100)));
        if (PercentageSonstiges == 0)
        {
            tvPercentageSonstiges.setText("Leer");
            tvPercentageSonstiges.setTextColor(Color.parseColor("#ff4545"));
        }
        else if (PercentageSonstiges < 0)
        {
            tvPercentageSonstiges.setText("Überschritten");
            tvPercentageSonstiges.setTextColor(Color.parseColor("#ff4545"));
        }
        else
        {
            tvPercentageSonstiges.setText(String.valueOf(PercentageSonstiges) + " %");
        }
        pgbCustomSonstiges.setProgress(PercentageSonstiges);

    }
}