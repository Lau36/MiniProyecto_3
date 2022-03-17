package myProject;

import javax.swing.*;

public class TableroUsuario extends JPanel{
    private int[][] matriz;
    private CasillaHumano casillaHumano;
    private boolean encontrado;
    private int valor; //el valor que da el usuario de la posicion

    /**
     * Constructor of GUI class
     */
    public TableroUsuario(){
        matriz = new int [10][10];
        encontrado = false;
    }

    public void insertarPortaaviones(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 1;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarSubmarinos(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 2;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarDestructores(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 3;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarFragatas(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 4;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
