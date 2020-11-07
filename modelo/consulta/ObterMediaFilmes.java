package modelo.consulta;

import infra.DAO;

public class ObterMediaFilmes {

	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		NotaFilme nota = dao.consultarUm("mediaGeral");
		
		System.out.println(nota.getMedia());
		
		dao.fechar();
	}
}
