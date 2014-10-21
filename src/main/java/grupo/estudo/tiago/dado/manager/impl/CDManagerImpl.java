package grupo.estudo.tiago.dado.manager.impl;

import grupo.estudo.tiago.dado.dao.CDDao;
import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.manager.CDManager;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class CDManagerImpl implements CDManager, Serializable {

	private static final long serialVersionUID = -8413970649024106267L;

	@Inject
	private CDDao cdDao;

	public void save(CD cd) {
		cdDao.save(cd);
	}

	public void update(CD cd) {
		cdDao.update(cd);
	}

	public CD findById(CD cd) {
		return cdDao.findById(cd);
	}

	public void delete(CD cd) {
		cdDao.delete(cd);
	}

	// public void comprarCD(CD cd) {
	// }

	// public void venderCD(CD cd) {
	// }

	public CD findByNome(String titulo) {
		return cdDao.findByNome(titulo);
	}

	public List<CD> findAllByNome(String titulo) {
		return cdDao.findAllByNome(titulo);
	}
	
	public List<CD> findAllByArtist(String nome) {
		return cdDao.findAllByArtist(nome);
	}

}
