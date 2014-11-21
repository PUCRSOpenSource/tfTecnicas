/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Salas;
import Negocio.SalasDAO;
import Negocio.SalasDAOException;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class SalasDAODerby implements SalasDAO {

    @Override
    public void adicionaSala(Salas sala) throws SalasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salas buscaPorId(int id) throws SalasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salas> buscaTodasSalas() throws SalasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
