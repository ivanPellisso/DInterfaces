/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imagenesivanpr.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author ivan
 */
public class ImagenPanel extends JPanel{

    private BufferedImage image;
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g); 
        if (this.image!=null){
           int coordX = (this.getWidth() - this.image.getWidth()) /2; 
           int coordY = (this.getHeight() - this.image.getHeight()) /2; 
           g.drawImage(this.image,coordX, coordY, null);
        }else{
            g.drawImage(this.image,0, 0, null);
        }
        
        
    }
    
    
    
}
