package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.Pedido;

public interface PedidoDAO {

    void save(Pedido pedido) throws Exception;

    void update(Pedido pedido) throws Exception;

    Pedido findById(Long id) throws Exception;

}
