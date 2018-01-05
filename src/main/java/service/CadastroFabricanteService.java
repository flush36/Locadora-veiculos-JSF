package service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.util.jpa.Transactional;

import dao.FabricanteDAO;
import modelo.Fabricante;

public class CadastroFabricanteService implements Serializable {

	@Inject
	private FabricanteDAO fabricanteDAO;
	
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) { 
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}
	
}
