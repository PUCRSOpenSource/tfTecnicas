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
public class CadeirasDAOException extends Exception {
    
    public CadeirasDAOException() {
        super();
    }

    public CadeirasDAOException(String mensagem) {
        super(mensagem);
    }

    public CadeirasDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
