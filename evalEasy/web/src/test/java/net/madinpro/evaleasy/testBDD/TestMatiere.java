package net.madinpro.evaleasy.testBDD;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.entities.Matiere;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;

public class TestMatiere {

	public static void main(String[] args) {

		System.out.println("Debut");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
		
		  Matiere espagnol = new Matiere(); espagnol.setLibelle("espagnol"); Matiere
		  latin = new Matiere(); latin.setLibelle("latin"); Matiere technologies = new
		  Matiere(); technologies.setLibelle("technologies"); Matiere svt = new
		  Matiere(); svt.setLibelle("svt");
		  
		  metier.ajouterMatiere(latin); metier.ajouterMatiere(espagnol);
		  metier.ajouterMatiere(technologies); metier.ajouterMatiere(svt);
		  
		  metier.ajouterMatiereAClasse("latin", "6sci1");
		  metier.ajouterMatiereAClasse("espagnol", "6sci1");
		  metier.ajouterMatiereAClasse("technologies", "6sci1");
		  metier.ajouterMatiereAClasse("svt", "6sci1");
		  metier.ajouterMatiereAClasse("latin", "6sci2".toUpperCase());
		  metier.ajouterMatiereAClasse("espagnol", "6sci2".toUpperCase());
		  metier.ajouterMatiereAClasse("technologies", "6sci2".toUpperCase());
		  metier.ajouterMatiereAClasse("svt", "6sci2".toUpperCase());
		  
		  metier.ajouterMatiereAClasse("latin", "6sci3".toUpperCase());
		  metier.ajouterMatiereAClasse("espagnol", "6sci3".toUpperCase());
		  metier.ajouterMatiereAClasse("technologies", "6sci3".toUpperCase());
		  metier.ajouterMatiereAClasse("svt", "6sci3".toUpperCase());
		  metier.ajouterMatiereAClasse("latin", "6sci4".toUpperCase());
		  metier.ajouterMatiereAClasse("espagnol", "6sci4".toUpperCase());
		  metier.ajouterMatiereAClasse("technologies", "6sci4".toUpperCase());
		  metier.ajouterMatiereAClasse("svt", "6sci4".toUpperCase());
		 
		
		List<Matiere> matieres = metier.consulterToutesLesMatieresParProfesseur("jreschild");
		System.out.println("Fin");

	}

}
