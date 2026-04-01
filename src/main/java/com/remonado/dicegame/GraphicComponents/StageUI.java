package com.remonado.dicegame.GraphicComponents;

import com.remonado.dicegame.DiceGame.Stage;
import com.remonado.dicegame.Tools.Dice;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class StageUI extends VBox {
    private Stage stage;
    private int stageIdx;
    private GridPane queueGrid;
    private HBox hBoxStage;
    private DiceUI dice;
    public  StageUI(Stage stage, int stageIdx){
        hBoxStage = new HBox();
        //this.setAlignment(Pos.CENTER);
        this.setFillWidth(true);
        this.setMaxWidth(250);
        this.setMinWidth(250);
        this.setPrefWidth(250);
        hBoxStage.setSpacing(20);
        this.stage = stage;
        this.stageIdx = stageIdx;
        dice = new DiceUI(stage.getDice());
        dice.setMaxWidth(USE_PREF_SIZE);
        queueGrid = new GridPane();

        //hBoxStage.setAlignment(Pos.CENTER);
        setGraphic();
        this.getChildren().add(hBoxStage);
        hBoxStage.getChildren().add(queueGrid);
        this.getChildren().add(dice);
        this.getStyleClass().add("stage-box");
        queueGrid.getStyleClass().add("queue-grid");
        refresh();

    }
    public void refreshDice(){
        dice.refresh();
    }
    public void refresh(){

        queueGrid.getChildren().clear();
        int maxCols = 5;

        for (int i = 0;i < stage.getSize();i++) {
            int col = i%maxCols;
            int fila = i/maxCols;
            ImageView imv = new ImageView(new Image("file:src/main/resources/com/remonado/dicegame/Images/pokebola.png"));
            imv.setFitWidth(20);
            imv.setPreserveRatio(true);
            queueGrid.add(imv,col,fila);
        }

    }
    private void setGraphic(){
        StringBuilder imgStb = new StringBuilder();
        imgStb.append("file:src/main/resources/com/remonado/dicegame/Images/p");
        if(stageIdx <1 ||  stageIdx > 10){
            stageIdx = 1;
        }
        imgStb.append(stageIdx+".png");
        ImageView imv = new ImageView(new Image(imgStb.toString()));
        imv.setFitWidth(100);
        imv.setPreserveRatio(true);
        StackPane stageImg = new StackPane(imv);
        hBoxStage.getChildren().add(stageImg);
    }

}
