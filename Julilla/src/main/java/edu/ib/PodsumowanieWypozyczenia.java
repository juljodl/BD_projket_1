package edu.ib;

import javafx.beans.property.*;

public class PodsumowanieWypozyczenia
{
    private IntegerProperty idWypozyczenia;
    private StringProperty idSamochod;
    private StringProperty idKlienta;
    private StringProperty dataWypozyczenia;
    private StringProperty dataOddania;
    private FloatProperty dlGeoStart;
    private FloatProperty szerGeoStart;

    private FloatProperty dlGeoStop;
    private FloatProperty szerGeoStop;
    private FloatProperty dystans;
    private FloatProperty kwota;
    private StringProperty uszkodzenia;


    public PodsumowanieWypozyczenia() {
        idWypozyczenia = new SimpleIntegerProperty();
        idSamochod = new SimpleStringProperty();
        idKlienta = new SimpleStringProperty();
        dataWypozyczenia = new SimpleStringProperty();
        dataOddania = new SimpleStringProperty();
        dlGeoStart = new SimpleFloatProperty();
        szerGeoStart = new SimpleFloatProperty();
        dlGeoStop = new SimpleFloatProperty();
        szerGeoStop = new SimpleFloatProperty();
        dystans = new SimpleFloatProperty();
        kwota = new SimpleFloatProperty();
        uszkodzenia = new SimpleStringProperty();
    }

    public int getIdWypozyczenia() {
        return idWypozyczenia.get();
    }

    public IntegerProperty idWypozyczeniaProperty() {
        return idWypozyczenia;
    }

    public void setIdWypozyczenia(int idWypozyczenia) {
        this.idWypozyczenia.set(idWypozyczenia);
    }

    public String getIdSamochod() {
        return idSamochod.get();
    }

    public StringProperty idSamochodProperty() {
        return idSamochod;
    }

    public void setIdSamochod(String idSamochod) {
        this.idSamochod.set(idSamochod);
    }

    public String getIdKlienta() {
        return idKlienta.get();
    }

    public StringProperty idKlientaProperty() {
        return idKlienta;
    }

    public void setIdKlienta(String idKlienta) {
        this.idKlienta.set(idKlienta);
    }

    public String getDataWypozyczenia() {
        return dataWypozyczenia.get();
    }

    public StringProperty dataWypozyczeniaProperty() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(String dataWypozyczenia) {
        this.dataWypozyczenia.set(dataWypozyczenia);
    }

    public String getDataOddania() {
        return dataOddania.get();
    }

    public StringProperty dataOddaniaProperty() {
        return dataOddania;
    }

    public void setDataOddania(String dataOddania) {
        this.dataOddania.set(dataOddania);
    }

    public float getDlGeoStart() {
        return dlGeoStart.get();
    }

    public FloatProperty dlGeoStartProperty() {
        return dlGeoStart;
    }

    public void setDlGeoStart(float dlGeoStart) {
        this.dlGeoStart.set(dlGeoStart);
    }

    public float getSzerGeoStart() {
        return szerGeoStart.get();
    }

    public FloatProperty szerGeoStartProperty() {
        return szerGeoStart;
    }

    public void setSzerGeoStart(float szerGeoStart) {
        this.szerGeoStart.set(szerGeoStart);
    }

    public float getDlGeoStop() {
        return dlGeoStop.get();
    }

    public FloatProperty dlGeoStopProperty() {
        return dlGeoStop;
    }

    public void setDlGeoStop(float dlGeoStop) {
        this.dlGeoStop.set(dlGeoStop);
    }

    public float getSzerGeoStop() {
        return szerGeoStop.get();
    }

    public FloatProperty szerGeoStopProperty() {
        return szerGeoStop;
    }

    public void setSzerGeoStop(float szerGeoStop) {
        this.szerGeoStop.set(szerGeoStop);
    }

    public float getDystans() {
        return dystans.get();
    }

    public FloatProperty dystansProperty() {
        return dystans;
    }

    public void setDystans(float dystans) {
        this.dystans.set(dystans);
    }

    public float getKwota() {
        return kwota.get();
    }

    public FloatProperty kwotaProperty() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota.set(kwota);
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
