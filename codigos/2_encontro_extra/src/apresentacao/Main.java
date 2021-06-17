package apresentacao;

import negocio.Veiculo;
import negocio.Carro;
import negocio.IPVACarroDeLocadora;
import negocio.IPVACarroDePasseio;

/**
 *
 * @author iapereira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carro onix = new Carro();
        onix.setMarca("GM");
        onix.setNome("Onix");
        onix.setPreco(80.000);
        onix.setQtdeRodas(4); // heranca de veiculo.
        onix.imprimeCaracteristicas();
        onix.setEstrategiaDeCalculo(new IPVACarroDePasseio());
        double valor = onix.ipva();       
        
//        Veiculo carroca = new Veiculo();
//        carroca.setQtdeRodas(3);
//        carroca.imprimeCaracteristicas();
        
        
    }
    
}
