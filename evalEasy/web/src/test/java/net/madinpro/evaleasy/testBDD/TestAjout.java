/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.madinpro.evaleasy.testBDD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.metier.IEvaleasyMetier;

/**
 *
 * @author jozz007
 */
public class TestAjout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("Debut");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
//        /*      
//        Etablissement etablissement = new Etablissement();
//        
//        etablissement.setId_ets("LouisaPaulinMuret");
//        etablissement.setNom("Collège Louisa Paulin");
//        
//        Adresse adresse = new Adresse();
//        adresse.setNomRue("Rue du Commandant Montalègre");
//        adresse.setCodePostal(31605);
//        adresse.setVille("Muret");
//        adresse.setPays("France");
//        adresse.setNumeroRue("1");
//        
//        Adresse adresse1 = new Adresse();
//        adresse1.setNumeroRue("17");
//        adresse1.setNomRue("rue de magnolias");
//        adresse1.setVille("Saint-Orens de Gameville");
//        adresse1.setCodePostal(31650);
//        
//        Adresse adresse2 = new Adresse();
//        adresse2.setNomRue("Camp Chazeau");
//        adresse2.setCodePostal(97260);
//        adresse2.setVille("Morne-Rouge");
//        adresse2.setPays("France");
//        
//        Privilege p = new Privilege();
//        p.setLibelleDroit("Administrateur");
//        p.setNiveauDroit(3);
//        
//        
//        Utilisateur prof = new Professeur();
//        prof.setAdresse(adresse1);
//        prof.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/1970"));
//        prof.setNom("Reschild");
//        prof.setPrenom("Jean-José");
//        prof.setDroitUtilisateur(p);
//        prof.setEmail("jeanjose.reschild@free.fr");
//        prof.setLogin("jreschild");
//        prof.setMotDePasse("madinina");
//        
//        //Utilisateur eleve = metier.consulterUtilisateurParLogin("dreschild");
//        //System.out.println(eleve);
//        //eleve.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2006"));
//        //metier.miseAJourUtilisateur(prof);
//        //metier.supprimerUtilisateur("jreschild");
//     /*   
//        metier.supprimerNiveau(metier.consulterNiveauparLibelle("Sixième"));
//        metier.supprimerNiveau(metier.consulterNiveauparLibelle("Cinquième"));
//        metier.supprimerNiveau(metier.consulterNiveauparLibelle("Sisième"));
//         */
//        Professeur prof = (Professeur) metier.consulterUtilisateurParLogin("gareto");
//        List<Classe> c = metier.consulterToutesLesClassesDUnNiveau("Sixième");
//        System.out.println("***************************************************");
////        System.out.println(c.get(0).getNiveauClasse().getLibelle());
//        System.out.println("Ajout d'une classe à un niveau");
//        Niveau n = metier.consulterNiveauparLibelle("Sixième");
//
//        Classe SIXSCI6 = new Classe();
//
//        SIXSCI6.setLibelleClasse("6SCI6");
//        SIXSCI6.setProfPrincipal(prof);
//
//        //metier.ajouterClasseANiveau(SIXSCI6, n);
//        for (Classe classe : c) {
//            System.out.println(classe.getLibelleClasse());
//        }
//        System.out.println("***************************************************");
//        System.out.println();
//        System.out.println("Fin");
//
//        Adresse a = new Adresse();
//        a.setVille("Le Francois");
//        a.setCodePostal(97254);
//        a.setNomRue("La Jetée");
//        a.setPays("France");
//        Utilisateur eleve = new Eleve();
//
//        Privilege p = metier.consulterPrivilegeParLibelle("Elève");
//        
//        eleve.setAdresse(a);
//        eleve.setDateDeNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("13/01/2000"));
//        eleve.setDroitUtilisateur(p);
//        eleve.setNom("Reschild");
//        eleve.setPrenom("Gaël");
//        eleve.setEmail("blabla.bla@bl.kl");
//        eleve.setLogin("greschild");
//        eleve.setMotDePasse("jkjhgkgsq");
//        
////        metier.AjouterUtilisateur(eleve);
//        Utilisateur temp = metier.consulterUtilisateurParLogin("dreschild");
//        Utilisateur temp2 = metier.consulterUtilisateurParLogin("greschild");
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(temp);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
//        metier.ajouterEleveAClasse(SIXSCI6, (Eleve)temp);
//        metier.ajouterEleveAClasse(SIXSCI6, (Eleve)temp2);
//
////        metier.supprimerToutesLesClassesDUnNiveau("Sixième");
    }
}
