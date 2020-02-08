package edu.ib;

import javafx.beans.property.*;

public class StanyBaterii
{
    private StringProperty nrRejestracyjny;
    private IntegerProperty dystansNaLadowanie;
    private FloatProperty stanBaterii;

    public StanyBaterii() {
        nrRejestracyjny = new SimpleStringProperty();
        dystansNaLadowanie = new SimpleIntegerProperty();
        stanBaterii =new SimpleFloatProperty();

    }

    public String getNrRejestracyjny() { return nrRejestracyjny.get(); }
    public StringProperty nrRejestracyjnyProperty() { return nrRejestracyjny; }
    public void setNrRejestracyjny(String nrRejestracyjny) { this.nrRejestracyjny.set(nrRejestracyjny); }
    public int getDystansNaLadowanie() { return dystansNaLadowanie.get(); }
    public IntegerProperty dystansNaLadowanieProperty() { return dystansNaLadowanie; }
    public void setDystansNaLadowanie(int dystansNaLadowanie) { this.dystansNaLadowanie.set(dystansNaLadowanie); }
    public float getStanBaterii() { return stanBaterii.get(); }
    public FloatProperty stanBateriiProperty() { return stanBaterii; }
    public void setStanBaterii(float stanBaterii) { this.stanBaterii.set(stanBaterii); }
}
