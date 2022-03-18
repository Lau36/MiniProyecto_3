package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class VentanaPrincipal extends JFrame {
    public static final String MENSAJE_INICIO = "";

    private Header headerProject;
    private JPanel panelPosicion, panelPrincipal;
    private JButton botonSalir, botonAyuda, botonJugar, verUsuario;
    private ImageIcon imageHeader;
    private boolean encontrado;
    private Escucha escucha;
    private Canva canva;
    private TableroUsuario tableroUsuario;
    private ModelJugadores modelJugadores;
    private CasillaHumano[][] nuevasCasillaHumanos;
    private CasillaMaquina[][] nuevasCasillaMaquina;
    private int counter1, counter2, counter3, counter4;
    private ArrayList<String> listaPortaaviones, listaDestructores, listaSubmarinos, listaFragata;
    private int numeroDeBarcos;
    private int filaVariable, columnaVariable;
    private int [][] matriz;

    /**
     * Constructor of GUI class
     */
    public VentanaPrincipal(){
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
        encontrado = false;
        listaPortaaviones = new ArrayList<String>();
        listaDestructores = new ArrayList<String>();
        listaFragata = new ArrayList<String>();
        listaSubmarinos = new ArrayList<String>();
        //casillas = new CasillaHumano();
        tableroUsuario = new TableroUsuario();
        modelJugadores = new ModelJugadores();
        nuevasCasillaHumanos = new CasillaHumano[10][10];
        matriz = new int[10][10];

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
        panelPosicion.setLayout(new GridLayout(10,10));

        //Crea las casillas y las visualiza
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                nuevasCasillaHumanos[i][j]= new CasillaHumano(i,j);
                nuevasCasillaHumanos[i][j].addActionListener(escucha);
                nuevasCasillaHumanos[i][j].setPreferredSize(new Dimension(20,20));
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
        panelPrincipal.setLayout(new GridLayout(10,10));
        //panelPrincipal.setPreferredSize(new Dimension(300,300));
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                nuevasCasillaHumanos[i][j]=new CasillaHumano(i,j);
                nuevasCasillaHumanos[i][j].addActionListener(escucha);
                panelPrincipal.add(nuevasCasillaHumanos[i][j]);
                nuevasCasillaHumanos[i][j].setPreferredSize(new Dimension(20,20));
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

        botonJugar = new JButton("Verificar");
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
    }




    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            VentanaPrincipal miProjectVentanaPrincipal = new VentanaPrincipal();
        });
    }


    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener{
        public Escucha(){
            counter1 = 0;
            counter2 = 0;
            counter3 = 0;
            counter4 = 0;

        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
                CasillaHumano casillaHumanoSeleccionada = (CasillaHumano) e.getSource(); //ya tengo la referencia de la casilla que se selecciono
                if(counter1<4){//portaaviones -> 1
                    casillaHumanoSeleccionada.setBackground(Color.GRAY);
                     filaVariable = casillaHumanoSeleccionada.getFila();
                     columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.getColumna();
                    System.out.println("LA FILA: "+filaVariable);
                    System.out.println("LA COLUMNA: "+columnaVariable);
                    numeroDeBarcos = 1; //Esto es el numero de barcos que hay en la flota para poder identificarlo en las funciones
                    listaPortaaviones.add("p");
                    System.out.println();
                    counter1++;
                    tableroUsuario.insertarPortaaviones(filaVariable,columnaVariable);
                    tableroUsuario.verificarPortaavion();
                }
                else if(counter2<6){//submarinos -> 2
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.setBackground(Color.BLUE);
                    casillaHumanoSeleccionada.getFila();
                    casillaHumanoSeleccionada.getColumna();
                    numeroDeBarcos = 2;
                    listaSubmarinos.add("s");
                    counter2++;
                    tableroUsuario.insertarSubmarinos(filaVariable,columnaVariable);
                }
                else if(counter3<6){ //destructores -> 3
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.setBackground(Color.RED);
                    casillaHumanoSeleccionada.getFila();
                    casillaHumanoSeleccionada.getColumna();
                    numeroDeBarcos = 3;
                    listaDestructores.add("d");
                    counter3++;
                    tableroUsuario.insertarDestructores(filaVariable,columnaVariable);
                }
                else if(counter4<4){ //fragatas -> 4
                    filaVariable = casillaHumanoSeleccionada.getFila();
                    columnaVariable = casillaHumanoSeleccionada.getColumna();
                    casillaHumanoSeleccionada.setBackground(Color.YELLOW);
                    casillaHumanoSeleccionada.getFila();
                    casillaHumanoSeleccionada.getColumna();
                    numeroDeBarcos = 4;
                    listaFragata.add("f");
                    tableroUsuario.insertarFragatas(filaVariable,columnaVariable);
                    counter4++;
                    modelJugadores.verificarDisparoPortaavion(filaVariable, columnaVariable);
                }
            }
        }


        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==verUsuario){
                VentanaAlterna ventanaAlterna = new VentanaAlterna();
                ventanaAlterna.setVisible(true);
                //ventanaAlterna.dispose();

            }
            if(e.getSource()==botonAyuda){
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO, "Bienvenido Jugador", JOptionPane.QUESTION_MESSAGE);
            }
            if(e.getSource()==botonSalir){
                System.exit(0);
            }
            if(e.getSource() == botonJugar ){

            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
