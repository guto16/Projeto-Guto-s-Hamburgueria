
package br.com.GutosHamburguers.jdbc;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ConectionTest {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: /n" + e);
        }
    }
}
