
package br.com.GutosHamburguers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regist",
                    "cliente","123guto");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
