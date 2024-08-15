package com.example.budgetheld;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class Ausgaben extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private TextView tvAusgabeErstellen;
    private EditText edtBeschreibung;
    private EditText edtBudgetHoehe;
    private Slider sldBudgetHoehe;
    private Button btnErstellen;
    private Spinner spnKategorie;
    private DBHandler dbHandler;
    private int kategorieAusgewaehlt;
    private ListView lvAusgaben;
    private AusgabenAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ausgaben);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvAusgabeErstellen = findViewById(R.id.tvAusgabErstellen);
        edtBeschreibung = findViewById(R.id.edtBeschreibungAusgaben);
        edtBudgetHoehe = findViewById(R.id.edtBudgetHoeheAusgaben);
        sldBudgetHoehe = findViewById(R.id.sldBudgetHoeheSliderAusgaben);
        btnErstellen = findViewById(R.id.btnErstellenAusgaben);
        spnKategorie = findViewById(R.id.spnKategorieAusgaben);
        dbHandler = new DBHandler(this);
        lvAusgaben = findViewById(R.id.lvAusgaben);
        lvAusgaben.setAdapter(adapter);
        lvAusgaben.setEnabled(true);


        String[] items = new String[]{"Haushaltswaren", "Elektronik", "Außergewöhnliches", "Sonstiges"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, items);


        spnKategorie.setAdapter(spinnerAdapter);
        spnKategorie.setOnItemSelectedListener(this);

        sldBudgetHoehe.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                edtBudgetHoehe.setText(String.valueOf(value) + " €");
            }
        });

        btnErstellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cuttedByCurrency = edtBudgetHoehe.getText().toString().replace("€", "").replace(" ", "");
                dbHandler.addNewAusgabe(edtBeschreibung.getText().toString(), Float.parseFloat(cuttedByCurrency), kategorieAusgewaehlt);
                loadAllAusgaben();
            }
        });

        loadAllAusgaben();

        lvAusgaben.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ausgabe myAusgabe = adapter.getItem(position);
                dbHandler.deleteAusgabe(adapter.getItem(position).getId());
                Toast.makeText(getApplicationContext(), "Ausgabe " + myAusgabe.getBeschreibung() +  " gelöscht.", Toast.LENGTH_SHORT).show();
                loadAllAusgaben();
            }
        });

    }


    private void loadAllAusgaben() {
        ArrayList<Ausgabe> ausgaben = dbHandler.getAllAusgaben();
        adapter = new AusgabenAdapter(this, ausgaben);
        lvAusgaben.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        switch (choice) {
            case "Haushaltswaren":
                kategorieAusgewaehlt = 1;
                break;
            case "Elektronik":
                kategorieAusgewaehlt = 2;
                break;
            case "Außergewöhnliches":
                kategorieAusgewaehlt = 3;
                break;
            case "Sonstiges":
                kategorieAusgewaehlt = 4;
                break;
            default:
                kategorieAusgewaehlt = 0;
                break;
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}

