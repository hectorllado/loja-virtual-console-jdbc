package main.java;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();
        //criar statements
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM PRODUTO");

        ResultSet rst = stm.getResultSet();

        while(rst.next()) {
            Integer id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");

            System.out.println(id);
            System.out.println(nome);
            System.out.println(descricao);
        }

        connection.close();
    }
}
