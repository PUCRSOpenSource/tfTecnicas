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
public interface HorariosDAO {
    
    public void adicionaHorario(Horarios horario) throws HorariosDAOException;
    
    public Horarios buscaHorarioPorId(int id) throws HorariosDAOException;
    
    public List<Horarios> buscaHorarioPorInicio(String inicio) throws HorariosDAOException;
    
    public List<Horarios> buscaTodosHorarios() throws HorariosDAOException;
}
