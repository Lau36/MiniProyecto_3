package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private ModelComputador modelComputador;
    private int counter1, counter2, counter3, counter4;
    private int[][] matrizComputador;
    private JButton botonPintar;
    private Escucha escucha;
    private int numAleatorio;
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
        modelComputador = new ModelComputador();
        nuevasCasillas1 = new CasillaMaquina[10][10];
        nuevasCasillas2 = new CasillaMaquina[10][10];
        matrizComputador = new int[10][10];
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        counter4 = 0;
        numAleatorio = 0;
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
                System.out.println("El numero aleatorio es: "+numAleatorio);
                numAleatorio = aleatorio.nextInt(5);
                tablerosAleatorios(numAleatorio);
                System.out.println();
                mostrarLaMatriz(modelComputador.getMatrizC());
            }

        }
    }

    public int getNumAleatorio() {
        System.out.println("El numero aleatorio es: "+numAleatorio);
        return numAleatorio;
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

    public void ataquesComputadora(){

    }


//--------Inicio de la funcion eternaaaa--------------------------------------------------------------------------------------------------------

    public void tablerosAleatorios(int valor){
        if(valor==0){
            while (counter1 < 4){
                if (counter1 == 0){
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(3, 0);
                    counter1++;
                }
                if (counter1 == 1){
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(4, 0);
                    counter1++;
                }
                if (counter1 == 2){
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(5, 0);
                    counter1++;
                }
                if (counter1 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(6, 0);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(5, 2);
                    counter2++;

                }
                if (counter2 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][3];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(5, 3);
                    counter2++;
                }
                if (counter2 == 2){
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][4];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(5, 4);
                    counter2++;
                }
                if (counter2 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(7, 2);
                    counter2++;

                }
                if (counter2 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][3];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(7, 3);
                    counter2++;

                }
                if (counter2 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][4];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(7, 4);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][2];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(3, 2);
                    counter3++;
                }
                if (counter3 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][3];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(3, 3);
                    counter3++;

                }
                if (counter3 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][5];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(3, 5);
                    counter3++;

                }
                if (counter3 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][6];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(3, 6);
                    counter3++;

                }
                if (counter3 == 4){
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[1][3];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(1, 3);
                    counter3++;

                }
                if (counter3 == 5){CasillaMaquina casillaMaquina1 = nuevasCasillas1[1][4];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(1, 4);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[9][6];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(9, 6);
                    counter4++;

                }
                if (counter4 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[8][7];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(8, 7);
                    counter4++;
                }
                if (counter4 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][8];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(7, 8);
                    counter4++;

                }
                if (counter4 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][9];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(6, 9);
                    counter4++;

                }

            }
        }

        if(valor==1){
            while (counter1 < 4) {
                if (counter1 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(7, 6);
                    counter1++;
                }
                if (counter1 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(6, 6);
                    counter1++;
                }
                if (counter1 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(5, 6);
                    counter1++;
                }
                if (counter1 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    modelComputador.insertarPortaavionesC(4,6);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[8][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(8,2);
                    counter2++;

                }
                if (counter2 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(7,2);
                    counter2++;
                }
                if (counter2 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(6,2);
                    counter2++;
                }
                if (counter2 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][1];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(4,1);
                    counter2++;

                }
                if (counter2 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][1];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(3,1);
                    counter2++;

                }
                if (counter2 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][1];
                    casillaMaquina1.setBackground(Color.BLUE);
                    modelComputador.insertarSubmarinosC(2,1);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][3];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(4,3);
                    counter3++;
                }
                if (counter3 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][4];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(4,4);
                    counter3++;

                }
                if (counter3 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][8];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(3,8);
                    counter3++;

                }
                if (counter3 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][8];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(4,8);
                    counter3++;

                }
                if (counter3 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[9][4];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(9,4);
                    counter3++;

                }
                if (counter3 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[9][5];
                    casillaMaquina1.setBackground(Color.RED);
                    modelComputador.insertarDestructoresC(9,5);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[8][8];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(8,8);
                    counter4++;

                }
                if (counter4 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][5];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(2,5);
                    counter4++;
                }
                if (counter4 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][4];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(7,4);
                    counter4++;

                }
                if (counter4 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][1];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    modelComputador.insertarFragatasC(6,1);
                    counter4++;

                }

            }


        }

        if(valor==2){
            while (counter1 < 4) {
                if (counter1 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][3];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(3,3);
                    counter1++;
                }
                if (counter1 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][3];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(4,3);
                    counter1++;
                }
                if (counter1 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][3];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(5,3);
                    counter1++;
                }
                if (counter1 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][3];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(6,3);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][1];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(2,1);
                    counter2++;

                }
                if (counter2 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][1];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(3,1);
                    counter2++;
                }
                if (counter2 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][1];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(4,1);
                    counter2++;
                }
                if (counter2 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][5];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(2,5);
                    counter2++;

                }
                if (counter2 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][5];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(3,5);
                    counter2++;

                }
                if (counter2 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][5];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(4,5);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][0];
                    casillaMaquina1.setBackground(Color.red);

                    modelComputador.insertarDestructoresC(7,0);
                    counter3++;
                }
                if (counter3 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][1];
                    casillaMaquina1.setBackground(Color.red);

                    modelComputador.insertarDestructoresC(7,1);
                    counter3++;

                }
                if (counter3 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][5];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(7,5);
                    counter3++;

                }
                if (counter3 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][6];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(7,6);
                    counter3++;

                }
                if (counter3 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][9];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(4,9);
                    counter3++;

                }
                if (counter3 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][9];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(5,9);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[1][0];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(1,0);
                    counter4++;

                }
                if (counter4 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[1][2];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(1,2);
                    counter4++;
                }
                if (counter4 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[8][3];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(8,3);
                    counter4++;

                }
                if (counter4 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][7];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(2,7);
                    counter4++;

                }

            }
        }
        if(valor==3){
            while (counter1 < 4) {
                if (counter1 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][6];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(2,6);
                    counter1++;
                }
                if (counter1 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][7];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(2,7);
                    counter1++;
                }
                if (counter1 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][8];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(2,8);
                    counter1++;
                }
                if (counter1 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][9];
                    casillaMaquina1.setBackground(Color.gray);
                    modelComputador.insertarPortaavionesC(2,9);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[1][4];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(1,4);
                    counter2++;

                }
                if (counter2 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[2][4];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(2,4);
                    counter2++;
                }
                if (counter2 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[3][4];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(3,4);
                    counter2++;
                }
                if (counter2 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][2];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(5,2);
                    counter2++;

                }
                if (counter2 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][2];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(6,2);
                    counter2++;

                }
                if (counter2 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][2];
                    casillaMaquina1.setBackground(Color.blue);
                    modelComputador.insertarSubmarinosC(7,2);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][6];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(5,6);
                    counter3++;
                }
                if (counter3 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[5][7];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(5,7);
                    counter3++;

                }
                if (counter3 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][8];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(7,8);
                    counter3++;

                }
                if (counter3 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[7][9];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(7,9);
                    counter3++;

                }
                if (counter3 == 4) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[9][6];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(9,6);
                    counter3++;

                }
                if (counter3 == 5) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[9][7];
                    casillaMaquina1.setBackground(Color.red);
                    modelComputador.insertarDestructoresC(9,7);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[1][2];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(1,2);
                    counter4++;

                }
                if (counter4 == 1) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[4][0];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(4,0);
                    counter4++;
                }
                if (counter4 == 2) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[8][0];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(8,0);
                    counter4++;

                }
                if (counter4 == 3) {
                    CasillaMaquina casillaMaquina1 = nuevasCasillas1[6][4];
                    casillaMaquina1.setBackground(Color.yellow);
                    modelComputador.insertarFragatasC(6,4);
                    counter4++;

                }

            }
        }
    }
//----------------Fin de la funcion larga-----------------------------------------------------------------------------------------------------------



}

