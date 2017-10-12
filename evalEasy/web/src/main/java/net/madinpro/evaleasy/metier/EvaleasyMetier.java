package net.madinpro.evaleasy.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.madinpro.evaleasy.dao.IEvaleasyDao;
import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Competence;
import net.madinpro.evaleasy.entities.Devoir;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Etablissement;
import net.madinpro.evaleasy.entities.Matiere;
import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.entities.Privilege;
import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.entities.Question;
import net.madinpro.evaleasy.entities.Utilisateur;

/**
 *
 * @author jozz007
 */
@Transactional
public class EvaleasyMetier implements IEvaleasyMetier {

	IEvaleasyDao dao;

	public IEvaleasyDao getDao() {
		return dao;
	}

	public void setDao(IEvaleasyDao dao) {
		this.dao = dao;
	}

	@Override
	public Adresse consulterAdresseparId(int id) {
		return dao.consulterAdresseparId(id);
	}

	@Override
	public Adresse AjouterAdresse(Adresse adresse) {
		return dao.AjouterAdresse(adresse);
	}

	@Override
	public Adresse miseAJourAdresse(Adresse adresse) {
		return dao.miseAJourAdresse(adresse);
	}

	@Override
	public void supprimerAdresse(Adresse adresse) {
		dao.supprimerAdresse(adresse);
	}

	@Override
	public Adresse consulterAdresseParUtilisateur(String login) {
		Utilisateur u = dao.consulterUtilisateurParLogin(login);
		return dao.consulterAdresseParUtilisateur(u);
	}

	@Override
	public void supprimerToutesAdresses() {
		dao.supprimerToutesAdresses();
	}

	@Override
	public Privilege consulterPrivilegeParLibelle(String libelleDroit) {
		return dao.consulterPrivilegeParLibelle(libelleDroit);
	}

	@Override
	public Privilege consulterPrivilegeParID(int id) {
		return dao.consulterPrivilegeParID(id);
	}

	@Override
	public List<Privilege> consulterTousLesPrivileges() {
		return dao.consulterTousLesPrivileges();
	}

	@Override
	public Privilege ajouterPrivilege(Privilege p) {
		return dao.ajouterPrivilege(p);
	}

	@Override
	public Privilege miseAJourPrivilege(Privilege p) {
		return dao.miseAJourPrivilege(p);
	}

	@Override
	public void supprimerPrivilegeParLibelle(String libelle) {
		Privilege p = consulterPrivilegeParLibelle(libelle);
		dao.supprimerPrivilege(p);
	}

	@Override
	public void supprimerTousLesPrivileges() {
		dao.supprimerTousLesPrivileges();
	}

	/*
	 * Gestion des utilisateurs
	 */
	@Override
	public Utilisateur consulterUtilisateurId(int id) {
		return dao.consulterUtilisateurId(id);
	}

	@Override
	public Utilisateur AjouterUtilisateur(Utilisateur u) {
		
		return dao.AjouterUtilisateur(u);
	}

	@Override
	public Utilisateur miseAJourUtilisateur(Utilisateur u) {
		return dao.miseAJourUtilisateur(u);
	}

	@Override
	public List<Utilisateur> consulterListeUtilisateurParNom(String nom) {
		return dao.consulterUtilisateurParNom(nom);
	}

	@Override
	public List<Utilisateur> consulterListeUtilisateurParPrivilege(String libelle) {
		Privilege p = dao.consulterPrivilegeParLibelle(libelle);
		return dao.consulterUtilisateurParPrivilege(p.getLibelle());
	}

	@Override
	public Utilisateur ajouterPrivilegeAUtilisateur(String libellePrivilege, String login) {
		Privilege p = dao.consulterPrivilegeParLibelle(libellePrivilege);
		Utilisateur u = dao.consulterUtilisateurParLogin(login);
		return dao.ajouterPrivilegeAUtilisateur(p, u);
	}

	@Override
	public List<Utilisateur> consulterTousLesUtilisateur() {
		return dao.consulterTousLesUtilisateur();
	}

	@Override
	public Utilisateur consulterUtilisateurParLogin(String login) {
		return dao.consulterUtilisateurParLogin(login);
	}
	
	@Override
	public  List<Professeur> consulterTousLesProfesseursDuneClasse(String libelle) {
		return dao.consulterTousLesProfesseursDuneClasse(libelle);
	}
	
	@Override
	public List<Eleve> consulterTousLesLelevesDuneClasse(String libelle){
		return dao.consulterTousLesLelevesDuneClasse(libelle);
	}

	@Override
	public void supprimerUtilisateur(String login) {
		Utilisateur u = dao.consulterUtilisateurParLogin(login);
		dao.supprimerUtilisateur(u);
	}

	@Override
	public void supprimerTousLesUtilisateurs() {
		dao.supprimerTousLesUtilisateurs();
	}

	/*
	 * Gestion des niveaux
	 */
	@Override
	public Niveau consulterNiveauParId(int id) {
		return dao.consulterNiveauParId(id);
	}

