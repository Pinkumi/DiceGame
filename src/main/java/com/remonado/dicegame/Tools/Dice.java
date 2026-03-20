package com.remonado.dicegame.Tools;
import java.util.Random;

public class Dice
{
    private int value;
    public Dice() {
        value = 1;
    }
    public int throwDice() {
        Random rnd = new Random();
        value = rnd.nextInt(6)+1;
        return value;
    }
    public String toString(){
        return "dice value: "+value;
    }
    public int getValue(){
        return value;
    }
    public void show(){
        System.out.println(value);
    }
}
