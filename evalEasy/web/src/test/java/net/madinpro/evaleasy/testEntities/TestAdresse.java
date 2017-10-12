/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.madinpro.evaleasy.testEntities;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;

/**
 *
 * @author jozz007
 */
public class TestAdresse {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
        System.out.println("Debut");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");

//        Utilisateur u = metier.consulterUtilisateurParLogin("jreschild");
//        Adresse a = metier.consulterAdresseParUtilisateur("jreschild");
        System.out.println(metier.consulterAdresseParUtilisateur("jreschild").getVille());
//        Adresse a = metier.consulterAdresseparId(01);
//        System.out.println(a);
//        Adresse b = metier.consulterAdresseparId(5);
//        Adresse b = new Adresse();
//        System.out.println(b);
//        b.setCodePostal(31200);
//        b.setImmeuble("Bat a");
//        b.setNomRue("Rue de la soie");
//        b.setPays("France");
//        b.setVille("Paris");
//        metier.AjouterAdresse(b);

//        b.setImmeuble("Batiment B");
//        metier.supprimerToutesAdresses();
    }

}
