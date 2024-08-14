package com.example.budgetheld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;


public class BudgetAdapter extends ArrayAdapter<Einzelbudget>
{
    public BudgetAdapter(Context context, List<Einzelbudget> budgets) {
        super(context, 0, budgets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Einzelbudget einzelbudget = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        TextView tvBeschreibung = convertView.findViewById(R.id.tvBeschreibung);
        TextView tvHoehe = convertView.findViewById(R.id.tvHoehe);
        TextView tvKategorie = convertView.findViewById(R.id.tvKategorie);

        String kategorie = "";

        assert einzelbudget != null;
        switch (einzelbudget.getKategorie()) {
            case 1:
                kategorie = "Haushaltswaren";
                break;
            case 2:
                kategorie = "Elektronik";
                break;
            case 3:
                kategorie = "Außergewöhnliches";
                break;
            case 4:
                kategorie = "Sonstiges";
                break;
            default:
                kategorie = "Nicht angegeben";
                break;
        }

        assert einzelbudget != null;
        tvBeschreibung.setText(einzelbudget.getBeschreibung());
        tvHoehe.setText(String.valueOf(einzelbudget.getHoehe()));
        tvKategorie.setText(kategorie);

        return convertView;
    }
}
