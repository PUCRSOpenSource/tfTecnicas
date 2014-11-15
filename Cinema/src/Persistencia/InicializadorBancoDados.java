/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientConnectionPoolDataSource;

/**
 *
 * @author CanTM
 */
public class InicializadorBancoDados {
    public static String DB_NAME = "TrabalhoFinal";
        public static String USER_NAME = "usuario";
        public static String PASSWORD = "senha";
        private static DataSource dataSource;

        private static DataSource criarDataSource() throws Exception {
                if (dataSource == null) {
                        ClientConnectionPoolDataSource ds = new ClientConnectionPoolDataSource();
                        ds.setDatabaseName(DB_NAME);
                        ds.setUser(USER_NAME);
                        ds.setPassword(PASSWORD);
                        dataSource = (DataSource) ds;
                }
                return dataSource;
        }

        public static Connection conectarBd() throws Exception {
                return criarDataSource().getConnection();
        }
}
