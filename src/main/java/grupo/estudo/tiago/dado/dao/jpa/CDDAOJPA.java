package grupo.estudo.tiago.dado.dao.jpa;

import grupo.estudo.tiago.dado.dao.CDDAO;
import grupo.estudo.tiago.dado.entity.CD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class CDDAOJPA implements CDDAO, Serializable {

    private static final long serialVersionUID = 5710334858991440849L;

    @Inject
    private EntityManager em;

    public void save(CD cd) {
        try {
            em.persist(cd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(CD cd) {
        try {
            em.merge(cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CD findById(Long id) {
        try {
            return em.find(CD.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(CD cd) {
        try {
            em.remove(cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CD> findAllByNome(String titulo) {
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
            return new ArrayList<CD>();
        }
    }

    public CD findByNome(String titulo) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CD> query = builder.createQuery(CD.class);
            Root<CD> entity = query.from(CD.class);

            query.select(query.from(CD.class)).where(
                    builder.equal(entity.get("titulo"), titulo));
            return em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CD> findAllByArtist(String nome) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CD> query = builder.createQuery(CD.class);
            Root<CD> entity = query.from(CD.class);

            query.select(query.from(CD.class)).where(
                    builder.and(builder.equal(entity.get("artista"), nome)));
            return em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<CD>();
        }
    }
}