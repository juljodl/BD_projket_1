package edu.ib;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WypozyczeniaController {
    private boolean start = true;
    public DBUtil dbUtil;
    public String samochod;

    @FXML
    private AnchorPane obudowa;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView tabelaZestaw;

    @FXML
    private Button wrocBtn;

    @FXML
    void wrocBtnOnClick(ActionEvent event) {
        Stage stage = (Stage) wrocBtn.getScene().getWindow();
        stage.close();

    }

    public void inicjalizacja(MouseEvent mouseEvent) {
        if (start) {
            System.out.println(samochod);
            WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);


            try {
                ObservableList<PodsumowanieWypozyczenia> podsumowanieWypozyczenia = wypozyczalniaDAO.showWypozyczeniaSamochoduOW(samochod);

                tabelaZestaw.getItems().clear();
                // calosc.add(podsumowanieWypozyczenia.get());
                tabelaZestaw.getItems().setAll(podsumowanieWypozyczenia);
                System.out.println(podsumowanieWypozyczenia.get(0).getDataWypozyczenia());

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize() {
        assert tabelaZestaw != null : "fx:id=\"tabelaZestaw\" was not injected: check your FXML file 'wypozyczeniaZestaw.fxml'.";
        assert wrocBtn != null : "fx:id=\"wrocBtn\" was not injected: check your FXML file 'wypozyczeniaZestaw.fxml'.";
        assert obudowa != null : "fx:id=\"obudowa\" was not injected: check your FXML file 'wypozyczeniaZestaw.fxml'.";


        obudowa.setOnMouseEntered(mouseEvent -> {
            if(start)
            {
                System.out.println(samochod);
                WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);


                try {
                    ObservableList<PodsumowanieWypozyczenia> podsumowanieWypozyczenia = wypozyczalniaDAO.showWypozyczeniaSamochoduOW(samochod);

                    //tabelaZestaw.getItems().clear();
                    // calosc.add(podsumowanieWypozyczenia.get());
                    tabelaZestaw.setItems(podsumowanieWypozyczenia);
                    //tabelaZestaw.getItems().setAll(podsumowanieWypozyczenia);
                    System.out.println(podsumowanieWypozyczenia.get(0).getDataWypozyczenia());

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            start = false;
        });
    }
}
