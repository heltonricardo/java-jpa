package modelo.umpraum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Para criar a relação bidirecional usamos a notação @OneToOne em um novo
 * atributo na entidade Assento. A anotação simples fará com que sejam criados
 * novos atributos/chaves estrangeiras em ambas as entidades (o que
 * proporciona grande possibilidade de inconsistência de dados), por isso
 * usamos a propriedade mappedBy. Nela é informado o atributo que conterá a
 * relação um pra um na outra tabela, permitindo o uso da bidirecionalidade com
 * a criação de chave chave estrangeira somente em uma das tabelas (na que não
 * contém o mappedBy).
 */

@Entity @Table(name = "ASSENTOS")
public class Assento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToOne(mappedBy = "assento")
	private Cliente cliente;

	public Assento() {}
	
	public Assento(String nome) {
		this.nome = nome;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
