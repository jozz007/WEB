package net.madinpro.evaleasy.testBDD;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Etablissement;
import net.madinpro.evaleasy.entities.Matiere;
import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.entities.Privilege;
import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.entities.Utilisateur;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;

public class InitBDDStPring {

	public static void main(String[] args) throws ParseException {

		System.out.println("Debut");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");

		Etablissement etablissement = new Etablissement();

		etablissement.setId_ets("LouisaPaulinMuret");
		etablissement.setNom("Collège Louisa Paulin");

		Adresse adresse = new Adresse();
		adresse.setNomRue("Rue du Commandant Montalègre");
		adresse.setCodePostal(31605);
		adresse.setVille("Muret");
		adresse.setPays("France");
		adresse.setNumeroRue("1");
		etablissement.setAdresse(adresse);

		metier.ajouterEtablissement(etablissement);

		/**
		 * Ajout de classe
		 */

		Niveau sixieme = new Niveau("Sixieme");
		Niveau cinquieme = new Niveau("Cinquieme");
		Niveau quatrieme = new Niveau("Quatrieme");
		Niveau troisieme = new Niveau("Troisieme");

		metier.ajouterNiveau(sixieme);
		metier.ajouterNiveau(cinquieme);
		metier.ajouterNiveau(quatrieme);
		metier.ajouterNiveau(troisieme);

		Classe SIXSCI1 = new Classe();
		SIXSCI1.setLibelle("6SCI1");
		SIXSCI1.setNiveauClasse(sixieme);
		metier.ajouterClasse(SIXSCI1);

		Classe SIXSCI2 = new Classe();
		SIXSCI2.setLibelle("6SCI2");
		SIXSCI2.setNiveauClasse(sixieme);
		metier.ajouterClasse(SIXSCI2);

		Classe SIXSCI3 = new Classe();
		SIXSCI3.setLibelle("6SCI3");
		SIXSCI3.setNiveauClasse(sixieme);
		metier.ajouterClasse(SIXSCI3);

		Classe SIXSCI4 = new Classe();
		SIXSCI4.setLibelle("6SCI4");
		SIXSCI4.setNiveauClasse(sixieme);
		metier.ajouterClasse(SIXSCI4);

		Classe SIXSCI5 = new Classe();
		SIXSCI5.setLibelle("6SCI5");
		SIXSCI5.setNiveauClasse(sixieme);
		metier.ajouterClasse(SIXSCI5);

		/**
		 * Ajout de privilèges
		 */

		Privilege privilegeAdministrateur = new Privilege("Administrateur", 3);
		Privilege privilegeProfesseur = new Privilege("Professeur", 2);
		Privilege privilegeEleve = new Privilege("Elève", 1);

		metier.ajouterPrivilege(privilegeEleve);
		metier.ajouterPrivilege(privilegeProfesseur);
		metier.ajouterPrivilege(privilegeAdministrateur);

		/**
		 * Ajout de professuers
		 * 
		 */

		Adresse adresse1 = new Adresse();
		adresse1.setNumeroRue("17");
		adresse1.setNomRue("rue de magnolias");
		adresse1.setVille("Saint-Orens de Gameville");
		adresse1.setCodePostal(31650);

		Adresse adresse2 = new Adresse();
		adresse2.setNomRue("Camp Chazeau");
		adresse2.setCodePostal(97260);
		adresse2.setVille("Morne-Rouge");
		adresse2.setPays("France");

		Adresse adresse3 = new Adresse();
		adresse3.setNomRue("Camp Chazeau");
		adresse3.setCodePostal(97260);
		adresse3.setVille("Morne-Rouge");
		adresse3.setPays("France");

		Utilisateur prof = new Professeur();
		prof.setAdresse(adresse1);
		prof.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
		prof.setNom("Reschild".toLowerCase());
		prof.setPrenom("Jean-José".toLowerCase());
		prof.setPrivilege(privilegeProfesseur);
		prof.setEmail("jeanjose.reschild@free.fr");
		prof.setLogin("jreschild".toLowerCase());
		prof.setMotDePasse("madinina".toLowerCase());
		prof.setTelephone("0628040085");
		prof.setSexe("M");

		Utilisateur prof1 = new Professeur();
		prof1.setAdresse(adresse3);
		prof1.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
		prof1.setNom("Barbaro".toLowerCase());
		prof1.setPrenom("Lydie".toLowerCase());
		prof1.setPrivilege(privilegeProfesseur);
		prof1.setEmail("lydie.barbaro@free.fr");
		prof1.setLogin("lbarbaro".toLowerCase());
		prof1.setMotDePasse("madinina".toLowerCase());
		prof1.setTelephone("0628040025");
		prof1.setSexe("F");

		Utilisateur prof2 = new Professeur();
		prof2.setAdresse(adresse1);
		prof2.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
		prof2.setNom("Reschild".toLowerCase());
		prof2.setPrenom("Jean-Michel".toLowerCase());
		prof2.setPrivilege(privilegeProfesseur);
		prof2.setEmail("jean-michel.reschild@free.fr");
		prof2.setLogin("jmreschild".toLowerCase());
		prof2.setMotDePasse("madinina".toLowerCase());
		prof2.setTelephone("0628040085");
		prof2.setSexe("M");

		Utilisateur prof3 = new Professeur();
		prof3.setSexe("M");
		prof3.setAdresse(adresse1);
		prof3.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
		prof3.setNom("Strulu".toLowerCase());
		prof3.setPrenom("Yves".toLowerCase());
		prof3.setPrivilege(privilegeProfesseur);
		prof3.setEmail("Strulu@free.fr");
		prof3.setLogin("ystrulu".toLowerCase());
		prof3.setMotDePasse("madinina".toLowerCase());
		prof3.setTelephone("0628040085");

		Utilisateur prof4 = new Professeur();
		prof4.setSexe("m");
		prof4.setAdresse(adresse1);
		prof4.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
		prof4.setNom("Gabriel".toLowerCase());
		prof4.setPrenom("philippe".toLowerCase());
		prof4.setPrivilege(privilegeProfesseur);
		prof4.setEmail("gabriel.philippe@free.fr");
		prof4.setLogin("gphilippe".toLowerCase());
		prof4.setMotDePasse("madinina".toLowerCase());
		prof4.setTelephone("0628040085");

		Utilisateur prof5 = new Professeur();
		prof5.setAdresse(adresse1);
		prof5.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
		prof5.setNom("Aréto".toLowerCase());
		prof5.setPrenom("Gladys".toLowerCase());
		prof5.setPrivilege(privilegeProfesseur);
		prof5.setEmail("Aréto.Gladys@free.fr");
		prof5.setLogin("gareto".toLowerCase());
		prof5.setMotDePasse("madinina".toLowerCase());
		prof5.setTelephone("0628040085");
		prof5.setSexe("f");

		Utilisateur eleve = new Eleve();
		eleve.setNom("RESCHILD--BARBARO".toLowerCase());
		eleve.setPrenom("Dorian".toLowerCase());
		eleve.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2006"));
		eleve.setEmail("kirby972@gmail.com".toLowerCase());
		eleve.setLogin("dreschild".toLowerCase());
		eleve.setPrivilege(privilegeEleve);
		eleve.setMotDePasse("minekraft01".toLowerCase());
		eleve.setAdresse(adresse2);
		eleve.setTelephone("0628040085");
		eleve.setSexe("m");

		Utilisateur eleve2 = new Eleve();
		eleve2.setAdresse(adresse1);
		eleve2.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("13/01/2000"));
		eleve2.setPrivilege(privilegeEleve);
		eleve2.setNom("Reschild");
		eleve2.setPrenom("Gaël");
		eleve2.setEmail("blabla.bla@bl.kl");
		eleve2.setLogin("greschild");
		eleve2.setMotDePasse("jkjhgkgsq");
		eleve2.setTelephone("0628040085");
		eleve2.setSexe("m");

