package controllers;

import entities.Pessoa;
import helpers.PessoaHelper;
import repositories.PessoaRepository;

public class PessoaController {

	// fluxo de cadastro de pessoa
	public void cadastrar() {

		try {

			System.out.println("\n *** CADASTRO DE PESSOA  *** \n");

			Pessoa pessoa = new Pessoa();

			pessoa.setNome(PessoaHelper.lerNome());
			pessoa.setEmail(PessoaHelper.lerEmail());

			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.create(pessoa);

			System.out.println("\nPessoa cadastrada com sucesso");

		} catch (Exception e) {

			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

	public void atualizar() {

		try {

			System.out.println("\n *** ATUALIZAÇÃO DE PESSOA  *** \n");

			Integer idPessoa = PessoaHelper.lerIdpessoa();

			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);

			if (pessoa != null) {

				pessoa.setNome(PessoaHelper.lerNome());
				pessoa.setEmail(PessoaHelper.lerEmail());

				pessoaRepository.update(pessoa);

				System.out.println("Pessoa atualizada com sucesso!");

			} 
			else {

				System.out.println("Pessoa não foi encontrada");

			}

		} catch (Exception e) {

			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

	public void excluir() {

		try {

			Integer idPessoa = PessoaHelper.lerIdpessoa();

			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = new PessoaRepository().findById(idPessoa);

			if (pessoa != null) {
				
				pessoaRepository.delete(pessoa);
				
				System.err.println("\nPessoa excluida com sucesso");

			} 
			else {

				System.out.println("Pessoa não foi encontrada");

			}

		} catch (Exception e) {
			
			System.out.println("Erro ao excluir" + e.getMessage());
			
		}

	}
	
	public void consultar() {
		
		try {
			
			System.out.println("\n *** CONSULTA DE PESSOAS *** \n");
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			
			for(Pessoa pessoa : pessoaRepository.findAll()) {
				
				System.out.println(pessoa.toString());
				
			}
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro" + e.getMessage());
		}
		
	}

}
