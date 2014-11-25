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
public class Relatorio {
    private Object object;
    private int quantidadeIngressosVendidos;

    public Relatorio(Object object, int quantidadeIngressosVendidos) {
        this.object = object;
        this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getQuantidadeIngressosVendidos() {
        return quantidadeIngressosVendidos;
    }

    public void setQuantidadeIngressosVendidos(int quantidadeIngressosVendidos) {
        this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
    }


    public String toStringSala() {
        return "Relatorio por Sala{" + "Sala=" + object + ", Ingressos Vendidos=" + quantidadeIngressosVendidos + '}';
    }
    
        public String toStringFilme() {
        return "Relatorio por Filme{" + "Filme=" + object + ", Ingressos Vendidos=" + quantidadeIngressosVendidos + '}';
    }


    
}
