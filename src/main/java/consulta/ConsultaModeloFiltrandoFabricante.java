package consulta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaModeloFiltrandoFabricante {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = emf.createEntityManager();
		
		List<String>  modelos = em.createQuery("Select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'VolksWagen'",String.class)
				.getResultList();

		for (String modelo : modelos) {
			System.out.println(modelo);
		}
	}

}
