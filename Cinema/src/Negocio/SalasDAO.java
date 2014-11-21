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
public interface SalasDAO {
    public void adicionaSala(Salas sala);
    
    public Salas buscaPorId(int id);
    
    public List<Salas> buscaTodasSalas();
}
