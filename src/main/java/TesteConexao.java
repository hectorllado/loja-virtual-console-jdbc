package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String stringConexao = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC";
        Connection connection = DriverManager
                .getConnection(stringConexao, "root", "It3r15@d03m03");

        System.out.println("Fechando conexão!!!");
        connection.close();

    }
}
