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
import view.Listaveiculos;

/**
 *
 * @author Pedraum
 */
public class ControllerVerificaCarros {
    private Listaveiculos view;
    
    public ControllerVerificaCarros(Listaveiculos view) {
        this.view = view;
    }
    
    public void lista(){
        Conexao conn = new Conexao();
        try{
            Connection connection = conn.getConnection();
            CarroDAO dao = new CarroDAO(connection);
            dao.listarCarros(view);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha ao carregar",
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
