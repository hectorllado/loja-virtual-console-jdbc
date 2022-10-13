package br.com.hector.dao;

import main.java.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {

            String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";

            try (PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, produto.getNome());
                pstm.setString(2, produto.getDescricao());

                pstm.execute();

                try(ResultSet rs = pstm.getGeneratedKeys()) {
                    while(rs.next()) {
                        produto.setId(rs.getInt(1));
                    }
                }

            }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * from PRODUTO";

        try(PreparedStatement pstm = this.connection.prepareStatement(sql)) {
            pstm.execute();

            try(ResultSet rs = pstm.getResultSet()) {
                while(rs.next()) {
                    Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

}

