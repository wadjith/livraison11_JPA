package cm.objis.wtt.pharmacie.presentation;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.objis.wtt.pharmacie.service.IService;
import cm.objis.wtt.pharmacie.service.ServiceImpl;

import cm.objis.wtt.pharmacie.domaine.Produit;

/**
 * Servlet implementation class ModifierProduitServlet
 */
@WebServlet("/modifierProduit")
public class ModifierProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produit produit = new Produit();
		// Je récupère la reference du produit
		String reference = request.getParameter("ref");
		
		// Obtention de EntityManagerFactory enregistré dans le contexte de l'application via le Listener
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        //Création de l'entity manager
        EntityManager em = emf.createEntityManager();
        
		//Je récupère la couche service
		IService service = new ServiceImpl(em);
		
		// Je récupère le produit à modifier
		produit = service.rechercheProduitService(reference);
		
		request.setAttribute("produit", produit);
		//Forward vers la page /WEB-INF/modifierProduit.jsp car protégé pour un accès authentifié
		request.getRequestDispatcher("/WEB-INF/jsp/modifierProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperation des valeurs saisies par l'utilisateur
		long idproduit = Long.parseLong(request.getParameter("idproduit"));
		String reference = request.getParameter("reference");
		String libelle = request.getParameter("libelle");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		
		
		// Obtention de EntityManagerFactory enregistré dans le contexte de l'application via le Listener
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        //Création de l'entity manager
        EntityManager em = emf.createEntityManager();
		
		//appel de la couche service
		IService service = new ServiceImpl(em);
		
		 // creation d'un objet produit et mise à jour de ses attributs
		 Produit produit = new Produit() ;
		 
		// Je récupère le produit à modifier. Il est important de placer la valeur de Id afin que l'ORM puisse gérer l'objet.  
	    produit.setId(idproduit);
	    produit.setReference(reference);
		produit.setLibelle(libelle);
		produit.setPrix(prix);
		produit.setQuantite(quantite);		
		
		
		//appel de la methode de modification de la couche service
		service.modifierProduitService(produit);
		
		
		//Redirection vers la Servlet ListeServlet
		request.getRequestDispatcher("listeProduit").forward(request, response);
	}

}
