package net.madinpro.evaleasy.testBDD;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;

public class TestProf {

	public static void main(String[] args) {

		System.out.println("Debut");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");

		

		metier.ajouterProfesseurAMatiere("gareto", "latin");
		metier.ajouterMatiereAProfesseur("espagnol", "gareto");
		metier.ajouterProfesseurAMatiere("jreschild", "technologies");
		metier.ajouterMatiereAProfesseur("technologies", "ystrulu");
		metier.ajouterMatiereAProfesseur("svt", "gphilippe");

		System.out.println("Fin");
	}

}
