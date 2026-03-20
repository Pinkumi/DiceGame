package com.remonado.dicegame.DiceGame;

import com.remonado.dicegame.Tools.Queue;
import com.remonado.dicegame.Tools.QueueSimple;

import java.util.ArrayList;

public class DiceGame {
    public ArrayList<Stage> stages = new ArrayList<>();
    public DiceGame(){
        initializeStages();
    }
    public void initializeStages(){
        for(int i = 1; i <= 10; i++){
            Stage stg = new Stage(new QueueSimple<>(150));
            for(int j = 0; j < 4; j++){
                stg.addToQueue(new Persona());
            }
            stages.add(stg);
        }
    }
    public void rollDices(){
        for(Stage stage: stages){
            stage.throwDice();
        }
        int[] cantDesplazados = new int[10];
        int[] cantPorStage =  new int[10];
        for(int i = 0; i <10;i++){
            cantPorStage[i] = stages.get(i).getSize();
        }
        for(int i = 0; i < 10; i++){
            Stage stg = stages.get(i);
            if(i==0){
                cantDesplazados[i] = stg.getDice().getValue();
            }else{
                if(stg.getDice().getValue() > cantPorStage[i-1]){
                    cantDesplazados[i] = cantPorStage[i-1];
                }else{
                    cantDesplazados[i] = stg.getDice().getValue();
                }
            }
        }

        for(int i = 9; i >= 0; i--){
            if(i==0){
                for(int j = 0; j < cantDesplazados[i]; j++){
                    stages.get(i).addToQueue(new Persona());
                }
            }else {
                for (int j = 0; j < cantDesplazados[i]; j++) {
                    stages.get(i).addToQueue(stages.get(i - 1).getElement());
                }
            }
        }
    }
//    public void rollDices(){
//
//        for(Stage stage: stages){
//            stage.throwDice();
//        }
//        //region calculo de desplazados por stage
//        int[] cantDesplazados = new int[10];
//        int[] cantPorStage =  new int[100];
//        for(int i = 0; i <10;i++){
//            cantPorStage[i] = stages.get(i).getSize();
//        }
//        for(int i = 0; i < 10; i++){
//            Stage stg = stages.get(i);
//            if(i==0){
//                cantDesplazados[i] = stg.getDice().getValue();
//            }else{
//                if(stg.getDice().getValue() > cantPorStage[i-1]){
//                    cantDesplazados[i] = cantPorStage[i-1];
//                }else{
//                    cantDesplazados[i] = stg.getDice().getValue();
//                }
//            }
//        }
//        //endregion
//
//        //region desplazo
//        for(int i = 0; i < 10; i++){
//            if(i==0){
//                for(int j = 0; j < cantDesplazados[i]; j++){
//                    stages.get(i).addToQueue(new Persona());
//                }
//            }else {
//                for (int j = 0; j < cantDesplazados[i]; j++) {
//                    stages.get(i).addToQueue(stages.get(i - 1).getElement());
//                }
//            }
//        }
//        //endregion
//    }
    public ArrayList<Stage> getStages(){
        return stages;
    }


    

}
