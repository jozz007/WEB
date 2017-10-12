/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.madinpro.evaleasy.testBDD;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.metier.IEvaleasyMetier;

/**
 *
 * @author jozz007
 */
public class TestSuppression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Debut");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
        metier.supprimerUtilisateur("greschild");
        System.out.println("fin");
    }
    
}
