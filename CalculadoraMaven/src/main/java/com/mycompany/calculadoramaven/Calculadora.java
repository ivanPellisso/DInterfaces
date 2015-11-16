/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadoramaven;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author dam2
 */
public class Calculadora extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    double op1, op2;
    public Calculadora() {
        initComponents();
        initLater();
    }
    
    private void initLater(){
        //rellenaComboOps();
        jTabbedPane1.setName("jTabbedPane1");
        jPanel1.setName("1");
        jPanel2.setName("2");
        jPanel3.setName("3");
    }
    /*
    private void rellenaComboOps(){
        bSuma.setText("A sumar");
        ItemListener[] listener=cOperacion.getItemListeners();
        cOperacion.removeItemListener(listener[0]);
        cOperacion.removeAllItems();
        cOperacion.addItem(new ComboOptionOperacion("Sumar",Operaciones.SUMAR).toString());
        cOperacion.addItem(new ComboOptionOperacion("Restar",Operaciones.RESTAR).toString());
        cOperacion.addItem(new ComboOptionOperacion("Multiplicar",Operaciones.MULTIPLICAR).toString());
        cOperacion.addItem(new ComboOptionOperacion("Dividir",Operaciones.DIVIDIR).toString());
        cOperacion.addItemListener(listener[0]);
        
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private boolean msgError(){
        txOp1B.setBackground(Color.white);
        txOp2B.setBackground(Color.white);
        boolean error=false;
        double num=0;
        try{
            op1=Double.parseDouble(txOp1B.getText());
        }catch(Exception e){
            txOp1B.setBackground(Color.red);
            error=true;
        }
        try{
            op2=Double.parseDouble(txOp2B.getText());
        }catch(Exception ex){
            txOp2B.setBackground(Color.red);
            error=true;
        }
        if(error){
            JOptionPane.showMessageDialog(this, "Escriba un número","Error", JOptionPane.ERROR_MESSAGE);
        }
        return error;
    }
    
    private boolean msgErrorRB(){
        txOp1RB.setBackground(Color.white);
        txOp2RB.setBackground(Color.white);
        boolean error=false;
        try{
            op1=Double.parseDouble(txOp1RB.getText());
        }catch(Exception e){
            txOp1RB.setBackground(Color.red);
            error=true;
        }
        try{
            op2=Double.parseDouble(txOp2RB.getText());
        }catch(Exception ex){
            txOp2RB.setBackground(Color.red);
            error=true;
        }
        if(error){
            JOptionPane.showMessageDialog(this, "Escriba un número","Error", JOptionPane.ERROR_MESSAGE);
        }
        return error;
    }
    
    private boolean msgErrorC(){
        txOp1C.setBackground(Color.white);
        txOp2C.setBackground(Color.white);
        boolean error=false;
        try{
            op1=Double.parseDouble(txOp1C.getText());
        }catch(Exception e){
            txOp1C.setBackground(Color.red);
            error=true;
        }
        try{
            op2=Double.parseDouble(txOp2C.getText());
        }catch(Exception ex){
            txOp2C.setBackground(Color.red);
            error=true;
        }
        if(error){
            JOptionPane.showMessageDialog(this, "Escriba un número","Error", JOptionPane.ERROR_MESSAGE);
        }
        return error;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txOp1B = new javax.swing.JTextField();
        txOp2B = new javax.swing.JTextField();
        labResB = new javax.swing.JLabel();
        bSuma = new javax.swing.JButton();
        bResta = new javax.swing.JButton();
        bMultiplica = new javax.swing.JButton();
        bDivide = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txOp1RB = new javax.swing.JTextField();
        txOp2RB = new javax.swing.JTextField();
        labResRB = new javax.swing.JLabel();
        rbSuma = new javax.swing.JRadioButton();
        rbResta = new javax.swing.JRadioButton();
        rbMultiplica = new javax.swing.JRadioButton();
        rbDivide = new javax.swing.JRadioButton();
        bEqual = new javax.swing.JButton();
        chDecimal = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        txOp1C = new javax.swing.JTextField();
        txOp2C = new javax.swing.JTextField();
        labResC = new javax.swing.JLabel();
        cOperacion = new javax.swing.JComboBox();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setName(""); // NOI18N

        jPanel1.setName(""); // NOI18N

        txOp1B.setName("txOp1B"); // NOI18N

        txOp2B.setName("txOp2B"); // NOI18N

        labResB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labResB.setName("labResB"); // NOI18N

        bSuma.setText("+");
        bSuma.setName("bSuma"); // NOI18N
        bSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSumaActionPerformed(evt);
            }
        });

        bResta.setText("-");
        bResta.setName("bResta"); // NOI18N
        bResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRestaActionPerformed(evt);
            }
        });

        bMultiplica.setText("x");
        bMultiplica.setName("bMultiplica"); // NOI18N
        bMultiplica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMultiplicaActionPerformed(evt);
            }
        });

        bDivide.setText("/");
        bDivide.setName("bDivide"); // NOI18N
        bDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labResB, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txOp2B, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txOp1B, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bSuma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bResta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bMultiplica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bSuma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bResta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bMultiplica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDivide))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txOp1B, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txOp2B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(labResB, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("1", jPanel1);

        txOp1RB.setName("txOp1RB"); // NOI18N

        txOp2RB.setName("txOp2RB"); // NOI18N

        labResRB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labResRB.setName("labResRB"); // NOI18N

        buttonGroup2.add(rbSuma);
        rbSuma.setText("Sumar");
        rbSuma.setActionCommand("Suma");
        rbSuma.setName("rbSuma"); // NOI18N

        buttonGroup2.add(rbResta);
        rbResta.setText("Restar");
        rbResta.setActionCommand("Resta");

        buttonGroup2.add(rbMultiplica);
        rbMultiplica.setText("Multiplicar");
        rbMultiplica.setActionCommand("Multiplica");

        buttonGroup2.add(rbDivide);
        rbDivide.setText("Dividir");
        rbDivide.setActionCommand("Divide");

        bEqual.setText("=");
        bEqual.setName("bEqual"); // NOI18N
        bEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEqualActionPerformed(evt);
            }
        });

        chDecimal.setText("Decimales");
        chDecimal.setName("chDecimal"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txOp2RB, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(txOp1RB))
                    .addComponent(labResRB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rbMultiplica, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rbDivide)
                        .addComponent(rbResta)
                        .addComponent(rbSuma))
                    .addComponent(chDecimal))
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bEqual)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txOp1RB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txOp2RB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbSuma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbResta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbMultiplica, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbDivide)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bEqual)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labResRB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chDecimal))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("2", jPanel2);

        labResC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cOperacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige...", "Sumar", "Restar", "Multiplicar", "Dividir" }));
        cOperacion.setName(""); // NOI18N
        cOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cOperacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labResC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txOp2C, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(txOp1C))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(cOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txOp1C, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txOp2C, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(labResC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEqualActionPerformed
        if(!msgErrorRB()){
            switch(buttonGroup2.getSelection().getActionCommand()){
                case "Suma":
                    if(!chDecimal.isSelected()){
                        labResRB.setText(((int)(op1+op2))+"");
                    }else{
                        labResRB.setText((op1+op2)+"");
                    }
                    break;
                case "Resta":
                    if(!chDecimal.isSelected()){
                        labResRB.setText(((int)(op1-op2))+"");
                    }else{
                        labResRB.setText((op1-op2)+"");
                    }
                    break;
                case "Multiplica":
                    if(!chDecimal.isSelected()){
                        labResRB.setText(((int)(op1*op2))+"");
                    }else{
                        labResRB.setText((op1*op2)+"");
                    }
                    break;
                case "Divide":
                    if(!chDecimal.isSelected()){
                        labResRB.setText(((int)((op1/op2)))+"");
                    }else{
                        labResRB.setText((op1/op2)+"");
                    }
                    break;
            }
        }
    }//GEN-LAST:event_bEqualActionPerformed

    private void bSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSumaActionPerformed
        if(!msgError()){labResB.setText(((int)(op1+op2))+"");}
    }//GEN-LAST:event_bSumaActionPerformed
    
    private void bRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRestaActionPerformed
        if(!msgError()){labResB.setText(((int)(op1-op2))+"");}
    }//GEN-LAST:event_bRestaActionPerformed

    private void bMultiplicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMultiplicaActionPerformed
        if(!msgError()){labResB.setText(((int)(op1*op2))+"");}
    }//GEN-LAST:event_bMultiplicaActionPerformed

    private void bDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivideActionPerformed
        if(!msgError()){labResB.setText(((op1/op2))+"");}
    }//GEN-LAST:event_bDivideActionPerformed

    private void cOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cOperacionActionPerformed
        if(!msgErrorC()){
            switch(cOperacion.getSelectedItem().toString()){
                case "Elige...":
                    txOp1C.setText("");
                    txOp2C.setText("");
                    labResC.setText("");
                    break;
                case "Sumar":
                    labResC.setText(((int)(op1+op2))+"");
                    break;
                case "Restar":
                    labResC.setText(((int)(op1-op2))+"");
                    break;
                case "Multiplicar":
                    labResC.setText(((int)(op1*op2))+"");
                    break;
                case "Dividir":
                    labResC.setText(((op1/op2))+"");
                    break;
            }
        }
    }//GEN-LAST:event_cOperacionActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDivide;
    private javax.swing.JButton bEqual;
    private javax.swing.JButton bMultiplica;
    private javax.swing.JButton bResta;
    private javax.swing.JButton bSuma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cOperacion;
    private javax.swing.JCheckBox chDecimal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labResB;
    private javax.swing.JLabel labResC;
    private javax.swing.JLabel labResRB;
    private javax.swing.JRadioButton rbDivide;
    private javax.swing.JRadioButton rbMultiplica;
    private javax.swing.JRadioButton rbResta;
    private javax.swing.JRadioButton rbSuma;
    private javax.swing.JTextField txOp1B;
    private javax.swing.JTextField txOp1C;
    private javax.swing.JTextField txOp1RB;
    private javax.swing.JTextField txOp2B;
    private javax.swing.JTextField txOp2C;
    private javax.swing.JTextField txOp2RB;
    // End of variables declaration//GEN-END:variables

}
