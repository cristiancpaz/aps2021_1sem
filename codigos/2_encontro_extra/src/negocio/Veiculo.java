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
public abstract class Veiculo {
    private int qtdeRodas;
    private EstrategiaDeCalculo estrategiaDeCalculo;
    
    public Veiculo(){
        
    }

    public int getQtdeRodas() {
        return qtdeRodas;
    }

    public void setQtdeRodas(int qtdeRodas) {
        this.qtdeRodas = qtdeRodas;
    }
    
    public double ipva(){
        return estrategiaDeCalculo.calcular();
        
    }

    public EstrategiaDeCalculo getEstrategiaDeCalculo() {
        return estrategiaDeCalculo;
    }

    public void setEstrategiaDeCalculo(EstrategiaDeCalculo estrategiaDeCalculo) {
        this.estrategiaDeCalculo = estrategiaDeCalculo;
    }
    
    
    
    
    public abstract void imprimeCaracteristicas();   
    
    
}
