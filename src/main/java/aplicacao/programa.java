package aplicacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;
import dominio.Produto;

public class programa {

	public static void main(String[] args) {
		/* Cria o banco a tabela e salva os dados */
		Pessoa p1 = new Pessoa(null, "Teste1", "teste1@gmail");
		Pessoa p2 = new Pessoa(null, "Teste2", "teste2@gmail");
		Pessoa p3 = new Pessoa(null, "teste3", "teste3@gmail");
		
		List<Pessoa> aPessoa = new ArrayList<>();
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
		 
		/*Busca os dados no banco de dados */
		
		EntityManagerFactory emfb = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager emb = emfb.createEntityManager();
		
		
		for(int i = 0;i<50;i++) {
			
				
			
			Pessoa pb = emb.find(Pessoa.class,i);
			if(pb != null) {
			aPessoa.add(pb);
			em.close();
			emf.close();
			}
		}

		
		/*Exclui itens monitorados(objeto buscado anteriormente)*/
		
		for(Pessoa p : aPessoa){
			if (p.getId() % 2 == 0 && p != null) {
				
				EntityManagerFactory emfex = Persistence.createEntityManagerFactory("exemplo-jpa");
				EntityManager emex = emfex.createEntityManager();
				
				Pessoa pex = emex.find(Pessoa.class, p.getId());
				
				emex.getTransaction().begin();
				emex.remove(pex);
				emex.getTransaction().commit();
				
				System.out.println("Excluido!!!");
				emex.close();
				emfex.close(); 
			}
		}
		
		/*
		Produto pro1 = new Produto("URT123", "Produto de venda","PC","CARREGADOR", 1,10);
		
		EntityManagerFactory emfpro = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager empro = emfpro.createEntityManager();
		empro.getTransaction();
		empro.persist(pro1);
		empro.getTransaction().commit();
		emfpro.close();
		emfpro.close();
		System.out.println("OK!");
		*/
	}

}
