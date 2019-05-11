package cm.objis.wtt.pharmacie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import cm.objis.wtt.pharmacie.domaine.Produit;

public class DaoImpl implements IDao {
	
	private EntityManager em;
	
	public DaoImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public boolean enregistrerProduitDao(Produit produit) {

		try {
			// Etape 1 : Ouverture de la transaction
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			// Etape 2 : Persistance de l'Objet: Création d'un enregistrement dans la base de données 
			em.persist(produit);
		
			// Etape 3 : Validation de la transaction et termine l'EntityManager 
			transaction.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
			
	}

	@Override
	public List<Produit> listProduitDao() {
		
		//création d'une collection de la collection des agriculteurs
		List<Produit> maListProduit= new ArrayList<Produit>();
		
		try {
			// Etape 1 : Obtention de la liste des produits. Une transaction n'est pas necessaire
			maListProduit = em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
		return maListProduit;
		
	}

	@Override
	public Produit rechercheProduitDao(String ref) {
		
		Produit produit= new Produit();
		
		try {
			// Etape 1 : Je fabrique la requête paramétrée de recherche du produit. Une transaction n'est pas necessaire
			Query query = em.createQuery("SELECT p FROM Produit p WHERE p.reference = :ref", Produit.class);
			//Je place la valeur du paramètre
			query.setParameter("ref", ref);

			// Etape 2 : Je récupère le produit correspondant
			produit = (Produit) query.getSingleResult();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		

		return produit;
	}
	
	

	@Override
	public boolean dejaEnregistreDao(String ref){
		boolean result = false;
		Produit produit;

		produit = rechercheProduitDao(ref);

		if (produit != null)  result = true;
		
		return result;
	}

	@Override
	public long nombreProduitDao() {
        long nbProduit = 0;
		
        try {
        	//Etape 1 : Lecture du nombre d'enregistrement en BD. Une transaction n'est pas requise
        	nbProduit = (Long) em.createQuery("SELECT COUNT(p) FROM Produit p").getSingleResult();
        	
        }catch (Exception e) {
        	
			e.printStackTrace();
		}
        
		return nbProduit;
	}
	

	@Override
	public boolean modifierProduitDao(Produit produit) {
		
		try {
			
			// Etape 1 : Je démarre une transaction 
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			//Etape 2 : j'effectue la modification des enregistrements
			em.merge(produit);
			em.flush();
			
			// Etape 3 : Validation de la transaction et termine l'EntityManager 
			transaction.commit(); 
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

}
