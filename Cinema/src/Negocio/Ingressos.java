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
    private Sessoes sessao;
    private Cadeiras cadeira;
    private double valorPago;

    public int getId() {
        return id;
    }

    public Sessoes getSessao() {
        return sessao;
    }

    public Cadeiras getCadeira() {
        return cadeira;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    
}
