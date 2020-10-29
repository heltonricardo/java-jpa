package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		Produto produto = new Produto("Monitor", 799.99);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.incluirAtomico(produto).fechar();
		
		System.out.println("Id do produto: " + produto.getId());
	}
}
