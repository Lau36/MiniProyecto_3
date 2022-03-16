package myProject;

import javax.swing.*;
import java.awt.*;

public class Canva extends JPanel{
    private ImageIcon imageFrame;

    public Canva(){

    }

    public void paintComponent(Graphics g){
        imageFrame = new ImageIcon(getClass().getResource("/recursos/agua.png"));
        g.drawImage(imageFrame.getImage(),0,0,getWidth(),getHeight(),null);
        setOpaque(false);
        super.paintComponent(g);
    }

}
