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
    public boolean adicionaFilme(Filmes filme) throws FilmesDAOException {
        String sql = "insert into filmes(ID,NOME,CARTAZ,ANOLANCAMENTO,SINOPSE,DIRETOR,ATORES) values(?,?,?,?,?,?,?)";
        int resultado = 0;
        boolean adicionou = false;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, filme.getId());
                comando.setString(2, filme.getNome());
                comando.setString(3, filme.getCartaz());
                comando.setInt(4, filme.getAnolancamento());
                comando.setString(5, filme.getSinopse());
                comando.setString(6, filme.getDiretor());
                comando.setString(7, filme.getAtores());
                resultado = comando.executeUpdate();
            }
            adicionou = true;
        } catch (Exception e) {
            throw new FilmesDAOException("Falha na inserção de filme", e);
        }
        if (resultado == 0) {
            throw new FilmesDAOException("Falha na inserção de filme");
        }
        return adicionou;
    }

    @Override
    public Filmes buscaFilmePorNome(String nome) throws FilmesDAOException {
        String sql = "select * from filmes where NOME = ?";
        Filmes filme = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, nome);
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
            throw new FilmesDAOException("Falha na busca do filme por nome", e);
        }
    }
    

    @Override
    public Filmes buscaFilmePorId(int id) throws FilmesDAOException {
        String sql = "select * from filmes where ID = ?";
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
