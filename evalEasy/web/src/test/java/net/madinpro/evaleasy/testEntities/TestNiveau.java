/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.madinpro.evaleasy.testEntities;

import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;


/**
 *
 * @author jozz007
 */
public class TestNiveau {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
        System.out.println("Debut");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
        // metier.supprimerToutesLesClassesDUnNiveau("Sixième");

        List<Niveau> niveaux = metier.consulterTousLesNiveaux();
        for (Niveau niveau : niveaux) {
            System.out.println(niveau.getLibelle());
        }
    }
}
