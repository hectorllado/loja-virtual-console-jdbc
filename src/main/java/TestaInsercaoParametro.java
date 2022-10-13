package main.java;

import java.sql.*;

public class TestaInsercaoParametro {

    public static void main(String[] args) throws SQLException {
        String nome = "Mouse";
        String descricao = "Mouse sem fio); delete from Produto";

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperaConexao();
        connection.setAutoCommit(false);

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            adicionarVariavel("Jiboia", "Uma cobra muito divertida", stm);
            adicionarVariavel("Carrinho", "Pé da Sandrinha", stm);
            adicionarVariavel("Hector Model", "Um boneco daora", stm);

            connection.commit();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("rollback executado");
            connection.rollback();
        }

        connection.close();

        System.out.println("Inserção realizada com sucesso!");
    }

    public static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);
        stm.execute();

        if(nome.equals("Jiboia")) {
            throw new RuntimeException("Não foi possivel adicionar, motivo: mesmo nome");
        }
    }
}
