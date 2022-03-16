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
    private int counter1, counter2, counter3, counter4;
    private int [][] matrizComputador;
    private JButton botonIniciar;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public VentanaAlterna(){
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

        //Create Listener Object and Control Object
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
        this.add(headerProject, BorderLayout.NORTH);
        headerProject.setBackground(Color.WHITE);

        panelPosicion = new JPanel();
        panelPosicion.setLayout(new GridLayout(10,10));
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                nuevasCasillas1[i][j] = new CasillaMaquina(i,j);
                panelPosicion.add(nuevasCasillas1[i][j]);
                nuevasCasillas1[i][j].setPreferredSize(new Dimension(25,25));
                panelPosicion.setBorder(BorderFactory.createTitledBorder("Tablero de posición"));
                this.add(panelPosicion,BorderLayout.EAST);

            }
        }

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(10,10));
        for(int i= 0; i<10; i++){
            for(int j =0; j<10; j++){
                nuevasCasillas2[i][j] = new CasillaMaquina(i,j);
                panelPrincipal.add(nuevasCasillas2[i][j]);
                nuevasCasillas2[i][j].setPreferredSize(new Dimension(20,20));
                panelPrincipal.setBorder(BorderFactory.createTitledBorder("Tablero principal"));
                this.add(panelPrincipal,BorderLayout.WEST);
            }
        }

        botonIniciar = new JButton();
        this.add(botonIniciar,BorderLayout.SOUTH);
        botonIniciar.addActionListener(escucha);

    }


    public void pintarBarcos(){
        if(counter1<4){
            Random aleatorio = new Random();
            CasillaMaquina casillaMaquina1 = nuevasCasillas1[aleatorio.nextInt(11)][aleatorio.nextInt(11)];
            this.casillaMaquina.setBackground(Color.GRAY);
            counter1++;
        }
        else if(counter2<6){
            casillaMaquina.setBackground(Color.BLUE);
            counter2++;

        }
        else if(counter3<6){
            casillaMaquina.setBackground(Color.red);
            counter3++;

        }
        else if(counter4<4){
            casillaMaquina.setBackground(Color.YELLOW);
            counter4++;

        }

    }


    public void insertarBarcos(){
        if(counter1<4){ //Portaaviones -> 1
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            Random aleatorio = new Random();
        for(int i= 0; i<matrizComputador.length; i++){
            for(int j = 0; j<matrizComputador[i].length;j++){
                matrizComputador[aleatorio.nextInt(11)][aleatorio.nextInt(11)] = 1;
            }
        }
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            counter1++;
    }
    else if(counter2<6){ //Submarinos -> 2
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            Random aleatorio = new Random();
            for(int i= 0; i<matrizComputador.length; i++){
                for(int j = 0; j<matrizComputador[i].length;j++){
                    matrizComputador[aleatorio.nextInt(11)][aleatorio.nextInt(11)] = 2;
                }
            }
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            counter2++;
    }

    else if(counter3<6){ //Destructores -> 3

            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            Random aleatorio = new Random();
            for(int i= 0; i<matrizComputador.length; i++){
                for(int j = 0; j<matrizComputador[i].length;j++){
                    matrizComputador[aleatorio.nextInt(11)][aleatorio.nextInt(11)] = 3;
                }
            }
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++){
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            counter3++;
        }

    else if(counter4<4){ //Fragatas -> 4
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            Random aleatorio = new Random();
            for(int i= 0; i<matrizComputador.length; i++){
                for(int j = 0; j<matrizComputador[i].length;j++){
                    matrizComputador[aleatorio.nextInt(11)][aleatorio.nextInt(11)] = 4;
                }
            }
            for(int i=0; i<matrizComputador.length ;i++){
                for (int j = 0; j < matrizComputador[i].length; j++) {
                    System.out.print(matrizComputador[i][j] + "");
                }
                System.out.println();
            }
            counter4++;
        }

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

    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==botonIniciar){
                if(counter1<4){ //Portaaviones -> 1
                    for(int i=0; i<matrizComputador.length ;i++){
                        for (int j = 0; j < matrizComputador[i].length; j++) {
                            System.out.print(matrizComputador[i][j] + "");
                        }
                        System.out.println();
                    }
                    Random aleatorio = new Random();
                    for(int i= 0; i<matrizComputador.length; i++){
                        for(int j = 0; j<matrizComputador[i].length;j++){
                            matrizComputador[aleatorio.nextInt(11)][aleatorio.nextInt(11)] = 1;
                        }
                    }
                    for(int i=0; i<matrizComputador.length ;i++){
                        for (int j = 0; j < matrizComputador[i].length; j++) {
                            System.out.print(matrizComputador[i][j] + "");
                        }
                        System.out.println();
                    }
                    counter1++;
                }
                else if(counter2<6){ //Submarinos -> 2
                    for(int i=0; i<matrizComputador.length ;i++){
                        for (int j = 0; j < matrizComputador[i].length; j++) {
                            System.out.print(matrizComputador[i][j] + "");
                        }
                        System.out.println();
                    }
                    Random aleatorio = new Random();
                    for(int i= 0; i<matrizComputador.length; i++){
                        for(int j = 0; j<matrizComputador[i].length;j++){
                            matrizComputador[aleatorio.nextInt(11)][aleatorio.nextInt(11)] = 2;
                        }
                    }
                    for(int i=0; i<matrizComputador.length ;i++){
                        for (int j = 0; j < matrizComputador[i].length; j++) {
                            System.out.print(matrizComputador[i][j] + "");
                        }
                        System.out.println();
                    }
                    counter2++;
                }
            }
    }
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

}

