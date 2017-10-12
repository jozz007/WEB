package net.madinpro.evaleasy.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.entities.Utilisateur;
import net.madinpro.evaleasy.exceptions.DaoException;
import net.madinpro.evaleasy.metier.IEvaleasyMetier;
import net.madinpro.evaleasy.models.ClasseForm;
import net.madinpro.evaleasy.models.ListUserForm;
import net.madinpro.evaleasy.models.NiveauForm;
import net.madinpro.evaleasy.models.UserForm;

@Controller
public class EvaleasyController {

	@Autowired
	private IEvaleasyMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "index";
	}

	@RequestMapping(value = "/indexUser")
	public String indexUser(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "vuesConsultations/consultationUtilisateur";
	}

	@RequestMapping(value = "/chargerUser")
	public String chargerUser(@Valid UserForm uf, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "vuesConsultations/consultationUtilisateur";
		}
		try {
			Utilisateur utilisateur = metier.consulterUtilisateurParLogin(uf.getLogin());
			Adresse adresse = metier.consulterAdresseParUtilisateur(utilisateur.getLogin());
			uf.setTypeUtilisateur(utilisateur.getClass().getSimpleName());
			uf.setUtilisateur(utilisateur);
			uf.setAdresse(adresse);
		} catch (Exception e) {
			uf.setException(e.getMessage());
		}
		model.addAttribute("userForm", uf);
		return "vuesConsultations/consultationUtilisateur";
	}

	@RequestMapping(value = "/consulterListUtilisateur")
	public String indexListUser(Model model) {
		model.addAttribute("listUserForm", new ListUserForm());
		return "vuesConsultations/consultationListUtilisateur";
	}

	@RequestMapping(value = "/chargerListUtilisateur")
	public String chargerListUser(@Valid ListUserForm lUf, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "vuesConsultations/consultationListUtilisateur";
		}
		try {

			List<Utilisateur> utilisateurs = metier.consulterListeUtilisateurParNom(lUf.getNom());
			lUf.setUtilisateurs(utilisateurs);
		} catch (Exception e) {
			lUf.setException(e.getMessage());
		}
		model.addAttribute("listUserForm", lUf);
		return "vuesConsultations/consultationListUtilisateur";
	}

	@RequestMapping(value = "/indexClasse")
	public String indexClasse(Model model) {
		model.addAttribute("classeForm", new ClasseForm());
		return "vuesConsultations/consultationClasse";
	}

	@RequestMapping(value = "/chargerClasse")
	public String chargerUser(@Valid ClasseForm cf, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "vuesConsultations/consultationClasse";
		}
		try {
			Classe classe = metier.consulterClasseParLibelle(cf.getLibelle());
			List<Professeur> professeurs = metier.consulterTousLesProfesseursDuneClasse(classe.getLibelle());
			List<Eleve> eleves = metier.consulterTousLesLelevesDuneClasse(classe.getLibelle());
			cf.setProfesseurs(professeurs);
			cf.setClasse(classe);
			cf.setEleves(eleves);

		} catch (Exception ex) {
			cf.setException(ex.getMessage());
		}
		model.addAttribute("classeForm", cf);
		return "vuesConsultations/consultationClasse";
	}

	@RequestMapping(value = "/chargerListeNiveaux")
	public String chargerListeNiveaux(@Valid NiveauForm nf, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "vuesConsultations/consultationNiveau";
		}
		try {
			List<Niveau> niveaux = metier.consulterTousLesNiveaux();
			nf.setNiveaux(niveaux);
			List<Classe> classes = metier.consulterToutesLesClassesDUnNiveauParLibelle(nf.getLibelle());
			nf.setClasses(classes);
		

		} catch (Exception ex) {
			nf.setException(ex.getMessage());
		}
		model.addAttribute("niveauForm", nf);
		return "metier/listeDeNiveaux";
	}
	
	@RequestMapping(value = "/chargerListesClassesParNiveau")
	public String chargerListesClassesParNiveau(@Valid NiveauForm nf, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "metier/listeDeClassesParNiveau";
		}
		try {
			List<Niveau> niveaux = metier.consulterTousLesNiveaux();
			nf.setNiveaux(niveaux);
			List<Classe> classes = metier.consulterToutesLesClassesDUnNiveauParId(nf.getId());
			nf.setClasses(classes);

		} catch (DaoException ex) {
			nf.setException(ex.getMessage());
		}
		model.addAttribute("niveauForm", nf);
		return "metier/listeDeClassesParNiveau";
	}
	
	@RequestMapping(value = "/vuNiveau")
	public String vuNiveau(@Valid NiveauForm nf ,Model model) {
		model.addAttribute("niveauForm", nf);
		return "vuesConsultations/consultationNiveau";
	}


}