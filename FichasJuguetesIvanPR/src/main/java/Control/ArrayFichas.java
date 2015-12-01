/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.FichasDAO;
import Modelo.FichaJuguete;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author IvPR
 */
public class ArrayFichas {
    private ArrayList<FichaJuguete> fichas;
    private int currentToy;
    
    public ArrayFichas(){
        fichas=new ArrayList();
        currentToy=0;
    }
    
    public int numberOfToys(){
        return fichas.size();
    }
    
    public void addToy(FichaJuguete fj){
        fichas.add(fj);
    }
    
    public void removeToy(){
        fichas.remove(currentToy);
        if(currentToy!=0){
            comeBack();
        }
    }
    
    public int getIndexCurrentToy(){
        return currentToy;
    }
    
    public int getIndexPreviousToy(){
        int indexToy=currentToy-1;
        return (indexToy<0?fichas.size()-1:indexToy);
    }
    
    public int getIndexNextToy(){
        return (currentToy+1)%fichas.size();
    }
    
    public void comeBack(){
        currentToy--;
        if(currentToy<0){
            currentToy=fichas.size()-1;
        }
    }
    
    public void goForward(){
        currentToy++;
        if(!fichas.isEmpty()){
            currentToy%=fichas.size();
        }
    }
    
    public FichaJuguete getFicha(int indexToy){
        return fichas.get(indexToy);
    }
    
    public int getSizeOfArrayFichas(){
        return fichas.size();
    }
    
    
}
