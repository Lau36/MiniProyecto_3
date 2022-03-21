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
    private JPanel panelPosicion, panelPrincipal, separador1, separados2;
    private JButton botonSalir, botonAyuda, botonJugar, verUsuario;
    private Escucha escucha;
    private Canva canva;
    private TableroUsuario tableroUsuario;
    private ModelJugador modelJugador;
    private ModelComputador modelComputador;
    private TableroComputador tableroComputador;
    private CasillaHumano[][] nuevasCasillaHumanos;
    private CasillaMaquina[][] nuevasCasillaMaquina;
    private CasillaHumano matriz;
    private VentanaAlterna ventanaAlterna;
    private int counter1, counter2, counter3, counter4;
    private int filaVariable, columnaVariable;
    private int estado;
    private ImageIcon imageHeader, imageBotonAyuda, imageBotonJugar, imageBotonVerOponente, imageHundido, imageTocado, imageAgua;


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
        modelComputador = new ModelComputador();
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
        headerProject.setPreferredSize(new Dimension(500, 120));
        imageHeader = new ImageIcon(getClass().getResource("/recursos/header.jpeg"));
        imageHeader = new ImageIcon(imageHeader.getImage().getScaledInstance(500,120, Image.SCALE_SMOOTH));
        headerProject.setIcon(imageHeader);
        constraints.gridx = 0;
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
                //panelPosicion.setBackground(Color.CYAN);
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
                nuevasCasillaMaquina[i][j] = new CasillaMaquina(i, j);
                nuevasCasillaMaquina[i][j].addMouseListener(escucha);
                panelPrincipal.add(nuevasCasillaMaquina[i][j]);
                nuevasCasillaMaquina[i][j].setPreferredSize(new Dimension(20, 20));
                panelPrincipal.setBorder(BorderFactory.createTitledBorder("Tablero principal"));
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.gridwidth = 1;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.CENTER;
                this.add(panelPrincipal, constraints);
            }
        }

        botonAyuda = new JButton("Ayuda");
        botonAyuda.setPreferredSize(new Dimension(130, 50));
        imageBotonAyuda = new ImageIcon(getClass().getResource("/recursos/ayuda.jpg"));
        imageBotonAyuda = new ImageIcon(imageBotonAyuda.getImage().getScaledInstance(137,50, Image.SCALE_SMOOTH));
        botonAyuda.setIcon(imageBotonAyuda);
        botonAyuda.setContentAreaFilled(false);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(botonAyuda, constraints);
        botonAyuda.addMouseListener(escucha);

        botonJugar = new JButton("Jugar");
        imageBotonJugar = new ImageIcon(getClass().getResource("/recursos/iniciar.jpeg"));
        imageBotonJugar = new ImageIcon(imageBotonJugar.getImage().getScaledInstance(137,50, Image.SCALE_SMOOTH));
        botonJugar.setIcon(imageBotonJugar);
        botonJugar.setContentAreaFilled(false);
        botonJugar.setPreferredSize(new Dimension(130, 50));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(botonJugar, constraints);
        botonJugar.addMouseListener(escucha);
        botonJugar.setVisible(false);

        verUsuario = new JButton("Ver oponente");
        verUsuario.setPreferredSize(new Dimension(130, 50));
        imageBotonVerOponente = new ImageIcon(getClass().getResource("/recursos/oponente.jpeg"));
        imageBotonVerOponente = new ImageIcon(imageBotonVerOponente.getImage().getScaledInstance(137,50, Image.SCALE_SMOOTH));
        verUsuario.setIcon(imageBotonVerOponente);
        verUsuario.setContentAreaFilled(false);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(verUsuario, constraints);
        verUsuario.addMouseListener(escucha);


        //JOptionPane.showMessageDialog(null, "Antes de iniciar, te recomiendo darle click al boton ayuda y leer las instrucciones :)");
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
                    mostrarLaMatriz(tableroUsuario.getMatriz());
                }

            }
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JButton && e.getSource() != botonAyuda && e.getSource() != verUsuario && e.getSource() != botonSalir && e.getSource() != botonJugar) {
                CasillaMaquina casillaMaquinaSeleccionada = (CasillaMaquina) e.getSource();
                while(estado == 0){
                botonJugar.addMouseListener(escucha);
                botonJugar.setVisible(true);
                casillaMaquinaSeleccionada.setPreferredSize(new Dimension(20, 20));
                casillaMaquinaSeleccionada.getFila();
                casillaMaquinaSeleccionada.getColumna();
                filaVariable = casillaMaquinaSeleccionada.getFila();
                columnaVariable = casillaMaquinaSeleccionada.getColumna();
                tableroComputador.tablerosAleatorios(ventanaAlterna.getNumAleatorio(), ventanaAlterna.getNuevasCasillas1(), ventanaAlterna.getCasillaMaquina());
                verificarCoordenada(filaVariable, columnaVariable, casillaMaquinaSeleccionada, tableroComputador.getMatrizC());
                mostrarLaMatriz(tableroComputador.getMatrizC());
                estado = 1;
            }
                    //System.out.println(ventanaAlterna.getNumAleatorio());
            }

                if (e.getSource() == verUsuario){
                    VentanaAlterna ventanaAlterna = new VentanaAlterna();
                    ventanaAlterna.setVisible(true);
                    verUsuario.removeMouseListener(escucha);
                    verUsuario.setVisible(false);

                }

                if (e.getSource() == botonAyuda) {
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO, "Bienvenido Jugador", JOptionPane.QUESTION_MESSAGE);
                }

                if (e.getSource() == botonSalir) {
                    System.exit(0);
                }

                if (e.getSource() == botonJugar){
                    modelComputador.ataques(tableroUsuario.getMatriz(), nuevasCasillaHumanos,matriz);
                    estado = 0;
                    botonJugar.removeMouseListener(escucha);
                    botonJugar.setVisible(false);
                    mostrarLaMatriz(tableroUsuario.getMatriz());
                    //tableroComputador.tablerosAleatorios();
                    //mostrarLaMatriz(tableroComputador.getMatrizC());
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

    /**
     * Verifica si en una fila y columna de la matriz del oponente hay un barco y pinta hundido, agua o tocado dependiendo del barco que este en esa fila y columna
     *
     * @version v.1.0.0 date 17/03/2022
     */
        public void verificarCoordenada(int fila, int columna, JButton matrizSeleccionada, int [][] matriz) {
            for (int i = 0; i < tableroComputador.getMatrizC().length; i++) {
                for (int j = 0; j < tableroComputador.getMatrizC()[i].length; j++) {
                    mostrarLaMatriz(tableroComputador.getMatrizC());
                    if (matriz[fila][columna] == 1 || tableroComputador.getMatrizC()[fila][columna] == 2 || tableroComputador.getMatrizC()[fila][columna] == 3) {
                        imageTocado = new ImageIcon(getClass().getResource("/recursos/bomba 1.png"));
                        imageTocado = new ImageIcon(imageTocado.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                        matrizSeleccionada.setIcon(imageTocado);
                        matrizSeleccionada.setContentAreaFilled(false);
                        matriz[fila][columna] = 5;
                    } else if (matriz[fila][columna] == 4) {
                        imageHundido = new ImageIcon(getClass().getResource("/recursos/fuego.png"));
                        imageHundido = new ImageIcon(imageHundido.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                        matrizSeleccionada.setIcon(imageHundido);
                        matrizSeleccionada.setContentAreaFilled(false);
                        matriz[fila][columna] = 6;

                    } else if (matriz[fila][columna] == 0) {
                        matriz[fila][columna] = 0;
                        imageAgua = new ImageIcon(getClass().getResource("/recursos/equis.png"));
                        imageAgua = new ImageIcon(imageAgua.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
                        matrizSeleccionada.setIcon(imageAgua);
                        matrizSeleccionada.setContentAreaFilled(false);
                    }
                }
            }
        }

    /**
     * Muestra la matriz actualizada
     *
     * @version v.1.0.0 date 17/03/2022
     */
        public void mostrarLaMatriz(int[][] matriz) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + "");
                }
                System.out.println();

            }
            System.out.println("-------------------------------");

        }

    /**
     * Getter del estado del juego
     *
     *@return el valor de tipo entero del estado del juego
     * @version v.1.0.0 date 18/03/2022
     */
        public int getEstado(){
        return estado;
        }

    /**
     * Getter de casillaHumanos
     *
     * @return la matriz de tipo CasillaHumanos
     * @version v.1.0.0 date 18/03/2022
     */
    public CasillaHumano[][] getNuevasCasillaHumanos() {
        return nuevasCasillaHumanos;
    }
}



