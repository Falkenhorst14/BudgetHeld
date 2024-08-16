package com.example.budgetheld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;


public class AusgabenAdapter extends ArrayAdapter<Ausgabe>
{
    public AusgabenAdapter(Context context, List<Ausgabe> ausgaben) {
        super(context, 0, ausgaben);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ausgabe ausgabe = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_ausgabe, parent, false);
        }


        TextView tvBeschreibung = convertView.findViewById(R.id.tvBeschreibungAusgabe);
        TextView tvHoehe = convertView.findViewById(R.id.tvHoeheAusgabe);
        TextView tvKategorie = convertView.findViewById(R.id.tvKategorieAusgabe);

        String kategorie = "";

        assert ausgabe != null;
        switch (ausgabe.getKategorie()) {
            case 1:
                kategorie = "Haushaltswaren";
                break;
            case 2:
                kategorie = "Elektronik";
                break;
            case 3:
                kategorie = "Kleidung";
                break;
            case 4:
                kategorie = "Unterhaltung";
                break;
            case 5:
                kategorie = "Essen & Trinken";
                break;
            case 6:
                kategorie = "Sport";
                break;
            case 7:
                kategorie = "Außergewöhnliches";
                break;
            case 8:
                kategorie = "Sonstiges";
                break;
            default:
                kategorie = "Nicht angegeben";
                break;
        }

        assert ausgabe != null;
        tvBeschreibung.setText(ausgabe.getBeschreibung());
        tvHoehe.setText(String.valueOf(ausgabe.getHoehe()));
        tvKategorie.setText(kategorie);

        return convertView;
    }
}
