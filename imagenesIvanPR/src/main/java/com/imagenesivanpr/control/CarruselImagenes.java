/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imagenesivanpr.control;

import com.imagenesivanpr.modelo.Imagen;
import com.imagenesivanpr.vista.View;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author dam2
 */
public class CarruselImagenes {
    private ArrayList<Imagen> imagenes;
    private int currentImg;

    public CarruselImagenes() {
        imagenes=new ArrayList();
        currentImg=0;
    }
    
    public void rmvImg(){
        imagenes.remove(currentImg);
        if(currentImg!=0){
            atras();
        }
    }

    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }
    
    public int tamano(){
        return imagenes.size();
    }
    
    public void addImagen(Imagen img){
        imagenes.add(img);
        resizeTheImages(img);
        resizeTheIcons(img);
    }
    
    public void resizeTheIcons(Imagen img){
        img.resizeIcon();
    }
    
    public void resizeTheImages(Imagen img){
        img.resizeImage();
    }
    
    public int getIndexCurrentImg(){
        return currentImg;
    }
    
    public int getIndexNextImg(){
        return (currentImg+1)%imagenes.size();
    }
    
    public int getIndexPreviousImg(){
        int indexImg=currentImg-1;
        return (indexImg<0?imagenes.size()-1:indexImg);
    }
    
    public Imagen getImage(int indexImg){
        return imagenes.get(indexImg);
    }
    
    public void pasar(){
        currentImg++;
        if(imagenes.size()!=0){
            currentImg%=imagenes.size();
        }
    }
    
    public void atras(){
        currentImg--;
        if(currentImg<0){
            currentImg=imagenes.size()-1;
        }
    }
    
    public ImageIcon getResizedIconPanel(String ruta){
        ImageIcon image=null;
        try {
            image=new ImageIcon(ImageIO.read(new File(ruta)));
        } catch (IOException ex) {
            
        }
        return image;
    }
    
    public BufferedImage getResizedImagePanel(String ruta){
        BufferedImage im=null;
        try {
            im=ImageIO.read(new File(ruta));
        } catch (IOException ex) {
            
        }
        return im;
    }
}
