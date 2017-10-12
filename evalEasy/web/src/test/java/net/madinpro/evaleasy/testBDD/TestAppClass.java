/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.madinpro.evaleasy.testBDD;

import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;

/**
 *
 * @author jozz007
 */
public class TestAppClass {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println("Debut");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
		List<Classe> classes = metier.consulterToutesLesClassesDUnNiveauParId(9);
		for(Classe c : classes) {
			System.out.println(c.getLibelle());
		}

	}

}
