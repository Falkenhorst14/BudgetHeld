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

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class Budget extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView tvBudgetErstellen;
    private EditText edtBeschreibung;
    private EditText edtBudgetHoehe;
    private Slider sldBudgetHoehe;
    private Button btnErstellen;
    private Spinner spnKategorie;
    private DBHandler dbHandler;
    private int kategorieAusgewaehlt;
    private ListView lvBudgets;
    private BudgetAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_budget);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvBudgetErstellen = findViewById(R.id.tvBudget);
        edtBeschreibung = findViewById(R.id.edtBeschreibungBudgets);
        edtBudgetHoehe = findViewById(R.id.edtBudgetHoeheBudgets);
        sldBudgetHoehe = findViewById(R.id.sldBudgetHoeheSliderBudgets);
        btnErstellen = findViewById(R.id.btnErstellenBudgets);
        spnKategorie = findViewById(R.id.spnKategorieBudgets);
        dbHandler = new DBHandler(this);
        lvBudgets = findViewById(R.id.lvBudgets);



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
                dbHandler.addNewBudget(edtBeschreibung.getText().toString(), Float.parseFloat(cuttedByCurrency), kategorieAusgewaehlt);
            }
        });

        loadAllBudgets();

        }

    private void loadAllBudgets() {
        ArrayList<Einzelbudget> budgets = dbHandler.getAllBudgets();
        adapter = new BudgetAdapter(this, budgets);
        lvBudgets.setAdapter(adapter);
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