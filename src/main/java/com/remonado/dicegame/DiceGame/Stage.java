package com.remonado.dicegame.DiceGame;

import com.remonado.dicegame.Tools.*;

import java.util.ArrayList;

public class Stage {
    private QueueSimple<Persona> queue;
    private Dice dice;

    public Stage(QueueSimple<Persona> personas){
        this.queue = personas;
        this.dice = new Dice();
    }
    public Dice getDice() {
        return dice;
    }
    public void throwDice(){
        dice.throwDice();
    }
    public void addToQueue(Persona persona){
        queue.addElement(persona);
    }
    public Persona getElement(){
        return queue.delete();
    }
    public int getSize(){
        return queue.getSize();
    }


}
