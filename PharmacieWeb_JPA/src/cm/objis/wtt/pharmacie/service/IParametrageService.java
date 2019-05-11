/**
 * 
 */
package cm.objis.wtt.pharmacie.service;

import java.util.List;
import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * Les exceptions seront logges dans un fichier 
 * 
 * @author thierry WADJI
 *
 */
public interface IParametrageService {
	
	
	/**
	 * @param user
	 * @return boolean
	 */
	public boolean enregistreUtilisateur(Utilisateur user);
	
	/**
	 * Liste de tous les utilisateurs
	 * 
	 * @param agence
	 * @return List<Utilisateur>
	 */
	public List<Utilisateur> listUtilisateurs();

	
	/**
	 * @param user
	 * @return boolean
	 */
	public boolean modifieUtilisateur(Utilisateur user);
	
	/**
	 * @param login
	 * @param password
	 * @return Utilisateur
	 */
	public Utilisateur connecteUtilisateur(String login, String password);
	
	/**
	 * Vérifie que le login renseigne existe dejà ou pas
	 * 
	 * @param login : Nom d'utilisateur 
	 * @return boolean
	 */
	public boolean utilisateurExist(String login);

}
