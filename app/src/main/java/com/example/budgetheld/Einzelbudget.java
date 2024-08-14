package com.example.budgetheld;

public class Einzelbudget
{

    private int id;
    private String beschreibung;
    private int getKategorie;
    private float hoehe;


    /*****************************************************************************************
     *                                                                                       |
     *                                   Konstruktoren                                       |
     ****************************************************************************************/

    public Einzelbudget()
    {

    }

    public Einzelbudget(String beschreibung, int kategorie, float hoehe)
    {
        this.beschreibung = beschreibung;
        this.getKategorie = kategorie;
        this.hoehe = hoehe;
    }

    /*****************************************************************************************
     *                                                                                       |
     *                                      GETTER                                           |
     ****************************************************************************************/
    public float getHoehe() {
        return hoehe;
    }

    public int getKategorie() {
        return getKategorie;
    }

    public int getId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }


    /*****************************************************************************************
     *                                                                                       |
     *                                      SETTER                                           |
     ****************************************************************************************/

    public void setId(int id) {
        this.id = id;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setKategorie(int getKategorie) {
        this.getKategorie = getKategorie;
    }

    public void setHoehe(float hoehe) {
        this.hoehe = hoehe;
    }


}
