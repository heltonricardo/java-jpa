package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		Filme filme1 = new Filme("Star Wars", 4.5);
		Filme filme2 = new Filme("O fugitivo", 5.0);
		
		Ator ator1 = new Ator("Harrison Ford");
		Ator ator2 = new Ator("Carrie Fisher");
		
		filme1.adicionarAtor(ator1);
		filme1.adicionarAtor(ator2);
		
		filme2.adicionarAtor(ator1);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(filme1).fechar();
	}
}
