package com.remonado.dicegame.DiceGame;

public class Persona {
    private int id;
    public Persona(int id){
        this.id = id;
    }
    public Persona(){
        id = -1;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
