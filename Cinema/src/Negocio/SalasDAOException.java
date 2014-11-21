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
public class SalasDAOException extends Exception {

    public SalasDAOException() {
        super();
    }

    public SalasDAOException(String mensagem) {
        super(mensagem);
    }

    public SalasDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
