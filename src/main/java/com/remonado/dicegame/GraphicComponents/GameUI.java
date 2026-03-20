package com.remonado.dicegame.GraphicComponents;

import com.remonado.dicegame.Controller;
import com.remonado.dicegame.DiceGame.DiceGame;
import com.remonado.dicegame.DiceGame.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GameUI extends HBox {
    private DiceGame game;
    private BorderPane stagesPane;
    private Button rollDices;
    private Controller controller;
    private ArrayList<StageUI> stagesUI;
    public GameUI(Controller controller){
        this.controller = controller;
        initializeGame();

    }
    public GameUI getGame(){
        return this;
    }
    public void initializeGame(){
        stagesPane = new BorderPane();

        stagesUI = new ArrayList<>();
        rollDices = new Button("Roll");
        rollDices.setOnAction(e -> {controller.rollDices();});
        ArrayList<Stage> stages = controller.getStages();
        HBox top = new HBox();
        top.setSpacing(40);
        VBox right = new VBox();
        right.setSpacing(15);
        HBox bottom = new HBox();
        bottom.setSpacing(40);
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
        for(int i =0;i<4;i++){
            bottom.getChildren().add(stagesUI.get(countStages));
            countStages++;
        }
        stagesPane.setTop(top);
        stagesPane.setRight(right);
        stagesPane.setBottom(bottom);

        this.getChildren().add(stagesPane);
        this.getChildren().add(rollDices);
    }
    public void refresh(){
        for(StageUI stageUI : stagesUI){
            stageUI.refresh();
        }
    }



}
