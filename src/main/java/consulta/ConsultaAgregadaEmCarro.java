package consulta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Carro;

public class ConsultaAgregadaEmCarro {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select  c, count(a), max(a.valorTotal), avg(a.valorTotal) "
				+ "from Carro c JOIN c.alugueis a "
				+ "group by c";
		
		List<Object[]> resultados = em.createQuery(jpql).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("Modelo: " + ((Carro)obj[0]).getModelo().getDescricao());
			System.out.println("Quantidade de alugueis: " + obj[1]);
			System.out.println("Valor maximo: " + obj[2]);
			System.out.println("Valor medio: " + obj[3]);
		}
			em.close();
	}

}
