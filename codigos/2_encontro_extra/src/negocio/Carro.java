/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author iapereira
 */
public class Carro extends Veiculo {
    private String nome;
    private String marca;
    private double preco;
    
    public Carro(){
//        super();
//        System.out.println("Chamando construtor....");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public void imprimeCaracteristicas(){        
        System.out.println(this.nome);
        System.out.println(this.marca);
        System.out.println(this.preco);
        System.out.println(super.getQtdeRodas());
        
    }
    
    
    
}
