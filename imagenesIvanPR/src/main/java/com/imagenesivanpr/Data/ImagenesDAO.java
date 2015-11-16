/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imagenesivanpr.Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imagenesivanpr.modelo.Imagen;
import com.imagenesivanpr.vista.View;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class ImagenesDAO {

    public ArrayList<Imagen> load() {
        ArrayList<Imagen> imagenes = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            imagenes = mapper.readValue(new File(".\\MyImages\\state\\imagenes.json"), 
                    new TypeReference<ArrayList<Imagen>>() {
            });

        } catch (IOException ex) {
            Logger.getLogger(ImagenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagenes;
    }

    public void save(ArrayList<Imagen> imagenes) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(".\\MyImages\\state\\imagenes.json"), imagenes);
            
        } catch (IOException ex) {
            Logger.getLogger(ImagenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveImage(BufferedImage bi, String path){
        try {
            ImageIO.write(bi, "jpg", new File(path));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
