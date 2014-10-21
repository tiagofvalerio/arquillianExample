package grupo.estudo.tiago.dado.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd")
public class CD implements Serializable {

	private static final long serialVersionUID = -7796408764199831624L;

	@Id
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "artista")
	private String artista;

	@Column(name = "genero")
	private String genero;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusCD status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public StatusCD getStatus() {
		return status;
	}

	public void setStatus(StatusCD status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", titulo=" + titulo + ", artista=" + artista
				+ ", genero=" + genero + "]";
	}

}
