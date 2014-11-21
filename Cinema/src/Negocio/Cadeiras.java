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
public class Cadeiras {
    private int id;
    private int salaId;
    private boolean disponibilidade;

    public Cadeiras(int id, int salaId, boolean disponibilidade) {
        this.id = id;
        this.salaId = salaId;
        this.disponibilidade = disponibilidade;
    }

    public int getId() {
        return id;
    }

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
