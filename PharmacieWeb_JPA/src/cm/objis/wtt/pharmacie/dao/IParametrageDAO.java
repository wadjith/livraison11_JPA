/**
 * 
 */
package cm.objis.wtt.pharmacie.dao;

import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public interface IParametrageDAO {
			
	/**
	 * @param user
	 */
	public boolean enregistreUtilisateur(Utilisateur user);
	
	/**
	 * Liste des utilisateurs
	 * 
	 * @return List<Utilisateur>
	 */
	public List<Utilisateur> listUtilisateurs();
	
	
	/**
	 * @param user
	 */
	public boolean modifieUtilisateur(Utilisateur user);
	
	/**
	 * @param login
	 * @param password
	 * @return Utilisateur
	 */
	public Utilisateur rechercheUtilisateur(String login, String password);
	
	/**
	 * Vérifie que le login renseigne existe dejà, en renvoyant un nombre entier qui représente le nombre d'occurence dans la BD
	 * 
	 * @param login : Nom d'utilisateur 
	 * @return
	 */
	public int verifieLogin(String login);
}
