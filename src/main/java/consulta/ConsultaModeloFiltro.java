package consulta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Carro;

public class ConsultaModeloFiltro {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = emf.createEntityManager();
		
		// BUSCA NO MODELOFABRICANTE o nome do fabricante Honda onde a categoria esta nos itens citados abaixo
		String jpql ="select mc.descricao from ModeloCarro mc"
				+ " where mc.fabricante.nome= 'Honda' and mc.categoria in ('HATCH_COMPACTO', 'SEDAN_GRANDE', 'MINIVAN')";
		
		List<String> modelos = em.createQuery(jpql).getResultList();
		
		
		//QUANDO SE PASSA MAIS DE UM VALOR É RETORNADO UM ARRAY DE OBJECT, COM O GETRESULTLIST FICA UMA LIST<OBJECT[]>;
		String jpql2 = "select car.cor, car.modelo.descricao, car.placa from Carro car" + " where car.valorDiaria > 100" ;
		
					List<Object[]>listaCarro =  em.createQuery(jpql2).getResultList();
		
					for (Object[] obj : listaCarro) {
						System.out.println("Descrição: " + obj[0] + " E Categoria: " + obj[1] + " E Placa: " + obj[2]);
					}
					em.close();
					


	}

}
