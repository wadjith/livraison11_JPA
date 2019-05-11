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
 * Servlet implementation class EnregistrerProduitServlet
 */
@WebServlet("/enregistrerProduit")
public class EnregistrerProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Redirection vers la page /WEB-INF/enregistrerProduit.jsp car protégé pour un accès authentifié
		request.getRequestDispatcher("/WEB-INF/jsp/enregistrerProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperation des valeurs saisies par l'utilisateur
		String reference = request.getParameter("reference");
		String libelle = request.getParameter("libelle");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		
		 // creation d'un objet produit et initialisation de ses attributions
		Produit produit = new Produit();
		produit.setReference(reference);
		produit.setLibelle(libelle);
		produit.setPrix(prix);
		produit.setQuantite(quantite);
		
		// Obtention de EntityManagerFactory enregistré dans le contexte de l'application via le Listener
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        //Création de l'entity manager
        EntityManager em = emf.createEntityManager();
		
		//appel de la couche service
		IService service = new ServiceImpl(em);
		
		//appel de la methode enregistreAgriculteurService de la couche service
		if(service.dejaEnregistreService(reference)) {
			request.setAttribute("errorMessage", "Un produit de reference (" + reference + ") est dejà enregistré!!");
			//Redirection vers la page d'enregistrement du produit
			request.getRequestDispatcher("/WEB-INF/jsp/enregistrerProduit.jsp").forward(request, response);
			
		} else {
			service.enregistrerProduitService(produit);
			//Redirection vers la page de liste des produits
			request.getRequestDispatcher("listeProduit").forward(request, response);
		}
		
	}

}
