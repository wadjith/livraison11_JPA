package cm.objis.wtt.pharmacie.service;

import java.util.List;

import javax.persistence.EntityManager;

import cm.objis.wtt.pharmacie.dao.DaoImpl;
import cm.objis.wtt.pharmacie.dao.IDao;
import cm.objis.wtt.pharmacie.domaine.Produit;

public class ServiceImpl implements IService {
	
	private IDao dao;
	
	
	public ServiceImpl(EntityManager em) {
		dao = new DaoImpl(em);
	}

	@Override
	public boolean enregistrerProduitService(Produit produit) {
		
		return dao.enregistrerProduitDao(produit);

	}

	@Override
	public List<Produit> listProduitService() {
		
		return dao.listProduitDao();		
	}

	@Override
	public Produit rechercheProduitService(String ref) {
		
		return dao.rechercheProduitDao(ref);
	}
	
	

	@Override
	public boolean dejaEnregistreService(String ref) {
		
		return dao.dejaEnregistreDao(ref);
	}

	@Override
	public long nombreProduitService() {
		
		return dao.nombreProduitDao();
	}

	@Override
	public boolean modifierProduitService(Produit produit) {
		
		// TODO Auto-generated method stub
		return dao.modifierProduitDao(produit);
	}

}
