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

	<div id="divListNiveaux">
		<f:form modelAttribute="niveauForm" method="post"
			action="classeNiveau">
			<select id="select-listNiveaux">
				<!-- Initialisation de la liste -->
				<optgroup label="Niveau scolaire" id="optgroup-listNiveaux">
					<option disabled="disabled" selected="selected" value="-1">Choisir un niveau scolaire...</option>
					<c:forEach var="niveau" items="${niveauForm.niveaux }">
						<option id="option-listNiveaux"
							value="${niveauForm.niveau.libelle }"> <c:out value="${niveauForm.niveau.libelle}"/> </option>
					</c:forEach>
				</optgroup>

			</select>
			<!-- <input type="submit" value="Go"> -->
		</f:form>

		<f:form modelAttribute="niveauForm" method="post" action="indexNiveau">
			<input type="submit" value="Reset">
		</f:form>
	</div>

	<div id="divListNiveau">
		<table cellspacing="0px" border="1px">
			<f:form method="get" action="indexNiveau" modelAttribute="niveauForm">
				<f:input path="niveau.libelle" />
				<tr>
					<th width="200px"><c:out value="Classe" /></th>
					<th width="200px"><c:out value="Professeur principal" /></th>
				</tr>
				<c:forEach items="${niveauForm.niveau.classes}" var="classe">
					<tr>
						<td>${classe.libelle }</td>
					</tr>
				</c:forEach>

				<input type="submit" value="OK" />
			</f:form>
		</table>
	</div>

	<div>
		<f:form modelAttribute="userForm" method="post" action="index">
			<input type="submit" value="Retour" />
		</f:form>
	</div>
</body>
</html>