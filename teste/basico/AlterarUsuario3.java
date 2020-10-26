package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {

	/* A função detach é usada para desassociar o objeto com o banco, em outras
	 * palavras: desativa a sincronização automática dos dados alterados no
	 * objeto. Nesse contexto, a atualização somente será concretizada quando a
	 * função merge for chamada.
	 */
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 1L);
		em.detach(usuario);
		
		usuario.setNome("Vick");
		em.merge(usuario);
		// O merge armazena as alterações que foram feitas até ele e as \
		// realiza no próximo commit:
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
