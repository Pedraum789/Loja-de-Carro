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
import view.Registravenda;

/**
 *
 * @author Pedraum
 */
public class ControllerRegistra {
    private Registravenda view;
    
    public ControllerRegistra(Registravenda view) {
        this.view = view;
    }
    
    public void registra(){
        String placa = view.getPlaca().getText();
        String dia = String.valueOf(view.getDia().getValue()); 
        String mes = String.valueOf(view.getMes().getValue());
        String ano = String.valueOf(view.getAno().getValue());
        double valor = Double.parseDouble(view.getValor().getText());
        Conexao conn = new Conexao();
        try{
            Connection connection = conn.getConnection();
            CarroDAO dao = new CarroDAO(connection);
            dao.registra(placa, dia, mes, ano, valor);
            JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso",
                    "VENDA REGISTRADA!", JOptionPane.INFORMATION_MESSAGE);
            view.setVisible(false);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha no registro",
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
