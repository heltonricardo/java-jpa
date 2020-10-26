package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	/* Mesmo não chamando o merge() os dados alterados de um usuário são
	 * refletidos no banco de dados somente por chamar begin e commit.
	 * Isso acontece pois a entidade Usuario está no estado GERENCIADO, e
	 * é essa característica que diferencia e ocasiona esse comportamento.
	 * Os dados alterados nos objetos também serão alterados no banco, isso
	 * quer dizer que esse programa, quando executado, alterará o nome do
	 * usuário cujo Id é 1 para "Nome alterado". A seguir veremos como é
	 * possível desativar essa sincronização automática, e fazê-la somente
	 * de forma manual.
	 */

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setNome("Nome alterado");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
