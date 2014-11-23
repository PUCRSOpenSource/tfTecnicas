/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.List;

/**
 *
 * @author CanTM
 */
public class Descontos {

    public double calculaValorComDesconto(Sessoes sessao, int quantidade, List<Integer> idades) {
        //calcula e retorna o valor do(s) ingressos(s) solicitados
        double valorComDesconto = 0;
        double valorIntegralUnitario = sessao.getValorIntegral();
        if (quantidade < 5) {
            for (int i : idades) {
                if (i <= 12) {
                    valorComDesconto = valorComDesconto + (valorIntegralUnitario - (valorIntegralUnitario * 0.5));
                } else if (i >= 65) {
                    valorComDesconto = valorComDesconto + (valorIntegralUnitario - (valorIntegralUnitario * 0.4));
                } else {
                    valorComDesconto = valorComDesconto + valorIntegralUnitario;
                }
            }
        } else {
            for (int i : idades) {
                if (i <= 12) {
                    double valor = valorIntegralUnitario - (valorIntegralUnitario * 0.5);
                    valorComDesconto = valorComDesconto + (valor - (valor * 0.05));
                } else if (i >= 65) {
                    double valor = valorIntegralUnitario - (valorIntegralUnitario * 0.4);
                    valorComDesconto = valorComDesconto + (valor - (valor * 0.05));
                } else {
                    valorComDesconto = valorComDesconto + (valorIntegralUnitario - (valorIntegralUnitario * 0.05));
                }
            }
        }
        return valorComDesconto;
    }

    public double getDescontoIdoso(double valorIntegralUnitario, int quantidade) {
        double valorComDesconto = valorIntegralUnitario - (valorIntegralUnitario * 0.4);
        return valorComDesconto * getDescontoQuantidade(quantidade);
    }

    public double getDescontoCrianca(double valorIntegralUnitario, int quantidade) {
        double valorComDesconto = valorIntegralUnitario - (valorIntegralUnitario * 0.5);
        return valorComDesconto * getDescontoQuantidade(quantidade);
    }
    
    public double getDescontoAdulto(double valorIntegralUnitario, int quantidade){
        return valorIntegralUnitario * getDescontoQuantidade(quantidade);
    }

    public double getDescontoQuantidade(int quantidade) {
        double x = 0;
        if (quantidade >= 5) {
            x = 0.95;
        } else {
            x = 1;
        }
        return x;
    }
}
