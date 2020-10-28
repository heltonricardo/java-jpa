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
	 * � poss�vel usar nomes diferentes na classe e na entidade atrav�s da
	 * notation @Table 
	 * 
	 * O padr�o do length � 255 para string. Se o JPA criar a tabela, ele usar�
	 * os padr�es definidos nas anota��es, mas se caso o banco j� existir, o
	 * JPA n�o alterar� as tabelas e nem aplicar� uma verifica��o nos dados.
	 * Portanto, essas notations servem somente para o caso da cria��o do banco
	 * e auxiliam na gera��o da documenta��o.
	 * 
	 * Precision: quantidade total de d�gitos em um n�mero (inteira + decimal)
	 * Scale: quantidade de casas decimais. Ent�o a parte inteira ser� igual a
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
