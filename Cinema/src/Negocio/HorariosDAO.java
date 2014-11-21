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
    
    public void adicionaHorario(Horarios horario);
    
    public Horarios buscaHorarioPorId(int id);
    
    public Horarios buscaHorarioPorInicio(String inicio);
    
    public List<Horarios> buscaTodosHorarios();
}
