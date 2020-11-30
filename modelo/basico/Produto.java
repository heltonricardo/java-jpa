package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto {
	
	/*
	 * É possível usar nomes diferentes na classe e na entidade através da
	 * propriedade name da notação @Table. 
	 * 
	 * O padrão do length é 255 para string. Se o JPA criar a tabela, ele usará
	 * os padrões definidos nas anotações, mas se caso o banco já existir, o
	 * JPA não alterará as tabelas e nem aplicará uma verificação nos dados.
	 * Portanto, essas notations servem somente para o caso da criação do banco
	 * e auxiliam na geração da documentação.
	 * 
	 * Precision: quantidade total de dígitos em um número (inteira + decimal)
	 * Scale: quantidade de casas decimais. Então a parte inteira será igual a
	 * precision menos scale.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private Long id;
	
	@Column(name = "PROD_NOME", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "PROD_PRECO", nullable = false, precision = 11,  scale = 2)
	private Double preco;
	
	public Produto() {}
	
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
