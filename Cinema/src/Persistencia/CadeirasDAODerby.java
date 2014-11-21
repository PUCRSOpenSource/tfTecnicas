/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Cadeiras;
import Negocio.CadeirasDAO;
import Negocio.CadeirasDAOException;
import Negocio.Salas;
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
    private Object InicializadorBancoDadosDataSource;

    @Override
    public void adicionaCadeira(Cadeiras cadeira) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraDisponibilidade(Cadeiras cadeira, boolean disponibilidade) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cadeiras buscaCadeiraPorId(int id) throws CadeirasDAOException {
        String sql = "select * from cadeiras where codigo = ?";
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
    public List<Cadeiras> buscaCadeirasPorSala(Salas sala) throws CadeirasDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
