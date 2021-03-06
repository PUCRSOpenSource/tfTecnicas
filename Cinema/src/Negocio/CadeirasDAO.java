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
public interface CadeirasDAO {

    public void adicionaCadeira(Cadeiras cadeira) throws CadeirasDAOException;

    public void alteraDisponibilidade(int id, boolean disponibilidade) throws CadeirasDAOException;

    public Cadeiras buscaCadeiraPorId(int id) throws CadeirasDAOException;

    public List<Cadeiras> buscaCadeirasPorSessao(int sessaoId) throws CadeirasDAOException;

    public List<Cadeiras> buscaTodasCadeiras() throws CadeirasDAOException;
}
