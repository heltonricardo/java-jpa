package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {

	/* A fun��o detach � usada para desassociar o objeto com o banco, em outras
	 * palavras: desativa a sincroniza��o autom�tica dos dados alterados no
	 * objeto. Nesse contexto, a atualiza��o somente ser� concretizada quando a
	 * fun��o merge for chamada.
	 */
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 1L);
		em.detach(usuario);
		
		usuario.setNome("Vick");
		em.merge(usuario);
		// O merge armazena as altera��es que foram feitas at� ele e as \
		// realiza no pr�ximo commit:
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
