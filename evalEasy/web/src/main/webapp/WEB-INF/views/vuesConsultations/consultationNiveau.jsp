<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation Niveaux 2</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/CSS/style1.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/JavaScript/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/JavaScript/js.js"></script>

</head>
<body onload="chargerNiveaux()">
	<div id="divNiveau"></div>
	<div id="divClasse"></div>
	<f:form modelAttribute="userForm" method="post" action="index">
		<input type="submit" value="Retour" />
	</f:form>
</body>
</html>