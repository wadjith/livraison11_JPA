package cm.objis.wtt.pharmacie.service;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;

/**
 * 
 * Interface de service de sur les produits
 * 
 * @author thierry WADJI
 *
 */
public interface IService {

	/**
	 * Méthode d'enregistrement de produit
	 * 
	 * @param produit est un objet de la classe Produit
	 */
	public boolean enregistrerProduitService(Produit produit);

	/**
	 * Méthode de listing des produits enregistrés en BD
	 * 
	 * @return List de Produit
	 */
	public List<Produit> listProduitService();

	/**
	 * Méthode de recherche de produit par sa référence
	 * 
	 * @param ref reférence du produit
	 * @return Produit objet de la classe Produit
	 */
	public Produit rechercheProduitService(String ref);

	/**
	 * Méthode qui vérifie si un produit de reférence donnée est déjà enregistré en
	 * BD
	 * 
	 * @param ref référence du produit
	 * @return true si le produit est dejà enregistrée en BD et false au cas
	 *         contraire
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public boolean dejaEnregistreService(String ref);

	/**
	 * Calcul le nombre d'enregistrement de produit
	 * 
	 * @return long nombre de produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public long nombreProduitService();
	
	/**
	 * Méthode de modification d'un produit
	 * 
	 * @param produit est un objet de la classe Produit
	 * @throws SQLException est générée s'il y'a une erreur
	 */
	public boolean modifierProduitService(Produit produit);

}
