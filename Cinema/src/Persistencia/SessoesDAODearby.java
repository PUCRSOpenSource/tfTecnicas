/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Filmes;
import Negocio.Horarios;
import Negocio.Salas;
import Negocio.Sessoes;
import Negocio.SessoesDAO;
import Negocio.SessoesDAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CanTM
 */
public class SessoesDAODearby implements SessoesDAO {

    @Override
    public void adicionaSessao(Sessoes sessao) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizaVagas(int vagas) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sessoes buscaPorId(int id) throws SessoesDAOException {
        String sql = "select * from sessoes where codigo = ?";
        Sessoes sessao = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        sessao = new Sessoes(
                                resultado.getInt("ID"),
                                resultado.getDate("DIA"),
                                resultado.getInt("VAGAS"),
                                resultado.getDouble("VALORINTEGRAL"),
                                resultado.getInt("IDSALA"),
                                resultado.getInt("IDHORARIO"),
                                resultado.getInt("IDFILME")
                        );
                    }
                    return sessao;
                }
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na busca da sessao por ID", e);
        }
    }

    @Override
    public List<Sessoes> buscaPorData(Date data) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorSala(Salas sala) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorHorario(Horarios horario) throws SessoesDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessoes> buscaPorFilma(Filmes filme) throws SessoesDAOException {
        List<Sessoes> sessoes = new ArrayList<>();
        String sql = "select * from sessoes";
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Sessoes sessao = new Sessoes(
                                resultado.getInt("ID"),
                                resultado.getDate("DIA"),
                                resultado.getInt("VAGAS"),
                                resultado.getDouble("VALORINTEGRAL"),
                                resultado.getInt("IDSALA"),
                                resultado.getInt("IDHORARIO"),
                                resultado.getInt("IDFILME")
                        );
                        sessoes.add(sessao);
                    }
                    return sessoes;
                }
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na busca de todos as sessoes", e);
        }
    }

}
