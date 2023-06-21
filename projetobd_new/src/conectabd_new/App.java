package conectabd_new;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.dao.PessoaDao;
import model.dao.ProdutoDao;
import model.entity.Pessoa;
import model.entity.Produto;

public class App {
	
	public static String leString(String msg) {
		String valor = JOptionPane.showInputDialog(null, msg);
		return valor;
	}
	
	public static int menuMain() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1 - Menu pessoa");
		System.out.println("2 - Menu produto");
		System.out.println("3 - Sair");
		System.out.println(" ");
		System.out.println("Digite uma opção: ");
		Scanner input1 = new Scanner(System.in);
		return input1.nextInt();
	}
	
	public static int menu() {
		System.out.println("MENU PESSOA");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar todos");
		System.out.println("3 - Listar por ID");
		System.out.println("4 - Excluir por ID");
		System.out.println("5 - Atualizar");
		System.out.println("6 - Sair");
		System.out.println(" ");
		System.out.print("Digite uma opção: ");
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	public static int menuProd() {
		System.out.println("MENU PRODUTO");
		System.out.println("1 - Inserir");
		System.out.println("2 - Consultar por ID");
		System.out.println("3 - Consultar por placa");
		System.out.println("4 - Excluir por ID");
		System.out.println("5 - Atualizar");
		System.out.println("6 - Sair");
		System.out.println(" ");
		System.out.print("Digite uma opção: ");
		Scanner input2 = new Scanner(System.in);
		return input2.nextInt();
	}
	
	//----------------------------------------------------------------------------------//
	//                           MÉTODOS CLASSE PESSOA
	//----------------------------------------------------------------------------------//
	
	public static void metodoInserir() {
		String nome = leString("Digite o nome: ");
		String email = leString("Digite o e-mail: ");
		Pessoa pessoa = new Pessoa(nome, email);
		PessoaDao pessoaDao = new PessoaDao();
		pessoaDao.inserir(pessoa);
	}
	
	public static void metodoConsultarTodos() {
		//PessoaDao pDao = new PessoaDao();
		//List<Pessoa> reg = pDao.consultarTodos();		
		List<Pessoa> registros = new PessoaDao().consultarTodos();
		if (!registros.isEmpty()) {
			String saida = "";
			saida += "id\tnome\temail\n";
			for (int  i = 0; i < registros.size(); i++) {
				Pessoa p = registros.get(i);
				saida += p.getId() + "\t";
				saida += p.getNome() + "\t";
				saida += p.getEmail() + "\n";
			}
			JOptionPane.showMessageDialog(null, new JTextArea(saida));
		} else {
			System.out.println("Não possui registros");
		}
	}
		
	// Metodo para exclusão
	public static void metodoExcluirId() {
		String idStr = leString("Digite o ID a ser excluído");
		int id = Integer.parseInt(idStr);
		PessoaDao dao = new PessoaDao();
		if (dao.excluir(id)) {
			JOptionPane.showMessageDialog(null, "Registro " + id + " excluído.");
		} else {
			JOptionPane.showMessageDialog(null, "Registro " + id + " não existe.");
		}
	}
	
	public static Pessoa metodoConsultarId() {
		String idStr = leString("Digite o ID");
		// converter de String para int
		int id = Integer.parseInt(idStr);
		PessoaDao dao = new PessoaDao();
		Pessoa p = dao.consultar(id);
		return p;
	}
	
	public static void metodoAtualizar(Pessoa p) {
		String nomeAntigo = p.getNome();
		String emailAntigo = p.getEmail();
		String novoNome = leString("Alterar nome: " + nomeAntigo);
		String novoEmail = leString("Alterar email: " + emailAntigo);
		p.setNome(novoNome);
		p.setEmail(novoEmail);
		PessoaDao dao = new PessoaDao();
		dao.atualizar(p);
	}
		
		/*for (Pessoa p : registros) {
			System.out.println("---------------------------");
			System.out.println("id: " + p.getId());
			System.out.println("nome: " + p.getNome());
			System.out.println("email: " + p.getEmail());
		}*/
	//----------------------------------------------------------------------------------//
	//                           MÉTODOS CLASSE PRODUTO
	//----------------------------------------------------------------------------------//
	
	public static void inserirProd() {
		String numeroChassi = leString("Digite o número do chassi: ");
		String placa = leString("Digite a placa: ");
		String modelo = leString("Digite o modelo: ");
		String marca = leString("Digite a marca: ");
		String valorStr = leString("Digite o valor: ");
		float valor = Float.parseFloat(valorStr);
		Produto produto = new Produto(numeroChassi, placa, modelo, marca, valor);
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.inserir(produto);
	}
	
	public static Produto consultar() {
		String idStr = leString("Digite o ID");
		// converter de String para int
		int id = Integer.parseInt(idStr);
		ProdutoDao dao = new ProdutoDao();
		Produto p = dao.consultar(id);
		return p;
	}
	
	public static Produto consultaPlaca() {
		String placa = leString("Digite a placa");
		ProdutoDao dao = new ProdutoDao();
		Produto p = dao.consultaPlaca(placa);
		return p;
	}
	
	public static void excluir() {
		String idStr = leString("Digite o ID a ser excluído");
		int id = Integer.parseInt(idStr);
		ProdutoDao dao = new ProdutoDao();
		if (dao.excluir(id)) {
			JOptionPane.showMessageDialog(null, "Registro " + id + " excluído.");
		} else {
			JOptionPane.showMessageDialog(null, "Registro " + id + " não existe.");
		}
	}
	
	public static void atualizar(Produto prod) {
		String chassiAntigo = prod.getNumeroChassi();
		String placaAntiga = prod.getPlaca();
		String modeloAntigo = prod.getModelo();
		String marcaAntiga = prod.getMarca();
		double valorAntigo = prod.getValor();
		
		String chassiNovo = leString("Alterar número chassi: " + chassiAntigo);
		String placaNova = leString("Alterar placa: " + placaAntiga);
		String modeloNovo = leString("Alterar modelo: " + modeloAntigo);
		String marcaNova = leString("Alterar marca: " + marcaAntiga);
		String valorStr = String.valueOf(valorAntigo);
		String valorNovo = leString("Alterar valor: " + valorStr);
		prod.setNumeroChassi(chassiNovo);
		prod.setPlaca(placaNova);
		prod.setModelo(modeloNovo);
		prod.setMarca(marcaNova);
		double valorNovo1 = Double.parseDouble(valorNovo);
		prod.setValor(valorNovo1);
		ProdutoDao dao = new ProdutoDao();
		dao.atualizar(prod);
	}
	

	public static void main(String[] args) {
		int opcao;
		
		do {
			opcao = menuMain();
			switch (opcao) {
				case 1:
					
					int op;
					
					do {
						op = menu();
						switch (op) {
							case 1:
								metodoInserir();
								break;
							case 2:
								metodoConsultarTodos();
								break;
							case 3:
								Pessoa pess = metodoConsultarId();
								String saida;
								if (pess != null) {
									saida = "id\tnome\temail\n";
									saida += pess.getId()+"\t";
									saida = saida + pess.getNome()+"\t";
									saida += pess.getEmail()+"\n";
								} else {
									saida = "Registro não foi localizado!";
								}
								JOptionPane.showMessageDialog(null, new JTextArea(saida));
								break;
							case 4:
								metodoExcluirId();
								break;
							case 5:
								Pessoa p = metodoConsultarId();
								if (p != null) {
									metodoAtualizar(p);
								} else {
									System.out.println("Registro não encontrado.");
								}
								break;
							case 6:
								System.out.println("Voltando ao menu principal.");
								break;
							default:
								System.out.println("Opção inválida.");
								break;
						}
					} while (op != 6);
					
					break;
				case 2:
					
					int opProd;
					
					do {
						opProd = menuProd();
						switch (opProd) {
							case 1:
								inserirProd();
								break;
							case 2:
								Produto prod = consultar();
								String saida;
								if (prod != null) {
									saida = "id\tchassi\tplaca\tmodelo\tmarca\tvalor\n";
									saida += prod.getId()+"\t";
									saida += prod.getNumeroChassi()+"\t";
									saida += prod.getPlaca()+"\t";
									saida += prod.getModelo()+"\t";
									saida += prod.getMarca()+"\t";
									saida += prod.getValor()+"\t";
								} else {
									saida = "Registro não foi localizado!";
								}
								JOptionPane.showMessageDialog(null, new JTextArea(saida));
								break;
							case 3:
								Produto prod1 = consultaPlaca();
								String saida1;
								if (prod1 != null) {
									saida1 = "id\tchassi\tplaca\tmodelo\tmarca\tvalor\n";
									saida1 += prod1.getId()+"\t";
									saida1 += prod1.getNumeroChassi()+"\t";
									saida1 += prod1.getPlaca()+"\t";
									saida1 += prod1.getModelo()+"\t";
									saida1 += prod1.getMarca()+"\t";
									saida1 += prod1.getValor()+"\t";
								} else {
									saida1 = "Registro não foi localizado!";
								}
								JOptionPane.showMessageDialog(null, new JTextArea(saida1));
								break;
							case 4:
								excluir();
								break;
							case 5:
								Produto prod2 = consultar();
								if (prod2 != null) {
									atualizar(prod2);
								} else {
									System.out.println("Registro não encontrado.");
								}
								break;
							case 6:
								System.out.println("Voltando ao menu principal.");
							default:
								System.out.println("Opção inválida.");
								break;
						}
					} while (opProd != 6);
					
					break;
				case 3:
					System.out.println("Finalizando programa.");
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao != 3);
		
		
				
		
		/*
		//Pessoa pessoa = new Pessoa("Ze lele", "zelele@email.com");
		PessoaDao pessoaDao = new PessoaDao();
		//pessoaDao.inserir(pessoa);
		//pessoa.inserir();
		
		List<Pessoa> listaPessoas = pessoaDao.consultarTodos();
		System.out.println(listaPessoas.isEmpty());
		for (Pessoa p : listaPessoas) {
			System.out.println("---------------------------");
			System.out.println("id: " + p.getId());
			System.out.println("nome: " + p.getNome());
			System.out.println("email: " + p.getEmail());
		}
		*/
	}

}
