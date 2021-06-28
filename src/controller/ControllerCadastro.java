/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CarroDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Carro;
import view.Cadastracarro;

/**
 *
 * @author Pedraum
 */
public class ControllerCadastro {
    private Cadastracarro view;

    public ControllerCadastro(Cadastracarro view) {
        this.view = view;
    }
    
    public void cadastra(){
        String placa = view.getPlaca().getText();
        String marca = view.getMarca().getText();
        String modelo = view.getModelo().getText();
        String ano_fabricacao = view.getAno_fabr().getText();
        String cor = view.getCor().getText();
        String chassi = view.getChassi().getText();
        String dia = String.valueOf(view.getDia_compra().getValue()); 
        String mes = String.valueOf(view.getMes_compra().getValue());
        String ano = String.valueOf(view.getAno_compra().getValue());
        double valor = Double.parseDouble(view.getValor().getText());
        Carro carro = new Carro(modelo, marca, ano_fabricacao, placa, cor, chassi, valor);
        
        Conexao conn = new Conexao();
        try{
            Connection connection = conn.getConnection();
            CarroDAO dao = new CarroDAO(connection);
            dao.cadastra(carro, dia, mes, ano, valor);
            JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso",
                    "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
            view.setVisible(false);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha no cadastro",
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
