package cm.objis.wtt.pharmacie.dao;

import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;


/**
 * 
 * Interface de communication avec la BD 
 * @author thierry WADJI
 *
 */
public interface IDao {
	
	
	
	/**
	 * Enregistre un produit dans la BD
	 * @param produit est un objet de type Produit
	 */
	public boolean enregistrerProduitDao(Produit produit);
	
	/**
	 * 
	 * Liste les produits de la BD
	 * 
	 * @return List de Produit
	 */
	public List<Produit> listProduitDao();
	
	
	/**
	 * @param ref reférene du Produit
	 * @return Produit
	 */
	public Produit rechercheProduitDao(String ref);
	
	
	/**
	 * Verifie si un produit de reference donnée est dejà enregistré dans la BD
	 * 
	 * @param ref reférence du produit
	 * @return True si un produit de reference(ref) esr dejà en BD ou False sinon 
	 */
	public boolean dejaEnregistreDao(String ref);
	
	
	/**
	 * Calcul le nombre de produit dans la BD
	 * 
	 * @return long
	 */
	public long nombreProduitDao();
	
	/**
	 * Modifie un produit sélectionné
	 * 
	 * @param produit un objet de type Produit 
	 */
	public boolean modifierProduitDao(Produit produit);

}
