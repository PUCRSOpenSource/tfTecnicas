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
public class HorariosDAOException extends Exception {

    public HorariosDAOException() {
        super();
    }

    public HorariosDAOException(String mensagem) {
        super(mensagem);
    }

    public HorariosDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
