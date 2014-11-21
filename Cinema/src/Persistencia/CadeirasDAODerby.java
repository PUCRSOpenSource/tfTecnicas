/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Cadeiras;
import Negocio.CadeirasDAO;
import Negocio.CadeirasDAOException;
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
public class CadeirasDAODerby implements CadeirasDAO {

    @Override
    public void adicionaCadeira(Cadeiras cadeira) throws CadeirasDAOException {
        String sql = "insert into cadeiras(ID,IDSALA,DISPONIBILIDADE) values(?,?,?)";
        int resultado = 0;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, cadeira.getId());
                comando.setInt(2, cadeira.getSalaId());
                comando.setBoolean(3, cadeira.isDisponibilidade());
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            throw new CadeirasDAOException("Falha na inserção de cadeira", e);
        }
        if (resultado == 0) {
            throw new CadeirasDAOException("Falha na inserção de cadeira");
        }
    }

    @Override
    public void alteraDisponibilidade(int id, boolean disponibilidade) throws CadeirasDAOException {
        String sql = "update cadeiras set DISPONIBILIDADE=? where ID = ?";
        int resultado = 0;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setBoolean(1, disponibilidade);
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            throw new CadeirasDAOException("Falha na alteração da disponibilidade", e);
        }
        if (resultado == 0) {
            throw new CadeirasDAOException("Falha na alteração da disponibilidade");
        }
    }

    @Override
    public Cadeiras buscaCadeiraPorId(int id) throws CadeirasDAOException {
        String sql = "select * from cadeiras where ID = ?";
        Cadeiras cadeira = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        cadeira = new Cadeiras(
                                resultado.getInt("ID"),
                                resultado.getInt("IDSALA"),
                                resultado.getBoolean("DISPONIBILIDADE")
                        );
                    }
                    return cadeira;
                }
            }
        } catch (Exception e) {
            throw new CadeirasDAOException("Falha na busca da cadeira por ID", e);
        }
    }

    @Override
    public List<Cadeiras> buscaCadeirasPorSala(int salaId) throws CadeirasDAOException {
        String sql = "select * from cadeiras where IDSALA = ?";
        List<Cadeiras> cadeiras = new ArrayList<>();
        Cadeiras cadeira = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, salaId);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        cadeira = new Cadeiras(
                                resultado.getInt("ID"),
                                resultado.getInt("IDSALA"),
                                resultado.getBoolean("DISPONIBILIDADE")
                        );
                        cadeiras.add(cadeira);
                    }
                    return cadeiras;
                }
            }
        } catch (Exception e) {
            throw new CadeirasDAOException("Falha na busca da cadeira por sala", e);
        }
    }

    @Override
    public List<Cadeiras> buscaTodasCadeiras() throws CadeirasDAOException {
        List<Cadeiras> cadeiras = new ArrayList<>();
        String sql = "select * from cadeiras";
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Cadeiras cadeira = new Cadeiras(
                                resultado.getInt("ID"),
                                resultado.getInt("IDSALA"),
                                resultado.getBoolean("DISPONIBILIDADE")
                        );
                        cadeiras.add(cadeira);
                    }
                    return cadeiras;
                }
            }
        } catch (Exception e) {
            throw new CadeirasDAOException("Falha na busca de todas as Cadeiras", e);
        }
    }

}
