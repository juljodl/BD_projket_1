package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class KlientController2 {

    public DBUtil dbUtil;
    public String samochod;
    public String godzina;
    private boolean start = true;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane obudowa;

    @FXML
    private TableView tabelaPodsum1;

    @FXML
    private TableView tabelaPodsum2;
    @FXML
    private Button wracanieBtn;


    @FXML
    void wrocBtn(ActionEvent event) {

        Stage stage = (Stage) wracanieBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {
        assert obudowa != null : "fx:id=\"obudowa\" was not injected: check your FXML file 'klientPodsumowanie.fxml'.";
        assert tabelaPodsum1 != null : "fx:id=\"tabelaPodsum1\" was not injected: check your FXML file 'klientPodsumowanie.fxml'.";
        assert tabelaPodsum2 != null : "fx:id=\"tabelaPodsum2\" was not injected: check your FXML file 'klientPodsumowanie.fxml'.";

    }


    public void inicjalizacja(MouseEvent mouseEvent)
    {
        if(start)
        {
            WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);


            try {
                ObservableList<PodsumowanieWypozyczenia> podsumowanieWypozyczenia = wypozyczalniaDAO.showKoniecWypozyczenia(samochod, godzina);
               tabelaPodsum1.getItems().clear();
               tabelaPodsum2.getItems().clear();
               ObservableList<PodsumowanieWypozyczenia> part1 = FXCollections.observableArrayList();
               part1.add(podsumowanieWypozyczenia.get(0));

               ObservableList<PodsumowanieWypozyczenia> part2 = FXCollections.observableArrayList();
               part2.add(podsumowanieWypozyczenia.get(1));

               tabelaPodsum1.setItems(part1);
               tabelaPodsum2.setItems(part2);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

