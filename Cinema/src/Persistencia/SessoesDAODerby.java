/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

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
public class SessoesDAODerby implements SessoesDAO {

    @Override
    public void adicionaSessao(Sessoes sessao) throws SessoesDAOException {
        String sql = "insert into sessoes(ID,DIA,VAGAS,VALORINTEGRAL,IDSALA,IDHORARIO,IDFILME) values(?,?,?,?,?,?,?)";
        int resultado = 0;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, sessao.getId());
                comando.setDate(2, (java.sql.Date) sessao.getDate());
                comando.setInt(3, sessao.getVagas());
                comando.setDouble(4, sessao.getValorIntegral());
                comando.setInt(5, sessao.getSalaId());
                comando.setInt(6, sessao.getHorarioId());
                comando.setInt(7, sessao.getFilmeId());
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na inserção de sessao", e);
        }
        if (resultado == 0) {
            throw new SessoesDAOException("Falha na inserção de sessao");
        }
    }

    @Override
    public void atualizaVagas(int id, int vagas) throws SessoesDAOException {
        String sql = "update sessoes set VAGAS=? where ID = ?";
        int resultado = 0;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, vagas);
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na alteração das vagas", e);
        }
        if (resultado == 0) {
            throw new SessoesDAOException("Falha na alteração das vagas");
        }
    }

    @Override
    public Sessoes buscaPorId(int id) throws SessoesDAOException {
        String sql = "select * from sessoes where ID = ?";
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
        String sql = "select * from sessoes where DIA = ?";
        Sessoes sessao = null;
        List<Sessoes> sessoes = new ArrayList<>();
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setDate(1, (java.sql.Date) data);
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
                        sessoes.add(sessao);
                    }
                    return sessoes;
                }
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na busca da sessao por data", e);
        }
    }

    @Override
    public List<Sessoes> buscaPorHorario(int horarioId) throws SessoesDAOException {
        String sql = "select * from sessoes where IDHORARIO = ?";
        Sessoes sessao = null;
        List<Sessoes> sessoes = new ArrayList<>();
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, horarioId);
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
                        sessoes.add(sessao);
                    }
                    return sessoes;
                }
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na busca da sessao por horario", e);
        }
    }

    @Override
    public List<Sessoes> buscaPorFilme(int filmeId) throws SessoesDAOException {
        String sql = "select * from sessoes where IDFILME = ?";
        Sessoes sessao = null;
        List<Sessoes> sessoes = new ArrayList<>();
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, filmeId);
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
                        sessoes.add(sessao);
                    }
                    return sessoes;
                }
            }
        } catch (Exception e) {
            throw new SessoesDAOException("Falha na busca da sessao por filme", e);
        }
    }

    @Override
    public List<Sessoes> buscaTodasSessoes() throws SessoesDAOException {
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
