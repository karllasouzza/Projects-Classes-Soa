package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.Produto;

public class ProdutoDAO {
	private Connection conexao;
	
	public ProdutoDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}
	
	public String salvar(Produto produto) {
		String sql = " INSERT INTO produto  " +
					 " (descricao, quantidade, valor) "+
					 " VALUES (?,?,?)";
		try {
			java.sql.PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setDouble(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.execute();
			ps.close();
			return "Produto gravado com �xito";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Houve um erro ao gravar o prouto!";
		}
	}
	
	public List<Produto> listarTodos() {
		String sql = " SELECT * FROM produto ";
		List<Produto> listaProdutos = new ArrayList<>();
		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getDouble("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				listaProdutos.add(produto);
			}
			ps.close();
			return listaProdutos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}