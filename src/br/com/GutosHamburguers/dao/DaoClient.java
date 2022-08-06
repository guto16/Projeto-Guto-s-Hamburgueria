
package br.com.GutosHamburguers.dao;

import br.com.GutosHamburguers.jdbc.ConnectionFactory;
import br.com.GutosHamburguers.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DaoClient {
    private Connection con;
    
    public DaoClient(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void clientSave(Client cli){
        try {
            String sql = "insert into clientData(nameClient, address, phone)" +
                " values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cli.getNameClient());
            stmt.setString(2, cli.getAddress());
            stmt.setString(3, cli.getPhone());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!: \n" + e);
        }
    }
    
}
