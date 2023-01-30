package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n *** GERENCIAMENTO DE PESSOAS \n");
		System.out.println("(1) Cadastrar Pessoa");
		System.out.println("(2) Atualizar Pessoa");
		System.out.println("(3) Excluir Pessoa");
		System.out.println("(4) Consultar Pessoa");

		System.out.println("\n Escolha a opção desejada: ");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		PessoaController pessoaController = new PessoaController();

		switch (opcao) {
		case 1:
			pessoaController.cadastrar();
			break;

		case 2:
			pessoaController.atualizar();
			break;

		case 3:
			pessoaController.excluir();
			break;

		case 4:
			pessoaController.consultar();
			break;

		default:
			System.out.println("Opção não existe!");
			break;
		}

	}

}
