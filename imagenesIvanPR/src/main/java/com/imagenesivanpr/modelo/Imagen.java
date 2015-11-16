/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imagenesivanpr.modelo;

import com.imagenesivanpr.Data.ImagenesDAO;
import com.imagenesivanpr.control.ControlImagenes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
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
public class Imagen implements Serializable{
    
    private String path;
    private String pathImage;
    private String pathImageBlur;
    private String pathImageGS;
    private String pathIcon;
    private String pathPaintedImages;
    private int tipo;

    public String getPathPaintedImages() {
        return pathPaintedImages;
    }

    public void setPathPaintedImages(String pathPaintedImages) {
        this.pathPaintedImages = pathPaintedImages;
    }

    public Imagen() {
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public Imagen(String pathFileChooser) {
        this.path=pathFileChooser;
        pathImage=".\\MyImages\\images\\"+pathFileChooser.substring(pathFileChooser.lastIndexOf("\\")+1);
        pathImageBlur=".\\MyImages\\blurImages\\"+pathFileChooser.substring(pathFileChooser.lastIndexOf("\\")+1);
        pathImageGS=".\\MyImages\\greyScaleImages\\"+pathFileChooser.substring(pathFileChooser.lastIndexOf("\\")+1);
        pathIcon=".\\MyImages\\imageIcons\\"+pathFileChooser.substring(pathFileChooser.lastIndexOf("\\")+1);
        pathPaintedImages=".\\MyImages\\paintedImages\\"+pathFileChooser.substring(pathFileChooser.lastIndexOf("\\")+1);
        tipo=1;
    }

    public void resizeIcon(){
        try{
            BufferedImage bi=ImageIO.read(new File(path));
            ImagenesDAO img=new ImagenesDAO();
            img.saveImage(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, 120, 80, null),pathIcon);
        }catch (IOException ex) {
            Logger.getLogger("Resize icons failed").log(Level.SEVERE, null, ex);
        }
    }
    
    public void resizeImage(){
        int wImg;
        int hImg;
        int wImgPanel;
        int hImgPanel;
        try {
            BufferedImage bi=ImageIO.read(new File(path));
            wImg=bi.getWidth();
            hImg=bi.getHeight();
            if(wImg>hImg){
                wImgPanel=500;
                hImgPanel=500*(hImg/wImg);
            }else{
                hImgPanel=500;
                wImgPanel=500*(wImg/hImg);
            }
            ImagenesDAO img=new ImagenesDAO();
            img.saveImage(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, wImgPanel, hImgPanel, null),pathImage);
            img.saveImage(this.blur(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, wImgPanel, hImgPanel, null)),pathImageBlur);
            img.saveImage(this.greyScale(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, wImgPanel, hImgPanel, null)), pathImageGS);
            img.saveImage(this.pintar(Scalr.resize(bi, Scalr.Mode.AUTOMATIC, wImgPanel, hImgPanel, null)), pathPaintedImages);
        } catch (IOException ex) {
            Logger.getLogger("Resize images failed").log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathIcon() {
        return pathIcon;
    }

    public void setPathIcon(String pathIcon) {
        this.pathIcon = pathIcon;
    }
    
    public String getPathImageBlur() {
        return pathImageBlur;
    }

    public void setPathImageBlur(String pathImageBlur) {
        this.pathImageBlur = pathImageBlur;
    }

    public String getPathImageGS() {
        return pathImageGS;
    }

    public void setPathImageGS(String pathImageGS) {
        this.pathImageGS = pathImageGS;
    }
    
    public String getPathImage() {
        return tipo==1?pathImage:(tipo==2?pathImageBlur:(tipo==3?pathImageGS:pathPaintedImages));
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
    
    public BufferedImage blur(BufferedImage im) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = im;
            Kernel kernel = new Kernel(3, 3, new float[]{1f / 9f, 1f / 9f, 1f / 9f,
                1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f});
            BufferedImageOp op = new ConvolveOp(kernel);
            bufferedImage = op.filter(bufferedImage, null);
        } catch (Exception ex) {
            Logger.getLogger(ControlImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bufferedImage;
    }
    
    public BufferedImage greyScale(BufferedImage im) {
        //Variables que almacenarán los píxeles
        int mediaPixel,colorSRGB;
        Color colorAux;
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < im.getWidth(); i++ ){
            for( int j = 0; j < im.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(im.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
                //Cambiamos a formato sRGB
                colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                //Asignamos el nuevo valor al BufferedImage
                im.setRGB(i, j,colorSRGB);
            }
        }
        return im;
    }
    
    public BufferedImage pintar(BufferedImage bi){
        BufferedImage im = bi;
        Graphics2D g = im.createGraphics();
        g.setColor(Color.red);        
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        g.drawString("IPR", 20, 20);
        return im;
    }
    
    
}
