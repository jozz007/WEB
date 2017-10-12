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

import net.madinpro.evaleasy.entities.Utilisateur;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;

/**
 *
 * @author jozz007
 */
public class TestUtilisateur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("Debut");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
                List<Utilisateur> u = metier.consulterListeUtilisateurParNom("eschildj");
        //        u.setEmail("jeanjose.reschild@orange.fr");
        //        metier.miseAJourUtilisateur(u);
         for(Utilisateur utilisateur : u)
         {
             System.out.println(utilisateur.getLogin());
         }
         System.out.println("fin");
    }

}
