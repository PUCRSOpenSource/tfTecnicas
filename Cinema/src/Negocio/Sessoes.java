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

    public Date getDate() {
        return date;
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

    public int getSalaId() {
        return salaId;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public int getFilmeId() {
        return filmeId;
    }

    @Override
    public String toString() {
        return "Sessoes{" + "date=" + date + ", vagas=" + vagas + ", valorIntegral=" + valorIntegral + ", salaId=" + salaId + ", horarioId=" + horarioId + ", filmeId=" + filmeId + '}';
    }

}
