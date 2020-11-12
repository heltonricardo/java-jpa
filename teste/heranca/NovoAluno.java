package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno(123L, "Ana");
		AlunoBolsista aluno2 = new AlunoBolsista(456L, "Leo", 1000);
		
		DAO<Aluno> dao = new DAO<>();
		
		dao.incluirAtomico(aluno1);
		
		// Podemos usar o mesmo DAO pois um aluno bolsista também é um aluno:
		dao.incluirAtomico(aluno2);
		
		dao.fechar();
	}
}
