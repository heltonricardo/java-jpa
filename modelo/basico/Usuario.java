package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * @Entity � usada para relacionar a classe com uma tabela no banco de dados
 * @Id define qual atributo ser� chave prim�ria
 * 
 * @GeneratedValue define auto incremento. Sem par�metros ela usar� a
 * estrat�gia AUTO/SEQUENCE, que compartilha o Id com outras tabelas atrav�s da
 * cria��o de uma tabela adicional para controlar o pr�ximo Id. Para ter um Id
 * �nico para cada tabela, usar strategy = GenerationType.IDENTITY
 * 
 * As colunas seguem padr�es que j� foram estabelecidos, como mesmo nome.
 * Para trocar isso ou adicionar restri��es usamos @Column. Exemplo:
 * @Column(name = "nome", nullable = false)
 * private String nomeUsuario;
 * 
 * Caso queira que um atributo n�o tenha correspondente no banco basta usar:
 * @Transient
 * 
 * Lembrando que todas as anota��es s�o de javax.persistense
 */

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
