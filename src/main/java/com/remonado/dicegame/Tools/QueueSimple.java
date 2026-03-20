package com.remonado.dicegame.Tools;

public class QueueSimple<T> extends Queue<T> {
    public QueueSimple(int capacidad){
        super(capacidad);

    }

    @Override
    public boolean addElement(T object){
        if(fin<queue.length-1){
            fin++;
            queue[fin]=object;
            if (fin==0){
                inicio=0;
            }
            return true;
        }
        return false;
    }
    @Override
    public T delete(){
        T ultimo=null;
        if(inicio!=-1){
            ultimo=queue[inicio];
            if(fin==inicio){
                inicio=-1;
                fin=-1;
            }else{
                inicio++;
            }
        }else{
            System.out.println("subdesbordamiento");
        }
        return ultimo;
    }

    @Override
    public T getNext() {
        if(inicio > -1){
            return queue[inicio];
        }
        return null;
    }

    public T verUltimo(){
        T ultimo=null;
        if(fin!=-1){
            ultimo=queue[fin];
        }
        return ultimo;
    }
    public boolean colaLlena(){
        return inicio==0&&fin==queue.length-1;
    }

    public boolean colaVacia(){
        return inicio==-1&&fin==-1;
    }
    public String toString(){
        StringBuilder impresion= new StringBuilder();
        for(int i=0; i< queue.length; i++){
            impresion.append(queue[i]);
        }
        return impresion.toString();
    }

}
