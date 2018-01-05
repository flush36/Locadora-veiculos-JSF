package service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.util.jpa.Transactional;

import dao.CarroDAO;
import modelo.Carro;

public class CadastroCarroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO carroDAO;
	
	@Transactional
	public void salvar(Carro carro) throws NegocioException {
		
		if (carro.getPlaca() == null || carro.getPlaca().trim().equals("")) {
			throw new NegocioException("A placa é obrigatória");
		}
		
		this.carroDAO.salvar(carro);
	}

}
