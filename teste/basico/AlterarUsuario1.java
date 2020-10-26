package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setNome("Duda");
		usuario.setEmail("duda@email.com");
		
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}