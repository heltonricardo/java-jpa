package modelo.composicao;

import javax.persistence.Embeddable;

/*
 * A anotação Embeddable significa que essa entidade não gerará uma nova tabela
 * no banco de dados. As informações contidas aqui serão inseridas diretamente
 * nas entidades que usarem instâncias de Endereco, nesse caso. 
 */

@Embeddable
public class Endereco {

	private String logradouro;
	private String complemento;
	
	public Endereco() {}
	
	public Endereco(String logradouro, String complemento) {
		this.logradouro = logradouro;
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
