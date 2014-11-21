/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Horarios;
import Negocio.HorariosDAO;
import Negocio.HorariosDAOException;
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
public class HorariosDAODerby implements HorariosDAO {

    @Override
    public void adicionaHorario(Horarios horario) throws HorariosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horarios buscaHorarioPorId(int id) throws HorariosDAOException {
        String sql = "select * from horarios where codigo = ?";
        Horarios horario = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        horario = new Horarios(
                                resultado.getInt("ID"),
                                resultado.getString("INICIO"),
                                resultado.getString("FIM")
                        );
                    }
                    return horario;
                }
            }
        } catch (Exception e) {
            throw new HorariosDAOException("Falha na busca do horario por ID", e);
        }
    }

    @Override
    public Horarios buscaHorarioPorInicio(String inicio) throws HorariosDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Horarios> buscaTodosHorarios() throws HorariosDAOException {
        List<Horarios> horarios = new ArrayList<>();
        String sql = "select * from horarios";
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Horarios horario = new Horarios(
                                resultado.getInt("ID"),
                                resultado.getString("INICIO"),
                                resultado.getString("FIM")
                        );
                        horarios.add(horario);
                    }
                    return horarios;
                }
            }
        } catch (Exception e) {
            throw new HorariosDAOException("Falha na busca de todos os horarios", e);
        }
    }

}
