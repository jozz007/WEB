<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste d'Utilisateur</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/CSS/style1.css" />
</head>
<body>
	<div>
		<h1 align="center">Recherche par nom</h1>
		<f:form modelAttribute="listUserForm" method="post"
			action="chargerListUtilisateur">
			<table>
				<tr>
					<td>nom:</td>
					<td><f:input path="nom" /></td>
					<td><f:errors path="nom" cssClass="error"></f:errors></td>
				</tr>

				<tr>
					<td><input type="submit" value="Soumettre"></td>
				</tr>
			</table>
		</f:form>
		<c:if test="${ empty listUserForm.exception  }">
			<c:if test="${not empty listUserForm.utilisateurs }">
				<div>
					<table>

						<c:forEach items="${ listUserForm.utilisateurs}" var="user">
							<tr>
								<td>Nom:</td>
								<td><form method="POST" action="chargerUser">
									<button type="submit" name="login" value="${user.login}" class="btn-link">${user.nom}</button>
								</form></td>
								<td>Prénom:</td>
								<td>${user.prenom }</td>
								<td>Login:</td>
								<td colspan="2" align="center">${user.login }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
		</c:if>
		<c:if test="${not empty listUserForm.exception  }">
			<font color="red">${listUserForm.exception }</font>44:48
		</c:if>


		<f:form modelAttribute="userForm" method="post" action="chargerUser">
			<input type="submit" value="Retour">
		</f:form>


	</div>
</body>
</html>