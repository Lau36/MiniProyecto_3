package myProject;

import javax.swing.*;

public class CasillaHumano extends JButton{
    private int fila;
    private int columna;

    public CasillaHumano(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }
}
