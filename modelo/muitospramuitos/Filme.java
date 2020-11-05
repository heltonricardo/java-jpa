package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * JoinTableserve para definir detalhes sobre a nova entidade que será gerada a
 * partir de um relacionamento N para N. "name" define o nome para a tabela,
 * quando não queremos usar o nome padrão do JPA. Para definir as colunas que
 * serão criadas na tabela de relacionamento, usamos a propriedade joinColumns,
 * que refere-se ao campo da entidade atual, e a inverseJoinClomns que refere-
 * se à outra entidade. A primeira propriedade informada é o nome para o campo
 * no banco de dados e o segundo é o nome do atributo criado na entidade.
 */

@Entity @Table(name = "FILMES")
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "PERSONAGENS",
			joinColumns =
				@JoinColumn(name = "filme_id", referencedColumnName = "id"),
			inverseJoinColumns = 
				@JoinColumn(name = "ator_id", referencedColumnName = "id")
	)
	private List<Ator> atores;
	
	public Filme() {}

	public Filme(String nome, Double nota) {
		this.nome = nome;
		this.nota = nota;
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
	
	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if (atores == null)
			atores = new ArrayList<>();
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	public void adicionarAtor(Ator ator) {
		if (ator != null && !getAtores().contains(ator)) {
			atores.add(ator);
			
			if (!ator.getFilmes().contains(this))
				ator.getFilmes().add(this);
		}
	}
}
