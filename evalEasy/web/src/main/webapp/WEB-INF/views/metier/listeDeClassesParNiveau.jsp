<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation Classes</title>
</head>
<body>
	<c:if test="${empty niveauForm.exception  }">
		<table border="1">
			<f:form method="post" action="indexNiveau"
				modelAttribute="niveauForm">
				<tr>
					<th width="200px"><c:out value="Classe" /></th>
					<th width="200px"><c:out value="Professeur principal" /></th>
				</tr>
				<c:if test="${not empty niveauForm.classes}">
					<c:forEach items="${niveauForm.classes}" var="classe">
						<tr>
							<td align="center">${classe.libelle}</td>
							<td>${classe.profPrincipal.sexe}&nbsp;
								${classe.profPrincipal.nom}</td>
						</tr>
					</c:forEach>
				</c:if>
			</f:form>
		</table>
	</c:if>
	<c:if test="${not empty niveauForm.exception  }">
		<tr>
			<td><font color="red">${niveauForm.exception }</font></td>
		</tr>
	</c:if>
</body>
</html>