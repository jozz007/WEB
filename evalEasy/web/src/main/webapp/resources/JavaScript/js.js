$(document).ready(function() {
	console.log("JQuery est pret");
	chargerNiveaux();

});

function testNiveaux() {

	$("#list").click(function() {
		alert('Chhhhaaaaannngggeemment!!!!!')
		console.log("JQuery est pret");
	});
}

/*
 * Chargement des niveaux
 */
function chargerNiveaux() {
	$.post("chargerListeNiveaux", function(data) {
		$("#divNiveau").html(data);
		$("#selectListeNiveaux").change(function() {
			chargerClasses($(this).val());
		});
	});
}

function chargerClasses(id) {
	$.post("chargerListesClassesParNiveau?id=" + id, function(data) {
		$("#divClasse").html(data);
	});
}