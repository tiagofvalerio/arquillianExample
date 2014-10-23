package grupo.estudo.tiago.dado.test;

import grupo.estudo.tiago.dado.dao.CDDAO;
import grupo.estudo.tiago.dado.dao.CompraDAO;
import grupo.estudo.tiago.dado.dao.PedidoDAO;
import grupo.estudo.tiago.dado.dao.jpa.CDDAOJPA;
import grupo.estudo.tiago.dado.dao.jpa.CompraDAOJPA;
import grupo.estudo.tiago.dado.dao.jpa.PedidoDAOJPA;
import grupo.estudo.tiago.dado.entity.CD;
import grupo.estudo.tiago.dado.entity.Compra;
import grupo.estudo.tiago.dado.entity.MeioPagamento;
import grupo.estudo.tiago.dado.entity.Pedido;
import grupo.estudo.tiago.dado.entity.Venda;
import grupo.estudo.tiago.dado.manager.CDManager;
import grupo.estudo.tiago.dado.manager.impl.CDManagerImpl;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptAfter;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LojaTest {

	@Deployment
	public static JavaArchive createDeployArchive() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml")
				.addClasses(CDDAO.class, CDDAOJPA.class, CompraDAO.class,
						CompraDAOJPA.class, PedidoDAO.class,
						PedidoDAOJPA.class, CD.class, Compra.class,
						MeioPagamento.class, Pedido.class, Venda.class,
						CDManager.class, CDManagerImpl.class);
	}

	@Inject
	private CDManager cdManager;

	@Test
	@UsingDataSet("datasets/cds.xml")
	@ShouldMatchDataSet(value = "datasets/compraResult.xml", excludeColumns = { "id" })
	public void comprarTest() {

		try {
			CD cd;

			cd = cdManager.findById(2l);

			Compra compra = new Compra();
			compra.setCd(cd);
			compra.setNumeroNF(1234);
			compra.setQuantidadeCompra(5);
			compra.setValorUnitario(15.0);
			compra.setValorTotal(75.0);

			cdManager.comprarCD(compra);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@UsingDataSet("datasets/cds.xml")
	@ShouldMatchDataSet(value = "datasets/vendaResult.xml", excludeColumns = { "id" })
	@ApplyScriptAfter("datasets/deleteAfterVenda.sql")
	public void venderTest() {
		try {
			CD cd;

			cd = cdManager.findById(3l);

			Venda venda = new Venda();
			venda.setCd(cd);
			venda.setQuantidadeVenda(1);

			Pedido pedido = new Pedido();
			pedido.getVendas().add(venda);
			pedido.setMeioPagamento(MeioPagamento.PARCELADO);

			cdManager.venderCD(pedido);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@UsingDataSet("datasets/cds.xml")
	public void buscarPorTituloTest() {

		try {
			CD cd;

			String titulo = "MEU REINO ENCANTADO";

			cd = cdManager.findByNome(titulo);

			System.out.println(cd.toString());

			Assert.assertNotNull(cd);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@UsingDataSet("datasets/cds.xml")
	public void buscarTodosPorArtistaTest() {

		try {
			List<CD> cds;
			String artista = "DANIEL";

			cds = cdManager.findAllByArtist(artista);

			System.out.println(cds.toString());

			Assert.assertNotNull(cds);
			Assert.assertTrue(cds.size() > 1);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@UsingDataSet("datasets/cds.xml")
	@ApplyScriptAfter("datasets/deleteAfterVenda.sql")
	public void descontoTest() {
		try {
			CD cd;

			cd = cdManager.findById(4l);

			Venda venda = new Venda();
			venda.setCd(cd);
			venda.setQuantidadeVenda(1);

			Pedido pedido = new Pedido();
			pedido.getVendas().add(venda);
			pedido.setMeioPagamento(MeioPagamento.AVISTA);

			cdManager.venderCD(pedido);
			Pedido pedidoSalvo = cdManager.findLastPedido();
			System.out.println(pedidoSalvo);
			Assert.assertNotNull(pedidoSalvo);
			Assert.assertTrue(pedidoSalvo.getDesconto() > 0D);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
