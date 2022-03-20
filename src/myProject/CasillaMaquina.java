package myProject;

import javax.swing.*;

public class CasillaMaquina extends JButton{
    private int fila;
    private int columna;

    /**
     * Class Constructor
     */
    public CasillaMaquina(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Obtiene el valor de la fila de la matriz para el jugador computadora
     *
     * @return el valor de tipo int de la fila
     * @version v.1.0.0 date 14/03/2022
     */
    public int getFila(){
        return fila;
    }

    /**
     * Obtiene el valor de la columna de la matriz para el jugador computadora
     *
     * @return el valor de tipo int de la columna
     * @version v.1.0.0 date 14/03/2022
     */
    public int getColumna(){
        return columna;
    }
}
