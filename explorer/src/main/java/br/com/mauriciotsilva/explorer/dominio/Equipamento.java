package br.com.mauriciotsilva.explorer.dominio;

import static java.util.stream.Collectors.toList;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.mauriciotsilva.explorer.Sonda;
import br.com.mauriciotsilva.explorer.navegacao.Bussola;

@Entity
@XmlAccessorType(FIELD)
@Table(name = "tb_equipamento")
@NamedEntityGraph(name = "graph.Equipamento.ultimosComandos", attributeNodes = @NamedAttributeNode("ultimosComandos") )
public class Equipamento {

	public static final int QUANTIDADE_MAXIMA_COMANDO = 5;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne
	private Mapa mapa;

	private String posicaoAtual;

	@Transient
	private Sonda sonda;

	@ElementCollection
	@CollectionTable(name = "tb_comandos")
	private List<ComandoEquipamento> ultimosComandos;

	protected Equipamento() {
		ultimosComandos = new ArrayList<>();
	}

	public Equipamento(Mapa mapa, String posicaoAtual) {
		this();
		this.mapa = mapa;
		this.posicaoAtual = posicaoAtual;

		Sonda sonda = criarSonda();
		validarPosicao(sonda);

	}

	public ComandoEquipamento comandar(String comando) {
		atualizarPosicao(comando);
		return registrarComando(comando);
	}

	private ComandoEquipamento registrarComando(String comando) {
		ComandoEquipamento comandoEquipamento = new ComandoEquipamento(comando);

		ultimosComandos.add(comandoEquipamento);
		ultimosComandos = ultimosComandos.stream().sorted().limit(QUANTIDADE_MAXIMA_COMANDO).collect(toList());

		return comandoEquipamento;
	}

	private void atualizarPosicao(String comando) {
		Sonda sonda = criarSonda();
		sonda.mover(comando);

		validarPosicao(sonda);
		posicaoAtual = sonda.getPosicaoAtual().toString();
	}

	private void validarPosicao(Sonda sonda) {
		if (mapa.existeEquipamento(sonda.getCoordernada())) {
			throw new RiscoColisaoException(sonda.getCoordernada());
		}
	}

	private Sonda criarSonda() {
		return new Sonda(mapa.getPlanalto(), Bussola.com(posicaoAtual));
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public String getPosicaoAtual() {
		return posicaoAtual;
	}

	protected void setPosicaoAtual(String posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	public List<ComandoEquipamento> getUltimosComandos() {
		return ultimosComandos;
	}

	protected void setUltimosComandos(List<ComandoEquipamento> ultimosComandos) {
		this.ultimosComandos = ultimosComandos;
	}

	public Mapa getMapa() {
		return mapa;
	}

	protected void setMapa(Mapa mapa) {
		this.mapa = mapa;
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
		Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
