/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.*;
import java.sql.SQLException;
import negocio.PessoaFisica;

/**
 *
 * @author iapereira
 */
public class PessoaFisicaDAO {
    
    
    public void inserir(PessoaFisica pessoaFisica) throws SQLException {
        String sql = "INSERT INTO pessoa(nome, cpf) VALUES (?, ?) RETURNING id";
        Connection connection = new ConexaoPostgreSQL().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pessoaFisica.getNome());
        preparedStatement.setString(2, pessoaFisica.getCpf());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            pessoaFisica.setId(rs.getInt("id"));            
        }       
     }    

    public PessoaFisica obter(int i) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        Connection connection = new ConexaoPostgreSQL().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, i);
        ResultSet rs = preparedStatement.executeQuery();
        PessoaFisica p = new PessoaFisica();
        if (rs.next()){
            p.setId(rs.getInt("id"));     
            p.setCpf(rs.getString("cpf"));
            p.setNome(rs.getString("nome"));
        }       
        return p;      
    }
}
