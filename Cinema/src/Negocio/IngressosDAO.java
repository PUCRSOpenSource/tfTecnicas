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

    public void adicionaIngresso(Ingressos ingresso);

    public Ingressos buscaPorId(int id);

    public List<Ingressos> buscaPorSessao(Sessoes sessao);

    public Ingressos buscaPorCadeira(Cadeiras cadeira);

    public List<Ingressos> buscaTodosIngressos();
}
