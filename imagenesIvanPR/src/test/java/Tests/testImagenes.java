package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.imagenesivanpr.Data.ImagenesDAO;
import com.imagenesivanpr.control.ControlImagenes;
import com.imagenesivanpr.vista.ImagenPanel;
import com.imagenesivanpr.vista.View;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.imgscalr.Scalr;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dam2
 */
public class testImagenes {
    private FrameFixture frame;
    private ControlImagenes control;
    public testImagenes() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        View v=new View();
        control=v.getControl();
        frame=new FrameFixture(v);
        frame.show();
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    //@Test
    public void testAdd(){
        ImageIcon ori=null;
        ImageIcon copiaIcon=null;
        BufferedImage copiaPanel=null;
        JMenuItemFixture add = frame.menuItem("miAdd");
        add.click();
        JFileChooserFixture fChooser = frame.fileChooser("fileChooser");
        File ruta=new File("src\\main\\resources\\otherImages\\");
        File foto1=new File("negros3.jpg");//der
        File foto2=new File("buho.jpg");//cen
        fChooser.setCurrentDirectory(ruta);
        fChooser.selectFiles(foto1,foto2);
        fChooser.approve();
        assertEquals(control.getTamano(), 2);
        ori=originalIcon("src\\main\\resources\\otherImages\\buho.jpg");
        copiaIcon=(ImageIcon)frame.label("labCen").target.getIcon();
        assertTrue(compareImages(((BufferedImage)(copiaIcon.getImage())),((BufferedImage)(ori.getImage()))));

        ori=originalIcon("src\\main\\resources\\otherImages\\negros3.jpg");
        copiaIcon=(ImageIcon)frame.label("labDer").target.getIcon();
        assertTrue(compareImages(((BufferedImage)(copiaIcon.getImage())),((BufferedImage)(ori.getImage()))));
        ori=originalImage("src\\main\\resources\\otherImages\\buho.jpg");
        copiaPanel=((ImagenPanel)frame.panel("imgPanel").target).getImage();
        assertTrue(compareImages(copiaPanel,(BufferedImage)ori.getImage()));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(testImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ImageIcon originalImage(String fich){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(resizeImage(new File(fich)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(fich+"imagenPruebas.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(fich+"imagenPruebas.jpg")));
        } catch (IOException ex) {
        }
        return ref;
    }
    
    public static BufferedImage resizeImage(File fich){
        int wImg;
        int hImg;
        int wImgPanel=0;
        int hImgPanel=0;
        BufferedImage bi=null;
        try {
            bi=ImageIO.read(fich);
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
        } catch (IOException ex) {
            Logger.getLogger("Resize images failed").log(Level.SEVERE, null, ex);
        }
        return Scalr.resize(bi, Scalr.Mode.AUTOMATIC, wImgPanel, hImgPanel, null);
    }
    
    public static ImageIcon originalIcon(String fich){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(resizeIcon(new File(fich)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(fich+"iconoPruebas.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(fich+"iconoPruebas.jpg")));
        } catch (IOException ex) {
        }
        return ref;
    }
    
    public static BufferedImage resizeIcon(File fich){
        BufferedImage ori = null;
        try {
            ori = ImageIO.read(fich);
        } catch (IOException ex) {
            Logger.getLogger(testImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
      return Scalr.resize(ori, Scalr.Mode.AUTOMATIC, 120, 80, null);
    }
    
    //@Test
    public void testDelete(){
        ImageIcon ori=null;
        ImageIcon copiaIcon=null;
        BufferedImage copiaPanel=null;
        JMenuItemFixture add = frame.menuItem("miAdd");
        add.click();
        JFileChooserFixture fChooser = frame.fileChooser("fileChooser");
        File ruta=new File("src\\main\\resources\\otherImages\\");
        File foto1=new File("negros3.jpg");//der
        File foto2=new File("buho.jpg");//cen
        fChooser.setCurrentDirectory(ruta);
        fChooser.selectFiles(foto1,foto2);
        fChooser.approve();
        JMenuItemFixture del = frame.menuItem("miDel");
        del.click();
        assertEquals(control.getTamano(), 1);
        ori=originalIcon("src\\main\\resources\\otherImages\\negros3.jpg");
        copiaIcon=(ImageIcon)frame.label("labCen").target.getIcon();
        assertTrue(compareImages((BufferedImage)(copiaIcon.getImage()),((BufferedImage)(ori.getImage()))));
        ori=originalImage("src\\main\\resources\\otherImages\\negros3.jpg");
        copiaPanel=((ImagenPanel)frame.panel("imgPanel").target).getImage();
        assertTrue(compareImages(copiaPanel,((BufferedImage)(ori.getImage()))));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(testImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testPreviousImage(){
        ImageIcon ori=null;
        ImageIcon copiaIcon=null;
        BufferedImage copiaPanel=null;
        JMenuItemFixture add = frame.menuItem("miAdd");
        add.click();
        JFileChooserFixture fChooser = frame.fileChooser("fileChooser");
        File ruta=new File("src\\main\\resources\\otherImages\\");
        File foto1=new File("negros3.jpg");//der
        File foto2=new File("buho.jpg");//cen
        File foto3=new File("penguin.jpg");
        fChooser.setCurrentDirectory(ruta);
        fChooser.selectFiles(foto1,foto2,foto3);
        fChooser.approve();
        JButtonFixture bIzq=frame.button("bIzq");
        bIzq.click();
        ori=originalIcon("src\\main\\resources\\otherImages\\penguin.jpg");
        copiaIcon=(ImageIcon)frame.label("labCen").target.getIcon();
        assertTrue(compareImages(((BufferedImage)(copiaIcon.getImage())),((BufferedImage)(ori.getImage()))));
        ori=originalIcon("src\\main\\resources\\otherImages\\negros3.jpg");
        copiaIcon=(ImageIcon)frame.label("labIzq").target.getIcon();
        assertTrue(compareImages((BufferedImage)(copiaIcon.getImage()),((BufferedImage)(ori.getImage()))));
        ori=originalIcon("src\\main\\resources\\otherImages\\buho.jpg");
        copiaIcon=(ImageIcon)frame.label("labDer").target.getIcon();
        assertTrue(compareImages((BufferedImage)(copiaIcon.getImage()),((BufferedImage)(ori.getImage()))));
        ori=originalImage("src\\main\\resources\\otherImages\\penguin.jpg");
        copiaPanel=((ImagenPanel)frame.panel("imgPanel").target).getImage();
        assertTrue(compareImages(copiaPanel,((BufferedImage)(ori.getImage()))));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(testImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testNextImage(){
        ImageIcon ori=null;
        ImageIcon copiaIcon=null;
        BufferedImage copiaPanel=null;
        JMenuItemFixture add = frame.menuItem("miAdd");
        add.click();
        JFileChooserFixture fChooser = frame.fileChooser("fileChooser");
        File ruta=new File("src\\main\\resources\\otherImages\\");
        File foto1=new File("negros3.jpg");//der
        File foto2=new File("buho.jpg");//cen
        File foto3=new File("penguin.jpg");
        fChooser.setCurrentDirectory(ruta);
        fChooser.selectFiles(foto1,foto2,foto3);
        fChooser.approve();
        JButtonFixture bDer=frame.button("bDer");
        bDer.click();
        ori=originalIcon("src\\main\\resources\\otherImages\\negros3.jpg");
        copiaIcon=(ImageIcon)frame.label("labCen").target.getIcon();
        assertTrue(compareImages(((BufferedImage)(copiaIcon.getImage())),((BufferedImage)(ori.getImage()))));
        ori=originalIcon("src\\main\\resources\\otherImages\\buho.jpg");
        copiaIcon=(ImageIcon)frame.label("labIzq").target.getIcon();
        assertTrue(compareImages((BufferedImage)(copiaIcon.getImage()),((BufferedImage)(ori.getImage()))));
        ori=originalIcon("src\\main\\resources\\otherImages\\penguin.jpg");
        copiaIcon=(ImageIcon)frame.label("labDer").target.getIcon();
        assertTrue(compareImages((BufferedImage)(copiaIcon.getImage()),((BufferedImage)(ori.getImage()))));
        ori=originalImage("src\\main\\resources\\otherImages\\negros3.jpg");
        copiaPanel=((ImagenPanel)frame.panel("imgPanel").target).getImage();
        assertTrue(compareImages(copiaPanel,((BufferedImage)(ori.getImage()))));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(testImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
    // The images mush be the same size.
        
        if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
            int width = imgA.getWidth();
            int height = imgA.getHeight();
            // Loop over every pixel.
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Compare the pixels for equality.
                    if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
