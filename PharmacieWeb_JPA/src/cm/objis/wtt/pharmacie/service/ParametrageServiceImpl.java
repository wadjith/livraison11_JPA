/**
 * 
 */
package cm.objis.wtt.pharmacie.service;

import java.util.List;

import javax.persistence.EntityManager;

import cm.objis.wtt.pharmacie.dao.IParametrageDAO;
import cm.objis.wtt.pharmacie.dao.ParametrageDaoImpl;
import cm.objis.wtt.pharmacie.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageServiceImpl implements IParametrageService {
	
	private IParametrageDAO dao;

	public ParametrageServiceImpl(EntityManager em) {
		super();
		this.dao = new ParametrageDaoImpl(em);
	}

	

	@Override
	public boolean enregistreUtilisateur(Utilisateur user) {
		
		return dao.enregistreUtilisateur(user);
	}

	
	@Override
	public boolean modifieUtilisateur(Utilisateur user) {
		
		return dao.modifieUtilisateur(user);
	}

	@Override
	public Utilisateur connecteUtilisateur(String login, String password) {
		
		return dao.rechercheUtilisateur(login, password);
	}

	@Override
	public boolean utilisateurExist(String login) {
		
		boolean result = false;
		if(dao.verifieLogin(login) != 0) result = true;
		
		return result;
	}

	
	@Override
	public List<Utilisateur> listUtilisateurs() {
		
		return dao.listUtilisateurs();
	}

}
