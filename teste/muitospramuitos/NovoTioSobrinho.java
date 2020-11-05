package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		
		Tio tia = new Tio("Maria");
		Tio tio = new Tio("João");
		
		Sobrinho sobrinho = new Sobrinho("Junior");
		Sobrinho sobrinha = new Sobrinho("Ana");
		
		tia.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tia);
		
		tia.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tia);
		
		tio.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tio);
		
		tio.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tio);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransacao()
			.incluir(tia)
			.incluir(tio)
			.incluir(sobrinho)
			.incluir(sobrinha)
			.fecharTransacao().fechar();
	}
}
