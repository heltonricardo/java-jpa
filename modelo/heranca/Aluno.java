package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * A Anota��o Inheritance serve para definir heran�a. Se n�o houver essa
 * anota��o ser� criada uma �nica tabela com todos os atributos de todas as
 * entidades. As correspond�ncias que n�o possu�rem determinado campo, ter�o
 * esse campo com valor nulo. Abaixo seguem as diferentes estrat�gias que podem
 * ser usadas para modificar o resultado no modelo de banco de dados gerado:
 * 
 * TABLE_PER_CLASS: para cada entidade � criada uma tabela diferente no banco.
 * A superclasse possuir� apenas seus atributos e a subclasse possuir�, al�m de
 * seus atributos, os atributos da classe m�e.
 * 
 * SINGLE_TABLE (op��o padr�o): � o mesmo funcionamento para quando n�o existe
 * a anota��o de heran�a - Inheritance 
 *
 * JOINED: para cada entidade � criada uma tabela diferente no banco. Cada
 * classe possui somente seus pr�prios atributos, sendo que e a subclasse
 * possuir�, no banco de dados, um campo que relaciona cada registro dessa
 * tabela com um registro da tabela da entidade m�e (rela��o um pra um). Nesse
 * caso, a tabela da entidade AlunoBolsista possuir� os campos valorBolsa e a
 * matr�cula do aluno registrado na tabela Aluno.
 * 
 * ----------------------------------------------------------------------------
 * 
 * _IMPORTANTE_: Quando usamos SINGLE_TABLE E JOINED tamb�m � poss�vel criar um
 * campo descriminador que identificar� qual � a entidade que cada um dos
 * registros pertence. O DiscriminatorColumn � usado na entidade m�e e define o
 * nome, tipo e tamanho desse campo. Ent�o, no DiscriminatorValue de cada
 * entidade que faz parte da heran�a � informado o valor, respeitando as regras
 * definidas na anota��o anterior. 
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
		name = "tipo",
		discriminatorType = DiscriminatorType.STRING,
		length = 2
)
@DiscriminatorValue("AL")
public class Aluno {

	@Id
	private Long matricula;
	
	private String nome;
	
	public Aluno() {}

	public Aluno(Long matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
