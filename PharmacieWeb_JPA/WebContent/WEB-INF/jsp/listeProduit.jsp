<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="header.jsp"></jsp:include>
      
      <section class="probootstrap-section probootstrap-section-colored">
        <div class="container">
          <div class="row">
            <div class="col-md-12 text-left section-heading probootstrap-animate">
              <h1>Liste des Produits</h1>
            </div>
          </div>
        </div>
      </section>
      
      <section class="probootstrap-section">
        <div class="container">
          

          <div class="row">
          	<c:forEach items="${requestScope.listProduit}" var="produit" varStatus="status">
	            <div class="col-md-3 col-sm-6">
	              <div class="probootstrap-teacher text-center probootstrap-animate">
	                <figure class="media">
	                  <img src="img/person_1.jpg" alt="Free Bootstrap Template by ProBootstrap.com" class="img-responsive">
	                </figure>
	                <div class="text">
	                  <h3><c:out value="${produit.libelle}" /></h3>
	                  <p>Prix: <c:out value="${ produit.prix }" /> FCFA - Qté: <c:out value="${ produit.quantite }" /></p>
	                  <ul class="probootstrap-footer-social">
	                    <li class="twitter"><a href="modifierProduit?ref=<c:out value="${ produit.reference }" />"><i class="icon-edit"></i></a></li>
	                    <li class="facebook"><a href="#"><i class="icon-facebook2"></i></a></li>
	                    <li class="instagram"><a href="#"><i class="icon-instagram2"></i></a></li>
	                    <li class="google-plus"><a href="#"><i class="icon-google-plus"></i></a></li>
	                  </ul>
	                </div>
	              </div>
	            </div>
            </c:forEach>
          </div>
          

        </div>
      </section>
      
      <jsp:include page="footer.jsp"></jsp:include>