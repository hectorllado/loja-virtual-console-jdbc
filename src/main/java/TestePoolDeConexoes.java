package main.java;

import java.sql.SQLException;

public class TestePoolDeConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 15; i++) {
            connectionFactory.recuperaConexao();
            System.out.println("Conexao de numero : " + i);
        }
    }
}
