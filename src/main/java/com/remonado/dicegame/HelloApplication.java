package com.remonado.dicegame;

import com.remonado.dicegame.DiceGame.DiceGame;
import com.remonado.dicegame.DiceGame.Persona;
import com.remonado.dicegame.GraphicComponents.GameUI;
import com.remonado.dicegame.GraphicComponents.StageUI;
import com.remonado.dicegame.Tools.QueueSimple;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Controller control = new Controller(new DiceGame());
        GameUI root = control.getScene();

        Scene scene = new Scene(root, 1800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}