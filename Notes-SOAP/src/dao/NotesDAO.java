package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.Notes;

public class NotesDAO {
	private Connection conexao;
	
	public NotesDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}
	
	
	public String InsertNote(Notes notes) {
		String sql = " INSERT INTO notes "+
					 " (title, content) "+
				     " VALUES (?,?) ";
		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, notes.getTitle());
			ps.setString(2, notes.getContent());
			ps.execute();
			ps.close();
			return "{error: false}";
		} catch (SQLException e) {
			e.printStackTrace();
			return "{error: true}";
		}
	}
	
	public List<Notes> ListALL() {
		String sql = " SELECT * FROM notes ";
		List<Notes> listaProdutos = new ArrayList<>();
		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Notes produto = new Notes();
				produto.setId(rs.getInt("id"));
				produto.setTitle(rs.getString("title"));
				produto.setContent(rs.getString("content"));
				listaProdutos.add(produto);
			}
			ps.close();
			return listaProdutos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Notes GetNoteByID(int id) {
		String sql = " SELECT * FROM notes "+
					 " WHERE id = ? ";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Notes produto = new Notes();
			produto.setId(rs.getInt("id"));
			produto.setTitle(rs.getString("title"));
			produto.setContent(rs.getString("content"));
			ps.close();
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Notes> GetNoteBySearch(String searchContent) {
		String sql = " SELECT * FROM notes "+
	                 " WHERE title  LIKE ?  OR content LIKE ?";
		List<Notes> noteList = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "%"+ searchContent +"%");
			ps.setString(2, "%"+ searchContent +"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Notes note = new Notes();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				noteList.add(note);
			}
			ps.close();
			return noteList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String UpdateNoteByID(Notes note) {
		String sql = " UPDATE notes SET title = ?, "+
					 " content = ? "+
					 " WHERE id = ? ";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, note.getTitle());
			ps.setString(2, note.getContent());
			ps.setInt(3, note.getId());
			ps.execute();
			ps.close();
			return "{error: false}";
		} catch (SQLException e) {
			e.printStackTrace();
			return "{error: true}";
		}
	}
	
	public String DeletNoteByID(int id) {
		String sql = " DELETE FROM notes WHERE id = ? ";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			return "{error: false}";
		} catch (SQLException e) {
			e.printStackTrace();
			return "{error: true}";
		}
	}
}
