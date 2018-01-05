package consulta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaPassandoParametros {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = emf.createEntityManager();
		// o :modelo é um parametro que vai ser setado no setParameter, o : transforma ele em parametro
		//setParameter(posicao, valor), ou seja o :modelo vai ser cada posicao do modelo existente e a
		// variavel modelo = "HondaCivic" vai ser a variavel que ela vai verificar
		String modelo = "Honda";
		
		String jpql = "select mc.descricao from ModeloCarro mc  "
				       + "where mc.fabricante.nome = :modelo";
		
		List<String> modelos = em.createQuery(jpql, String.class).setParameter("modelo", modelo)
				.getResultList();
		
		for (String m : modelos) {
			System.out.println(m);
		}
		
		em.close();
	}

}
