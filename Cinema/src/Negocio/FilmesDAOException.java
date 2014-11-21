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
public class FilmesDAOException extends Exception {
    
    public FilmesDAOException() {
        super();
    }

    public FilmesDAOException(String mensagem) {
        super(mensagem);
    }

    public FilmesDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
