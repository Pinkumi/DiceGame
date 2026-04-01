package com.remonado.dicegame.GraphicComponents;

import com.remonado.dicegame.Controller;
import com.remonado.dicegame.DiceGame.DiceGame;
import com.remonado.dicegame.DiceGame.Stage;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

import java.util.ArrayList;

public class GameUI extends HBox {
    private DiceGame game;
    private BorderPane stagesPane;
    private Button rollDices,activity,throughput,numberInSystem, refresh;
    private Label rounds;
    private Controller controller;
    private ArrayList<StageUI> stagesUI;
    public GameUI(Controller controller){
        this.controller = controller;
        initializeGame();
        this.setStyle("-fx-background-color: #dbffd6");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);

    }
    public GameUI getGame(){
        return this;
    }
    public void initializeGame(){
        stagesPane = new BorderPane();

        stagesUI = new ArrayList<>();
        ImageView imv = new ImageView(new Image("file:src/main/resources/com/remonado/dicegame/Images/roll.png"));
        imv.setFitWidth(140);
        imv.setPreserveRatio(true);
        rounds = new Label("Ronda: 0");
        rollDices = new Button();
        activity = new Button("Activity");
        refresh = new Button("Refresh");
        throughput = new Button("Throughput");
        numberInSystem = new Button("Number In System");
        rounds.setStyle("-fx-background-color: #dbffd6;-fx-font-size: 25");

        rollDices.setGraphic(imv);

        rollDices.getStyleClass().add("rollDiceBTN.css");
        refresh.setOnAction(event -> {controller.refreshGame();});
        rollDices.setOnAction(e -> {controller.rollDices();});
        activity.setOnAction(e->{
            showActivity();
        });
        throughput.setOnAction(e->{
            showThroughput();
        });
        numberInSystem.setOnAction(e->{
            showNumberInSystem();
        });

        ArrayList<Stage> stages = controller.getStages();
        VBox buttons = new VBox();
        HBox top = new HBox();
        top.setSpacing(40);
        VBox right = new VBox();
        right.setSpacing(15);
        HBox bottom = new HBox();
        bottom.setSpacing(40);
        right.setAlignment(Pos.CENTER);
        int countStages = 0;
        for(int i  = 0; i < stages.size(); i++){
            stagesUI.add(new StageUI(stages.get(i), i+1));
        }
        for(int i =0;i<4;i++){
            top.getChildren().add(stagesUI.get(countStages));
            countStages++;
        }
        for(int i =0;i<2;i++){
            right.getChildren().add(stagesUI.get(countStages));
            countStages++;
        }
        for(int i =9;i>=6;i--){
            bottom.getChildren().add(stagesUI.get(i));
            countStages++;
        }
        stagesPane.setTop(top);
        stagesPane.setRight(right);
        stagesPane.setBottom(bottom);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        this.getChildren().add(stagesPane);
        buttons.getChildren().addAll(activity,throughput,numberInSystem,rounds,rollDices,refresh);
        this.getChildren().add(buttons);

    }
    public void showActivity(){
        javafx.stage.Stage selector = new javafx.stage.Stage();
        selector.setTitle("Mostrando Actividad");
        VBox vb  = new VBox();
        Label lbl = new Label("Activity Moved: "+ controller.getActivityMoved());
        Label lbl2 = new Label("Activity Rolled : "+ controller.getActivityRolled());
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(lbl,lbl2);
        lbl.setStyle("-fx-padding: 15; -fx-alignment: center;");
        selector.setOnCloseRequest(event -> {
            selector.close();});
        Scene scene = new Scene(vb, 300, 100);
        selector.setScene(scene);
        selector.showAndWait();
    }
    public void showThroughput(){
        javafx.stage.Stage selector = new javafx.stage.Stage();
        selector.setTitle("Mostrando Throughput");
        Label lbl = new Label("Throughput: " + controller.getThroughput());
        lbl.setStyle("-fx-padding: 15; -fx-alignment: center;");
        selector.setOnCloseRequest(event -> {
            selector.close();});
        Scene scene = new Scene(lbl, 300, 100);
        selector.setScene(scene);
        selector.showAndWait();
    }
    public  void showNumberInSystem(){
        javafx.stage.Stage selector = new javafx.stage.Stage();
        selector.setTitle("Mostrando Numero de personas en sistema");
        Label lbl = new Label("Numero de personas en sistema: "+ controller.getNumberInSystem());
        lbl.setStyle("-fx-padding: 15; -fx-alignment: center;");
        selector.setOnCloseRequest(event -> {
            selector.close();});
        Scene scene = new Scene(lbl, 300, 100);
        selector.setScene(scene);
        selector.showAndWait();
    }

    public void refresh(){
        for(StageUI stageUI : stagesUI){
            stageUI.refresh();
        }
        rounds.setText("Ronda: "+controller.getNRounds());
    }
    public void refreshDices(){
        for(StageUI stageUI : stagesUI){
            stageUI.refreshDice();
        }
    }



}
