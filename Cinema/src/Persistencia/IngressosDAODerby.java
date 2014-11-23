/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Ingressos;
import Negocio.IngressosDAO;
import Negocio.IngressosDAOException;
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
public class IngressosDAODerby implements IngressosDAO {

    @Override
    public void adicionaIngresso(Ingressos ingresso) throws IngressosDAOException {
        String sql = "insert into ingressos(ID,IDSESSAO,IDCADEIRA,VALORPAGO) values(?,?,?,?,?)";
        int resultado = 0;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, ingresso.getId());
                comando.setInt(2, ingresso.getSessaoId());
                comando.setInt(4, ingresso.getCadeiraId());
                comando.setDouble(5, ingresso.getValorPago());
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            throw new IngressosDAOException("Falha na inserção de ingresso", e);
        }
        if (resultado == 0) {
            throw new IngressosDAOException("Falha na inserção de ingresso");
        }
    }

    @Override
    public Ingressos buscaPorId(int id) throws IngressosDAOException {
        String sql = "select * from ingressos where ID = ?";
        Ingressos ingresso = null;
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        ingresso = new Ingressos(
                                resultado.getInt("ID"),
                                resultado.getInt("IDSESSAO"),
                                resultado.getInt("IDCADEIRA"),
                                resultado.getDouble("VALORPAGO")
                        );
                    }
                    return ingresso;
                }
            }
        } catch (Exception e) {
            throw new IngressosDAOException("Falha na busca do ingresso por ID", e);
        }
    }

    @Override
    public List<Ingressos> buscaPorSessao(int sessaoId) throws IngressosDAOException {
        String sql = "select * from ingressos where IDSESSAO = ?";
        Ingressos ingresso = null;
        List<Ingressos> ingressos = new ArrayList<>();
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, sessaoId);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        ingresso = new Ingressos(
                                resultado.getInt("ID"),
                                resultado.getInt("IDSESSAO"),
                                resultado.getInt("IDCADEIRA"),
                                resultado.getDouble("VALORPAGO")
                        );
                        ingressos.add(ingresso);
                    }
                    return ingressos;
                }
            }
        } catch (Exception e) {
            throw new IngressosDAOException("Falha na busca do ingressos por sessao", e);
        }
    }

    @Override
    public List<Ingressos> buscaTodosIngressos() throws IngressosDAOException {
        List<Ingressos> ingressos = new ArrayList<>();
        String sql = "select * from ingressos";
        try (Connection conexao = InicializadorBancoDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Ingressos ingresso = new Ingressos(
                                resultado.getInt("ID"),
                                resultado.getInt("IDSESSAO"),
                                resultado.getInt("IDCADEIRA"),
                                resultado.getDouble("VALORPAGO")
                        );
                        ingressos.add(ingresso);
                    }
                    return ingressos;
                }
            }
        } catch (Exception e) {
            throw new IngressosDAOException("Falha na busca de todos os ingressos", e);
        }
    }

}
