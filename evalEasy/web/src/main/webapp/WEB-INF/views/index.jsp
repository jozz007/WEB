<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<!-- <link href="style.css" rel="stylesheet" type="text/css"> -->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/CSS/style.css" />
<style>
.content {
	margin-right: -1px;
}
/* cette marge négative de 1px peut être placée sur n'importe quelle colonne de cette mise en page, avec le même effet correcteur. */
ul.nav a {
	zoom: 1;
}
/* la propriété de zoom donne à IE le déclencheur hasLayout requis pour corriger les espaces blancs supplémentaires entre les liens */
</style>
<![endif]-->
</head>

<body>
	<div class="container">
		<div class="header">
			<a href="#"><img src="" alt="Insérer le logo ici"
				name="Insert_logo" width="180px" height="90" id="Insert_logo"
				style="background-color: #8090AB; display: block;" /></a>
			<!-- end .header -->
		</div>
		<div class="sidebar1">
			<p>&nbsp;</p>
			<ul id="menu-accordeon">
				<li id="none"><h1>Menu</h1></li>
				<li><a href="#">Utilisateur</a>
					<ul>
						<li><a href="http://www.google.fr">Créer</a></li>
						<li><a href="<%=request.getContextPath()%>/indexUser">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>

				<li><a href="#">Niveau</a>
					<ul>
						<li><a href="http://www.google.fr">Créer</a></li>
						<li><a href="<%=request.getContextPath()%>/vuNiveau">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>

				<li><a href="#">Classe</a>
					<ul>
						<li><a href="#">Créer</a></li>
						<li><a href="<%=request.getContextPath()%>/indexClasse">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>

				<li><a href="#">Compétences</a>
					<ul>
						<li><a href="#">Créer</a></li>
						<li><a href="#">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>

				<li><a href="#">Devoirs</a>
					<ul>
						<li><a href="#">Créer</a></li>
						<li><a href="#">Effectuer</a></li>
						<li><a href="#">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>

				<li><a href="#">Questions</a>
					<ul>
						<li><a href="#">Créer</a></li>
						<li><a href="#">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>
				<li><a href="#">Privilège</a>
					<ul>
						<li><a href="#">Créer</a></li>
						<li><a href="<%=request.getContextPath()%>/indexPrivilege">Consulter</a></li>
						<li><a href="#">Modifier</a></li>
						<li><a href="#">Supprimer</a></li>
					</ul></li>
			</ul>

		</div>
		<div class="content">
			<h1>
				Bienvenu sur à toi...
				<!-- end .content -->
			</h1>
			<a class="corpDePage"> Selectionne une action dans le menu </a>
		</div>
		<div class="footer">
			<p>Ce .footer contient la déclaration position:relative, de façon
				à attribuer hasLayout à Internet Explorer 6 pour le .footer et
				forcer son effacement correct. Si la compatibilité avec IE6 n'est
				pas nécessaire, vous pouvez le supprimer.</p>
			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>
</body>
</html>