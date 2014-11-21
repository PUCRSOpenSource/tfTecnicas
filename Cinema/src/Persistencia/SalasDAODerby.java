/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Salas;
import Negocio.SalasDAO;
import Negocio.SalasDAOException;
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
public class SalasDAODerby implements SalasDAO {

    @Override
    public void adicionaSala(Salas sala) throws SalasDAOException {
        String sql = "insert into salas(ID,CAPACIDADE) values(?,?)";
        int resultado = 0;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, sala.getId());
                comando.setInt(2, sala.getCapacidade());
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            throw new SalasDAOException("Falha na inserção de sala", e);
        }
        if (resultado == 0) {
            throw new SalasDAOException("Falha na inserção de sala");
        }
    }

    @Override
    public Salas buscaPorId(int id) throws SalasDAOException {
        String sql = "select * from salas where ID = ?";
        Salas sala = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        sala = new Salas(
                                resultado.getInt("ID"),
                                resultado.getInt("CAPACIDADE")
                        );
                    }
                    return sala;
                }
            }
        } catch (Exception e) {
            throw new SalasDAOException("Falha na busca da sala por ID", e);
        }
    }

    @Override
    public List<Salas> buscaTodasSalas() throws SalasDAOException {
        List<Salas> salas = new ArrayList<>();
        String sql = "select * from salas";
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Salas sala = new Salas(
                                resultado.getInt("ID"),
                                resultado.getInt("CAPACIDADE")
                        );
                        salas.add(sala);
                    }
                    return salas;
                }
            }
        } catch (Exception e) {
            throw new SalasDAOException("Falha na busca de todos as salas", e);
        }
    }

}
