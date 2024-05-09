package it.viligiardi.controller;

import java.io.IOException;

import it.viligiardi.pojo.Game;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerMenu {
    @FXML
    private TextField nickName1;
    @FXML
    private TextField nickName2;

    @FXML
    private void switchToSecondary() throws IOException {
        Game.p1.setNickName(nickName1.getText().toUpperCase(), 1);
        Game.p2.setNickName(nickName2.getText().toUpperCase(), 2);
        App.setRoot("game");
    }
}