	@Override
	public Niveau consulterNiveauParLibelle(String libelle) {
		return dao.consulterNiveauParLibelle(libelle);
	}

	@Override
	public List<Niveau> consulterTousLesNiveaux() {
		return dao.consulterTousLesNiveaux();
	}

	@Override
	public Niveau ajouterNiveau(Niveau n) {
		return dao.ajouterNiveau(n);
	}

	@Override
	public Niveau ajouterClasseANiveau(String libelleClass, String libelleNiveau) {
		Classe c = dao.consulterClasseParLibelle(libelleClass);
		Niveau n = dao.consulterNiveauParLibelle(libelleNiveau);
		return dao.ajouterClasseANiveau(c, n);
	}

	@Override
	public Niveau supprimerClasseANiveau(String libelleClass, String libelleNiveau) {
		Classe c = dao.consulterClasseParLibelle(libelleClass);
		Niveau n = dao.consulterNiveauParLibelle(libelleNiveau);
		return dao.supprimerClasseANiveau(c, n);
	}

	@Override
	public Niveau miseAJourNiveau(Niveau n) {
		return dao.miseAJourNiveau(n);
	}

	@Override
	public void supprimerNiveau(String libelleNiveau) {
		Niveau n = dao.consulterNiveauParLibelle(libelleNiveau);
		dao.supprimerNiveau(n);
	}

	@Override
	public void supprimerTousLesNiveaux() {
		dao.supprimerTousLesNiveaux();
	}

	/*
	 * Gestion des classes
	 */
	@Override
	public Classe consulterClasseParId(int id) {
		return dao.consulterClasseParId(id);
	}

	@Override
	public void AjouterProfPrincipal(String libelleClasse, String login) {
		dao.AjouterProfPrincipal(libelleClasse, login);
	}

	@Override
	public void ajouterProfesseurAClasse(String login, String libelleClasse) {
		dao.ajouterProfesseurAClasse(login, libelleClasse);
	}

	@Override
	public Classe consulterClasseParLibelle(String libelleClasse) {
		return dao.consulterClasseParLibelle(libelleClasse);
	}

	@Override
	public List<Classe> consulterToutesLesClasses() {
		return dao.consulterToutesLesClasses();
	}

	@Override
	public List<Classe> consulterToutesLesClassesDUnNiveauParLibelle(String libelleNiveau) {
		consulterNiveauParLibelle(libelleNiveau);
		return dao.consulterToutesLesClassesDUnNiveau(libelleNiveau);
	}

	@Override
	public List<Classe> consulterToutesLesClassesDUnNiveauParId(int id){
		Niveau niveau = consulterNiveauParId(id);
		return dao.consulterToutesLesClassesDUnNiveau(niveau.getLibelle());	
	}
	
	@Override
	public Classe ajouterClasse(Classe c) {
		return dao.ajouterClasse(c);
	}

	@Override
	public Classe ajouterEleveAClasse(String libelleClasse, String login) {
		Classe classe = dao.consulterClasseParLibelle(libelleClasse);
		Eleve eleve = (Eleve) dao.consulterUtilisateurParLogin(login);
		return dao.ajouterEleveAClasse(classe, eleve);
	}

	@Override
	public Classe ajouterMatiereAClasse(String libelleMatiere, String libelleClasse) {
		Matiere matiere = dao.consulterMatiereParLibelle(libelleMatiere);
		Classe classe = dao.consulterClasseParLibelle(libelleClasse);
		return dao.ajouterMatiereAClasse(matiere, classe);
	}

	@Override
	public Classe miseAJourClasse(Classe c) {
		return dao.miseAJourClasse(c);
	}

	@Override
	public void supprimerClasse(String libelleClasse) {
		Classe c = consulterClasseParLibelle(libelleClasse);
		dao.supprimerClasse(c);
	}

	@Override
	public void supprimerToutesLesClasses() {
		dao.supprimerToutesLesClasses();
	}

	@Override
	public void supprimerToutesLesClassesDUnNiveau(String libelleNiveau) {
		consulterNiveauParLibelle(libelleNiveau);
		List<Classe> classes = consulterToutesLesClassesDUnNiveauParLibelle(libelleNiveau);
		dao.supprimerToutesLesClassesDUnNiveau(classes);
	}

	@Override
	public Devoir consulterDevoirParId(int id) {
		return dao.consulterDevoirParId(id);
	}

	@Override
	public List<Devoir> consulterDevoirParClasse(String libelleClasse) {
		consulterClasseParLibelle(libelleClasse);
		return dao.consulterDevoirParClasse(libelleClasse);
	}

	@Override
	public List<Devoir> consulterDevoirParEleve(String login) {
		consulterUtilisateurParLogin(login);
		return dao.consulterDevoirParEleve(login);
	}

	@Override
	public List<Devoir> consulterDevoirParMatiereEtClasse(String libelleMatiere, String libelleClasse) {
		consulterClasseParLibelle(libelleClasse);
		consulterMatiereParLibelle(libelleMatiere);
		return dao.consulterDevoirParMatiereEtClasse(libelleMatiere, libelleClasse);
	}

