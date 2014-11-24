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

    private int sessaoId;
    private int cadeiraId;
    private double valorPago;

    public Ingressos(int sessaoId, int cadeiraId, double valorPago) {
        this.sessaoId = sessaoId;
        this.cadeiraId = cadeiraId;
        this.valorPago = valorPago;
    }

    public int getSessaoId() {
        return sessaoId;
    }

    public int getCadeiraId() {
        return cadeiraId;
    }

    public double getValorPago() {
        return valorPago;
    }

    @Override
    public String toString() {
        return "Ingressos{" + "sessaoId=" + sessaoId + ", cadeiraId=" + cadeiraId + ", valorPago=" + valorPago + '}';
    }

}
