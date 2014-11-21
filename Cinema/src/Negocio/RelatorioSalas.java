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
public class RelatorioSalas {
    private int nroSala;
    private int quantidadeIngressosVendidos;

    public RelatorioSalas(int nroSala, int quantidadeIngressosVendidos) {
        this.nroSala = nroSala;
        this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public int getQuantidadeIngressosVendidos() {
        return quantidadeIngressosVendidos;
    }

    public void setQuantidadeIngressosVendidos(int quantidadeIngressosVendidos) {
        this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
    }

    @Override
    public String toString() {
        return "RelatorioSalas{" + "nroSala=" + nroSala + ", quantidadeIngressosVendidos=" + quantidadeIngressosVendidos + '}';
    }
    
}
