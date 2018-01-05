package modeloLazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import dao.CarroDAO;
import modelo.Carro;
//LAZYDATAMODEL É UMA CLASSE PROPRIETARIA DO PRIMEFACES
public class LazyCarroDataModel extends LazyDataModel<Carro> implements Serializable{

	private CarroDAO carroDAO;
	
	public LazyCarroDataModel(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}
	//load é um metodo sobrescrito;
	@Override
	public List<Carro> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, String> filters) {
		
			List<Carro> carros = this.carroDAO.buscarComPaginacao(first, pageSize);
			
			this.setRowCount(this.carroDAO.encontrarQuantidadeCarros().intValue());
			
			return carros;
		
	}
}
