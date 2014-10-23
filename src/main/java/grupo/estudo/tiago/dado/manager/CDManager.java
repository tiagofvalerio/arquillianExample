package grupo.estudo.tiago.dado.manager;

import java.util.List;

import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Compra;
import grupo.estudo.tiago.dado.entity.Pedido;

public interface CDManager {

	void save(CD cd) throws Exception;

	void update(CD cd) throws Exception;

	CD findById(Long id) throws Exception;

	void delete(CD cd) throws Exception;

	List<CD> findAllByNome(String titulo) throws Exception;

	CD findByNome(String titulo) throws Exception;

	List<CD> findAllByArtist(String nome) throws Exception;

	void comprarCD(Compra compra) throws Exception;

	void venderCD(Pedido pedido) throws Exception;

	Pedido findLastPedido() throws Exception;
}
