/**
 * @author Cory Howard - clhoward1
 * CIS175 - Spring 2024
 * Feb 1, 2024
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListTanks;

public class ListTanksHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TankList");
	
	
	/**
	 * Inserts tank record into database
	 */
	public void insertTank(ListTanks li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Returns list of all records
	 */
	public List<ListTanks> showAllTanks(){
		EntityManager em = emfactory.createEntityManager();
		List<ListTanks> allTanks = em.createQuery("SELECT i FROM ListTanks i").getResultList();
		return allTanks;
		}
	
	/**
	 * Deletes record of specified tank
	 */
	public void deleteTank(ListTanks toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTanks> typedQuery = 
				em.createQuery("select li from ListTanks li where li.country = :selectedCountry and li.model = :selectedModel and li.gunCaliber = :selectedGunCaliber", ListTanks.class);

		typedQuery.setParameter("selectedCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedGunCaliber", toDelete.getGunCaliber());

		typedQuery.setMaxResults(1);

		ListTanks result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}


	/**
	 * Searches for tanks by row ID and returns
	 */
	public ListTanks searchForTankById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListTanks foundID = em.find(ListTanks.class, idToEdit);
		em.close();
		return foundID;
	}

	/**
	 * Updates tank in database
	 */
	public void updateTank(ListTanks toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	/**
	 * Searches for tanks by country and returns list
	 */
	public List<ListTanks> searchForTankByCountry(String country) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTanks> typedQuery = 
				em.createQuery("select li from ListTanks li where li.country = :selectedCountry", ListTanks.class);
		typedQuery.setParameter("selectedCountry", country);
		List<ListTanks> foundTanks = typedQuery.getResultList();
		em.close();
		return foundTanks;
	}

	/**
	 * Searches for tanks by model name and returns list
	 */
	public List<ListTanks> searchForTankByModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTanks> typedQuery = em.createQuery("select li from ListTanks li where li.model = :selectedModel", ListTanks.class);
		typedQuery.setParameter("selectedModel", model);
		List<ListTanks> foundTanks = typedQuery.getResultList();
		em.close();
		return foundTanks;
	}
	
	
	/**
	 * Searches for tanks by gun caliber and returns list
	 */
	public List<ListTanks> searchForTankByGunCaliber(String gunCaliber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTanks> typedQuery = em.createQuery("select li from ListTanks li where li.gunCaliber = :selectedGunCaliber", ListTanks.class);
		typedQuery.setParameter("selectedGunCaliber", gunCaliber);
		List<ListTanks> foundTanks = typedQuery.getResultList();
		em.close();
		return foundTanks;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
