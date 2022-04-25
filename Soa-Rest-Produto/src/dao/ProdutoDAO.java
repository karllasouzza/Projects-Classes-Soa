package dao;

import java.sql.Connection;
import java.sql.SQLException;

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
}
