package modelo.composicao;

import javax.persistence.Embeddable;

/*
 * A anota��o Embeddable significa que essa entidade n�o gerar� uma nova tabela
 * no banco de dados. As informa��es contidas aqui ser�o inseridas diretamente
 * nas entidades que usarem inst�ncias de Endereco, nesse caso. 
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
