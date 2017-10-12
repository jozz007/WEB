<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation Niveaux</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/CSS/style1.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/JavaScript/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/JavaScript/js.js"></script>
</head>
<%-- "tuto-ajax-avec-jquery-php-html-css-dwm-enset-m-youssfi" 27'00"--%>

<body>
	<div id="debug"></div>
	<div id="NiveauScolaire">

		<!-- Liste déroulante du niveau scolaire sélectionnable -->

		<select id="listNiveaux">

			<!-- Initialisation de la liste -->
			<optgroup label="Niveau scolaire">
				<option disabled="disabled" selected="selected" value="-1">Choisir un niveau scolaire...</option>
				<c:forEach var="niveau" items="${niveauForm.niveaux }">
					<option id="libelleNiveau" value="${niveau.libelle }"> <c:out value="${niveau.libelle }"/> </option>
				</c:forEach>
			</optgroup>
		</select>
<input type="button" id="list" value="list()" />



		<f:form modelAttribute="niveauForm" method="get" action="indexNiveau">
			<input type=submit value="Retour">
		</f:form>
	</div>

	<div id="classes">
	</div>
	
	
	<c:if test="${ not empty niveauForm.exception  }">
		<font class="error">${niveauForm.exception }</font>
	</c:if>

	<div>
		<f:form modelAttribute="userForm" method="post" action="index">
			<input type="submit" value="Retour">
		</f:form>
	</div>
</body>
</html>