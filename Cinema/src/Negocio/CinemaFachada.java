/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Persistencia.CadeirasDAODerby;
import Persistencia.FilmesDAODerby;
import Persistencia.HorariosDAODerby;
import Persistencia.IngressosDAODerby;
import Persistencia.SessoesDAODerby;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author CanTM
 */
public class CinemaFachada {

    private FilmesDAO filmesDAO;
    private SessoesDAO sessoesDAO;
    private HorariosDAO horariosDAO;
    private CadeirasDAO cadeirasDAO;
    private IngressosDAO ingressosDAO;

    public Filmes buscarFilme(String nome) throws FilmesDAOException {
        //Busca um filme pelo seu nome
        filmesDAO = new FilmesDAODerby();
        Filmes filme = null;
        filme = filmesDAO.buscaFilmePorNome(nome);
        return filme;
    }

    public List<Sessoes> buscarSessoesDeFilme(String nomeDoFilme) throws FilmesDAOException, SessoesDAOException {
        //Busca as sessões de exibição de um filme
        filmesDAO = new FilmesDAODerby();
        Filmes filme = null;
        filme = filmesDAO.buscaFilmePorNome(nomeDoFilme);
        sessoesDAO = new SessoesDAODerby();
        List<Sessoes> sessoes = new ArrayList<>();
        sessoes = sessoesDAO.buscaPorFilme(filme.getId());
        return sessoes;
    }

    public String buscaFilmePorId(int filmeId) throws FilmesDAOException {
        filmesDAO = new FilmesDAODerby();
        Filmes filme = null;
        filme = filmesDAO.buscaFilmePorId(filmeId);
        String nomeDoFilme = filme.getNome();
        return nomeDoFilme;
    }

    public String buscarHorarioDeInicioDaSessao(int horarioId) throws HorariosDAOException {
        horariosDAO = new HorariosDAODerby();
        Horarios horario = horariosDAO.buscaHorarioPorId(horarioId);
        String inicio = horario.getInicio();
        return inicio;
    }

    public String buscarHorarioDeFimDaSessao(int horarioId) throws HorariosDAOException {
        horariosDAO = new HorariosDAODerby();
        Horarios horario = horariosDAO.buscaHorarioPorId(horarioId);
        String fim = horario.getFim();
        return fim;
    }

    public List<Sessoes> buscarSessoesPorData(Date data) throws SessoesDAOException {
        //Busca as sessões de exibição por data
        sessoesDAO = new SessoesDAODerby();
        List<Sessoes> sessoes = new ArrayList<>();
        sessoes = sessoesDAO.buscaPorData(data);
        return sessoes;
    }

    public List<Sessoes> buscarSessoesPorHorario(String inicio) throws HorariosDAOException, SessoesDAOException {
        //Busca as sessões de exibição por horario na data corrente
        horariosDAO = new HorariosDAODerby();
        Horarios horario = horariosDAO.buscaHorarioPorInicio(inicio);
        sessoesDAO = new SessoesDAODerby();
        List<Sessoes> sessoes = new ArrayList<>();
        sessoes = sessoesDAO.buscaPorHorario(horario.getId());
        return sessoes;
    }

    public double valorIntegralDoIngresso(Sessoes sessao) {
        //retorna o valor integral do ingresso
        double valor = sessao.getValorIntegral();
        return valor;
    }

    public double valorDoIngressoComDescontos(Sessoes sessao, int quantidade, List<Integer> idades) {
        //retorna o valor do ingresso já com os descontor aplicados
        Descontos d = new Descontos();
        double valor = d.calculaValorComDesconto(sessao, quantidade, idades);
        return valor;
    }

    public int disponibilidadeDeIngresso(Sessoes sessao) {
        //informa sobre a quantidade de ingressos disponíveis para venda para a sessao escolhida    
        int quantidadeDeIngressosDisponiveis = sessao.getVagas();
        return quantidadeDeIngressosDisponiveis;
    }

    public boolean conprarIngresso(Sessoes sessao, List<Integer> nroCadeiras, List<Integer> idades) throws CadeirasDAOException, IngressosDAOException, SessoesDAOException {
        //Ainda não implementado
        //tenta realizar a compra do cliente, 
        //retorna falso caso a caompra não seja efetuada, 
        //deve lidar com acesso concorrente ao banco de dados
        Descontos d = new Descontos();
        boolean disponivel = true;
        cadeirasDAO = new CadeirasDAODerby();
        ingressosDAO = new IngressosDAODerby();
        sessoesDAO = new SessoesDAODerby();
        boolean compraEfetuada = false;
        for (int i : nroCadeiras) {
            if (cadeirasDAO.buscaCadeiraPorId(i).isDisponibilidade() == false) {
                disponivel = false;
                break;
            }
        }
        if (disponivel == true) {
            for (int i = 0; i < nroCadeiras.size(); i++) {
                cadeirasDAO.alteraDisponibilidade(nroCadeiras.get(i), false);
                double valor = 0;
                if (idades.get(i) >= 65) {
                    valor = d.getDescontoIdoso(sessao.getValorIntegral(), nroCadeiras.size());
                } else if (idades.get(i) <= 12) {
                    valor = d.getDescontoCrianca(sessao.getValorIntegral(), nroCadeiras.size());
                } else {
                    valor = d.getDescontoAdulto(sessao.getValorIntegral(), nroCadeiras.size());
                }
                Ingressos ingresso = new Ingressos(sessao.getId(), nroCadeiras.get(i), valor);
                compraEfetuada = ingressosDAO.adicionaIngresso(ingresso);
            }
            sessoesDAO.atualizaVagas(sessao.getId(), sessao.getVagas() - nroCadeiras.size());
        }
        return compraEfetuada;
    }

    //Funcionalidades usadas somente pelo gerente
    public boolean adcionarFilmeParaExibicao(Filmes filme) throws FilmesDAOException {
        //adiciona um novo filme para exibição
        filmesDAO = new FilmesDAODerby();
        boolean adicionou = filmesDAO.adicionaFilme(filme);;
        return adicionou;
    }

    public boolean adicionaSessao(Sessoes sessao) throws SessoesDAOException {
        //adiciona uma nova sessao de exibição para um filme
        sessoesDAO = new SessoesDAODerby();
        boolean adicionou = sessoesDAO.adicionaSessao(sessao);
        return adicionou;
    }

    public ArrayList<Relatorio> totalIngressosPorFilme(Date data, Filmes filme) throws SessoesDAOException, IngressosDAOException {
        //retorna uma lista com o valor total de ingressos vendidos para cada filme em um determinado dia
        //provavelmente vai ser necessário uma classe MontaRelatorio
        MontaRelatorio mr = new MontaRelatorio();
        ArrayList<Relatorio> relatorio = mr.relatorioFilmes(data, filme);
        return relatorio;
    }

    public ArrayList<Relatorio> totalIngressosPorSala(Date data, Salas sala) throws SessoesDAOException, IngressosDAOException {
        //retorna uma lista com o valor total de ingressos vendidos para cada sala em um determinado dia
        //provavelmente vai ser necessário uma classe MontaRelatorio
        MontaRelatorio mr = new MontaRelatorio();
        ArrayList<Relatorio> relatorio = mr.relatorioSalas(data, sala);
        return relatorio;
    }
}
