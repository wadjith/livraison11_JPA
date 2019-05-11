package cm.objis.wtt.pharmacie.presentation;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cm.objis.wtt.pharmacie.domaine.Utilisateur;
import cm.objis.wtt.pharmacie.service.IParametrageService;
import cm.objis.wtt.pharmacie.service.ParametrageServiceImpl;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirection vers la page de connexion
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur user = new Utilisateur();
		String urlDestination;
		
		//Récupération des valeurs saisies par l'utilisateur
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// Obtention de EntityManagerFactory enregistré dans le contexte de l'application via le Listener
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        //Création de l'entity manager
        EntityManager em = emf.createEntityManager();
        
		//Appel de la couche Service 
		IParametrageService pService = new ParametrageServiceImpl(em);
		
		//Appel de la méthode de connexion de la couche service
		user = pService.connecteUtilisateur(login, password);
		
		//Placer des valeurs dans la session ou la requête  
		HttpSession session = request.getSession();
		
		if(user == null) { // Les paramètres d'authentification sont fausses
			session.setAttribute("authenticated", false);
			request.setAttribute("errorMessage", "Login ou mot de passe incorrect !!");
			urlDestination = "/WEB-INF/jsp/login.jsp";
			
		} else {
			session.setAttribute("authenticated", true);
			session.setAttribute("user", user);
			urlDestination = "home";
			
		}
		
		//Redirection vers la page de destination
		request.getRequestDispatcher(urlDestination).forward(request, response);
	}

}
