package myProject;

import javax.swing.*;

public class Casilla extends JButton{
    private int fila;
    private int columna;

    public Casilla(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
