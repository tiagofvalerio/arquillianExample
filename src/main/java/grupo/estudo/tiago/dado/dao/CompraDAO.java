package grupo.estudo.tiago.dado.dao;

import grupo.estudo.tiago.dado.entity.Compra;

public interface CompraDAO {

    void save(Compra compra);

    void update(Compra compra);

    Compra findById(Long id);

}
