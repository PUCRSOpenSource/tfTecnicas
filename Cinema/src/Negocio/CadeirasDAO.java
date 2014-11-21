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
public interface CadeirasDAO {

    public void adicionaCadeira(Cadeiras cadeira);

    public void alteraDisponibilidade(Cadeiras cadeira, boolean disponibilidade);

    public Cadeiras buscaCadeira(Cadeiras cadeira);

    public List<Cadeiras> buscaCadeirasPorSala(Salas sala);

    public List<Cadeiras> buscaTodasCadeiras();
}
