package net.madinpro.evaleasy.testBDD;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Etablissement;
import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.entities.Privilege;
import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.entities.Utilisateur;

public class InitBdd {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_eleve");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transac = em.getTransaction();
		transac.begin();

		Etablissement etablissement = new Etablissement();

		etablissement.setId_ets("LouisaPaulinMuret");
		etablissement.setNom("Collège Louisa Paulin");

		Niveau sixieme = new Niveau("Sixième");
		Niveau cinquieme = new Niveau("Cinquième");
		Niveau quatrieme = new Niveau("Quatrième");
		Niveau troisieme = new Niveau("Troisième");

		Privilege privilegeAdministrateur = new Privilege("Administrateur", 3);
		Privilege privilegeProfesseur = new Privilege("Professeur", 2);
		Privilege privilegeEleve = new Privilege("Elève", 1);

		Adresse adresse = new Adresse();
		adresse.setNomRue("Rue du Commandant Montalègre");
		adresse.setCodePostal(31605);
		adresse.setVille("Muret");
		adresse.setPays("France");
		adresse.setNumeroRue("1");

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

		em.persist(privilegeEleve);
		em.persist(privilegeProfesseur);
		em.persist(privilegeAdministrateur);

		System.out.println(etablissement);

		etablissement.setAdresse(adresse);
		em.persist(prof);
		em.persist(prof1);
		em.persist(prof2);
		em.persist(prof3);
		em.persist(prof4);
		em.persist(prof5);

		em.persist(eleve);
		em.persist(eleve2);
		em.persist(etablissement);

		em.persist(sixieme);
		em.persist(cinquieme);
		em.persist(quatrieme);
		em.persist(troisieme);

		Classe SIXSCI1 = new Classe();
		SIXSCI1.setLibelle("6SCI1");
		SIXSCI1.setNiveauClasse(em.merge(sixieme));
		SIXSCI1.setProfPrincipal((Professeur) prof);

		Classe SIXSCI2 = new Classe("6SCI2", sixieme, (Professeur) prof1);
		Classe SIXSCI3 = new Classe("6SCI3", sixieme, (Professeur) prof2);
		Classe SIXSCI4 = new Classe("6SCI4", sixieme, (Professeur) prof3);
		Classe SIXSCI5 = new Classe("6SCI5", sixieme, (Professeur) prof4);

		em.persist(SIXSCI1);
		em.persist(SIXSCI2);
		em.persist(SIXSCI3);
		em.persist(SIXSCI4);
		em.persist(SIXSCI5);

		transac.commit();

		em.close();
		emf.close();

		System.out.println("Fin");
	}

}