	@Override
	public List<Devoir> consulterDevoirParProfesseur(String login) {
		consulterUtilisateurParLogin(login);
		return dao.consulterDevoirParProfesseur(login);
	}

	@Override
	public Devoir ajouterDevoir(Devoir d) {
		return dao.ajouterDevoir(d);
	}

	@Override
	public Devoir miseAJourDevoir(Devoir d) {
		return dao.ajouterDevoir(d);
	}

	@Override
	public void supprimerDevoir(Devoir d) {
		dao.supprimerDevoir(d);
	}

	@Override
	public void supprimerTousLesDevoirs() {
		dao.supprimerTousLesDevoirs();
	}

	@Override
	public Etablissement consulterEtablissementparId(int id) {
		return dao.consulterEtablissementparId(id);
	}

	@Override
	public Etablissement ajouterEtablissement(Etablissement e) {
		return dao.ajouterEtablissement(e);
	}

	@Override
	public Etablissement miseAJourEtablissement(Etablissement e) {
		return dao.miseAJourEtablissement(e);
	}

	@Override
	public void supprimerEtablissement(Etablissement e) {
		dao.supprimerEtablissement(e);
	}

	@Override
	public void supprimerTousLesEtablissements() {
		dao.supprimerTousLesEtablissements();
	}

	@Override
	public Matiere consulterMatiereParId(int id) {
		return dao.consulterMatiereParId(id);
	}

	@Override
	public Matiere consulterMatiereParLibelle(String libelle) {
		return dao.consulterMatiereParLibelle(libelle);
	}

	/**
	 * Gestion des matieres
	 **/

	@Override
	public void ajouterProfesseurAMatiere(String login, String libelle) {
		dao.ajouterProfesseurAMatiere(login, libelle);
	}

	@Override
	public void ajouterMatiereAProfesseur(String libelle, String login) {
		dao.ajouterProfesseurAMatiere(login, libelle);
	}

	@Override
	public List<Matiere> consulterToutesLesMatieres() {
		return dao.consulterToutesLesMatieres();
	}

	@Override
	public List<Matiere> consulterToutesLesMatieresParProfesseur(String login) {
		consulterUtilisateurParLogin(login);
		return dao.consulterToutesLesMatieresParProfesseur(login);
	}

	@Override
	public List<Matiere> consulterToutesLesMatieresParClasse(String libelleClasse) {
		consulterClasseParLibelle(libelleClasse);
		return dao.consulterToutesLesMatieresParClasse(libelleClasse);
	}

	@Override
	public Matiere ajouterMatiere(Matiere m) {
		return dao.ajouterMatiere(m);
	}

	@Override
	public Matiere miseAJourMatiere(Matiere m) {
		return dao.miseAJourMatiere(m);
	}

	@Override
	public void supprimerMatiere(Matiere m) {
		dao.supprimerMatiere(m);
	}

	@Override
	public void supprimerToutesLesMatieres() {
		dao.supprimerToutesLesMatieres();
	}

	/**
	 * ******************************************************************************
	 * Gestion des questions *
	 * *****************************************************************************
	 */
	@Override
	public Question consulterQuestionParId(int id) {
		return dao.consulterQuestionParId(id);
	}

	@Override
	public Question ajouterQuestion(Question question) {
		return dao.ajouterQuestion(question);
	}

	@Override
	public Question miseAJourQuestion(Question question) {
		return dao.miseAJourQuestion(question);
	}

	@Override
	public Question consulterQuestionParLibelle(String libelle) {
		return dao.consulterQuestionParLibelle(libelle);
	}

	@Override
	public List<Question> consulterQuestionsParProfesseur(String loginProf) {
		consulterUtilisateurParLogin(loginProf);
		return dao.consulterQuestionsParProfesseur(loginProf);
	}

	@Override
	public void supprimerQuestion(Question question) {
		dao.supprimerQuestion(question);
	}

	@Override
	public void supprimerListeQuestions(List<Question> questions) {
		dao.supprimerListeQuestions(questions);
	}

	/**
	 * ******************************************************************************
	 * Gestion des competences *
	 * *****************************************************************************
	 */
	@Override
	public Competence consulterCompetenceParId(int id) {
		return dao.consulterCompetenceParId(id);
	}

	@Override
	public Competence ajouterCompetence(Competence competence) {
		return dao.ajouterCompetence(competence);
	}

	@Override
	public Competence miseAJourCompetence(Competence competence) {
		return dao.miseAJourCompetence(competence);
	}

	@Override
	public Competence consulterCompetenceParLibelle(String libelle) {
		return dao.consulterCompetenceParLibelle(libelle);
	}

	@Override
	public void supprimerCompetence(Competence competence) {
		dao.supprimerCompetence(competence);
	}

	@Override
	public void supprimerListeCompetences(List<Competence> competences) {
		dao.supprimerListeCompetences(competences);
	}

}
