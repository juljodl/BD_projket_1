package edu.ib;

import javafx.beans.property.*;

public class Wypozyczenia
{
    private IntegerProperty id_wypozyczenia;
    private IntegerProperty id_klienta;
    private IntegerProperty id_samochod;
    private IntegerProperty data_wypozyczenia;
    private IntegerProperty data_oddania;
    private FloatProperty dl_geo_start;
    private FloatProperty szer_geo_start;
    private FloatProperty dl_geo_stop;
    private FloatProperty szer_geo_stop;
    private FloatProperty dystans;
    private FloatProperty kwota;
    private StringProperty uszkodzenia;


    public Wypozyczenia() {
        id_wypozyczenia = new SimpleIntegerProperty();
        id_klienta = new SimpleIntegerProperty();
        id_samochod = new SimpleIntegerProperty();
        data_wypozyczenia = new SimpleIntegerProperty();
        data_oddania = new SimpleIntegerProperty();
        dl_geo_start = new SimpleFloatProperty();
        szer_geo_start = new SimpleFloatProperty();
        dl_geo_stop = new SimpleFloatProperty();
        szer_geo_stop = new SimpleFloatProperty();
        dystans = new SimpleFloatProperty();
        kwota = new SimpleFloatProperty();
        uszkodzenia = new SimpleStringProperty();
    }

    public int getId_wypozyczenia() { return id_wypozyczenia.get(); }
    public IntegerProperty id_wypozyczeniaProperty() { return id_wypozyczenia; }
    public void setId_wypozyczenia(int id_wypozyczenia) { this.id_wypozyczenia.set(id_wypozyczenia); }
    public int getId_klienta() { return id_klienta.get(); }
    public IntegerProperty id_klientaProperty() { return id_klienta; }
    public void setId_klienta(int id_klienta) { this.id_klienta.set(id_klienta); }
    public int getId_samochod() { return id_samochod.get(); }
    public IntegerProperty id_samochodProperty() { return id_samochod; }
    public void setId_samochod(int id_samochod) { this.id_samochod.set(id_samochod); }
    public int getData_wypozyczenia() { return data_wypozyczenia.get(); }
    public IntegerProperty data_wypozyczeniaProperty() { return data_wypozyczenia; }
    public void setData_wypozyczenia(int data_wypozyczenia) { this.data_wypozyczenia.set(data_wypozyczenia); }
    public int getData_oddania() { return data_oddania.get(); }
    public IntegerProperty data_oddaniaProperty() { return data_oddania; }
    public void setData_oddania(int data_oddania) { this.data_oddania.set(data_oddania); }
    public float getDl_geo_start() { return dl_geo_start.get(); }
    public FloatProperty dl_geo_startProperty() { return dl_geo_start; }
    public void setDl_geo_start(float dl_geo_start) { this.dl_geo_start.set(dl_geo_start); }
    public float getSzer_geo_start() { return szer_geo_start.get(); }
    public FloatProperty szer_geo_startProperty() { return szer_geo_start; }
    public void setSzer_geo_start(float szer_geo_start) { this.szer_geo_start.set(szer_geo_start); }
    public float getDl_geo_stop() { return dl_geo_stop.get(); }
    public FloatProperty dl_geo_stopProperty() { return dl_geo_stop; }
    public void setDl_geo_stop(float dl_geo_stop) { this.dl_geo_stop.set(dl_geo_stop); }
    public float getSzer_geo_stop() { return szer_geo_stop.get(); }
    public FloatProperty szer_geo_stopProperty() { return szer_geo_stop; }
    public void setSzer_geo_stop(float szer_geo_stop) { this.szer_geo_stop.set(szer_geo_stop); }
    public float getDystans() { return dystans.get(); }
    public FloatProperty dystansProperty() { return dystans; }
    public void setDystans(float dystans) { this.dystans.set(dystans); }
    public float getKwota() { return kwota.get(); }
    public FloatProperty kwotaProperty() { return kwota; }
    public void setKwota(float kwota) { this.kwota.set(kwota); }
    public String getUszkodzenia() { return uszkodzenia.get(); }
    public StringProperty uszkodzeniaProperty() { return uszkodzenia; }
    public void setUszkodzenia(String uszkodzenia) { this.uszkodzenia.set(uszkodzenia); }
}
