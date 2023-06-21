package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entity.Pessoa;

public class PessoaDao {
	// CRUD
	// C - Create | R - Retrieve | U - Update | D - Delete

	public void inserir(Pessoa pessoa) {
		// ABRIR CONEXÃO
		 ConectaBD con = new ConectaBD();
		 String sql = "INSERT INTO pessoa (nome, email) VALUES (?,?)";
		 try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getEmail());
			pst.execute();
			System.out.println(pessoa.getNome() + " inserido com sucesso.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Pessoa> consultarTodos(){
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa";
		List<Pessoa> lista = new LinkedList<Pessoa>();
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				pessoa.setId(id);
				pessoa.setNome(nome);
				pessoa.setEmail(email);
				lista.add(pessoa);
				
				/*System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("nome"));
				System.out.println(rs.getString("email"));*/
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Pessoa consultar(int id) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa WHERE id = ?";
		Pessoa p = null;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				p = new Pessoa(nome, email);
				p.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			
		}
		return p;
	}
	
	public boolean excluir(int id) {
		String sql = "DELETE FROM pessoa WHERE id = ?";
		try {
			ConectaBD con = new ConectaBD();
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			return pst.getUpdateCount()>0;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean atualizar(Pessoa pessoa) {
		try {
			String sql = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
			ConectaBD con = new ConectaBD();
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getEmail());
			pst.setInt(3, pessoa.getId());
			int linhas = pst.executeUpdate();
			return linhas > 0;
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
	return false;
	}
}