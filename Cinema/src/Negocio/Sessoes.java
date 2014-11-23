/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.sql.Date;



/**
 *
 * @author CanTM
 */
public class Sessoes {

    private int id;
    private Date date;
    private int vagas;
    private double valorIntegral;
    private int salaId;
    private int horarioId;
    private int filmeId;

    public Sessoes(int id, Date date, int vagas, double valorIntegral, int salaId, int horarioId, int filmeId) {
        this.id = id;
        this.date = date;
        this.vagas = vagas;
        this.valorIntegral = valorIntegral;
        this.salaId = salaId;
        this.horarioId = horarioId;
        this.filmeId = filmeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public int getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    @Override
    public String toString() {
        return "Sessoes{" + "date=" + date + ", vagas=" + vagas + ", valorIntegral=" + valorIntegral + ", salaId=" + salaId + ", horarioId=" + horarioId + ", filmeId=" + filmeId + '}';
    }

}
