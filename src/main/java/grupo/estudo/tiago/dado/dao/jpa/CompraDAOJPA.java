package grupo.estudo.tiago.dado.dao.jpa;

import grupo.estudo.tiago.dado.dao.CompraDAO;
import grupo.estudo.tiago.dado.entity.Compra;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class CompraDAOJPA implements CompraDAO, Serializable {

    private static final long serialVersionUID = 5710334858991440849L;

    @Inject
    private EntityManager em;

    @Override
    public void save(Compra compra) {
        try {
            em.persist(compra);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Compra compra) {
        try {
            em.merge(compra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Compra findById(Long id) {
        try {
            return em.find(Compra.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}