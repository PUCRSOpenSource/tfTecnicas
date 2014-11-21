/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Filmes;
import Negocio.FilmesDAO;
import Negocio.FilmesDAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
        String sql = "select * from filmes where codigo = ?";
        Filmes filme = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        filme = new Filmes(
                                resultado.getInt("ID"),
                                resultado.getString("NOME"),
                                resultado.getString("CARTAZ"),
                                resultado.getInt("ANOLANCAMENTO"),
                                resultado.getString("SINOPSE"),
                                resultado.getString("DIRETOR"),
                                resultado.getString("ATORES")
                        );
                    }
                    return filme;
                }
            }
        } catch (Exception e) {
            throw new FilmesDAOException("Falha na busca do filme por ID", e);
        }
    }

    @Override
    public List<Filmes> buscaTodosFilmes() throws FilmesDAOException {
        List<Filmes> filmes = new ArrayList<>();
        String sql = "select * from filmes";
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Filmes filme = new Filmes(
                                resultado.getInt("ID"),
                                resultado.getString("NOME"),
                                resultado.getString("CARTAZ"),
                                resultado.getInt("ANOLANCAMENTO"),
                                resultado.getString("SINOPSE"),
                                resultado.getString("DIRETOR"),
                                resultado.getString("ATORES")
                        );
                        filmes.add(filme);
                    }
                    return filmes;
                }
            }
        } catch (Exception e) {
            throw new FilmesDAOException("Falha na busca de todos os filmes", e);
        }
    }

}
