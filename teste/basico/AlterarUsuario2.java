package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	/* Mesmo n�o chamando o merge() os dados alterados de um usu�rio s�o
	 * refletidos no banco de dados somente por chamar begin e commit.
	 * Isso acontece pois a entidade Usuario est� no estado GERENCIADO, e
	 * � essa caracter�stica que diferencia e ocasiona esse comportamento.
	 * Os dados alterados nos objetos tamb�m ser�o alterados no banco, isso
	 * quer dizer que esse programa, quando executado, alterar� o nome do
	 * usu�rio cujo Id � 1 para "Nome alterado". A seguir veremos como �
	 * poss�vel desativar essa sincroniza��o autom�tica, e faz�-la somente
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
