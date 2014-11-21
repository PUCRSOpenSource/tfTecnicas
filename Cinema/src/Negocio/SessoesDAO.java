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
    public void adicionaSessao(Sessoes sessao);
    
    public void atualizaVagas(int vagas);
    
    public Sessoes buscaPorId(int id);
    
    public List<Sessoes> buscaPorData(Date data);
    
    public List<Sessoes> buscaPorSala(Salas sala);
    
    public List<Sessoes> buscaPorHorario(Horarios horario);
    
    public List<Sessoes> buscaPorFilma(Filmes filme);
}
