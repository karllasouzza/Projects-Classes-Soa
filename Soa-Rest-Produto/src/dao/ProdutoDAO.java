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
			return "Produto gravado com êxito";
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
	
	public Produto getProdutoPorCodigo(int codigo) {
		String sql = " SELECT * FROM produto " + 
					 " WHERE codigo = ?";

		try {
		java.sql.PreparedStatement ps = conexao.prepareStatement(sql);;
		ps.setInt(1, codigo);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Produto produto = new Produto();
		produto.setCodigo(rs.getInt("codigo"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setQuantidade(rs.getDouble("quantidade"));
		produto.setValor(rs.getDouble("valor"));
		ps.close();
		return produto;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	};
	
	public Produto getProdutoPorDescricao(String desc) {
		String sql = " SELECT * FROM produto " + 
					 " WHERE descricao LIKE ?";

		try {
		java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, '%' + desc + '%');
		ResultSet rs = ps.executeQuery();
		rs.next();
		Produto produto = new Produto();
		produto.setCodigo(rs.getInt("codigo"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setQuantidade(rs.getDouble("quantidade"));
		produto.setValor(rs.getDouble("valor"));
		ps.close();
		return produto;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	};
	
	public String alterar(Produto produto) {
	String sql = " UPDATE produto " + 
					 "SET descricao =  ?, quantidade = ?, valor = ?" + 
					 "WHERE codigo = ?";

					 
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setDouble(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.setInt(4, produto.getCodigo());
			ps.execute();
			ps.close();
			return "produto alterado";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Houve um erro. Tente novamente!";
		}
	}
	
	public String excluir(int codigo) {
		String sql = "DELETE FROM produto WHERE codigo = ?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			 ps.setInt(1, codigo);
			 ps.execute();
			 ps.close();
			 return  "produto excluido";
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "Houve um erro. Tente novamente!";
		}
	}
}
