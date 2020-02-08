package edu.ib;

import javafx.beans.property.*;

public class Samochod
{
    private StringProperty nr_rejestracyjny;
    private StringProperty nazwa;
    private StringProperty marka;
    private IntegerProperty dystans_km_na_ladowanie;
    private IntegerProperty licznik_km;
    private FloatProperty stan_baterii;
    private StringProperty status_samochodu;
    private StringProperty data_wygasniecia_przegladu;

    public Samochod() {
        nr_rejestracyjny = new SimpleStringProperty();
        nazwa = new SimpleStringProperty();
        marka = new SimpleStringProperty();
        dystans_km_na_ladowanie = new SimpleIntegerProperty();
        licznik_km = new SimpleIntegerProperty();
        stan_baterii = new SimpleFloatProperty();
        status_samochodu = new SimpleStringProperty();
        data_wygasniecia_przegladu = new SimpleStringProperty();
    }

    public String getNr_rejestracyjny() { return nr_rejestracyjny.get(); }
    public StringProperty nr_rejestracyjnyProperty() { return nr_rejestracyjny; }
    public void setNr_rejestracyjny(String nr_rejestracyjny) { this.nr_rejestracyjny.set(nr_rejestracyjny); }
    public String getNazwa() { return nazwa.get(); }
    public StringProperty nazwaProperty() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa.set(nazwa); }
    public String getMarka() { return marka.get(); }
    public StringProperty markaProperty() { return marka; }
    public void setMarka(String marka) { this.marka.set(marka); }
    public int getDystans_km_na_ladowanie() { return dystans_km_na_ladowanie.get(); }
    public IntegerProperty dystans_km_na_ladowanieProperty() { return dystans_km_na_ladowanie; }
    public void setDystans_km_na_ladowanie(int dystans_km_na_ladowanie) { this.dystans_km_na_ladowanie.set(dystans_km_na_ladowanie); }
    public int getLicznik_km() { return licznik_km.get(); }
    public IntegerProperty licznik_kmProperty() { return licznik_km; }
    public void setLicznik_km(int licznik_km) { this.licznik_km.set(licznik_km); }
    public float getStan_baterii() { return stan_baterii.get(); }
    public FloatProperty stan_bateriiProperty() { return stan_baterii; }
    public void setStan_baterii(float stan_baterii) { this.stan_baterii.set(stan_baterii); }
    public String getStatus_samochodu() { return status_samochodu.get(); }
    public StringProperty status_samochoduProperty() { return status_samochodu; }
    public void setStatus_samochodu(String status_samochodu) { this.status_samochodu.set(status_samochodu); }
    public String getData_wygasniecia_przegladu() { return data_wygasniecia_przegladu.get(); }
    public StringProperty data_wygasniecia_przegladuProperty() { return data_wygasniecia_przegladu; }
    public void setData_wygasniecia_przegladu(String data_wygasniecia_przegladu) { this.data_wygasniecia_przegladu.set(data_wygasniecia_przegladu); }
}
