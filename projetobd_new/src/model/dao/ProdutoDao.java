package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entity.Produto;

public class ProdutoDao {
	// CRUD
	// C - Create | R - Retrieve | U - Update | D - Delete

	public void inserir(Produto produto) {
		// ABRIR CONEXÃO
		 ConectaBD con = new ConectaBD();
		 String sql = "INSERT INTO produto (numeroChassi, placa, modelo, marca, valor) VALUES (?,?,?,?,?)";
		 try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, produto.getNumeroChassi());
			pst.setString(2, produto.getPlaca());
			pst.setString(3, produto.getModelo());
			pst.setString(4, produto.getMarca());
			pst.setDouble(5, produto.getValor());
			pst.execute();
			System.out.println(produto.getModelo() + " inserido com sucesso.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public Produto consultar(int id) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM produto WHERE id = ?";
		Produto p = null;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String numeroChassi = rs.getString("numeroChassi");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				double valor = rs.getDouble("valor");
				p = new Produto(numeroChassi, placa, modelo, marca, valor);
				p.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			
		}
		return p;
	}
	
	public Produto consultaPlaca(String placa) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM produto WHERE placa = ?";
		Produto prod = null;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, placa);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String numeroChassi = rs.getString("numeroChassi");
				String placa1 = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				double valor = rs.getDouble("valor");
				prod = new Produto(numeroChassi, placa1, modelo, marca, valor);
				prod.setPlaca(rs.getString("placa"));
			}
		} catch (Exception e) {
			
		}
		return prod;
	}
	
	
	public boolean excluir(int id) {
		String sql = "DELETE FROM produto WHERE id = ?";
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
	
	public boolean atualizar(Produto produto) {
		try {
			String sql = "UPDATE produto SET numeroChassi = ?, placa = ?, modelo = ?, marca = ?, valor = ? WHERE id = ?";
			ConectaBD con = new ConectaBD();
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, produto.getNumeroChassi());
			pst.setString(2, produto.getPlaca());
			pst.setString(3, produto.getModelo());
			pst.setString(4, produto.getMarca());
			pst.setDouble(5, produto.getValor());
			pst.setInt(6, produto.getId());
			int linhas = pst.executeUpdate();
			return linhas > 0;
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
	return false;
	}
}