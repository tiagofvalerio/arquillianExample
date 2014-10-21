package grupo.estudo.tiago.dado.dao.jpa;

import grupo.estudo.tiago.dado.dao.PedidoDAO;
import grupo.estudo.tiago.dado.entity.Pedido;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class PedidoDAOJPA implements PedidoDAO, Serializable {

    private static final long serialVersionUID = 5710334858991440849L;

    @Inject
    private EntityManager em;

    @Override
    public void save(Pedido pedido) {
        try {
            em.persist(pedido);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Pedido pedido) {
        try {
            em.merge(pedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido findById(Long id) {
        try {
            return em.find(Pedido.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}