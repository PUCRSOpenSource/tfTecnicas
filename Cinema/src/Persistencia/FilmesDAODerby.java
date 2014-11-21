/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Filmes;
import Negocio.FilmesDAO;
import Negocio.FilmesDAOException;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class FilmesDAODerby implements FilmesDAO {

    @Override
    public void adicionaFilme(Filmes filme) throws FilmesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filmes buscaFilmePorNome(String nome) throws FilmesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filmes buscaFilmePorId(int id) throws FilmesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Filmes> buscaTodosFilmes() throws FilmesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
