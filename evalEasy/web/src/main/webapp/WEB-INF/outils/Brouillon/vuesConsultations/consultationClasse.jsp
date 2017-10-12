<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classe</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/CSS/style1.css" />
</head>
<body>
	<c:if test="${empty classeForm.classe }">
		<div>
			<f:form modelAttribute="classeForm" method="post"
				action="chargerClasse">
				<table>
					<tr>
						<td>Libellé:</td>
						<td><f:input path="libelle" /></td>
						<td><f:errors path="libelle" cssClass="error"></f:errors></td>
					</tr>
					<tr>
						<td><input type="submit" value="Soumettre"></td>
					</tr>
				</table>
			</f:form>
		</div>
	</c:if>
	<c:if test="${ empty classeForm.exception  }">
		<c:if test="${not empty classeForm.classe }">
			<div>
				<h1 align="center" style="color: green;">${classeForm.classe.libelle}<br />
				</h1>
				<h2>
					<a><c:out
							value="Professeur principal:
						${classeForm.classe.profPrincipal.nom.toUpperCase()}"></c:out></a>
					<strong><c:out
							value="Niveau: 
						${classeForm.classe.niveauClasse.libelle.toUpperCase()}"></c:out></strong>
				</h2>

				<!-- Consulter la liste des professeurs -->

				<table id="listProfesseur">
					<tr>
						<th width="300px" align="left">Professeurs</th>
						<th width="30px" colspan="2" align="left">Matière</th>
					</tr>
					<c:forEach items="${classeForm.professeurs }" var="prof">
						<tr>
							<td><c:out value="${prof.sexe } ${prof.nom }"></c:out>
								<c:forEach items="${prof.matieres }" var="matiere"><tr>
								<td>&nbsp;</td>
									<td><c:out value="${matiere.libelle}"></c:out></td>
								</tr></c:forEach></td>
						</tr>
					</c:forEach>
					<f:form modelAttribute="classeForm" method="post"
						action="indexClasse">
						<tr>
							<td><input type="submit" value="Nouvelle recherche" /></td>
						</tr>
					</f:form>

				</table>
			</div>
			<div>
				<h2>Liste des élèves :</h2>
				<table>
					<tr>
						<th width="300px" align="left">Nom</th>

						<th width="30px" colspan="2" align="left">Prénom</th>

					</tr>

					<c:forEach items="${ classeForm.eleves}" var="eleve">
						<tr>
							<td><form method="POST" action="chargerUser">
									<button type="submit" name="login" value="${eleve.login}"
										class="btn-link">${eleve.nom}</button>
								</form></td>
							<td><c:out value="${eleve.prenom }"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</c:if>
	<c:if test="${not empty classeForm.exception  }">
		<div>
			<font color="red">${classeForm.exception }</font>
		</div>
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