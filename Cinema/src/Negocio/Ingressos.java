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
public class Ingressos {
    private int id;
    private int sessaoId;
    private int salaId;
    private int cadeiraId;
    private double valorPago;

    public Ingressos(int id, int sessaoId, int salaId, int cadeiraId, double valorPago) {
        this.id = id;
        this.sessaoId = sessaoId;
        this.salaId = salaId;
        this.cadeiraId = cadeiraId;
        this.valorPago = valorPago;
    }

    public int getId() {
        return id;
    }

    public int getSessaoId() {
        return sessaoId;
    }

    public int getSalaId() {
        return salaId;
    }

    public int getCadeiraId() {
        return cadeiraId;
    }

    public double getValorPago() {
        return valorPago;
    }


    
}
