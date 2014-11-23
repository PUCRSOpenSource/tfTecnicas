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
    private int sessaoId;
    private boolean disponibilidade;

    public Cadeiras(int id, int sessaoId, boolean disponibilidade) {
        this.id = id;
        this.sessaoId = sessaoId;
        this.disponibilidade = disponibilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(int sessaoId) {
        this.sessaoId = sessaoId;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Cadeiras{" + "sessaoId=" + sessaoId + ", disponibilidade=" + disponibilidade + '}';
    }

}
