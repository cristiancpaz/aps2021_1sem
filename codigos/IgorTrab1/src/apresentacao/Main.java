package apresentacao;

import java.sql.SQLException;
import persistencia.ContatoDAO;
import negocio.*;
import persistencia.EnderecoDAO;

/**
 * @author iapereira
 */
public class Main {
    public static void main(String[] args) throws SQLException {       
       ContatoDAO contatoDAO = new ContatoDAO();
       Contato contato = contatoDAO.obter(2);       
       contato.getVetEndereco().add(new Endereco("Av. Presidente", "559"));              
       contato.getVetEndereco().add(new Endereco("Rio Branco", "134"));       
       EnderecoDAO enderecoDAO = new EnderecoDAO();
       enderecoDAO.inserir(contato);              
    }    
}