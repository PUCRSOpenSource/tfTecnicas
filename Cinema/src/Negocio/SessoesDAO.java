/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author CanTM
 */
public interface SessoesDAO {

    public boolean adicionaSessao(Sessoes sessao) throws SessoesDAOException;

    public void atualizaVagas(int id, int vagas) throws SessoesDAOException;

    public Sessoes buscaPorId(int id) throws SessoesDAOException;

    public List<Sessoes> buscaPorData(Date data) throws SessoesDAOException;

    public List<Sessoes> buscaPorHorario(int horarioId) throws SessoesDAOException;

    public List<Sessoes> buscaPorFilme(int filmeId) throws SessoesDAOException;
    
    public List<Sessoes> buscaTodasSessoes() throws SessoesDAOException;
}
