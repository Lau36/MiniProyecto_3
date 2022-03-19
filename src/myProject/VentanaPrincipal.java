package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class VentanaPrincipal extends JFrame {
    public static final String MENSAJE_INICIO = "";

    private Header headerProject;
    private JPanel panelPosicion, panelPrincipal;
    private JButton botonSalir, botonAyuda, botonJugar, verUsuario;
    private Escucha escucha;
    private Canva canva;
    private TableroUsuario tableroUsuario;
    private ModelJugador modelJugador;
    private TableroComputador tableroComputador;
    private CasillaHumano[][] nuevasCasillaHumanos;
    private CasillaMaquina[][] nuevasCasillaMaquina;
    private VentanaAlterna ventanaAlterna;
    private int counter1, counter2, counter3, counter4;
    private int filaVariable, columnaVariable;
    private int estado;


    /**
     * Constructor of GUI class
     */
    public VentanaPrincipal() {
        this.setContentPane(new Canva());
        initVentana();
        //Default JFrame configuration
        this.setTitle("Battleship app");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initVentana() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        //casillas = new CasillaHumano();
        tableroUsuario = new TableroUsuario();
        modelJugador = new ModelJugador();
        tableroComputador = new TableroComputador();
        nuevasCasillaHumanos = new CasillaHumano[10][10];
        nuevasCasillaMaquina = new CasillaMaquina[10][10];
        ventanaAlterna = new VentanaAlterna();
        ventanaAlterna.setVisible(false);


        //Set up JComponents
        headerProject = new Header("", Color.BLACK);
        headerProject.setPreferredSize(new Dimension(612, 131));
        ImageIcon imageHeader = new ImageIcon(getClass().getResource("/recursos/header.jpeg"));
        headerProject.setIcon(imageHeader);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(headerProject, constraints);
        headerProject.setBackground(Color.WHITE);

        panelPosicion = new JPanel();
        panelPosicion.setLayout(new GridLayout(10, 10));

        //Crea las casillas y las visualiza
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nuevasCasillaHumanos[i][j] = new CasillaHumano(i, j);
                nuevasCasillaHumanos[i][j].addActionListener(escucha);
                nuevasCasillaHumanos[i][j].setPreferredSize(new Dimension(20, 20));
                panelPosicion.add(nuevasCasillaHumanos[i][j]);
                panelPosicion.setBorder(BorderFactory.createTitledBorder("Tablero de posición"));
                panelPosicion.setBackground(Color.CYAN);
                constraints.gridx = 1;
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
                nuevasCasillaMaquina[i][j] = new CasillaMaquina(i, j);
                nuevasCasillaMaquina[i][j].addMouseListener(escucha);
                panelPrincipal.add(nuevasCasillaMaquina[i][j]);
                nuevasCasillaMaquina[i][j].setPreferredSize(new Dimension(20, 20));
                panelPrincipal.setBorder(BorderFactory.createTitledBorder("Tablero principal"));
                constraints.gridx = 2;
                constraints.gridy = 1;
                constraints.gridwidth = 1;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.CENTER;
                this.add(panelPrincipal, constraints);
            }
        }

        botonSalir = new JButton("Salir");
        botonSalir.setPreferredSize(new Dimension(100, 45));
        //ImageIcon imageBotonsalir = new ImageIcon(getClass().getResource("/recursos/exit.jpeg"));
        //botonSalir.setIcon(imageBotonsalir);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonSalir, constraints);
        botonSalir.addMouseListener(escucha);

        botonAyuda = new JButton("Ayuda");
        botonAyuda.setPreferredSize(new Dimension(108, 45));
        //ImageIcon imageBotonAyuda = new ImageIcon(getClass().getResource("/recursos/ayudaa.jpeg"));
        //botonAyuda.setIcon(imageBotonAyuda);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(botonAyuda, constraints);
        botonAyuda.addMouseListener(escucha);

        botonJugar = new JButton("Jugar");
        //ImageIcon imageBotonJugar = new ImageIcon(getClass().getResource("/recursos/jugar.jpeg"));
        //botonJugar.setIcon(imageBotonJugar);
        botonJugar.setPreferredSize(new Dimension(120, 45));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonJugar, constraints);
        botonJugar.addMouseListener(escucha);

        verUsuario = new JButton("Ver oponente");
        verUsuario.setPreferredSize(new Dimension(120, 45));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(verUsuario, constraints);
        verUsuario.addMouseListener(escucha);

        JOptionPane.showMessageDialog(null, "Antes de iniciar, te recomiendo darle click al boton ayuda y leer las instrucciones :)");
    }


    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            VentanaPrincipal miProjectVentanaPrincipal = new VentanaPrincipal();
        });
    }


    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener {
        public Escucha() {
            counter1 = 0;
            counter2 = 0;
            counter3 = 0;
            counter4 = 0;
            estado = 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                CasillaHumano casillaHumanoSeleccionada = (CasillaHumano) e.getSource(); //ya tengo la referencia de la casilla que se selecciono
                if (counter1 < 4) {//portaaviones -> 1
                    casillaHumanoSeleccionada.setBackground(Color.GRAY);
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.getColumna();
                    System.out.println("LA FILA: " + filaVariable);
                    System.out.println("LA COLUMNA: " + columnaVariable);
                    System.out.println();
                    counter1++;
                    tableroUsuario.insertarPortaaviones(filaVariable, columnaVariable);
                } else if (counter2 < 6) {//submarinos -> 2
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.setBackground(Color.BLUE);
                    casillaHumanoSeleccionada.getFila();
                    casillaHumanoSeleccionada.getColumna();
                    counter2++;
                    tableroUsuario.insertarSubmarinos(filaVariable, columnaVariable);
                } else if (counter3 < 6) { //destructores -> 3
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.setBackground(Color.RED);
                    casillaHumanoSeleccionada.getFila();
                    casillaHumanoSeleccionada.getColumna();
                    counter3++;
                    tableroUsuario.insertarDestructores(filaVariable, columnaVariable);
                } else if (counter4 < 4) { //fragatas -> 4
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.setBackground(Color.YELLOW);
                    casillaHumanoSeleccionada.getFila();
                    casillaHumanoSeleccionada.getColumna();
                    tableroUsuario.insertarFragatas(filaVariable, columnaVariable);
                    counter4++;
                    modelJugador.verificarDisparoPortaavion(filaVariable, columnaVariable);
                }

            }
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JButton && e.getSource() != botonAyuda && e.getSource() != verUsuario && e.getSource() != botonSalir && e.getSource() != botonJugar) {
                    CasillaMaquina casillaMaquinaSeleccionada = (CasillaMaquina) e.getSource();
                    System.out.println("aaaaaa");
                    casillaMaquinaSeleccionada.getFila();
                    casillaMaquinaSeleccionada.getColumna();
                    filaVariable = casillaMaquinaSeleccionada.getFila();
                    columnaVariable = casillaMaquinaSeleccionada.getColumna();
                    tableroComputador.tablerosAleatorios(ventanaAlterna.getNumAleatorio(),ventanaAlterna.getNuevasCasillas1(),ventanaAlterna.getCasillaMaquina());
                    verificarCoordenada(filaVariable, columnaVariable, casillaMaquinaSeleccionada);
                    mostrarLaMatriz(tableroComputador.getMatrizC());
                    System.out.println(ventanaAlterna.getNumAleatorio());
            }

                if (e.getSource() == verUsuario) {
                    VentanaAlterna ventanaAlterna = new VentanaAlterna();
                    ventanaAlterna.setVisible(true);

                }

                if (e.getSource() == botonAyuda) {
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO, "Bienvenido Jugador", JOptionPane.QUESTION_MESSAGE);
                }

                if (e.getSource() == botonSalir) {
                    System.exit(0);
                }

                if (e.getSource() == botonJugar) {
                    //tableroComputador.tablerosAleatorios();
                    mostrarLaMatriz(tableroComputador.getMatrizC());
                }

            }

            @Override
            public void mousePressed (MouseEvent e){

            }

            @Override
            public void mouseReleased (MouseEvent e){

            }

            @Override
            public void mouseEntered (MouseEvent e){

            }

            @Override
            public void mouseExited (MouseEvent e){

            }
        }

        public void verificarCoordenada(int fila, int columna, JButton matrizSeleccionada) {
            for (int i = 0; i < tableroComputador.getMatrizC().length; i++) {
                for (int j = 0; j < tableroComputador.getMatrizC()[i].length; j++) {
                    mostrarLaMatriz(tableroComputador.getMatrizC());
                    if (tableroComputador.getMatrizC()[fila][columna] == 1 || tableroComputador.getMatrizC()[fila][columna] == 2 || tableroComputador.getMatrizC()[fila][columna] == 3) {
                            /*ImageIcon image = new ImageIcon(getClass().getResource("/recursos/ayudaa.jpeg"));
                            casillaMaquinaSeleccionada.setIcon(image);*/
                        matrizSeleccionada.setBackground(Color.orange);
                        tableroComputador.getMatrizC()[fila][columna] = 5;
                    } else if (tableroComputador.getMatrizC()[fila][columna] == 4) {
                        tableroComputador.getMatrizC()[fila][columna] = 6;
                        matrizSeleccionada.setBackground(Color.black);
                    } else if (tableroComputador.getMatrizC()[fila][columna] == 0) {
                        tableroComputador.getMatrizC()[fila][columna] = 0;
                        matrizSeleccionada.setBackground(Color.CYAN);
                    }
                }
            }
        }

        public void mostrarLaMatriz(int[][] matriz) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + "");
                }
                System.out.println();

            }
            System.out.println("-------------------------------");

        }

        public int getEstado(){
        return estado;
        }

    public CasillaHumano[][] getNuevasCasillaHumanos() {
        return nuevasCasillaHumanos;
    }
}



