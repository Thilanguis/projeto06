package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;
import interfaces.IPessoaRepository;

public class PessoaRepository implements IPessoaRepository {

	@Override
	public void create(Pessoa pessoa) throws Exception {

		// abrir conexão com o bando de dados
		Connection connection = ConnectionFactory.getConnection();

		// Usando um comando para cadastrar uma pessoa
		/*
		 * !!PreparedStatement!!
		 * 
		 * Interface capaz de executar comandos / sentenças em linguagem SQL na base de
		 * dados, tais como INSERT, UPDATE, DELETE, SELECT etc.
		 */
		PreparedStatement statement = connection.prepareStatement("insert into pessoa(nome, email) values(?, ?)"); //
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getEmail());
		statement.execute();

		connection.close();

	}

	@Override
	public void update(Pessoa pessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update pessoa set nome = ?, email = ? where idpessoa = ?");
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getEmail());
		statement.setInt(3, pessoa.getIdPessoa());
		statement.execute();

		connection.close();

	}

	@Override
	public void delete(Pessoa pessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from pessoa where idpessoa = ?");
		statement.setInt(1, pessoa.getIdPessoa());
		statement.execute();

		connection.close();

	}

	@Override
	public List<Pessoa> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from pessoa");

		/*
		 * !!ResultSet!!
		 * 
		 * Interface capaz de ler registros obtidos de consultas feitas do banco de
		 * dados, ou seja, após qualquer comando SELECT realizado no banco, precisamos
		 * do ResultSet para ler o retorno dessa consulta.
		 */
		ResultSet resultSet = statement.executeQuery();
		List<Pessoa> lista = new ArrayList<Pessoa>();

		while (resultSet.next()) {

			Pessoa pessoa = new Pessoa(resultSet.getInt("idpessoa"), resultSet.getString("nome"),
					resultSet.getString("email"));
			lista.add(pessoa);

			// método instaciando pessoa de forma mais direta, outra forma de se fazer
//			lista.add(new Pessoa(resultset.getInt("idpessoa"), resultset.getString("nome"), resultset.getString("email")));

		}
		connection.close();

		return lista;
	}

	@Override
	public Pessoa findById(Integer idPessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from pessoa where idpessoa = ?");
		statement.setInt(1, idPessoa);
		ResultSet resultSet = statement.executeQuery();

		Pessoa pessoa = null;

		if (resultSet.next()) {

			pessoa = new Pessoa(resultSet.getInt("idpessoa"), resultSet.getString("nome"),
					resultSet.getString("email"));

		}
		connection.close();

		return pessoa;
	}

}
