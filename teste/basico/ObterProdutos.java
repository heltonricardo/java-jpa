package teste.basico;

import java.util.List;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProdutos {

	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> produtos = dao.obterTodos();
		
		for (Produto produto : produtos)
			System.out.println(produto.getId() + ": " +
					produto.getNome() + " (R$ " +
					produto.getPreco() + ")");
		
		double pretoTotal = produtos
				.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (t, p) -> t + p)
				.doubleValue();
		
		System.out.printf("Preço total: R$ %.2f", pretoTotal);
		
		dao.fechar();
	}
}
