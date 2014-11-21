/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author CanTM
 */
public class Filmes {
    private int id;
    private String nome;
    private String cartaz;
    private int anolancamento;
    private String sinopse;
    private String diretor;
    private String Atores;

    public int getId() {
        return id;
    }

    public Filmes(int id, String nome, String cartaz, int anolancamento, String sinopse, String diretor, String Atores) {
        this.id = id;
        this.nome = nome;
        this.cartaz = cartaz;
        this.anolancamento = anolancamento;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.Atores = Atores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartaz() {
        return cartaz;
    }

    public void setCartaz(String cartaz) {
        this.cartaz = cartaz;
    }

    public int getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(int anolancamento) {
        this.anolancamento = anolancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtores() {
        return Atores;
    }

    public void setAtores(String Atores) {
        this.Atores = Atores;
    }
    
}
