package edu.ib;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utarg
{
    private StringProperty dataWplaty;
    private FloatProperty kwota;

    public Utarg() {
        dataWplaty = new SimpleStringProperty();
        kwota = new SimpleFloatProperty();
    }

    public String getDataWplaty() { return dataWplaty.get(); }
    public StringProperty dataWplatyProperty() { return dataWplaty; }
    public void setDataWplaty(String dataWplaty) { this.dataWplaty.set(dataWplaty); }
    public float getKwota() { return kwota.get(); }
    public FloatProperty kwotaProperty() { return kwota; }
    public void setKwota(float kwota) { this.kwota.set(kwota); }
}

