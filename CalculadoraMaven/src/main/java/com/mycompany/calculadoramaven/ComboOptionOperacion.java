/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadoramaven;

/**
 *
 * @author dam2
 */
public class ComboOptionOperacion {
    private String text;
    private Operaciones operacion;

    public ComboOptionOperacion(String text, Operaciones operacion) {
        this.text = text;
        this.operacion = operacion;
    }

    public ComboOptionOperacion() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
}
