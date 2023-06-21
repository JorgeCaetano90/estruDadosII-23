package model.entity;

import model.dao.ProdutoDao;

public class Produto {
	int id;
	private String numeroChassi, placa, modelo, marca;
	double valor;

	public Produto() {
	}

	public Produto(String numeroChassi, String placa, String modelo, String marca, double valor) {
		this.numeroChassi = numeroChassi;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroChassi() {
		return numeroChassi;
	}

	public void setNumeroChassi(String numeroChassi) {
		this.numeroChassi = numeroChassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void inserir() {
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.inserir(this);
	}
	
}
