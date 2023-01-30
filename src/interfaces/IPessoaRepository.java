package interfaces;

import java.util.List;

import entities.Pessoa;

public interface IPessoaRepository {

	void create(Pessoa pessoa) throws Exception;
	
	void update(Pessoa pessoa) throws Exception;
	
	void delete(Pessoa pessoa) throws Exception;
	
	List<Pessoa> findAll() throws Exception;
	
	Pessoa findById (Integer integer) throws Exception;
	
}
