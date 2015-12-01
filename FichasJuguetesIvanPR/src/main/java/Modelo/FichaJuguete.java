/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.FichasDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author dam2
 */
public class FichaJuguete implements Serializable{
    private String nombre;
    private String marca;
    private int edad;
    private float precio;
    private String tipo;
    private String pathImage;
    private String path;
    
    public FichaJuguete(String pathFileChooser){
        path=pathFileChooser;
        pathImage=".\\Toys\\ToyImages\\images\\"+pathFileChooser.substring(pathFileChooser.lastIndexOf("\\")+1);
    }
    
    public void scaleImage(){
        try{
            BufferedImage bi=ImageIO.read(new File(pathImage));
            FichasDAO img=new FichasDAO();
            img.saveImageOfToy(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, 120, 80, null),pathImage);
        }catch (IOException ex) {
            Logger.getLogger("Resize icons failed").log(Level.SEVERE, null, ex);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPathImage() {
        return pathImage;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void resizeIconOfToy(String path){
        try{
            BufferedImage bi=ImageIO.read(new File(path));
            FichasDAO img=new FichasDAO();
            img.saveImageOfToy(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, 120, 80, null),pathImage);
        }catch (IOException ex) {
            Logger.getLogger("Resize icons failed").log(Level.SEVERE, null, ex);
        }
    }
}
