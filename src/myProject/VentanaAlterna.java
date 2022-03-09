package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class VentanaAlterna extends JFrame {
    private Header headerProject;
    private JPanel panelPosicion, panelPrincipal;
    private Casillas casillas;

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
        /*this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();*/
        //Create Listener Object and Control Object
        casillas = new Casillas();
        //Set up JComponents
        headerProject = new Header("", Color.BLACK);
        headerProject.setPreferredSize(new Dimension(612, 131));
        ImageIcon imageHeader = new ImageIcon(getClass().getResource("/recursos/header.jpeg"));
        headerProject.setIcon(imageHeader);
        this.add(headerProject, BorderLayout.NORTH);
        /*constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(headerProject, constraints);*/
        headerProject.setBackground(Color.WHITE);

        casillas = new Casillas();
        casillas.setPreferredSize(new Dimension(300,300));
        casillas.setBorder(BorderFactory.createTitledBorder("Tablero de posición"));
        this.add(casillas,BorderLayout.EAST);
        /*constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelPosicion, constraints);*/
        //panelPosicion.add(casillas);
        casillas.inicio();
        casillas.ordenar();

        panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(300,300));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder("Tablero principal"));
        this.add(panelPrincipal,BorderLayout.WEST);
        /*constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelPrincipal, constraints);*/
        //panelPrincipal.add(probar);


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

