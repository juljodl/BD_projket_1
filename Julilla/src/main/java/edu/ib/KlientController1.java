package edu.ib;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class KlientController1 {
    private DBUtil dbUtil;
    private boolean dbUtilpolacz = true;
    private String dataWyp;
    private String samochodWyp;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button dostepneBtn;


    @FXML
    private Button wypozyczanieBtn;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private VBox vboxKolumna1;

    @FXML
    private VBox vboxKolumna2;

    @FXML
    private Button zakonczenieBtn;

    @FXML
    private Button potwierdzenieBtn;

    @FXML
    private Button wylogowanieBtn;

    @FXML
    private Label usernameFieldInvisible;

    @FXML
    private Label passwordFieldInvisible;

    @FXML
    TextField uszkodzenia;

    @FXML
    void oddajBtn(ActionEvent event)
    {
        uszkodzenia.setDisable(false);
        brakUBtn.setDisable(false);
        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);
        wypozyczalniaDAO.callOddaj(choiceBox.getValue(),dataWyp);


    }

    @FXML
    void listaRejestracjiChoiceBox(MouseEvent event) {

    }

    @FXML
    void pokazDostepneBtn(ActionEvent event) {
        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);
        ObservableList<DostepneSamochody> dostepneSamochodies = null;

        try {
            dostepneSamochodies = wypozyczalniaDAO.showAllDostepneSamochody();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> nrRejestracyjne = new ArrayList<>();

        for (DostepneSamochody dostepneSamochody : dostepneSamochodies) {
            nrRejestracyjne.add(dostepneSamochody.getNrRejestracyjny());
        }

            choiceBox.getItems().clear();
        if(nrRejestracyjne.isEmpty()) {
            choiceBox.getItems().add("Brak brum brum");
            choiceBox.setValue("Brak brumbrum");
        }
        else {
            choiceBox.getItems().addAll(nrRejestracyjne);
            choiceBox.setValue(nrRejestracyjne.get(0));
        }
    }



    @FXML
    void wylogujBtn(ActionEvent event) {

    }

    @FXML
    void wypozyczBtn(ActionEvent event)
    {
        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);
        PodsumowanieWypozyczenia pw = new PodsumowanieWypozyczenia();

        try {
            Date date = new Date();
            SimpleDateFormat datesf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dataWyp=datesf.format(date.getTime());
            wypozyczalniaDAO.callWypozycz(choiceBox.getValue(),"dupa");
            pw = wypozyczalniaDAO.showStartWypozyczenia(choiceBox.getValue(),dataWyp);

            zakonczenieBtn.setDisable(false);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }




        vboxKolumna2.getChildren().clear();
        vboxKolumna1.getChildren().clear();


        vboxKolumna1.getChildren().add(new Label("id wypozyczenia: "));
        vboxKolumna1.getChildren().add(new Label("id klienta: "));
        vboxKolumna1.getChildren().add(new Label("nr rejestracji "));
        vboxKolumna1.getChildren().add(new Label("Data rozpoczecia:  "));
        vboxKolumna1.getChildren().add(new Label("Długość geo startu: "));
        vboxKolumna1.getChildren().add(new Label("Szerokość geo startu: "));


        vboxKolumna2.getChildren().add(new Label(String.valueOf(pw.getIdWypozyczenia())));
        vboxKolumna2.getChildren().add(new Label(pw.getIdKlienta()));
        vboxKolumna2.getChildren().add(new Label(pw.getIdSamochod()));
        vboxKolumna2.getChildren().add(new Label(pw.getDataWypozyczenia()));
        vboxKolumna2.getChildren().add(new Label(String.valueOf(pw.getDlGeoStart())));
        vboxKolumna2.getChildren().add(new Label(String.valueOf(pw.getSzerGeoStart())));



    }



    @FXML
    void firstOnMouseEntered(MouseEvent event) {
        if(dbUtilpolacz){
            usernameFieldInvisible.setText("root");
            passwordFieldInvisible.setText("Maniek1234");
            dbUtil = new DBUtil(usernameFieldInvisible.getText(), passwordFieldInvisible.getText());
        }
        dbUtilpolacz = false;
    }



    public void wybierzRej(ActionEvent actionEvent) {

        wypozyczanieBtn.setDisable(false);
        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);
        ObservableList<DostepneSamochody> dostepneSamochodies = null;
        try {
            dostepneSamochodies = wypozyczalniaDAO.showAllDostepneSamochody();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //UszkodzeniaLista us = new UszkodzeniaLista();


        ArrayList<String> nrRejestracyjne = new ArrayList<>();
        ArrayList<String> nazwy = new ArrayList<>();
        ArrayList<String> marki = new ArrayList<>();
        ArrayList<Integer> licznikiKm = new ArrayList<>();
        ArrayList<Float> stanyBaterii = new ArrayList<>();
        ArrayList<String> przeglady = new ArrayList<>();
        ArrayList<String> uszkodzenia = new ArrayList<>();

        for (DostepneSamochody dostepneSamochody : dostepneSamochodies) {
            nrRejestracyjne.add(dostepneSamochody.getNrRejestracyjny());
            nazwy.add(dostepneSamochody.getNazwa());
            marki.add(dostepneSamochody.getMarka());
            licznikiKm.add(dostepneSamochody.getLicznikKm());
            stanyBaterii.add(dostepneSamochody.getStanBaterii());
            przeglady.add(dostepneSamochody.getDataWygasnieciaPrzegladu());
        }


        String wybraneAutoRejestracja = choiceBox.getValue();
        samochodWyp = wybraneAutoRejestracja;
        PodsumowanieWypozyczenia pw2 = new PodsumowanieWypozyczenia();
        try {
            pw2 = wypozyczalniaDAO.showUszkodzenia(wybraneAutoRejestracja);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //ObservableList<UszkodzeniaLista> uszkodzeniaListas = null;
        //try {
        //  uszkodzeniaListas = wypozyczalniaDAO.showUszkodzenia(wybraneAutoRejestracja);
        // } catch (SQLException e) {
        //      e.printStackTrace();
        //  } catch (ClassNotFoundException e) {
        //   e.printStackTrace();
        // }
//        ObservableList<PodsumowanieWypozyczenia> wypozyczenias = null;
//
//    for (PodsumowanieWypozyczenia pw: wypozyczenias
//        ) { uszkodzenia.add(u.getUszkodzenia());
//        }
//        String str[]=new String[uszkodzenia.size()];
//        for (int i = 0; i < uszkodzenia.size(); i++) {
//            str[i] = uszkodzenia.get(i);
//        }


        try {
            vboxKolumna2.getChildren().clear();
            vboxKolumna1.getChildren().clear();
            DostepneSamochody samochod = wypozyczalniaDAO.showDostepnySamochodDane(wybraneAutoRejestracja);
            vboxKolumna1.getChildren().add(new Label("nr. rej: "));
            vboxKolumna1.getChildren().add(new Label("nazwa: "));
            vboxKolumna1.getChildren().add(new Label("marka: "));
            vboxKolumna1.getChildren().add(new Label("licznik km: "));
            vboxKolumna1.getChildren().add(new Label("stan baterii: "));
            vboxKolumna1.getChildren().add(new Label("data przegladu: "));
            vboxKolumna1.getChildren().add(new Label("uszkodzenia: "));

            vboxKolumna2.getChildren().add(new Label(samochod.getNrRejestracyjny()));
            vboxKolumna2.getChildren().add(new Label(samochod.getNazwa()));
            vboxKolumna2.getChildren().add(new Label(samochod.getMarka()));
            vboxKolumna2.getChildren().add(new Label(String.valueOf(samochod.getLicznikKm())));
            vboxKolumna2.getChildren().add(new Label(String.valueOf(samochod.getStanBaterii())));
            vboxKolumna2.getChildren().add(new Label(samochod.getDataWygasnieciaPrzegladu()));
       //     for (int i = 0; i < uszkodzenia.size(); i++) {

            vboxKolumna2.getChildren().add(new Label(pw2.getUszkodzenia()));
    //    }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
        @FXML
        private Button wprowadzenieUBtn;

        @FXML
        private Button brakUBtn;

        @FXML
        private Button historiaBtn;

        @FXML
        void PodsumBezUBtn(ActionEvent event) {

        }

    @FXML
    void pokazHistorieBtn(ActionEvent event) {

    }

    @FXML
    void wprowadzUBtn(ActionEvent event) {

            String uszk = uszkodzenia.getText();
        System.out.println(uszk);
        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);
        if(uszk != null) {
            System.out.println("bedzie wykonyesc sie call uszkodzenia");
            wypozyczalniaDAO.callUszkodzenia(choiceBox.getValue(), dataWyp, uszk);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ib/klientPodsumowanie.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage secondStage = new Stage();
        secondStage.setScene(scene);
        secondStage.initModality(Modality.WINDOW_MODAL);
        KlientController2 kc2= fxmlLoader.getController();
        kc2.dbUtil=this.dbUtil;
        kc2.samochod = samochodWyp;
        kc2.godzina = dataWyp;
        secondStage.show();
        uszkodzenia.clear();

    }



    @FXML
    void initialize() {
        assert dostepneBtn != null : "fx:id=\"dostepneBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        //assert spinnerRejestracje != null : "fx:id=\"spinnerRejestracje\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert wypozyczanieBtn != null : "fx:id=\"wypozyczanieBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert vboxKolumna1 != null : "fx:id=\"vboxKolumna1\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert vboxKolumna2 != null : "fx:id=\"vboxKolumna2\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert zakonczenieBtn != null : "fx:id=\"zakonczenieBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert potwierdzenieBtn != null : "fx:id=\"potwierdzenieBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert wylogowanieBtn != null : "fx:id=\"wylogowanieBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert usernameFieldInvisible != null : "fx:id=\"usernameFieldInvisible\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert passwordFieldInvisible != null : "fx:id=\"passwordFieldInvisible\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert uszkodzenia != null : "fx:id=\"uszkodzenia\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert wprowadzenieUBtn != null : "fx:id=\"wprowadzenieUBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert brakUBtn != null : "fx:id=\"brakUBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";
        assert historiaBtn != null : "fx:id=\"historiaBtn\" was not injected: check your FXML file 'klientWindow.fxml'.";


        uszkodzenia.setOnMouseEntered(mouseEvent -> {
            if(!zakonczenieBtn.isDisabled())
                wprowadzenieUBtn.setDisable(false);
        });


        brakUBtn.setOnAction(actionEvent ->
        {


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ib/klientPodsumowanie.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.WINDOW_MODAL);
            KlientController2 kc2= fxmlLoader.getController();
            kc2.dbUtil=this.dbUtil;
            kc2.samochod = samochodWyp;
            kc2.godzina = dataWyp;
            secondStage.show();

        });

    }

}//class
