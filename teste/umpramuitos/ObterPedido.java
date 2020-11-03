package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorId(1L);
		
		System.out.println("Pedido " + pedido.getId() + ":");
		for (ItemPedido item: pedido.getItens())
			System.out.printf("* %2d - %s", item.getQuantidade(),
					item.getProduto().getNome());
		
		dao.fechar();
	}
}
