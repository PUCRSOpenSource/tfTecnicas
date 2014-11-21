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

    public void setId(int id) {
        this.id = id;
    }

    public int getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(int sessaoId) {
        this.sessaoId = sessaoId;
    }

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public int getCadeiraId() {
        return cadeiraId;
    }

    public void setCadeiraId(int cadeiraId) {
        this.cadeiraId = cadeiraId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Ingressos{" + "sessaoId=" + sessaoId + ", salaId=" + salaId + ", cadeiraId=" + cadeiraId + ", valorPago=" + valorPago + '}';
    }

}
