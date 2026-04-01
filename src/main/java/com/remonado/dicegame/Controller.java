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
    public void refreshGame(){
        gameUi.refresh();
    }
    public void rollDices(){
        game.rollDices();
        gameUi.refreshDices();
    }
    public ArrayList<Stage> getStages(){
        return game.getStages();
    }
    public GameUI getScene(){
        return gameUi;
    }
    public ArrayList<Integer> getActivityMoved(){
        return game.getActivityMoved();
    }
    public ArrayList<Integer> getActivityRolled(){
        return game.getActivityRolled();
    }
    public int getNumberInSystem(){
        return game.getNumberInSystem();
    }
    public int getThroughput(){
        return game.getThroughput();
    }
    public int getNRounds(){
        return game.getNRounds();
    }
}
