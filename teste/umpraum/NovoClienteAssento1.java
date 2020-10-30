package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

/*
 * Como o cliente depende do pré-cadastro do assento, o assento deve ser
 * persistido antes do seu respectivo cliente. Ou seja, um assento pode ser
 * cadastrado em uma transação anterior à transação referente ao cliente ou no
 * máximo na mesma transação do cliente, como foi exemplificado abaixo:.
 */

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("H13");
		Cliente cliente = new Cliente("Helton", assento);
		
		DAO<Object> dao = new DAO<Object>();
		dao.abrirTransacao()
			.incluir(assento)
			.incluir(cliente)
			.fecharTransacao()
			.fechar();
		
	}
}
