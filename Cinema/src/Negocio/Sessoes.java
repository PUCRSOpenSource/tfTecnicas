/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Date;

/**
 *
 * @author CanTM
 */
public class Sessoes {
    private int id;
    private Date date;
    private int vagas;
    private double valorIntegral;
    private Salas sala;
    private Horarios horario;
    private Filmes filme;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public double getValorIntegral() {
        return valorIntegral;
    }

    public void setValorIntegral(double valorIntegral) {
        this.valorIntegral = valorIntegral;
    }

    public Filmes getFilme() {
        return filme;
    }

    public Horarios getHorario() {
        return horario;
    }

    public Salas getSala() {
        return sala;
    }
}
