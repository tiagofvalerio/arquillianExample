package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.CD;

import java.util.List;

public interface CDDao {
	void save(CD cd);

	void update(CD cd);

	CD findById(CD cd);

	void delete(CD cd);

	CD findByNome(String titulo);

	List<CD> findAllByNome(String titulo);
	
	List<CD> findAllByArtist(String nome);
}
