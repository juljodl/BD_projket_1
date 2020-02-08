package edu.ib;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UszkodzeniaLista
{
    private StringProperty nr_rej;
    private StringProperty uszkodzenia;

    public UszkodzeniaLista() {
        nr_rej = new SimpleStringProperty();
        uszkodzenia = new SimpleStringProperty();
    }

    public String getNr_rej() { return nr_rej.get(); }
    public StringProperty nr_rejProperty() { return nr_rej; }
    public void setNr_rej(String nr_rej) { this.nr_rej.set(nr_rej); }
    public String getUszkodzenia() { return uszkodzenia.get(); }
    public StringProperty uszkodzeniaProperty() { return uszkodzenia; }
    public void setUszkodzenia(String uszkodzenia) { this.uszkodzenia.set(uszkodzenia); }
}
