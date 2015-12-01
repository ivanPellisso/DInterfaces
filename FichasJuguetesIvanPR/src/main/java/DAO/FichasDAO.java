/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.FichaJuguete;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author dam2
 */
public class FichasDAO {
    
    public void save(ArrayList<FichaJuguete> fichas){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(".\\Toys\\bin\\toys.dat")));
            oos.writeObject(fichas);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<FichaJuguete> load(){
        ArrayList<FichaJuguete> fichas=null;
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(".\\Toys\\bin\\toys.dat")));
            fichas=(ArrayList<FichaJuguete>)ois.readObject();
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void saveImageOfToy(BufferedImage bi, String path){
        try {
            ImageIO.write(bi, "jpg", new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
