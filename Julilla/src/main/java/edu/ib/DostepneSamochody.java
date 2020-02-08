package edu.ib;

import javafx.beans.property.*;

public class DostepneSamochody
{
    private StringProperty nrRejestracyjny;
    private StringProperty nazwa;
    private StringProperty marka;
    private IntegerProperty licznikKm;
    private IntegerProperty dystansKmNaLadowanie;
    private FloatProperty stanBaterii;
    private StringProperty dataWygasnieciaPrzegladu;
    private StringProperty uszkodzenia;

    public DostepneSamochody() {
        nrRejestracyjny = new SimpleStringProperty();
        nazwa = new SimpleStringProperty();
        marka = new SimpleStringProperty();
        licznikKm = new SimpleIntegerProperty();
        dystansKmNaLadowanie = new SimpleIntegerProperty();
        stanBaterii = new SimpleFloatProperty();
        dataWygasnieciaPrzegladu = new SimpleStringProperty();
        uszkodzenia = new SimpleStringProperty();
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny.get();
    }

    public StringProperty nrRejestracyjnyProperty() {
        return nrRejestracyjny;
    }

    public void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny.set(nrRejestracyjny);
    }

    public String getNazwa() {
        return nazwa.get();
    }

    public StringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    public String getMarka() {
        return marka.get();
    }

    public StringProperty markaProperty() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka.set(marka);
    }

    public int getLicznikKm() {
        return licznikKm.get();
    }

    public IntegerProperty licznikKmProperty() {
        return licznikKm;
    }

    public void setLicznikKm(int licznikKm) {
        this.licznikKm.set(licznikKm);
    }

    public int getDystansKmNaLadowanie() {
        return dystansKmNaLadowanie.get();
    }

    public IntegerProperty dystansKmNaLadowanieProperty() {
        return dystansKmNaLadowanie;
    }

    public void setDystansKmNaLadowanie(int dystansKmNaLadowanie) {
        this.dystansKmNaLadowanie.set(dystansKmNaLadowanie);
    }

    public float getStanBaterii() {
        return stanBaterii.get();
    }

    public FloatProperty stanBateriiProperty() {
        return stanBaterii;
    }

    public void setStanBaterii(float stanBaterii) {
        this.stanBaterii.set(stanBaterii);
    }

    public String getDataWygasnieciaPrzegladu() {
        return dataWygasnieciaPrzegladu.get();
    }

    public StringProperty dataWygasnieciaPrzegladuProperty() {
        return dataWygasnieciaPrzegladu;
    }

    public void setDataWygasnieciaPrzegladu(String dataWygasnieciaPrzegladu) {
        this.dataWygasnieciaPrzegladu.set(dataWygasnieciaPrzegladu);
    }

    public String getUszkodzenia() {
        return uszkodzenia.get();
    }

    public StringProperty uszkodzeniaProperty() {
        return uszkodzenia;
    }

    public void setUszkodzenia(String uszkodzenia) {
        this.uszkodzenia.set(uszkodzenia);
    }
}
