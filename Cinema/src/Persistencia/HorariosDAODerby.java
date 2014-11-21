/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Horarios;
import Negocio.HorariosDAO;
import Negocio.HorariosDAOException;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class HorariosDAODerby implements HorariosDAO{

    @Override
    public void adicionaHorario(Horarios horario) throws HorariosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horarios buscaHorarioPorId(int id) throws HorariosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horarios buscaHorarioPorInicio(String inicio) throws HorariosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Horarios> buscaTodosHorarios() throws HorariosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
