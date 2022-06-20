
package br.com.GutosHamburguers.jdbc;

import javax.swing.JOptionPane;

public class ConectionTest {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Aff deu erro: \n " + e);
        }
    }
}
