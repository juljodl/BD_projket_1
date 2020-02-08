package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ObslugaController {

    private DBUtil dbUtil;
    private boolean dbUtilpolacz = true;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField rejestracjaText;

    @FXML
    private Button sprWypBtn;

    @FXML
    private Button bateriaBtn;

    @FXML
    private Label usernameFieldInvisible;

     @FXML
     private Label passwordFieldInvisible;

    @FXML
    private Button rozladowaneBtn;

    @FXML
    private TextField rejLadujBtn;

    @FXML
    private Button ladujBtn;

    @FXML
    private Button utargBtn;

    @FXML
    private TableView tabelaBaterie;

    @FXML
    void ladujBtnOnClick(ActionEvent event) {

    }

    @FXML
    void menuUtargBtnOnClick(ActionEvent event) {

    }

    @FXML
    void sprBateriaBtnOnClick(ActionEvent event) {

        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);

        try {
            ObservableList<StanyBaterii> stanyLista = wypozyczalniaDAO.showStanyBateriiOW();

            tabelaBaterie.getItems().clear();
            // calosc.add(podsumowanieWypozyczenia.get());
            tabelaBaterie.getItems().setAll(stanyLista);
            //System.out.println(podsumowanieWypozyczenia.get(0).getDataWypozyczenia());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        @FXML
    void sprWypBtnOnClick(ActionEvent event) throws IOException {

        WypozyczalniaDAO wypozyczalniaDAO = new WypozyczalniaDAO(dbUtil);
        String samochodRej = rejestracjaText.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ib/wypozyczeniaZestaw.fxml"));


        Scene scene = new Scene(fxmlLoader.load());
        Stage secondStage = new Stage();
        secondStage.setScene(scene);
        secondStage.initModality(Modality.WINDOW_MODAL);
        WypozyczeniaController wc= fxmlLoader.getController();
        wc.dbUtil=this.dbUtil;
        wc.samochod = samochodRej;
        secondStage.show();




    }

    @FXML
    void sprawdzRozlBtnOnClick(ActionEvent event) {

    }





    @FXML
    void initialize() {
        assert rejestracjaText != null : "fx:id=\"rejestracjaText\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert sprWypBtn != null : "fx:id=\"sprWypBtn\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert bateriaBtn != null : "fx:id=\"bateriaBtn\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert rozladowaneBtn != null : "fx:id=\"rozladowaneBtn\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert rejLadujBtn != null : "fx:id=\"rejLadujBtn\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert ladujBtn != null : "fx:id=\"ladujBtn\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert utargBtn != null : "fx:id=\"utargBtn\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert tabelaBaterie != null : "fx:id=\"tabelaBaterie\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert usernameFieldInvisible != null : "fx:id=\"usernameFieldInvisible\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";
        assert passwordFieldInvisible != null : "fx:id=\"passwordFieldInvisible\" was not injected: check your FXML file 'obslugaKlienta.fxml'.";

        rejestracjaText.setOnMouseEntered(mouseEvent -> {
            sprWypBtn.setDisable(false);
        });
    }
}
