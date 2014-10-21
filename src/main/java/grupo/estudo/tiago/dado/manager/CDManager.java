package grupo.estudo.tiago.dado.manager;

import java.util.List;

import grupo.estudo.tiago.dado.entity.CD;

public interface CDManager {

	void save(CD cd);

	void update(CD cd);

	CD findById(CD cd);

	void delete(CD cd);
	
	//void comprarCD(CD cd);
	
	List<CD> findAllByNome(String titulo);
	
	CD findByNome(String titulo);
	
	List<CD> findAllByArtist(String nome);
}
