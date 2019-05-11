<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="header.jsp"></jsp:include>
      
      <section class="probootstrap-section probootstrap-section-colored">
        <div class="container">
          <div class="row">
            <div class="col-md-12 text-left section-heading probootstrap-animate">
              <h1 class="mb0">Enregistrer un Produit</h1>
            </div>
          </div>
        </div>
      </section>

      <section class="probootstrap-section probootstrap-section-sm">
        <div class="container">
          <c:if test="${ !empty requestScope.errorMessage }">
            <div class="alert alert-danger" role="alert"><c:out value="${ errorMessage }"></c:out></div>
          </c:if>
          <div class="row">
            <div class="col-md-12">
              <div class="row probootstrap-gutter0">
                <div class="col-md-7 col-md-push-1  probootstrap-animate" id="probootstrap-content">
                  <p>Tous les champs (*) sont obligatoires</p>
                  <form action="enregistrerProduit" method="post" class="probootstrap-form">
                    <div class="form-group">
                      <label for="reference">Reference *:</label>
                      <input type="text" class="form-control" id="reference" name="reference" required>
                    </div>
                    <div class="form-group">
                      <label for="libelle">Libellé * :</label>
                      <input type="text" class="form-control" id="libelle" name="libelle" required>
                    </div>
                    <div class="form-group">
                      <label for="prix">Prix * :</label>
                      <input type="number" class="form-control" id="prix" name="prix" required>
                    </div>
                    <div class="form-group">
                      <label for="quantite">Quantité * :</label>
                      <input type="number" class="form-control" id="quantite" name="quantite" required>
                    </div>
                    <div class="form-group">
                      <input type="submit" class="btn btn-primary btn-lg" id="submit" name="submit" value="Enregistrer">
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      
      <jsp:include page="footer.jsp"></jsp:include>