/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.sql.SQLException;
import negocio.Endereco;
import negocio.PessoaFisica;
import persistencia.EnderecoDAO;
import persistencia.PessoaFisicaDAO;

/**
 *
 * @author iapereira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica igor = pessoaFisicaDAO.obter(1);        
        
        Endereco enderecoIgor = new Endereco();
        enderecoIgor.setPessoa(igor); // endereco sabe de quem pertence
        enderecoIgor.setNumero("559");
        enderecoIgor.setLogradouro("rio branco");
        enderecoIgor.setBairro("cidade nova");
        enderecoIgor.setComplemento("");
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();        
        enderecoDAO.inserir(enderecoIgor);
        
        
        igor.getVetEndereco().add(enderecoIgor); // a pessoa sabe que seu endereco foi setado
        
        

        
        
        
    }
    
}
