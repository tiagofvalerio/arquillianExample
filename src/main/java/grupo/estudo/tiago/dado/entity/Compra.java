package grupo.estudo.tiago.dado.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {

	private static final long serialVersionUID = -3067734056300592541L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private CD cd;
	private Date dataCompra;
	private Integer numeroNF;
	private Integer quantidadeCompra;
	private Double valorUnitario;
	private Double valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getNumeroNF() {
		return numeroNF;
	}

	public void setNumeroNF(Integer numeroNF) {
		this.numeroNF = numeroNF;
	}

	public Integer getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(Integer quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", cd=" + cd + ", dataCompra=" + dataCompra
				+ ", numeroNF=" + numeroNF + ", quantidadeCompra="
				+ quantidadeCompra + ", valorUnitario=" + valorUnitario
				+ ", valorTotal=" + valorTotal + "]";
	}

}
