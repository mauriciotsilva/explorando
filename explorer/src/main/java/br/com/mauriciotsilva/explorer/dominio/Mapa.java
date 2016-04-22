package br.com.mauriciotsilva.explorer.dominio;

import static javax.persistence.GenerationType.AUTO;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.mauriciotsilva.explorer.Planalto;

@Entity
@Table(name = "mapa")
@XmlAccessorType(FIELD)
public class Mapa {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	private Instant dataCricao;
	private Integer x;
	private Integer y;

	protected Mapa() {
		dataCricao = Instant.now();
	}

	public Mapa(Integer x, Integer y) {
		this();
		this.x = x;
		this.y = y;
	}

	public Planalto getPlanalto() {
		return Planalto.com(x, y);
	}

	protected Long getId() {
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

	public Instant getDataCricao() {
		return dataCricao;
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
