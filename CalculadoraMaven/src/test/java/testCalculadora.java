/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.calculadoramaven.Calculadora;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.fest.swing.fixture.JTabbedPaneFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dam2
 */
public class testCalculadora {
    private FrameFixture frame;
    
    public testCalculadora() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        frame=new FrameFixture(new Calculadora());
        frame.show();
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void testSuma() {
        JTabbedPaneFixture tpFx=frame.tabbedPane("jTabbedPane1");
        JButtonFixture bFx=frame.button("bSuma");
        JTextComponentFixture tcFx=frame.textBox("txOp1B");
        JTextComponentFixture tcFx2=frame.textBox("txOp2B");
        JLabelFixture labFx=frame.label("labResB");
        tpFx.selectTab("1");
        tcFx.setText("20");
        tcFx2.setText("5");
        bFx.click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        labFx.requireText("25");
    }
    
    //@Test
    public void testResta() {
        JTabbedPaneFixture tpFx=frame.tabbedPane("jTabbedPane1");
        JButtonFixture bFx=frame.button("bResta");
        JTextComponentFixture tcFx=frame.textBox("txOp1B");
        JTextComponentFixture tcFx2=frame.textBox("txOp2B");
        JLabelFixture labFx=frame.label("labResB");
        tpFx.selectTab("1");
        tcFx.setText("20");
        tcFx2.setText("5");
        bFx.click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        labFx.requireText("15");
    }
    
    //@Test
    public void testMultiplica() {
        JTabbedPaneFixture tpFx=frame.tabbedPane("jTabbedPane1");
        JButtonFixture bFx=frame.button("bMultiplica");
        JTextComponentFixture tcFx=frame.textBox("txOp1B");
        JTextComponentFixture tcFx2=frame.textBox("txOp2B");
        JLabelFixture labFx=frame.label("labResB");
        tpFx.selectTab("1");
        tcFx.setText("20");
        tcFx2.setText("5");
        bFx.click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        labFx.requireText("100");
    }
    
    //@Test
    public void testDivide() {
        JTabbedPaneFixture tpFx=frame.tabbedPane("jTabbedPane1");
        JButtonFixture bFx=frame.button("bDivide");
        JTextComponentFixture tcFx=frame.textBox("txOp1B");
        JTextComponentFixture tcFx2=frame.textBox("txOp2B");
        JLabelFixture labFx=frame.label("labResB");
        tpFx.selectTab("1");
        tcFx.setText("20");
        tcFx2.setText("5");
        bFx.click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        labFx.requireText("4.0");
        tcFx.setText("82");
        tcFx2.setText("4");
        bFx.click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        labFx.requireText("20.5");
    }
    
    @Test
    public void errorTextSuma(){
        errorTx1("jTabbedPane1", "bSuma", "txOp1B", "txOp2B", "labResB", "1");
        errorTx2("jTabbedPane1", "bSuma", "txOp1B", "txOp2B", "labResB", "1");
        errorTx1y2("jTabbedPane1", "bSuma", "txOp1B", "txOp2B", "labResB", "1");
    }
    
    //@Test
    public void errorTextResta(){
        errorTx1("jTabbedPane1", "bResta", "txOp1B", "txOp2B", "labResB", "1");
        errorTx2("jTabbedPane1", "bResta", "txOp1B", "txOp2B", "labResB", "1");
        errorTx1y2("jTabbedPane1", "bResta", "txOp1B", "txOp2B", "labResB", "1");
    }
    
    //@Test
    public void errorTextMultiplica(){
        errorTx1("jTabbedPane1", "bMultiplica", "txOp1B", "txOp2B", "labResB", "1");
        errorTx2("jTabbedPane1", "bMultiplica", "txOp1B", "txOp2B", "labResB", "1");
        errorTx1y2("jTabbedPane1", "bMultiplica", "txOp1B", "txOp2B", "labResB", "1");
    }
    
