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
	console.log("JQuery est pret pour chargerNiveaux");
	$("indexNiveau").change(function(){
		var str = "";
	    $( "select option:selected" ).each(function() {
	        str += $( this ).text() + " ";
	      });
	      $( "#divNiveau" ).text( str );
	});
}


