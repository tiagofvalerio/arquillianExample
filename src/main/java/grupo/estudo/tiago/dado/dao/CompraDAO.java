package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.Compra;

public interface CompraDAO {

    void save(Compra compra) throws Exception;

    void update(Compra compra) throws Exception;

    Compra findById(Long id) throws Exception;

}
