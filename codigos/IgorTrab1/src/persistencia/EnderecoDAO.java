/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Contato;
import negocio.Endereco;

/**
 *
 * @author iapereira
 */
public class EnderecoDAO {

    public void inserir(Contato contato) throws SQLException {
        ArrayList<Endereco> vetEndereco = contato.getVetEndereco();
        String sql = "";
        for (int i = 0; i < vetEndereco.size(); i++) {
            Endereco endereco = vetEndereco.get(i);
            sql = "INSERT INTO enderecos (logradouro, numero, contato_id) VALUES(?, ?, ?)";
            Connection connection = new ConexaoPostgreSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setInt(3, contato.getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }
    }

}
