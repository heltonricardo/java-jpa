package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

/*
 * Como o cliente depende do pr�-cadastro do assento, o assento deve ser
 * persistido antes do seu respectivo cliente. Ou seja, um assento pode ser
 * cadastrado em uma transa��o anterior � transa��o referente ao cliente ou no
 * m�ximo na mesma transa��o do cliente, como foi exemplificado abaixo:.
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
