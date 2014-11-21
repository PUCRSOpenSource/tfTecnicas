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
public class Salas {
    private int id;
    private int capacidade;

    public Salas(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getId() {
        return id;
    }
}
