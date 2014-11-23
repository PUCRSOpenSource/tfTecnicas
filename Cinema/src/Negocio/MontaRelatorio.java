/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Persistencia.IngressosDAODerby;
import Persistencia.SessoesDAODerby;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author CanTM
 */
public class MontaRelatorio {

    ArrayList<Relatorio> relatorio;
    SessoesDAO sessoesDAO;
    IngressosDAO ingressosDAO;

    public ArrayList<Relatorio> relatorioFilmes(Date data, Filmes filme) throws SessoesDAOException, IngressosDAOException {
        relatorio = new ArrayList<>();
        sessoesDAO = new SessoesDAODerby();
        ingressosDAO = new IngressosDAODerby();
        List<Sessoes> sessoes = sessoesDAO.buscaPorData(data);
        int nroIngressos = 0;
        for (Sessoes s : sessoes) {
            if (s.getFilmeId() == filme.getId()) {
                List<Ingressos> ingressos = ingressosDAO.buscaPorSessao(s.getId());
                nroIngressos = nroIngressos + ingressos.size();
                boolean atualizou = false;
                if (!relatorio.isEmpty()) {
                    for (Relatorio r : relatorio) {
                        if (r.getObject().equals(filme.getNome())) {
                            r.setQuantidadeIngressosVendidos(r.getQuantidadeIngressosVendidos() + nroIngressos);
                            atualizou = true;
                        }
                    }
                } else {
                    if (atualizou == false) {
                        Relatorio rel = new Relatorio(filme.getNome(), nroIngressos);
                        relatorio.add(rel);
                    }
                }
            }
        }
        return relatorio;
    }

    public ArrayList<Relatorio> relatorioSalas(Date data, Salas sala) throws SessoesDAOException, IngressosDAOException {
        relatorio = new ArrayList<>();
        sessoesDAO = new SessoesDAODerby();
        ingressosDAO = new IngressosDAODerby();
        List<Sessoes> sessoes = sessoesDAO.buscaPorData(data);
        int nroIngressos = 0;
        for (Sessoes s : sessoes) {
            if (s.getSalaId() == sala.getId()) {
                List<Ingressos> ingressos = ingressosDAO.buscaPorSessao(s.getId());
                nroIngressos = nroIngressos + ingressos.size();
                boolean atualizou = false;
                if (!relatorio.isEmpty()) {
                    for (Relatorio r : relatorio) {
                        if (r.getObject().equals(sala.getId())) {
                            r.setQuantidadeIngressosVendidos(r.getQuantidadeIngressosVendidos() + nroIngressos);
                            atualizou = true;
                        }
                    }
                } else {
                    if (atualizou == false) {
                        Relatorio rel = new Relatorio(sala.getId(), nroIngressos);
                        relatorio.add(rel);
                    }
                }
            }
        }
        return relatorio;
    }
}
