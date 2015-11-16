/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imagenesivanpr.control;

import com.imagenesivanpr.Data.ImagenesDAO;
import com.imagenesivanpr.modelo.Imagen;
import com.imagenesivanpr.vista.View;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author dam2
 */
public class ControlImagenes {

    private CarruselImagenes imagenes;

    public ControlImagenes() {
        imagenes = new CarruselImagenes();
    }

     public void addImg(Imagen img){
        imagenes.addImagen(img);
        
    }

    public CarruselImagenes getCarrusel() {
        return imagenes;
    }

    public void setImagenes(CarruselImagenes imagenes) {
        this.imagenes = imagenes;
    }
     
    public void pasarSiguienteImagen(){
        imagenes.pasar();
    } 
    
    public void pasarImagenPrevia(){
        imagenes.atras();
    }
    
    public Imagen getCurrentImage(){
        Imagen img=imagenes.getImage(imagenes.getIndexCurrentImg());
        return img;
    }
    
    public Imagen getNextImage(){
        Imagen img=imagenes.getImage(imagenes.getIndexNextImg());
        return img;
    }
    
    public Imagen getPreviousImage(){
        Imagen img=imagenes.getImage(imagenes.getIndexPreviousImg());
        return img;
    }
    
    public int getTamano(){
        return imagenes.tamano();
    }
    
    public ImageIcon getResizedIcon(String path){
        return imagenes.getResizedIconPanel(path);
    }
    
    public BufferedImage getResizedImage(String path){
        return imagenes.getResizedImagePanel(path);
    }
       
    public void saveImages() {
        //Guardar como JSON.
        ImagenesDAO imagenDAO = new ImagenesDAO();
        imagenDAO.save(imagenes.getImagenes());
    }

    public void loadImages() {
        //Cargar como JSON.
        ImagenesDAO imagenDAO = new ImagenesDAO();
        imagenes.setImagenes(imagenDAO.load());
    }
    
    
    
}
