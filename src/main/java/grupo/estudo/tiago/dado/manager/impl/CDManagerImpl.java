package grupo.estudo.tiago.dado.manager.impl;

import grupo.estudo.tiago.dado.dao.CDDAO;
import grupo.estudo.tiago.dado.dao.CompraDAO;
import grupo.estudo.tiago.dado.dao.PedidoDAO;
import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Compra;
import grupo.estudo.tiago.dado.entity.MeioPagamento;
import grupo.estudo.tiago.dado.entity.Pedido;
import grupo.estudo.tiago.dado.entity.Venda;
import grupo.estudo.tiago.dado.manager.CDManager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CDManagerImpl implements CDManager, Serializable {

	private static final long serialVersionUID = -8413970649024106267L;

	@Inject
	private CDDAO cdDao;
	@Inject
	private CompraDAO compraDAO;
	@Inject
	private PedidoDAO pedidoDAO;

	public void save(CD cd) {
		cdDao.save(cd);
	}

	public void update(CD cd) {
		cdDao.update(cd);
	}

	public CD findById(Long id) {
		return cdDao.findById(id);
	}

	public void delete(CD cd) {
		cdDao.delete(cd);
	}

	@Override
	public void comprarCD(Compra compra) {
		compra.setDataCompra(new Date());
		Integer estoque = compra.getCd().getEstoque()
				+ compra.getQuantidadeCompra();
		compra.getCd().setEstoque(estoque);
		compraDAO.save(compra);
	}

	@Override
	public void venderCD(Pedido pedido) throws Exception {

		for (Venda venda : pedido.getVendas()) {
			if (venda.getQuantidadeVenda() > venda.getCd().getEstoque()) {
				throw new Exception("Quantidade de compra maior que estoque");
			}
			venda.getCd().setEstoque(
					venda.getCd().getEstoque() - venda.getQuantidadeVenda());

			if (MeioPagamento.AVISTA.equals(pedido.getMeioPagamento())) {
				Double valor = venda.getCd().getValor();
				pedido.setDesconto(pedido.getDesconto() + (valor * 15 / 100));
			}

		}
		pedidoDAO.save(pedido);
	}

	public CD findByNome(String titulo) {
		return cdDao.findByNome(titulo);
	}

	public List<CD> findAllByNome(String titulo) {
		return cdDao.findAllByNome(titulo);
	}

	public List<CD> findAllByArtist(String nome) {
		return cdDao.findAllByArtist(nome);
	}
	
	public Pedido findLastPedido() {
		return cdDao.findLastPedido();
	}

}
