package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * A Anotação Inheritance serve para definir herança. Se não houver essa
 * anotação será criada uma única tabela com todos os atributos de todas as
 * entidades. As correspondências que não possuírem determinado campo, terão
 * esse campo com valor nulo. Abaixo seguem as diferentes estratégias que podem
 * ser usadas para modificar o resultado no modelo de banco de dados gerado:
 * 
 * TABLE_PER_CLASS: para cada entidade é criada uma tabela diferente no banco.
 * A superclasse possuirá apenas seus atributos e a subclasse possuirá, além de
 * seus atributos, os atributos da classe mãe.
 * 
 * SINGLE_TABLE (opção padrão): é o mesmo funcionamento para quando não existe
 * a anotação de herança - Inheritance 
 *
 * JOINED: para cada entidade é criada uma tabela diferente no banco. Cada
 * classe possui somente seus próprios atributos, sendo que e a subclasse
 * possuirá, no banco de dados, um campo que relaciona cada registro dessa
 * tabela com um registro da tabela da entidade mãe (relação um pra um). Nesse
 * caso, a tabela da entidade AlunoBolsista possuirá os campos valorBolsa e a
 * matrícula do aluno registrado na tabela Aluno.
 * 
 * ----------------------------------------------------------------------------
 * 
 * _IMPORTANTE_: Quando usamos SINGLE_TABLE E JOINED também é possível criar um
 * campo descriminador que identificará qual é a entidade que cada um dos
 * registros pertence. O DiscriminatorColumn é usado na entidade mãe e define o
 * nome, tipo e tamanho desse campo. Então, no DiscriminatorValue de cada
 * entidade que faz parte da herança é informado o valor, respeitando as regras
 * definidas na anotação anterior. 
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
