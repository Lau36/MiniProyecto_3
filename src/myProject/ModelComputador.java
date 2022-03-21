package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @version v.1.0.0 date:15/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class ModelComputador extends JPanel {
    private ImageIcon imageTocado, imageHundido, imageAgua;
    private CasillaHumano matriz2;
    private int fila;
    private int columna;


    /**
     * Class Constructor
     */
    public ModelComputador(){
        /*
        Los numero con el que identificamos los barcos son los siguientes
        Portaaviones ->1
        Submarinos -> 2
        Destructores -> 3
        Fragats -> 4
        */

    }

    /**
     * Genera los ataques del computador de forma aleatoria
     *
     * @version v.1.0.0 date 21/03/2022
     */
    public void ataques(int[][] matriz1, CasillaHumano[][] nuevasCasillas, CasillaHumano matriz2){
        Random aleatorio = new Random();
        fila = aleatorio.nextInt(10);
        columna= aleatorio.nextInt(10);
        for(int i=0; i<matriz1.length ;i++){
            for(int j = 0; j<matriz1[i].length; j++){
                if(matriz1[fila][columna]== 1 || matriz1[fila][columna]== 2 || matriz1[fila][columna]== 3){//recorre la matriz de la logica y pinta en la matriz del gui
                    matriz2 = nuevasCasillas[fila][columna];
                    imageTocado = new ImageIcon(getClass().getResource("/recursos/bomba 1.png"));
                    imageTocado = new ImageIcon(imageTocado.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                    matriz2.setIcon(imageTocado);
                    matriz2.setContentAreaFilled(false);
                    matriz1[fila][columna] = 5;
                }
                if(matriz1[fila][columna]== 4){
                    matriz2 = nuevasCasillas[fila][columna];
                    imageHundido = new ImageIcon(getClass().getResource("/recursos/fuego.png"));
                    imageHundido = new ImageIcon(imageHundido.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                    matriz2.setIcon(imageHundido);
                    matriz2.setContentAreaFilled(false);
                    matriz1[fila][columna] = 6;
                }
                if(matriz1[fila][columna]== 0){
                    matriz2 = nuevasCasillas[fila][columna];
                    imageAgua = new ImageIcon(getClass().getResource("/recursos/equis.png"));
                    imageAgua = new ImageIcon(imageAgua.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                    matriz2.setIcon(imageAgua);
                    matriz2.setContentAreaFilled(false);
                    matriz1[fila][columna] = 0;

                }
            }
        }
    }

}
