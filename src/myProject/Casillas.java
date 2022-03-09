package myProject;

import javax.swing.*;
import java.awt.*;

public class Casillas extends JPanel{
    private JButton[][] nCasillas;
    private int numero_Filas;
    private int numero_Columnas;

    public void Casillas() {
        nCasillas = null;
        numero_Columnas = 10;
        numero_Filas = 10;
    }

    //Esta funcion es para que se pueda ordenar
    public void ordenar() {
        int ancho = this.getWidth();
        int alto = this.getHeight();

        int altoCasillas = alto / 10;
        int anchoCasillas = ancho / 10;

        for (int fila = 0; fila < numero_Filas; fila++) {
            for (int columna = 0; columna < numero_Columnas; columna++){

                //Se obtiene una referencia al boton actual
                JButton casilla = nCasillas[fila][columna];

                //fija cada casilla en un posicion y tamñano respecto a su fila y columna
                casilla.setBounds(columna*anchoCasillas,fila*altoCasillas,anchoCasillas,altoCasillas);
            }
        }
}

    public void inicio(){
        nCasillas = new JButton[numero_Filas][numero_Columnas];
        for(int fila=0; fila<numero_Filas; fila++){
            for(int columna=0; columna<numero_Columnas; columna++){
                JButton casilla = new JButton();
                casilla.setPreferredSize(new Dimension(20,20));
                casilla.setText("Agua posicion: "+"("+fila+")"+"("+columna+")");
                //this.add(casilla);//agrega los botones al panel
                nCasillas[fila][columna] = casilla;// agrega el boton a las casillas
            }
        }
    }
}
