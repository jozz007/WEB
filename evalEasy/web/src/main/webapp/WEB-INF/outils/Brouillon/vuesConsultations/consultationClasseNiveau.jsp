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
	src="<%=request.getContextPath()%>/resources/JavaScript/evalEasy.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/JavaScript/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div>
		<table cellspacing="0px" border="1px">
		<f:form method="get" action="classeNiveau" modelAttribute="niveauForm">
			<tr>
				<th width="200px"><c:out value="Classe"/></th>
				<th width="200px"><c:out value="Professeur principal"/></th>
			</tr>
			<c:forEach items="${niveauForm.niveauTemp.classes}" var="classe">
			<tr>
				<td align="center"><c:out value="${classe.libelle }"></c:out></td>
				<td align="center"><c:out value="${classe.profPrincipal.sexe } ${classe.profPrincipal.nom }"></c:out></td>
			</tr>
			</c:forEach>
			
		</f:form>
		</table>
	</div>

	<div>
		<f:form modelAttribute="userForm" method="post" action="indexNiveau">
			<input type="submit" value="Retour">
		</f:form>
	</div>
</body>
</html>