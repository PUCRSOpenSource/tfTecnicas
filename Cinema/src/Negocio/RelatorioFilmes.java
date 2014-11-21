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
public class RelatorioFilmes {
    private String nomeDoFilme;
    private int quantidadeIngressosVendidos;

    public RelatorioFilmes(String nomeDoFilme, int quantidadeIngressosVendidos) {
        this.nomeDoFilme = nomeDoFilme;
        this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    public int getQuantidadeIngressosVendidos() {
        return quantidadeIngressosVendidos;
    }

    public void setQuantidadeIngressosVendidos(int quantidadeIngressosVendidos) {
        this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
    }

    @Override
    public String toString() {
        return "RelatorioFilmes{" + "nomeDoFilme=" + nomeDoFilme + ", quantidadeIngressosVendidos=" + quantidadeIngressosVendidos + '}';
    }
    
}
