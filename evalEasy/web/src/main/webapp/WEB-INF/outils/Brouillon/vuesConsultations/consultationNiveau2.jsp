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
		<c:if test="${ empty niveauForm.exception  }">
			<c:if test="${not empty niveauForm.niveaux }">

				<c:forEach items="${niveauForm.classes}" var="classe">
					<br />
			${classe.libelle}
			</c:forEach>

			</c:if>
		</c:if>
	</div>
	<c:if test="${ not empty niveauForm.exception  }">
		<font class="error">${niveauForm.exception }</font>
	</c:if>

	<div>
		<f:form modelAttribute="userForm" method="post" action="indexNiveau">
			<input type="submit" value="Retour">
		</f:form>
	</div>
</body>
</html>