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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author IvPR
 */
public class ControlFichas {
    private ArrayFichas fichas;
    
    public ControlFichas() {
        fichas=new ArrayFichas();
    }
    
    public void addFicha(FichaJuguete fj){
        fichas.addToy(fj);
        //scaleImage(path);
    }
    
    public void pasarFicha(){
        fichas.goForward();
    }
    
    public void pasarAtras(){
        fichas.comeBack();
    }
    
    public FichaJuguete getFichaActual(){
        FichaJuguete ficha=fichas.getFicha(fichas.getIndexCurrentToy());
        return ficha;
    }
    
    public FichaJuguete getFichaSiguiente(){
        FichaJuguete ficha=fichas.getFicha(fichas.getIndexNextToy());
        return ficha;
    }
    
    public FichaJuguete getFichaAnterior(){
        FichaJuguete ficha=fichas.getFicha(fichas.getIndexPreviousToy());
        return ficha;
    }
    
    public int getNumFichas(){
        return fichas.getSizeOfArrayFichas();
    }
    
    
    
}
