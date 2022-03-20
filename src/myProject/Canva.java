package myProject;

import javax.swing.*;
import java.awt.*;

public class Canva extends JPanel{
    private ImageIcon imageFrame;

    /**
     * Class Constructor
     */
    public Canva(){

    }

    /**
     * Pinta el fondo de la ventana
     *
     * @version v.1.0.0 date 16/03/2022
     */
    public void paintComponent(Graphics g){
        imageFrame = new ImageIcon(getClass().getResource("/recursos/aguaa.jpg"));
        g.drawImage(imageFrame.getImage(),0,0,getWidth(),getHeight(),null);
        setOpaque(false);
        super.paintComponent(g);
    }

}
