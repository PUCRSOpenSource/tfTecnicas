/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class CinemaFachada {
    
    public Filmes buscarfilme(String nome){
        //Busca um filme pelo seu nome
        Filmes filme =null;
        return filme;
    }
    
    public List<Sessoes> buscarSessoesDeFilme(String nomeDoFilme){
        //Busca as sessões de exibição de um filme
        List<Sessoes> sessoes = new ArrayList<>();
        return sessoes;
    }
    
    public List<Sessoes> buscarSessoesPorData(Date data){
        //Busca as sessões de exibição por data
        List<Sessoes> sessoes = new ArrayList<>();
        return sessoes;
    }
    
    public List<Sessoes> buscarSessoesPorHorario(String inicio){
        //Busca as sessões de exibição por horario na data corrente
        List<Sessoes> sessoes = new ArrayList<>();
        return sessoes;
    }
    
    public double valorIntegralDoIngresso(Sessoes sessao){
        //retorna o valor integral do ingresso
        double valor = sessao.getValorIntegral();
        return valor;
    }
    
    public double valorDoIngressoComDescontos(Sessoes sessao, int quantidade, List<Integer> idades){
        //retorna o valor do ingresso já com os descontor aplicados
        double valor = sessao.getValorIntegral();
        return valor;
    }
    
    public boolean disponibilidadeDeIngresso(Sessoes sessao){
        //informa sobre a disponibilidade de ingressos para a sessao escolhida
        boolean disponivel = false;
        return disponivel;
    }
    
    public boolean conprarIngresso(Sessoes sessao, int quantidade, List<Integer> idades, List<Integer> nroCadeiras){
        //tenta realizar a compra do cliente, retorna falso caso a caompra não seja efetuada, deve lidar com acesso concorrente ao banco de dados
        boolean compraEfetuada = false;
        return compraEfetuada;
    }
    
    //Funcionalidades usadas somente pelo gerente
    public boolean adcionarFilmeParaExibicao(Filmes filme){
        //adiciona um novo filme para exibição
        boolean adicionou = false;
        return adicionou;
    }
    
    public boolean adicionaSessao(Date data, double valorIntegral, int salaId, int horarioId, int filmeId){
        //adiciona uma nova sessao de exibição para um filme
        boolean adicionou = false;
        return adicionou;
    }
    
    public List<RelatorioFilmes> totalIngressosPorFilme(Date data){
        //retorna uma lista com o valor total de ingressos vendidos para cada filme em um determinado dia
        //provavelmente vai ser necessário uma classe MontaRelatorio
        List<RelatorioFilmes> relatorio = new ArrayList<>();
        return relatorio;
    }
    
    public List<RelatorioSalas> totalIngressosPorSala(Date data){
        //retorna uma lista com o valor total de ingressos vendidos para cada sala em um determinado dia
        //provavelmente vai ser necessário uma classe MontaRelatorio
        List<RelatorioSalas> relatorio = new ArrayList<>();
        return relatorio;
    }
}
