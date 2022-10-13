package main.java;

import br.com.hector.dao.ProdutoDAO;

import java.sql.*;
import java.util.List;

public class TesteInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Comoda", "Comoda Vertical");

       try (Connection connection = new ConnectionFactory().recuperaConexao()) {
           new ProdutoDAO(connection).salvar(comoda);
          List<Produto> listaDeProdutos = new ProdutoDAO(connection).listar();

          //foreach lambda
          listaDeProdutos.stream().forEach(lp -> System.out.println(lp));

       }

        System.out.println(comoda);

    }



}
