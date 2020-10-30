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
 * JoinColumn serve para mapear campos que definem junções de tabelas
 * Unique serve para definir que o assento é único para cada cliente, ou seja,
 * não podem existir duas ou mais pessoas relacionadas a um mesmo assento.
 * 
 * Cascade é usada para que durante a persistência de um objeto, sejam feitas
 * as persistências de objetos relacionados a ele automaticamente. É possível
 * usar cascade = {CascadeType.PERSIST, CascadeType.MERGE} para atualizar na
 * criação e alteração (então separa com vírgulas). No caso de somente uma
 * propriedade, o uso é como abaixo. Também existe o CascadeType.ALL, usado
 * para todas as operações existentes.
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
