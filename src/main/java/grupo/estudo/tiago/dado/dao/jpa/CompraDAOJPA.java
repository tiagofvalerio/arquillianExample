package grupo.estudo.tiago.dado.dao.jpa;

import grupo.estudo.tiago.dado.dao.CompraDAO;
import grupo.estudo.tiago.dado.entity.Compra;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CompraDAOJPA implements CompraDAO, Serializable {

	private static final long serialVersionUID = 5710334858991440849L;

	@PersistenceContext(name = "test")
	private EntityManager em;

	@Override
	public void save(Compra compra) throws Exception {
		try {
			em.persist(compra);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	@Override
	public void update(Compra compra) throws Exception {
		try {
			em.merge(compra);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public Compra findById(Long id) throws Exception {
		try {
			return em.find(Compra.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}