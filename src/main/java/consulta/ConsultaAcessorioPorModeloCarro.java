package consulta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaAcessorioPorModeloCarro {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager em = emf.createEntityManager();
		
		//Selecione o 'a' é uma variavel de acessorio, e o 'c' de carro, o join une os dois atraves,
		// do c.acessorios ele navega ate o Acessorio e declara o 'a' que esta com a descrição citada no inicio,
		//ou seja fica c.acessorios de a, que significa c.acessorios de a.descricao una acessoio e descricao;
		String jpql = "select a.descricao from Carro c JOIN c.acessorios a where c.modelo.descricao= 'HondaCivic'";
		
		
		List<String> acessorios = em.createQuery(jpql, String.class).getResultList();
		for (String acessorio : acessorios) {
			
			System.out.println("Acessório: " + acessorio);
		}
		
		em.close();

	}	

}
