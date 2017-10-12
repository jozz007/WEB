<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation Niveaux</title>
</head>
<%-- "tuto-ajax-avec-jquery-php-html-css-dwm-enset-m-youssfi" 27'00"--%>
<body>
	<c:if test="${ not empty niveauForm.niveaux  }">
		<f:form modelAttribute="niveauForm" method="post" action="indexNiveau">
			<select id="selectListeNiveaux" name="niveau"
				onchange="chargerNiveaux(this.value)">
				<!-- Initialisation de la liste -->
				<optgroup label="Niveau scolaire" id="optgroup-listNiveaux">
					<option disabled="disabled" selected="selected" value="-1">Choisir un niveau scolaire...</option>

					<c:forEach items="${niveauForm.niveaux}" var="niveau">
						<option id="optionListNiveau" value="${niveau.id}">
						${niveau.libelle}
					</option>
					</c:forEach>
				</optgroup>
			</select>
		</f:form>
	</c:if>
	<%-- <c:if test="${not empty niveauForm.exception  }">
		<font class="error">${niveauForm.exception }</font>
	</c:if> --%>
</body>
</html>