package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Pedido;

import java.util.List;

public interface CDDAO {
	void save(CD cd);

	void update(CD cd);

	CD findById(Long id);

	void delete(CD cd);

	CD findByNome(String titulo);

	List<CD> findAllByNome(String titulo);
	
	List<CD> findAllByArtist(String nome);
	
	Pedido findLastPedido();
}
