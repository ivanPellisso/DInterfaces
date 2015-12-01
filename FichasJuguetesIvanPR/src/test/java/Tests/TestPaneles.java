package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Vista.JFrameFormulario;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JPanelFixture;
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
public class TestPaneles {
    private FrameFixture frame;
    
    public TestPaneles() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        frame=new FrameFixture(new JFrameFormulario());
        frame.show();
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    
    @Test
    public void panelCorrecto(){
        JMenuItemFixture vista=frame.menuItem("miVista");
        JMenuItemFixture edicion=frame.menuItem("miUpdate");
        JMenuItemFixture filtro=frame.menuItem("miFiltro");
        JPanelFixture panelVista=frame.panel("vista");
        vista.click();
        assertEquals(panelVista.target.isVisible(), true);
        edicion.click();
        JPanelFixture panelEdicion=frame.panel("editar");
        assertEquals(panelEdicion.target.isVisible(), true);
        filtro.click();
        JPanelFixture panelFiltro=frame.panel("filtro");
        assertEquals(panelFiltro.target.isVisible(), true);
    }
}
