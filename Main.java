package com.mahima.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
      FXMLLoader loader= new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane= loader.load();
        controller= loader.getController();
        controller.createPlayground();
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane= (Pane)rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene= new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu()
    {
        Menu fileMenu= new Menu("File");
        MenuItem newGame= new MenuItem("New Game");

        newGame.setOnAction(actionEvent -> resetGame());
        MenuItem resetGame= new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> resetGame());
        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
        MenuItem exitGame= new MenuItem("Exit Game");
        exitGame.setOnAction(event->exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        // help menu
        Menu helpMenu= new Menu("Help");
        MenuItem aboutGame= new MenuItem("About ConnectFour");
        aboutGame.setOnAction(event->aboutConnect4Game());
        SeparatorMenuItem separator= new SeparatorMenuItem();
        MenuItem aboutMe= new MenuItem("About Me");
        aboutMe.setOnAction(event->aboutMe());

        helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

        MenuBar menuBar= new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;

    }

    private void aboutMe() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Mahima Kataria");
        alert.setContentText("I love to play with codes and games"
                +"so I built this game for fun and to explore with codes! "+"" +
                "I am an aspiring software developer and love to code!");
        alert.show();


    }

    private void aboutConnect4Game() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four Game");
        alert.setHeaderText("How to Play?");

        alert.setContentText("Connect Four is a two-player connection game"+"" +
                " in which the players first choose a color"
                +"and then take turns dropping one colored disc "+"" +
                "from the top into a seven-column, six-row vertically suspended grid."
                +"The pieces fall straight down, occupying the lowest "+"" +
                "available space within the column. "
                +"The objective of the game is to be the first to"+"" +
                " form a horizontal, vertical, or diagonal line of four of one's own discs.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        //todo
    }


    public static void main(String[] args) {
        launch(args);
    }
}