		metier.AjouterUtilisateur(prof);
		metier.AjouterUtilisateur(prof1);
		metier.AjouterUtilisateur(prof2);
		metier.AjouterUtilisateur(prof3);
		metier.AjouterUtilisateur(prof4);
		metier.AjouterUtilisateur(prof5);
		metier.AjouterUtilisateur(eleve2);
		metier.AjouterUtilisateur(eleve);

		/**
		 * Ajout de matieres
		 */

		Matiere français = new Matiere();
		français.setLibelle("français");
		Matiere espagnol = new Matiere();
		espagnol.setLibelle("espagnol");
		Matiere latin = new Matiere();
		latin.setLibelle("latin");
		Matiere technologies = new Matiere();
		technologies.setLibelle("technologies");
		Matiere svt = new Matiere();
		svt.setLibelle("svt");
		Matiere anglais = new Matiere();
		anglais.setLibelle("anglais");

		metier.ajouterMatiere(latin);
		metier.ajouterMatiere(espagnol);
		metier.ajouterMatiere(technologies);
		metier.ajouterMatiere(svt);
		metier.ajouterMatiere(français);
		metier.ajouterMatiere(anglais);

		metier.ajouterMatiereAClasse("latin", "6sci1");
		metier.ajouterMatiereAClasse("espagnol", "6sci1");
		metier.ajouterMatiereAClasse("technologies", "6sci1");
		metier.ajouterMatiereAClasse("svt", "6sci1");
		metier.ajouterMatiereAClasse("anglais", "6sci1");
		metier.ajouterMatiereAClasse("français", "6sci1");
		metier.ajouterMatiereAClasse("latin", "6sci2".toUpperCase());
		metier.ajouterMatiereAClasse("espagnol", "6sci2".toUpperCase());
		metier.ajouterMatiereAClasse("technologies", "6sci2".toUpperCase());
		metier.ajouterMatiereAClasse("svt", "6sci2".toUpperCase());
		metier.ajouterMatiereAClasse("français", "6sci2");
		metier.ajouterMatiereAClasse("anglais", "6sci2");

