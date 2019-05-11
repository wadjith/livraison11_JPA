package cm.objis.wtt.pharmacie.presentation;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Authentification
 */
@WebFilter(urlPatterns= {"/enregistrerProduit", "/modifierProduit"})
public class AuthentificationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthentificationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest hrequest = null;
		HttpServletResponse hresponse = null;
		//Je caste request et response en Servlet Http
		if(request instanceof HttpServletRequest) hrequest = (HttpServletRequest) request;
		if(response instanceof HttpServletResponse) hresponse = (HttpServletResponse) response;
		
		//Je récupère la variable d'authentification en session
		Boolean authenticated = (Boolean) hrequest.getSession().getAttribute("authenticated");
		
		if(authenticated == null || !authenticated) {
			//L'utilisateur n'est pas authentifié, je le redirige vers login.jsp
			hresponse.sendRedirect(hresponse.encodeRedirectURL("connexion"));
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
