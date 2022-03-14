package myProject;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class VentanaAlterna extends JFrame {
    private Header headerProject;
    private JPanel panelPosicion, panelPrincipal;
    private CasillaMaquina[][] nuevasCasillas1, nuevasCasillas2;
    private CasillaMaquina casillaMaquina;

    /**
     * Constructor of GUI class
     */
    public VentanaAlterna(){
        initVentanaAlterna();

        //Default JFrame configuration
        this.setTitle("Battleship app");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initVentanaAlterna() {
        //Set up JFrame Container's Layout

        //Create Listener Object and Control Object
        nuevasCasillas1 = new CasillaMaquina[10][10];
        nuevasCasillas2 = new CasillaMaquina[10][10];
        //Set up JComponents
        headerProject = new Header("", Color.BLACK);
        headerProject.setPreferredSize(new Dimension(612, 131));
        ImageIcon imageHeader = new ImageIcon(getClass().getResource("/recursos/header.jpeg"));
        headerProject.setIcon(imageHeader);
        this.add(headerProject, BorderLayout.NORTH);
        headerProject.setBackground(Color.WHITE);

        panelPosicion = new JPanel();
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                nuevasCasillas1[i][j] = new CasillaMaquina(i,j); //se puede crear otra clase casillaHumano que sea las casillas del oponente
                panelPosicion.add(nuevasCasillas1[i][j]);
                nuevasCasillas1[i][j].setPreferredSize(new Dimension(25,25));
                panelPosicion.setPreferredSize(new Dimension(300,300));
                panelPosicion.setBorder(BorderFactory.createTitledBorder("Tablero de posición"));
                this.add(panelPosicion,BorderLayout.EAST);
            }
        }

        panelPrincipal = new JPanel();
        for(int i= 0; i<10; i++){
            for(int j =0; j<10; j++){
                nuevasCasillas2[i][j] = new CasillaMaquina(i,j);
                panelPrincipal.add(nuevasCasillas2[i][j]);
                panelPrincipal.setPreferredSize(new Dimension(300,300));
                nuevasCasillas2[i][j].setPreferredSize(new Dimension(20,20));
                panelPrincipal.setBorder(BorderFactory.createTitledBorder("Tablero principal"));
                this.add(panelPrincipal,BorderLayout.WEST);
            }
        }

    }

    public void pintarCasilla(){

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            VentanaAlterna miProjectVentanaAlterna = new VentanaAlterna();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

}

