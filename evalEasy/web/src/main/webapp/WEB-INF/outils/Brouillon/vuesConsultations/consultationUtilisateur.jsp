<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utilisateur</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/CSS/style1.css" />
</head>
<body>
	<c:if test="${empty userForm.utilisateur }">
		<div>
			<f:form modelAttribute="userForm" method="post" action="chargerUser">
				<table>
					<tr>
						<td>Login:</td>
						<td><f:input path="login" /></td>
						<td><f:errors path="login" cssClass="error"></f:errors></td>
					</tr>
					<tr>
						<td><input type="submit" value="Soumettre"></td>
					</tr>
				</table>
			</f:form>
		</div>
	</c:if>
	<c:if test="${ empty userForm.exception  }">
		<c:if test="${not empty userForm.utilisateur }">
			<div>
				<h1 align="center" style="color: green;"><c:out value="${userForm.utilisateur.nom.toUpperCase()}
					${userForm.utilisateur.prenom.toUpperCase()}"></c:out></h1>
				<table>
					<thead>
						<tr>
							<th>Status:</th>
							<th>${userForm.typeUtilisateur }</th>
							<c:if test="${ userForm.typeUtilisateur=='Professeur'}">
								<th align="center">Matières</th>
								<c:forEach items="${ userForm.utilisateur.matieres}" var="mat">
									<tr>
										<td></td>
										<td></td>
										<td><c:out value="${mat.libelle }"></c:out></td>
									</tr>
								</c:forEach>
							</c:if>
						</tr>
					</thead>
					<c:if test="${ userForm.typeUtilisateur=='Eleve'}">
						<tr>
							<td>Classe:</td>
							<td><c:out value="${userForm.utilisateur.classe.libelle }"></c:out></td>
						</tr>
					</c:if>

					<tr>
						<td>Login:</td>
						<td><c:out value="${userForm.utilisateur.login }"></c:out></td>
					</tr>
					<tr>
						<td>Nom:</td>
						<td><c:out value="${userForm.utilisateur.nom.toUpperCase()}"></c:out></td>
						<td>Prénom:</td>
						<td><c:out value="${userForm.utilisateur.prenom }"></c:out></td>
					</tr>
					<tr>
						<td>Téléphone:</td>
						<td><c:out value="${userForm.utilisateur.telephone }"></c:out></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td colspan=2>${userForm.utilisateur.email }</td>
					</tr>
					<thead>
					<tr ><td></td></tr>
					<tr><td></td></tr>
					<tr><td></td></tr>
					<tr><td></td></tr>
					<tr>
						<th colspan="3" align="center">Adresse</th>
					</tr>
					</thead>
					<tr>
						<c:if test="${not empty userForm.utilisateur.adresse.numeroRue }">
							<td><c:out value="${userForm.utilisateur.adresse.numeroRue},"></c:out></td>
						</c:if>
						<td colspan="2">${userForm.utilisateur.adresse.nomRue}</td>
					</tr>
					<c:if test="${not empty userForm.utilisateur.adresse.immeuble }">
						<tr>
							<td><c:out value="${userForm.utilisateur.adresse.immeuble }"></c:out></td>
						</tr>
					</c:if>
					<tr>
						<td><c:out value="${userForm.utilisateur.adresse.codePostal},"></c:out></td>
						<td><c:out value="${userForm.utilisateur.adresse.ville}"></c:out></td>
					</tr>
					<tr>
						<td><c:out value="${userForm.utilisateur.adresse.pays}"></c:out></td>
					</tr>
					<f:form modelAttribute="userForm" method="post" action="indexUser">
					<tr>
						<td><input type="submit" value="Nouvelle recherche"></td>
					</tr>
					</f:form>
				</table>
			</div>
		</c:if>
	</c:if>
	<c:if test="${not empty userForm.exception  }">
		<font class="error">${userForm.exception }</font>

			<f:form modelAttribute="listUserForm" method="post"
			action="consulterListUtilisateur">
			<table>
				<tr>
					<td><h2>Souhaitez-vous faire une recherche par nom?</h2></td>
					<td>&nbsp;</td>
					<td><input type="submit" value="OK"></td>

				</tr>
			</table>
		</f:form>

	</c:if>
	<div>
		<f:form modelAttribute="userForm" method="post" action="index">
			<table>
				<tr>
					<td><input type="submit" value="Retour"></td>
				</tr>
			</table>
		</f:form>
	</div>

</body>
</html>