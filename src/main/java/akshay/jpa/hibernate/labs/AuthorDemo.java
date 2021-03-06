package akshay.jpa.hibernate.labs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import akshay.jpa.hibernate.labs.entities.Author;


public interface AuthorDemo {
public static void main(String[] args) {
		
		System.out.println("Start");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abcd");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		Author emp1 = new Author(101,"Akshay","Abhay","Bhanushali",8569321475l);
		Author emp2 = new Author(102,"Gunnu","Mala","Paranjape",7852369814l);
		Author emp3 = new Author(103,"Shubham","Sahil","Gujjar",9863217485l);
		
		em.persist(emp1);  //insert
		em.persist(emp2);
		em.persist(emp3);
		
//		em.remove(emp2);
		
		// Updating record
//		emp1.setFirstName("MonaLisa");
//		em.merge(emp1);    //Update
		
		// Displaying record
		Author aut = em.find(Author.class, 101);   //Select
		System.out.println(aut.toString());
		
		tr.commit();
		System.out.println("End");
}
}
