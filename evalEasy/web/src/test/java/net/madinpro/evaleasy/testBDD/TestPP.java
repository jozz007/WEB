package net.madinpro.evaleasy.testBDD;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.madinpro.evaleasy.metier.IEvaleasyMetier;

public class TestPP {

	public static void main(String[] args) {
		System.out.println("Debut");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEvaleasyMetier metier = (IEvaleasyMetier) context.getBean("metier");
		metier.AjouterProfPrincipal("6sci1", "jreschild");
		metier.AjouterProfPrincipal("6sci2".toUpperCase(), "ystrulu");
		metier.AjouterProfPrincipal("6sci3".toUpperCase(), "gphilippe");
		metier.AjouterProfPrincipal("6sci4".toUpperCase(), "gareto");
		System.out.println("fin");
	}

}
