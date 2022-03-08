package myProject;

import javax.swing.*;
import java.awt.*;

public class TableroUsuario extends JPanel{
    private int[][] tableroPosicion;
    private int[][] tableroPrincipal;
    private int valor; //el valor que da el usuario de la posicion
    private int valorFila, valorColumna, valorFilaD, valorColumnaD,valorFilaS, valorColumnaS,valorFilaP, valorColumnaP;

    /**
     * Constructor of GUI class
     */
    public TableroUsuario(){
        tableroPosicion = new int [10][10];
        tableroPrincipal = new int [10][10];
    }
    //Le pregunta al usuario en que posicion quiere colocar el barco y guarda el valor
    public void preguntarPosicionFila(){
        valorFila = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la fila en la que quiere posicionar la fragata","Posicion",JOptionPane.QUESTION_MESSAGE));
    }
    public void preguntarPosicionColumna(){
        valorColumna = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la columna en la que quiere posicionar la fragata","Posicion",JOptionPane.QUESTION_MESSAGE));
    }

    public void preguntarPosicionFilaD(){
        valorFilaD = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la fila en la que quiere posicionar el destructor","Posicion",JOptionPane.QUESTION_MESSAGE));
    }
    public void preguntarPosicionColumnaD(){
        valorColumnaD = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la columna en la que quiere posicionar el destructor","Posicion",JOptionPane.QUESTION_MESSAGE));
    }
    public void preguntarPosicionFilaS(){
        valorFilaS = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la fila en la que quiere posicionar el submarino","Posicion",JOptionPane.QUESTION_MESSAGE));
    }
    public void preguntarPosicionColumnaS(){
        valorColumnaS = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la columna en la que quiere posicionar el submarino","Posicion",JOptionPane.QUESTION_MESSAGE));
    }
    public void preguntarPosicionFilaP(){
        valorFilaP = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la fila en la que quiere posicionar el portaaviones","Posicion",JOptionPane.QUESTION_MESSAGE));
    }
    public void preguntarPosicionColumnaP(){
        valorColumnaP = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la columna en la que quiere posicionar el portaaviones","Posicion",JOptionPane.QUESTION_MESSAGE));
    }

    public void insertarFragata(){
        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }
        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                tableroPosicion[valorFila][valorColumna] = 1;
            }
            System.out.println();
        }
        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }

    }
    public void insertarDestructor(){
        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }

        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                tableroPosicion[valorFilaD][valorColumnaD] = 2;
            }
        }

        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarSubmarino(){
        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }

            for (int i = 0; i < tableroPosicion.length; i++) {
                for (int j = 0; j < tableroPosicion[i].length; j++) {
                    tableroPosicion[valorFilaS][valorColumnaS] = 3;
                }
            }

        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }
    }

    public void insertarPortaaviones(){
        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }

        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                tableroPosicion[valorFilaP][valorColumnaP] = 4;
            }
        }

        for(int i=0; i<tableroPosicion.length ;i++){
            for (int j = 0; j < tableroPosicion[i].length; j++) {
                System.out.print(tableroPosicion[i][j] + "");
            }
            System.out.println();
        }
    }

    public int[][] getTableroPosicion() {
        return tableroPosicion;
    }

    public int[][] getTableroPrincipal() {
        return tableroPrincipal;
    }

    public void iniciarPartida() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroPrincipal[i][j] = 0;
            }
        }
    }

    public void pintarTablero(Graphics g, int tablero[][], int x, int y) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(tablero[i][j]==0){
                    g.setColor(Color.BLACK);
                    g.drawRect(x+i*30,y+j*30,30,30);
                }
                tableroPrincipal[i][j]=0;
            }
        }
    }

    public void pintar(Graphics g){
        iniciarPartida();
        pintarTablero(g,tableroPrincipal,300,300);
    }


}