    //@Test
    public void errorTextDivide(){
        errorTx1("jTabbedPane1", "bDivide", "txOp1B", "txOp2B", "labResB", "1");
        errorTx2("jTabbedPane1", "bDivide", "txOp1B", "txOp2B", "labResB", "1");
        errorTx1y2("jTabbedPane1", "bDivide", "txOp1B", "txOp2B", "labResB", "1");
    }
    
    public void errorTx1(String tp, String b, String tx1, String tx2, String lab, String tab ){
        JTabbedPaneFixture tpFx=frame.tabbedPane(tp);
        JButtonFixture bFx=frame.button(b);
        JTextComponentFixture tcFx1=frame.textBox(tx1);
        JTextComponentFixture tcFx2=frame.textBox(tx2);
        JLabelFixture labFx=frame.label(lab);
        tpFx.selectTab(tab);
        tcFx1.setText("");
        tcFx2.setText("5");
        bFx.click();
        JOptionPaneFixture opFx1=frame.optionPane();
        assertEquals(tcFx1.target.getBackground(), Color.RED);
        opFx1.okButton().click();
        assertEquals(opFx1.target.getMessageType(),JOptionPane.ERROR_MESSAGE);
        tcFx1.setText("a");
        tcFx2.setText("4");
        bFx.click();
        JOptionPaneFixture opFx2=frame.optionPane();
        assertEquals(tcFx1.target.getBackground(), Color.RED);
        opFx1.okButton().click();
        assertEquals(opFx2.target.getMessageType(),JOptionPane.ERROR_MESSAGE);
    }
    public void errorTx2(String tp, String b, String tx1, String tx2, String lab, String tab ){
        JTabbedPaneFixture tpFx=frame.tabbedPane(tp);
        JButtonFixture bFx=frame.button(b);
        JTextComponentFixture tcFx1=frame.textBox(tx1);
        JTextComponentFixture tcFx2=frame.textBox(tx2);
        JLabelFixture labFx=frame.label(lab);
        tpFx.selectTab(tab);
        tcFx1.setText("34");
        tcFx2.setText("");
        bFx.click();
        JOptionPaneFixture opFx1=frame.optionPane();
        assertEquals(tcFx2.target.getBackground(), Color.RED);
        opFx1.okButton().click();
        assertEquals(opFx1.target.getMessageType(),JOptionPane.ERROR_MESSAGE);
        tcFx1.setText("2");
        tcFx2.setText("b");
        bFx.click();
        JOptionPaneFixture opFx2=frame.optionPane();
        assertEquals(tcFx2.target.getBackground(), Color.RED);
        opFx1.okButton().click();
        assertEquals(opFx2.target.getMessageType(),JOptionPane.ERROR_MESSAGE);
    }
    public void errorTx1y2(String tp, String b, String tx1, String tx2, String lab, String tab ){
        JTabbedPaneFixture tpFx=frame.tabbedPane(tp);
        JButtonFixture bFx=frame.button(b);
        JTextComponentFixture tcFx1=frame.textBox(tx1);
        JTextComponentFixture tcFx2=frame.textBox(tx2);
        JLabelFixture labFx=frame.label(lab);
        tpFx.selectTab(tab);
        tcFx1.setText("");
        tcFx2.setText("");
        bFx.click();
        JOptionPaneFixture opFx1=frame.optionPane();
        assertEquals(tcFx1.target.getBackground(), Color.RED);
        opFx1.okButton().click();
        assertEquals(opFx1.target.getMessageType(),JOptionPane.ERROR_MESSAGE);
        tcFx1.setText("a");
        tcFx2.setText("a");
        bFx.click();
        JOptionPaneFixture opFx2=frame.optionPane();
        assertEquals(tcFx2.target.getBackground(), Color.RED);
        opFx1.okButton().click();
        assertEquals(opFx2.target.getMessageType(),JOptionPane.ERROR_MESSAGE);
    }
}
