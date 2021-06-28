
package model;

/**
 *
 * @author Pedraum
 */
public class Carro {
    private String modelo, marca, ano_fabr, placa, cor, chassi;
    private double valor;

    public Carro(String modelo, String marca, String ano_fabr, String placa, String cor, String chassi, double valor) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano_fabr = ano_fabr;
        this.placa = placa;
        this.cor = cor;
        this.chassi = chassi;
        this.valor = valor;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno_fabr() {
        return ano_fabr;
    }

    public void setAno_fabr(String ano_fabr) {
        this.ano_fabr = ano_fabr;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
