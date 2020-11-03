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
 * A propriedade fetch pode ser usada sempre que há relacionamentos entre as
 * entidades. Ela denota a prioridade com que os dados de entidades
 * relacionadas são trazidos para a aplicação quando há pesquisa de um atributo
 * com anotação de relacionamento. Usando essa entidade como exemplo: pedido
 * possui uma lista de itens, sendo uma relação de um para muitos, por padrão,
 * quando um pedido é acessado o java não traz os dados dos itens a ele
 * relacionados. O JPA traz automaticamente apenas os dados de relacionamentos
 * que terminam com um (um para um e muitos para um, usando relacão
 * bidirecional), os itens serão somente recuperados do banco caso haja
 * interação com eles. Usando fetch como EAGER fará com que todos os itens
 * do pedido sejam trazidos do banco juntamente com os dados do pedido. Para
 * alterar o comportamento padrão dos relacionamentos terminados em um, basta
 * utilizar fetch = FetchType.LAZY para que os dados não sejam carregados
 * automaticamente. Quando o EAGER está ativado, os dados dos relacionamentos
 * são trazidos NA MESMA PESQUISA que os da entidade principal (mais rápido),
 * mas se forem muitos dados, pode haver demora já que esse instrumento pode
 * ser usado recursivamente entre as dependências de cada entidade. É
 * importante salientar que no caso de LAZY, o EntityManager ainda deve estar
 * aberto para que consiga trazer os dados de forma tardia. Nesse caso
 * específico foi julgado que, na maioria das vezes, sempre que consultarmos
 * um pedido também iremos consultar seus respectivos itens.
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