		metier.ajouterMatiereAClasse("latin", "6sci3".toUpperCase());
		metier.ajouterMatiereAClasse("espagnol", "6sci3".toUpperCase());
		metier.ajouterMatiereAClasse("technologies", "6sci3".toUpperCase());
		metier.ajouterMatiereAClasse("français", "6sci3");
		metier.ajouterMatiereAClasse("anglais", "6sci3");
		metier.ajouterMatiereAClasse("svt", "6sci3".toUpperCase());
		metier.ajouterMatiereAClasse("latin", "6sci4".toUpperCase());
		metier.ajouterMatiereAClasse("espagnol", "6sci4".toUpperCase());
		metier.ajouterMatiereAClasse("technologies", "6sci4".toUpperCase());
		metier.ajouterMatiereAClasse("svt", "6sci4".toUpperCase());
		metier.ajouterMatiereAClasse("français", "6sci4");
		metier.ajouterMatiereAClasse("anglais", "6sci4");
		
		/**
		 * Ajout de professeurs
		 */
		
		metier.ajouterProfesseurAMatiere("gareto", "latin");
		metier.ajouterMatiereAProfesseur("espagnol", "gareto");
		metier.ajouterMatiereAProfesseur("francais", "gareto");
		metier.ajouterProfesseurAMatiere("jreschild", "technologies");
		metier.ajouterProfesseurAMatiere("jreschild", "anglais");
		metier.ajouterMatiereAProfesseur("technologies", "ystrulu");
		metier.ajouterMatiereAProfesseur("svt", "gphilippe");
		
		/**
		 * Ajout de professeurs principal
		 */
		
		metier.AjouterProfPrincipal("6sci1", "jreschild");
		metier.AjouterProfPrincipal("6sci2", "ystrulu");
		metier.AjouterProfPrincipal("6sci3", "gphilippe");
		metier.AjouterProfPrincipal("6sci4", "gareto");
		metier.AjouterProfPrincipal("6sci5", "lbarbaro");
		
		
		/**
		 * Ajout de professeurs dans une classe
		 */
		metier.ajouterProfesseurAClasse("jreschild", "6sci1");
		metier.ajouterProfesseurAClasse("jreschild", "6sci2");
		metier.ajouterProfesseurAClasse("jreschild", "6sci3");
		metier.ajouterProfesseurAClasse("jreschild", "6sci4");
		metier.ajouterProfesseurAClasse("jreschild", "6sci5");
		metier.ajouterProfesseurAClasse("ystrulu", "6sci2");
		metier.ajouterProfesseurAClasse("ystrulu", "6sci3");
		metier.ajouterProfesseurAClasse("ystrulu", "6sci4");
		
		/**
		 * Ajout des élèves dans une classe
		 */
		metier.ajouterEleveAClasse("6sci2", "greschild");
		metier.ajouterEleveAClasse("6sci2", "dreschild");
		
		System.out.println("fin");

	}

}
