package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.User;

public class ProdutoDAO {
	private Connection conexao;
	
	public ProdutoDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}
	
	public String salvar(User produto) {
		String sql = " INSERT INTO user  " +
					 " (descricao, quantidade, valor) "+
					 " VALUES (?,?,?)";
		try {
			java.sql.PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setDouble(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.execute();
			ps.close();
			return "Produto gravado com êxito";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Houve um erro ao gravar o prouto!";
		}
	}
	
	public List<User> listarTodos() {
		String sql = " SELECT * FROM produto ";
		List<User> listaProdutos = new ArrayList<>();
		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User produto = new User();
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
