package jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPA {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiniMoodleApp");
	private static EntityManager em = emf.createEntityManager();
	
	public static void createRecord(Object object) {
		
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> readRecord(String className) {

		return em.createQuery("SELECT o FROM " + className + " o").getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> readRecordWithParameter(String className, Map<String, Object> parameters) {

		String query = "SELECT o FROM " + className + " o WHERE ";
		
		for(Map.Entry<String, Object> entry : parameters.entrySet()) {
			query += "o." + entry.getKey() + " = " + ":" + entry.getKey() + " and ";
		}
		query = query.substring(0, query.length()-5);
		
		Query q = em.createQuery(query);
		for(Map.Entry<String, Object> entry : parameters.entrySet()) {
			q.setParameter(entry.getKey(), entry.getValue());
		}
		
		return q.getResultList();
		
	}
	
	public static Object readRecordWithID(String className, int id) {
		
		try {
			return em.find(Class.forName(className), id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void updateRecord(Object object) {
		
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		
	}

	public static void deleteRecord(Object object) {
	
		em.getTransaction().begin();
		em.remove(object);
		em.getTransaction().commit();
		
	}

}
