package com.example.budgetheld;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class Budget extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView tvBudgetErstellen;
    private EditText edtBeschreibung;
    private EditText edtBudgetHoehe;
    private Slider sldBudgetHoehe;
    private Button btnErstellen;
    private Spinner spnKategorie;



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
        edtBeschreibung = findViewById(R.id.edtBeschreibung);
        edtBudgetHoehe = findViewById(R.id.edtBudgetHoehe);
        sldBudgetHoehe = findViewById(R.id.sldBudgetHoeheSlider);
        btnErstellen = findViewById(R.id.btnErstellen);
        spnKategorie = findViewById(R.id.spnKategorie);


        String[] items = new String[]{"Haushaltswaren", "Elektronik", "Außergewöhnliches", "Sonstiges"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, items);


        spnKategorie.setAdapter(adapter);

        spnKategorie.setOnItemSelectedListener(this);

        sldBudgetHoehe.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                edtBudgetHoehe.setText(String.valueOf(value) + " €");
            }
        });

        }

        @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        switch (choice) {
            case "Haushaltswaren":

                break;
            case "Elektronik":

                break;
            case "Außergewöhnliches":

                break;
            case "Sonstiges":

                break;
            default:

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}