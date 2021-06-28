/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Carro;
import view.Listaveiculos;
import view.Valortotal;

/**
 *
 * @author Pedraum
 */
public class CarroDAO {
    private Connection conn;

    public CarroDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void cadastra(Carro carro, String dia, String mes, String ano, double value) throws SQLException{
        String sql = "INSERT INTO cadastracompra(Placa, Modelo, Ano_fabricacao, Cor, Chassi, Valor, Dia, Mes, Ano)"
                + " values('" + carro.getPlaca() + "','" 
                + carro.getModelo() + "', '" 
                + carro.getAno_fabr() + "', '" 
                + carro.getCor() + "', '" 
                + carro.getChassi() + "', '" 
                + value + "', '" 
                + dia   + "', '" 
                + mes   + "', '" 
                + ano   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    public void registra(String placa, String dia, String mes, String ano, double value) throws SQLException{
        String select = "SELECT valor FROM cadastracompra WHERE placa = ?";
        
        PreparedStatement statement = conn.prepareStatement(select);
        statement.setString(1, placa);
        ResultSet resultado = statement.executeQuery();
        String valor_carro = "";
        while(resultado.next()){
            valor_carro = resultado.getString("valor");
        }
        
        String sql = "INSERT INTO RegistraVenda(placa, valor_venda, dia, mes, ano, comissao, lucro)"
                + " values('"
                + placa + "', '"
                + value + "', '"
                + dia + "', '"
                + mes + "', '"
                + ano + "','"
                + ((Double.parseDouble(valor_carro) - value)*0.1) + "','"
                + ((Double.parseDouble(valor_carro) - value)*0.9) + "')";
        PreparedStatement statement_2 = conn.prepareStatement(sql);
        statement_2.execute();
        
        String sql_3 = "DELETE FROM cadastracompra WHERE placa = ?";
        PreparedStatement statement_3 = conn.prepareStatement(sql_3);
        statement_3.setString(1, placa);
        statement_3.execute();
        
        
        conn.close();
    }
    
    public void listarCarros(Listaveiculos view) throws SQLException{
        String select = "SELECT placa, modelo, ano_fabricacao, cor, chassi, valor FROM cadastracompra";
        
        PreparedStatement statement = conn.prepareStatement(select);
        ResultSet resultado = statement.executeQuery();
        while(resultado.next()){
            view.getText1().append(
                    "Placa: " + resultado.getString("placa") + "\t" + 
                    "Modelo: " + resultado.getString("modelo") + "\t" +
                    "Ano: " + resultado.getString("ano_fabricacao") + "\t" +
                    "Cor: " + resultado.getString("cor") + "\t" +
                    "Chassi: " + resultado.getString("chassi") + "\t" +
                    "Valor: R$ " + resultado.getString("valor"));
            view.getText1().append("\n");
        }
        String select_2 = "SELECT placa, valor_venda, dia, mes, ano FROM registravenda";
        
        PreparedStatement statement_2 = conn.prepareStatement(select_2);
        ResultSet result = statement_2.executeQuery();
        while(result.next()){
            view.getText2().append(
                    "Placa: " + result.getString("placa") + "\t" +
                    "Valor da venda:R$ " + result.getString("valor_venda") + "\t" +
                    "Dia: " + result.getString("dia") + "\t" +
                    "Mes: " + result.getString("mes") + "\t" +
                    "Ano: " + result.getString("ano"));
            view.getText2().append("\n");
        }
        conn.close();
    }
    public void valoresTotais(Valortotal view) throws SQLException{
        double total = 0;
        view.getText1().setText("");
        view.getText2().setText("");
        view.getText3().setText("");
        view.getText4().setText("");
        String mes = String.valueOf(view.getMes().getValue());
        //
        try{
        String select = "SELECT placa, modelo, valor FROM cadastracompra WHERE mes=?";
        PreparedStatement statement = conn.prepareStatement(select);
        statement.setString(1, mes);
        ResultSet resultado = statement.executeQuery();
        total = 0;
        while(resultado.next()){
            view.getText1().append(
                    "Placa: " + resultado.getString("placa") + "\t" +
                    "Modelo: " + resultado.getString("modelo") + "\t" +
                    "Valor da venda:R$ " + resultado.getString("valor"));
            view.getText1().append("\n");
            total += Double.parseDouble(resultado.getString("valor"));
        }
        view.getText1().append("Valor de compra TOTAL:R$ " + String.valueOf(total));
        }
        catch(Exception e){}
        //
        try{
        String select_2 = "SELECT placa, valor_venda FROM registravenda WHERE mes=?";
        PreparedStatement statement_2 = conn.prepareStatement(select_2);
        statement_2.setString(1, mes);
        ResultSet resultado_2 = statement_2.executeQuery();
        total = 0;
        while(resultado_2.next()){
            view.getText2().append(
                    "Placa: " + resultado_2.getString("placa") + "\t" +
                    "Valor da venda:R$ " + resultado_2.getString("valor_venda"));
            view.getText2().append("\n");
            total += Double.parseDouble(resultado_2.getString("valor_venda"));
        }
        view.getText2().append("Valor de venda TOTAL:R$ " + String.valueOf(total));
        }
        catch(Exception e){}
        try{
            String select_3 = "SELECT placa, valor_venda, lucro FROM registravenda WHERE mes=?";
            PreparedStatement statement_3 = conn.prepareStatement(select_3);
            statement_3.setString(1, mes);
            ResultSet resultado_3 = statement_3.executeQuery();
            total = 0;
            while(resultado_3.next()){
                view.getText3().append(
                        "Placa: " + resultado_3.getString("placa") + "\t" +
                        "Valor da venda:R$ " + resultado_3.getString("valor_venda") + "\t" +
                        "Lucro:R$ " + resultado_3.getString("lucro"));
                view.getText3().append("\n");
                total += Double.parseDouble(resultado_3.getString("lucro"));
            }
            view.getText3().append("Lucro TOTAL:R$ " + String.valueOf(total));
        }
        catch(Exception e){}
        try{
            String select_4 = "SELECT placa, valor_venda, comissao FROM registravenda WHERE mes=?";
            PreparedStatement statement_4 = conn.prepareStatement(select_4);
            statement_4.setString(1, mes);
            ResultSet resultado_4 = statement_4.executeQuery();
            total = 0;
            while(resultado_4.next()){
                view.getText4().append(
                        "Placa: " + resultado_4.getString("placa") + "\t" +
                        "Valor da venda:R$ " + resultado_4.getString("valor_venda") + "\t" +
                        "Lucro:R$ " + resultado_4.getString("comissao"));
                view.getText4().append("\n");
                total += Double.parseDouble(resultado_4.getString("comissao"));
            }
            view.getText4().append("Comissão TOTAL:R$ " + String.valueOf(total));
        }
        catch(Exception e){}
        
        
        conn.close();
    }
    
    
    
//    public ResultSet consultar(Aluno aluno) throws SQLException{
//        String sql = "SELECT * FROM alunos WHERE USUARIO = ? AND SENHA = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, aluno.getUsuario());
//        statement.setString(2, aluno.getSenha());
//        statement.execute();
//        ResultSet resultado = statement.getResultSet();
//        conn.close();
//        return resultado;
//    }
//    public ResultSet deletar(Aluno aluno) throws SQLException{
//        String sq1 = "DELETE * FROM alunos WHERE USUARIO = ? AND SENHA = ?";
//        PreparedStatement statement = conn.prepareStatement(sq1);
//        statement.setString(1, aluno.getUsuario());
//        statement.setString(2, aluno.getSenha());
//        statement.execute();
//        ResultSet resultado = statement.getResultSet();
//        conn.close();
//        return resultado;
//    }
    
}
