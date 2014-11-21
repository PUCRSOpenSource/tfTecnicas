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
public class SessoesDAOException extends Exception {

    public SessoesDAOException() {
        super();
    }

    public SessoesDAOException(String mensagem) {
        super(mensagem);
    }

    public SessoesDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
