package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private JTextArea  jugador;
    private Escucha escucha;
    private TableroUsuario tableroUsuario;
    private ModelJugadores modelJugadores;
    private Casillas casillas;
    private Casilla[][] nuevasCasillas;

    /**
     * Constructor of GUI class
     */
    public VentanaPrincipal(){
        initVentana();

        //Default JFrame configuration
        this.setTitle("Battleship app");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        //this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        //casillas = new Casilla();
        tableroUsuario = new TableroUsuario();
        modelJugadores = new ModelJugadores();
        nuevasCasillas = new Casilla[10][10];

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
                nuevasCasillas[i][j]= new Casilla(i,j);
                nuevasCasillas[i][j].addActionListener(escucha);
                nuevasCasillas[i][j].setPreferredSize(new Dimension(20,20));
                panelPosicion.add(nuevasCasillas[i][j]);
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
        panelPrincipal.setPreferredSize(new Dimension(300,300));
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                nuevasCasillas[i][j]=new Casilla(i,j);
                nuevasCasillas[i][j].addActionListener(escucha);
                panelPrincipal.add(nuevasCasillas[i][j]);
                nuevasCasillas[i][j].setPreferredSize(new Dimension(20,20));
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

        botonJugar = new JButton("Posicionar");
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
        @Override
        public void actionPerformed(ActionEvent e){
                //Casilla casillaSeleccionada = (Casilla) e.getSource(); //ya tengo la referencia de la casilla que se selecciono
        }

        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==verUsuario){
                VentanaAlterna ventanaAlterna = new VentanaAlterna();
                ventanaAlterna.setVisible(true);
            }
            if(e.getSource()==botonJugar){
                int num = 0;
                while(num<4){
                    tableroUsuario.preguntarPosicionFila();
                    tableroUsuario.preguntarPosicionColumna();
                    tableroUsuario.insertarFragata();
                    num++;
                }
                int num2 = 0;
                while(num2<3){
                    tableroUsuario.preguntarPosicionFilaD();
                    tableroUsuario.preguntarPosicionColumnaD();
                    tableroUsuario.insertarDestructor();
                    num2++;
                }
                int num3 = 0;
                while(num3<2){
                    tableroUsuario.preguntarPosicionFilaS();
                    tableroUsuario.preguntarPosicionColumnaS();
                    tableroUsuario.insertarSubmarino();
                    num3++;
                }
                int num4 = 0;
                while(num4<1){
                    tableroUsuario.preguntarPosicionFilaP();
                    tableroUsuario.preguntarPosicionColumnaP();
                    tableroUsuario.insertarPortaaviones();
                    num4++;
                }
                tableroUsuario.getTableroPosicion();
                tableroUsuario.verificarFragata();

            }
            if(e.getSource()==botonAyuda){
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO, "Bienvenido Jugador", JOptionPane.QUESTION_MESSAGE);
            }
            if(e.getSource()==botonSalir){
                System.exit(0);
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
