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

    public Filmes(int id, String nome, String cartaz, int anolancamento, String sinopse, String diretor, String Atores) {
        this.id = id;
        this.nome = nome;
        this.cartaz = cartaz;
        this.anolancamento = anolancamento;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.Atores = Atores;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCartaz() {
        return cartaz;
    }

    public int getAnolancamento() {
        return anolancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getAtores() {
        return Atores;
    }

    @Override
    public String toString() {
        return "Filmes{" + "nome=" + nome + ", cartaz=" + cartaz + ", anolancamento=" + anolancamento + ", sinopse=" + sinopse + ", diretor=" + diretor + ", Atores=" + Atores + '}';
    }

}
