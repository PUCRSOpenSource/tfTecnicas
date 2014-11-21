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
public interface IngressosDAO {

    public void adicionaIngresso(Ingressos ingresso) throws IngressosDAOException;

    public Ingressos buscaPorId(int id) throws IngressosDAOException;

    public List<Ingressos> buscaPorSessao(Sessoes sessao) throws IngressosDAOException;

    public Ingressos buscaPorCadeira(Cadeiras cadeira) throws IngressosDAOException;

    public List<Ingressos> buscaTodosIngressos() throws IngressosDAOException;
}
