package myProject;

import javax.swing.*;

public class TableroUsuario extends JPanel {
    private int[][] matriz;
    private CasillaHumano casillaHumano;
    private boolean encontrado;
    private int valor; //el valor que da el usuario de la posicion

    /**
     * Constructor of GUI class
     */
    public TableroUsuario() {
        matriz = new int[10][10];
        encontrado = false;
    }

    /**
     * Inserta los barcos de tipo Portaaviones a la matriz del jugador Humano
     *
     * @return
     * @version v.1.0.0 date 10/03/2022
     */
    public void insertarPortaaviones(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 1;
            }
        }
    }

    /**
     * Inserta los barcos de tipo Submarinos a la matriz del jugador Humano
     *
     * @version v.1.0.0 date 10/03/2022
     */
    public void insertarSubmarinos(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 2;
            }
        }
    }

    /**
     * Inserta los barcos de tipo Destructores a la matriz del jugador Humano
     *
     * @version v.1.0.0 date 10/03/2022
     */
    public void insertarDestructores(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 3;
            }
        }
    }

    /**
     * Inserta los barcos de tipo Fragatas a la matriz del jugador Humano
     *
     * @version v.1.0.0 date 10/03/2022
     */
    public void insertarFragatas(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 4;
            }
        }

    }

    /**
     * Obtiene la matriz actualizada del jugador humano
     *
     * @return el valor de la matriz del jugador humano de tipo matriz de enteros
     * @version v.1.0.0 date 16/03/2022
     */
    public int[][] getMatriz(){
        return matriz;
    }
    
}
