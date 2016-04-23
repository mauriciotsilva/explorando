package br.com.mauriciotsilva.explorer.dominio;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import java.time.Instant;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mauriciotsilva.explorer.Planalto;

@Entity
@XmlAccessorType(FIELD)
@Table(name = "tb_mapa")
public class Mapa {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String nome;
	private Instant criadoEm;

	@NotNull
	private Integer x;

	@NotNull
	private Integer y;

	@Transient
	private Optional<Planalto> planalto;

	protected Mapa() {
		criadoEm = Instant.now();
		planalto = Optional.empty();
	}

	public Mapa(Integer x, Integer y) {
		this();
		this.x = x;
		this.y = y;
		this.planalto = Optional.of(criarPlanalto());
	}

	@JsonIgnore
	public Planalto getPlanalto() {
		return planalto.orElse(criarPlanalto());
	}

	private Planalto criarPlanalto() {
		return Planalto.com(x, y);
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public Integer getX() {
		return x;
	}

	protected void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	protected void setY(Integer y) {
		this.y = y;
	}

	public Instant getCriadoEm() {
		return criadoEm;
	}

	protected void setCriadoEm(Instant criadoEm) {
		this.criadoEm = criadoEm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mapa other = (Mapa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
