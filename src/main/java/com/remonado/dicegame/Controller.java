package com.remonado.dicegame;

import com.remonado.dicegame.DiceGame.DiceGame;
import com.remonado.dicegame.DiceGame.Stage;
import com.remonado.dicegame.GraphicComponents.GameUI;

import java.util.ArrayList;

public class Controller {
    private GameUI gameUi;
    private DiceGame game;
    public Controller(DiceGame game){
        this.game = game;
        gameUi = new GameUI(this);
    }
    public void rollDices(){
        game.rollDices();
        gameUi.refresh();
    }
    public ArrayList<Stage> getStages(){
        return game.getStages();
    }
    public GameUI getScene(){
        return gameUi;
    }
}
