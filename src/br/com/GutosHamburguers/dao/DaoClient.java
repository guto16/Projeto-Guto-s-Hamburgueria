
package br.com.GutosHamburguers.dao;

import br.com.GutosHamburguers.jdbc.ConnectionFactory;
import br.com.GutosHamburguers.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

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
            
            stmt.setInt(1, cli.getId());
            stmt.setString(2, cli.getNameClient());
            stmt.setString(3, cli.getAddress());
            stmt.setString(4, cli.getPhone());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!: \n" + e);
        }
    }
    public List<Client> clientList(){
        try {
            List<Client> clientes = new ArrayList<>();
            
            String sql = "SELECT * FROM clientData";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Client cli = new Client();
                cli.setId(rs.getInt("id"));
                cli.setNameClient(rs.getString("nameClient"));
                cli.setAddress(rs.getString("address"));
                cli.setPhone(rs.getString("phone"));
                
                clientes.add(cli);
            }
            
            return clientes;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO NA CONSULTA!: \n" + e);
            return null;
        }
    }
   
}
