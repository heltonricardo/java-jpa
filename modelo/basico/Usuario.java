package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @Entity é usada para relacionar a classe com uma tabela no banco de dados
 * @Id define qual atributo será chave primária
 * 
 * As colunas seguem padrões que já foram estabelecidos, como mesmo nome.
 * Para trocar isso ou adicionar restrições usamos @Column. Exemplo:
 * @Column(name = "nome", nullable = false)
 * private String nomeUsuario;
 * 
 * Caso queira que um atributo não tenha correspondente no banco basta usar:
 * @Transient
 * 
 * Lembrando que todas as anotações são de javax.persistense
 */

@Entity
public class Usuario {

	@Id
	private Long id;
	private String nome;
	private String email;
	
	public Usuario() {}
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
