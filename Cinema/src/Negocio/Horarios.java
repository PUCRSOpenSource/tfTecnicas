/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author CanTM
 */
public class Horarios {

    private int id;
    private String inicio;
    private String fim;

    public Horarios(int id, String inicio, String fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getId() {
        return id;
    }
    
    public String getInicio() {
        return inicio;
    }

    public String getFim() {
        return fim;
    }

    @Override
    public String toString() {
        return "Horarios{" + "inicio=" + inicio + ", fim=" + fim + '}';
    }

}
