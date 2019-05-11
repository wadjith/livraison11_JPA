/**
 * 
 */
package cm.objis.wtt.pharmacie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageDaoImpl implements IParametrageDAO {
	
	private EntityManager em;
	

	public ParametrageDaoImpl(EntityManager em) {
		super();
		this.em = em;
	}


	@Override
	public boolean enregistreUtilisateur(Utilisateur user) {
		
		try {
			// Etape 1 : Ouverture de la transaction
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			// Etape 2 : Persistance de l'Objet: Création d'un enregistrement dans la base de données 
			em.persist(user);
		
			// Etape 3 : Validation de la transaction et termine l'EntityManager 
			transaction.commit();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	
	@Override
	public boolean modifieUtilisateur(Utilisateur user) {
		
		try {
			
			// Etape 1 : Je démarre une transaction 
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			//Etape 2 : j'effectue la modification des enregistrements
			em.merge(user);
			em.flush();
			
			// Etape 3 : Validation de la transaction et termine l'EntityManager 
			transaction.commit(); 
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public Utilisateur rechercheUtilisateur(String login, String password) {
		//création d'un objet utilisateur null
		Utilisateur user = null;
		
		try {
			//Etape 1 : Je prépare la requête de sélection
			Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :pswd", Utilisateur.class);
			query.setParameter("login", login);
			query.setParameter("pswd", password);
			
			//Etape 2 : J'exécute la requête
			user = (Utilisateur) query.getSingleResult();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
		return user;
	}

	@Override
	public int verifieLogin(String login) {
		int nb = 0;
		
		try {
			//Etape 1 : Je prépare la requête 
			Query query = em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE login = :login");
			query.setParameter("login", login);
			
			//Etape 2 : J'exécute la requête
			nb = (Integer) query.getSingleResult();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}

		return nb;
	}
	
	/**
	 * @return
	 */
	private static java.sql.Date getCurrentDate() {
		
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	
	@Override
	public List<Utilisateur> listUtilisateurs() {
		//création d'une collection des utilisateurs
		List<Utilisateur> userList = new ArrayList<Utilisateur>();
		
		try {
			//Etape 1 : Récupération de la liste des utilisateurs
			userList = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
				
		return userList;
	}


}
