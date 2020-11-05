package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * O mappedBy � usado no lado oposto o qual cont�m a rela��o principal. Nesse
 * exemplo ele est� sendo usado na entidade Sobrinho, isso significa que a
 * entidade Tio cont�m o relacionamento principal, gerando o nome da nova
 * tabela no banco como TIO_SOBRINHO (e n�o o inverso). Como j� foi informado,
 * o mappedBy proporcionar� a rela��o bidirecional dentro do Java.
 */

@Entity
@Table(name = "SOBRINHOS")
public class Sobrinho {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "sobrinhos")
	private List<Tio> tios = new ArrayList<>();
	
	public Sobrinho() {}

	public Sobrinho(String nome) {
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

	public List<Tio> getTios() {
		return tios;
	}

	public void setTios(List<Tio> tios) {
		this.tios = tios;
	}
}
