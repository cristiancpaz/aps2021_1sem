/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Contato;
import java.sql.*;
/**
 *
 * @author iapereira
 */
public class ContatoDAO {

    public void inserir(Contato contato) throws SQLException {
        String sql = "INSERT INTO contatos (nome) VALUES (?);";
        Connection connection = new ConexaoPostgreSQL().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, contato.getNome());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();    
    }    

    public Contato obter(int id) throws SQLException {
        String sql = "SELECT * FROM contatos WHERE id = ?;";
        Connection connection = new ConexaoPostgreSQL().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Contato contato = new Contato();
        if (rs.next()){
            contato = new Contato();
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
        }
        preparedStatement.close();
        connection.close(); 
        return contato;
    }
    
    
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id = ?;";
        Connection connection = new ConexaoPostgreSQL().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}
