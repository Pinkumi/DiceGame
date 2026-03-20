package com.remonado.dicegame.Tools;
public abstract class Queue<T>{
    //en una cola simple verificamos si esta llena  de froma que:
    //en una cola circular verificamos si esta llena de forma que: (inicio == 0 && fin == cola.lenght -1) o tambien: (fin + 1 == inicio)
    protected T[] queue;
    protected int fin;
    protected int inicio;

    public Queue(int capacidad){
        queue = (T[])new Object[capacidad];
        inicio = -1;
        fin = -1;

    }
    public Queue(){
        queue = (T[])new Object[10];
        inicio = -1;
        fin = -1;

    }
    public abstract boolean addElement(T object);
    public abstract T delete();
    public abstract T getNext();
    public int getSize(){
        if(inicio == -1){
            return 0;
        }
        return fin - inicio + 1;
    }




}