/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Cadeiras;
import Negocio.CadeirasDAO;
import Negocio.CadeirasDAOException;
import Negocio.Salas;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class CadeirasDAODerby implements CadeirasDAO {

    @Override
    public void adicionaCadeira(Cadeiras cadeira) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraDisponibilidade(Cadeiras cadeira, boolean disponibilidade) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cadeiras buscaCadeira(int id) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cadeiras> buscaCadeirasPorSala(Salas sala) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cadeiras> buscaTodasCadeiras() throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
