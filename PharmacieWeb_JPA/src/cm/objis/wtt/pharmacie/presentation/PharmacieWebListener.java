package cm.objis.wtt.pharmacie.presentation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class PharmacieWebListener
 *
 */
@WebListener
public class PharmacieWebListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PharmacieWebListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // Je détruit l'EntityManagerFactory
    	EntityManagerFactory emf = (EntityManagerFactory) arg0.getServletContext().getAttribute("emf");
    	emf.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        // Je crée l'entity manager factory qui me servira à créer l'entity manager
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pharmaweb-pu");
    	
    	//Je place l'Entity Manager Factory dans le contexte de l'application (applicationScope)
    	arg0.getServletContext().setAttribute("emf", emf);
    	
    	
    }
	
}
