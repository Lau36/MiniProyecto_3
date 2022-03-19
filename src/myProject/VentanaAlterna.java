package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class VentanaAlterna extends JFrame {
    private Header headerProject;
    private JPanel panelPosicion, panelPrincipal;
    private CasillaMaquina[][] nuevasCasillas1, nuevasCasillas2, casillaSeleccionada;
    private CasillaMaquina casillaMaquina;
    private TableroComputador tableroComputador;
    private int counter1, counter2, counter3, counter4;
    private int[][] matrizComputador;
    private JButton botonPintar;
    private Escucha escucha;

    private int numAleatorioF, numAleatorioC;

    /**
     * Constructor of GUI class
     */
    public VentanaAlterna() {
        this.setContentPane(new Canva());
        initVentanaAlterna();
        //Default JFrame configuration
        this.setTitle("Battleship app");
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
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        tableroComputador = new TableroComputador();
        nuevasCasillas1 = new CasillaMaquina[10][10];
        nuevasCasillas2 = new CasillaMaquina[10][10];
        matrizComputador = new int[10][10];
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        counter4 = 0;

        //Set up JComponents
        headerProject = new Header("", Color.BLACK);
        headerProject.setPreferredSize(new Dimension(612, 131));
        ImageIcon imageHeader = new ImageIcon(getClass().getResource("/recursos/header.jpeg"));
        headerProject.setIcon(imageHeader);
        headerProject.setBackground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(headerProject, constraints);

        panelPosicion = new JPanel();
        panelPosicion.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nuevasCasillas1[i][j] = new CasillaMaquina(i, j);
                panelPosicion.add(nuevasCasillas1[i][j]);
                nuevasCasillas1[i][j].setPreferredSize(new Dimension(25, 25));
                panelPosicion.setBorder(BorderFactory.createTitledBorder("Tablero de posición"));
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.gridwidth = 1;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.CENTER;
                this.add(panelPosicion, constraints);

            }
        }

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nuevasCasillas2[i][j] = new CasillaMaquina(i, j);
                panelPrincipal.add(nuevasCasillas2[i][j]);
                nuevasCasillas2[i][j].setPreferredSize(new Dimension(20, 20));
                panelPrincipal.setBorder(BorderFactory.createTitledBorder("Tablero principal"));
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.gridwidth = 1;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.CENTER;
                this.add(panelPrincipal, constraints);
            }
        }

        botonPintar = new JButton("PINTAR");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonPintar, constraints);
        botonPintar.addActionListener(escucha);

    }


    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            VentanaAlterna miProjectVentanaAlterna = new VentanaAlterna();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == botonPintar){
                Random aleatorio = new Random();
                //System.out.println("El numero aleatorio es: "+tableroComputador.getNumAleatorio());
              //  tableroComputador.getNumAleatorio() = tableroComputador.getNumAleatorio();
                tableroComputador.tablerosAleatorios(tableroComputador.getNumAleatorio(),nuevasCasillas1,casillaMaquina);
                System.out.println();
                mostrarLaMatriz(tableroComputador.getMatrizC());
            }

        }
    }

    public int getNumAleatorio() {
        System.out.println("El numero aleatorio es: "+tableroComputador.getNumAleatorio());
        return tableroComputador.getNumAleatorio();
    }

    public void mostrarLaMatriz(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

    }


    public CasillaMaquina getCasillaMaquina() {
        return casillaMaquina;
    }

    public CasillaMaquina[][] getNuevasCasillas1() {
        return nuevasCasillas1;
    }



}

