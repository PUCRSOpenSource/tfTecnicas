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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
