package modelo.umpramuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * A propriedade fetch pode ser usada sempre que h� relacionamentos entre as
 * entidades. Ela denota a prioridade com que os dados de entidades
 * relacionadas s�o trazidos para a aplica��o quando h� pesquisa de um atributo
 * com anota��o de relacionamento. Usando essa entidade como exemplo: pedido
 * possui uma lista de itens, sendo uma rela��o de um para muitos, por padr�o,
 * quando um pedido � acessado o java n�o traz os dados dos itens a ele
 * relacionados. O JPA traz automaticamente apenas os dados de relacionamentos
 * que terminam com um (um para um e muitos para um, usando relac�o
 * bidirecional), os itens ser�o somente recuperados do banco caso haja
 * intera��o com eles. Usando fetch como EAGER far� com que todos os itens
 * do pedido sejam trazidos do banco juntamente com os dados do pedido. Para
 * alterar o comportamento padr�o dos relacionamentos terminados em um, basta
 * utilizar fetch = FetchType.LAZY para que os dados n�o sejam carregados
 * automaticamente. Quando o EAGER est� ativado, os dados dos relacionamentos
 * s�o trazidos NA MESMA PESQUISA que os da entidade principal (mais r�pido),
 * mas se forem muitos dados, pode haver demora j� que esse instrumento pode
 * ser usado recursivamente entre as depend�ncias de cada entidade. �
 * importante salientar que no caso de LAZY, o EntityManager ainda deve estar
 * aberto para que consiga trazer os dados de forma tardia. Nesse caso
 * espec�fico foi julgado que, na maioria das vezes, sempre que consultarmos
 * um pedido tamb�m iremos consultar seus respectivos itens.
 */

@Entity
@Table(name = "PEDIDOS")
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ItemPedido> itens;

	public Pedido() {
		this(new Date());
	}
	
	public Pedido(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
}
