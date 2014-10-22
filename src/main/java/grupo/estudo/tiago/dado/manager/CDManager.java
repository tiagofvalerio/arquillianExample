package grupo.estudo.tiago.dado.manager;

import java.util.List;

import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Compra;
import grupo.estudo.tiago.dado.entity.Pedido;

public interface CDManager {

	void save(CD cd);

	void update(CD cd);

	CD findById(Long id);

	void delete(CD cd);

	List<CD> findAllByNome(String titulo);

	CD findByNome(String titulo);

	List<CD> findAllByArtist(String nome);

	void comprarCD(Compra compra);

	void venderCD(Pedido pedido) throws Exception;

	Pedido findLastPedido();
}
