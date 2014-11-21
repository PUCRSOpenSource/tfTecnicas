/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Cadeiras;
import Negocio.Ingressos;
import Negocio.IngressosDAO;
import Negocio.IngressosDAOException;
import Negocio.Sessoes;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class IngressosDAODerby implements IngressosDAO{

    @Override
    public void adicionaIngresso(Ingressos ingresso) throws IngressosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ingressos buscaPorId(int id) throws IngressosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ingressos> buscaPorSessao(Sessoes sessao) throws IngressosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ingressos buscaPorCadeira(Cadeiras cadeira) throws IngressosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ingressos> buscaTodosIngressos() throws IngressosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
