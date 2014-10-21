package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.Pedido;

public interface PedidoDAO {

    void save(Pedido pedido);

    void update(Pedido pedido);

    Pedido findById(Long id);

}
