package grupo.estudo.tiago.dado.dao.jpa;

import grupo.estudo.tiago.dado.dao.CDDAO;
import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Pedido;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class CDDAOJPA implements CDDAO, Serializable {

	private static final long serialVersionUID = 5710334858991440849L;

	@PersistenceContext(name = "test")
	private EntityManager em;

	public void save(CD cd) throws Exception {
		try {
			em.persist(cd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	public void update(CD cd) throws Exception {
		try {
			em.merge(cd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public CD findById(Long id) throws Exception {
		try {
			return em.find(CD.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void delete(CD cd) throws Exception {
		try {
			em.remove(cd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public List<CD> findAllByNome(String titulo) throws Exception {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<CD> query = builder.createQuery(CD.class);

			Root<CD> entity = query.from(CD.class);

			query.select(query.from(CD.class))
					.where(builder.like(entity.get("titulo").as(String.class),
							titulo));
			return em.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public CD findByNome(String titulo) throws Exception {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<CD> query = builder.createQuery(CD.class);
			Root<CD> entity = query.from(CD.class);

			query.select(entity).where(
					builder.equal(entity.get("titulo"), titulo));
			return em.createQuery(query).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public List<CD> findAllByArtist(String nome) throws Exception {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<CD> query = builder.createQuery(CD.class);
			Root<CD> entity = query.from(CD.class);

			query.select(entity).where(
					builder.and(builder.equal(entity.get("artista"), nome)));
			return em.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Pedido findLastPedido() throws Exception {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Pedido> query = builder.createQuery(Pedido.class);
			Root<Pedido> entity = query.from(Pedido.class);

			query.select(entity).orderBy(builder.desc(entity.get("id")));
			return em.createQuery(query).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}