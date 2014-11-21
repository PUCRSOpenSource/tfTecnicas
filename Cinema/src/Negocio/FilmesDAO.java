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
public interface FilmesDAO {
    
    public void adicionaFilme(Filmes filme);  

    public Filmes buscaFilmePorNome(String nome);
    
    public Filmes buscaFilmePorId(int id);

    public List<Filmes> buscaTodosFilmes();
}
