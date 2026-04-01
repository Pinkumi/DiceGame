package com.remonado.dicegame.DiceGame;

import com.remonado.dicegame.Tools.Queue;
import com.remonado.dicegame.Tools.QueueSimple;

import java.util.ArrayList;

public class DiceGame {
    public ArrayList<Stage> stages = new ArrayList<>();
    private int numberInSystem, throughput;
    private ArrayList<Integer> activityMoved;
    private ArrayList<Integer> activityRolled;

    private int nRounds = 0;

    public DiceGame(){
        initializeStages();
        numberInSystem = 36;
        throughput = 0;
        activityMoved = new ArrayList<>(10);
        activityRolled = new ArrayList<>(10);
        for(int i = 0; i < 10; i++){
            activityRolled.add(0);
            activityMoved.add(0);
        }
    }
    public void initializeStages(){

        for(int i = 1; i <= 10; i++){
            Stage stg = new Stage(new QueueSimple<>(150));
            if(i != 10){
                for(int j = 0; j < 4; j++){
                    stg.addToQueue(new Persona());
                }
            }
            stages.add(stg);
        }

    }
    public void rollDices(){
        nRounds++;
        for(int i = 0; i < 10; i++){
            stages.get(i).throwDice();
            activityRolled.set(i, stages.get(i).getDice().getValue());
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
                if(i==9){
                    for (int j = 0; j < cantDesplazados[i]; j++) {
                        stages.get(i).addToQueue(stages.get(i - 1).getElement());
                        numberInSystem--;
                    }
                }else{
                    for (int j = 0; j < cantDesplazados[i]; j++) {
                        stages.get(i).addToQueue(stages.get(i - 1).getElement());
                    }
                }
            }
            activityMoved.set(i, cantDesplazados[i]);
        }
        numberInSystem += cantDesplazados[0];
        throughput = stages.getLast().getSize();
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

    public ArrayList<Integer> getActivityMoved(){
        return activityMoved;
    }
    public ArrayList<Integer> getActivityRolled(){
        return activityRolled;
    }
    public int getNumberInSystem(){
        return numberInSystem;
    }
    public int getThroughput(){
        return throughput;
    }
    public int getNRounds(){
        return nRounds;
    }


    

}
