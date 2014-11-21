/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Filmes;
import Negocio.Horarios;
import Negocio.Salas;
import Negocio.Sessoes;
import Negocio.SessoesDAO;
import Negocio.SessoesDAOException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class SessoesDAODearby implements SessoesDAO {

    @Override
    public void adicionaSessao(Sessoes sessao) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizaVagas(int vagas) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sessoes buscaPorId(int id) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorData(Date data) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorSala(Salas sala) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorHorario(Horarios horario) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorFilma(Filmes filme) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
