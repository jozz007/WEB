function getXMLHttpRequest() {
		var xhr = null;

		if (window.XMLHttpRequest || window.ActiveXObject) {
			if (window.ActiveXObject) {
				try {
					xhr = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					xhr = new ActiveXObject("Microsoft.XMLHTTP");
				}
			} else {
				xhr = new XMLHttpRequest();
			}
		} else {
			alert("Votre navigateur ne supporte pas l'objet XMLHTTPRequest...");
			return null;
		}
		return xhr;
}

function chargerNiveaux(){
	var xhr = getXMLHttpRequest()
	xhr.open("GET", "indexNiveau", false);
	xhr.send(null);
	var rep= xhr.responseText;
	document.getElementById("divNiveau").innerHTML=rep;
}

function chargerClasse(libelle){
	var xhr = getXMLHttpRequest()
	xhr.open("GET", "listClasses?libelle="+libelle, false);
	xhr.send(null);
	var rep= xhr.responseText;
	document.getElementById("divClasse").innerHTML=rep;
}