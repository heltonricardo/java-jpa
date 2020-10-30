package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

/*
 * Para que seja possível persistir diretamente um objeto que depende de outro
 * sem antes ter persistido esse segundo, deve-se adicionar a propriedade
 * cascade na anotação OneToOne do atributo identificador do relacionamento.
 * Verificar a exemplificação no arquivo modelo.umpraum.Cliente.
 */
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Carlos", new Assento("C51"));
		
		DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
		
		dao.incluirAtomico(cliente).fechar();
	}
}
