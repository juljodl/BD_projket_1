package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    private DBUtil dbUtil;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField hasloText;

    @FXML
    private Button logowanieBtn;

    @FXML
    void btnZaloguj(ActionEvent event)
    {


    }

    @FXML
    void initialize() {
        assert loginText != null : "fx:id=\"loginText\" was not injected: check your FXML file 'startWindow.fxml'.";
        assert hasloText != null : "fx:id=\"hasloText\" was not injected: check your FXML file 'startWindow.fxml'.";
        assert logowanieBtn != null : "fx:id=\"logowanieBtn\" was not injected: check your FXML file 'startWindow.fxml'.";
        dbUtil = new DBUtil("root", "Maniek1234");


    }
}

