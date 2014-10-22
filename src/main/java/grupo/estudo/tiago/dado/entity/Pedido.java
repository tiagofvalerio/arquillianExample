package grupo.estudo.tiago.dado.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -3067734056300592541L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = { CascadeType.ALL })
	private Set<Venda> vendas;
	private Date dataPedido;
	private Double desconto;
	private MeioPagamento meioPagamento;

	public Pedido() {
		this.dataPedido = new Date();
		this.desconto = 0D;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Venda> getVendas() {
		if (vendas == null) {
			vendas = new HashSet<Venda>();
		}
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public MeioPagamento getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(MeioPagamento meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", vendas=" + vendas + ", dataPedido="
				+ dataPedido + ", desconto=" + desconto + ", meioPagamento="
				+ meioPagamento + "]";
	}

}
