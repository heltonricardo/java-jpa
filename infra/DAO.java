package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	/*
	 * Um bloco static é executado somente uma vez, quando a classe é carregada
	 * pelo Java. Nesse caso foi usado para inicializar as variáveis estáticas
	 * que também poderiam ser inicializadas durante a declaração.
	 */
	
	static {
		try {
			emf = Persistence
					.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) { }
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E objeto) {
		em.persist(objeto);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento) {
		if (classe == null)
			throw new UnsupportedOperationException("Classe nula.");
		
		String jpql = "SELECT e FROM " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public void fechar() {
		em.close();
	}
}
