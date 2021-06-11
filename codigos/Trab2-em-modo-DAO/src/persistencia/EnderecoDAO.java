/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Endereco;
import negocio.PessoaFisica;

/**
 *
 * @author iapereira
 */
public class EnderecoDAO { 
    
    public void inserir(Endereco endereco) throws SQLException {        
        String sql = "INSERT INTO endereco (numero, bairro, logradouro, complemento, pessoa_id) VALUES (?,?,?,?,?) RETURNING id";
        Connection connection = new ConexaoPostgreSQL().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, endereco.getNumero());
        preparedStatement.setString(2, endereco.getBairro());        
        preparedStatement.setString(3, endereco.getLogradouro());        
        preparedStatement.setString(4, endereco.getComplemento());        
        preparedStatement.setInt(5, endereco.getPessoa().getId());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
           endereco.setId(rs.getInt("id"));            
        }       
     }      
}
