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
public class IngressosDAOException extends Exception {

    public IngressosDAOException() {
        super();
    }

    public IngressosDAOException(String mensagem) {
        super(mensagem);
    }

    public IngressosDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
