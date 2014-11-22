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
    
    public boolean adicionaFilme(Filmes filme) throws FilmesDAOException;  

    public Filmes buscaFilmePorNome(String nome) throws FilmesDAOException;
    
    public Filmes buscaFilmePorId(int id) throws FilmesDAOException;

    public List<Filmes> buscaTodosFilmes() throws FilmesDAOException;
}
