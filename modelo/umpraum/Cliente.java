package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * JoinColumn serve para mapear campos que definem jun��es de tabelas
 * Unique serve para definir que o assento � �nico para cada cliente, ou seja,
 * n�o podem existir duas ou mais pessoas relacionadas a um mesmo assento.
 * 
 * Cascade � usada para que durante a persist�ncia de um objeto, sejam feitas
 * as persist�ncias de objetos relacionados a ele automaticamente. � poss�vel
 * usar cascade = {CascadeType.PERSIST, CascadeType.MERGE} para atualizar na
 * cria��o e altera��o (ent�o separa com v�rgulas). No caso de somente uma
 * propriedade, o uso � como abaixo. Tamb�m existe o CascadeType.ALL, usado
 * para todas as opera��es existentes.
 */

@Entity
@Table(name = "CLIENTES")
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "assento_id", unique = true)
	private Assento assento;
	
	public Cliente() {}
	
	public Cliente(String nome, Assento assento) {
		this.nome = nome;
		this.assento = assento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
}
