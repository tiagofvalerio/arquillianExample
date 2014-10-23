package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Pedido;

import java.util.List;

public interface CDDAO {
	void save(CD cd) throws Exception;

	void update(CD cd) throws Exception;

	CD findById(Long id) throws Exception;

	void delete(CD cd) throws Exception;

	CD findByNome(String titulo) throws Exception;

	List<CD> findAllByNome(String titulo) throws Exception;

	List<CD> findAllByArtist(String nome) throws Exception;

	Pedido findLastPedido() throws Exception;
}
