package it.viligiardi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.viligiardi.pojo.Game;
import it.viligiardi.pojo.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ControllerGame implements Initializable {
    @FXML
    private GridPane gpScore;
    @FXML
    private GridPane gp;
    @FXML
    private Label nameP1;
    @FXML
    private Label nameP2;
    @FXML
    private Label scoreP1;
    @FXML
    private Label scoreP2;
    @FXML
    private Label comment;

    // String letter = "O";
    int counter;

    @FXML
    private void switchToPrimary() throws IOException {
        resetAll();
        App.setRoot("menu");
    }

    // @FXML
    private void view() {
        nameP1.setText(Game.p1.getName());
        nameP2.setText(Game.p2.getName());
        String s = Game.p1.getScore().toString();
        scoreP1.setText(s);
        String s1 = Game.p2.getScore().toString();
        scoreP2.setText(s1);
    }

    public void isVictory(Player p, Button b) {
        Integer y = GridPane.getColumnIndex(b);
        Integer x = GridPane.getRowIndex(b);

        if (Game.placeSymbol(x, y, p)) {
            b.setText(p.getSymbol());
            Game.viewMatrix(); // per il controllo
            // b.setText(letter);
            // letter = letter.equals("O") ? "X" : "O";
            if (Game.isVictory(p)) {
                gp.setDisable(true);
                p.setScore(p.getScore() + 1);
                view();
                comment.setText("HAI VINTO " + p.getName() + "!");
            } else if (Game.isDraw()) {
                gp.setDisable(true);
                comment.setText("PAREGGIO!");
            }
        } else {
            comment.setText("Scegli un'altra posizione nel campo");
        }

    }

    // @FXML
    public void selectButton(Button b) {
        if (counter % 2 == 0) {
            isVictory(Game.p2, b);
        } else {
            isVictory(Game.p1, b);
        }
        counter++;
    }

    @FXML
    public void resetGridPane() {
        // Rimuovi tutti i nodi dalla GridPane
        Game.resetField();
        gp.setDisable(false);
        gp.getChildren().clear();
        createGridPane();
        counter = 1;
    }

    // @FXML
    public void resetAll() {
        resetGridPane();
        gpScore.getChildren().clear();
        Game.p1.setScore(0);
        Game.p2.setScore(0);
    }

    // @FXML
    public void createGridPane() {
        comment.setText("Posiziona un simbolo nel campo");
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button b = new Button();
                b.setPrefSize(84.0, 84.0);

                b.setOnAction(event -> {
                    // quello che succede al clic
                    selectButton(b);
                });

                gp.add(b, x, y);
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        counter = 1;
        view();
        createGridPane();
    }
}