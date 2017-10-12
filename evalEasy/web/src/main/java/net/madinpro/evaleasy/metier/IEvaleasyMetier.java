package net.madinpro.evaleasy.metier;

import java.util.List;

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
public interface IEvaleasyMetier {

	/*
	 * GFestion des adresses
	 */
	public Adresse consulterAdresseparId(int id);

	public Adresse AjouterAdresse(Adresse adresse);

	public Adresse miseAJourAdresse(Adresse adresse);

	public void supprimerAdresse(Adresse adresse);

	public Adresse consulterAdresseParUtilisateur(String login);

	public void supprimerToutesAdresses();

	// ***************************************************************************/
	// Gestion des Privileges
	public Privilege consulterPrivilegeParLibelle(String libelleDroit);

	public Privilege consulterPrivilegeParID(int id);

	public List<Privilege> consulterTousLesPrivileges();

	public Privilege ajouterPrivilege(Privilege p);

	public Privilege miseAJourPrivilege(Privilege p);

	public void supprimerPrivilegeParLibelle(String libelle);

	public void supprimerTousLesPrivileges();

	// ***************************************************************************/
	// Gestion des Utilisateurs
	// Gestion des Utilisateur
	public Utilisateur consulterUtilisateurId(int id);

	public Utilisateur AjouterUtilisateur(Utilisateur u);

	public Utilisateur miseAJourUtilisateur(Utilisateur u);

	public List<Utilisateur> consulterListeUtilisateurParNom(String nom);

	public List<Utilisateur> consulterListeUtilisateurParPrivilege(String libelle);

	public List<Professeur> consulterTousLesProfesseursDuneClasse(String libelle);
	
	public List<Eleve> consulterTousLesLelevesDuneClasse(String libelle);

	public Utilisateur ajouterPrivilegeAUtilisateur(String libellePrivilege, String login);

	public List<Utilisateur> consulterTousLesUtilisateur();

	public Utilisateur consulterUtilisateurParLogin(String login);

	public void supprimerUtilisateur(String login);

	public void supprimerTousLesUtilisateurs();

	// Gestion des niveaux
	public Niveau consulterNiveauParId(int id);

	public Niveau consulterNiveauParLibelle(String libelle);

	public List<Niveau> consulterTousLesNiveaux();

	public Niveau ajouterNiveau(Niveau n);

	public Niveau ajouterClasseANiveau(String libelleClass, String libelleNiveau);

	public Niveau supprimerClasseANiveau(String libelleClass, String libelleNiveau);

	public Niveau miseAJourNiveau(Niveau n);

	public void supprimerNiveau(String libelleNiveau);

	public void supprimerTousLesNiveaux();

	// Gestion des Classe
	public Classe consulterClasseParId(int id);

	public void AjouterProfPrincipal(String libelleClasse, String login);

	public void ajouterProfesseurAClasse(String login, String libelleClasse);

	public Classe consulterClasseParLibelle(String libelleClasse);

	public List<Classe> consulterToutesLesClasses();

	public List<Classe> consulterToutesLesClassesDUnNiveauParLibelle(String libelleNiveau);
	
	public List<Classe> consulterToutesLesClassesDUnNiveauParId(int id);

	public Classe ajouterClasse(Classe c);

	public Classe ajouterEleveAClasse(String libelleClasse, String login);

	public Classe ajouterMatiereAClasse(String login, String libelleClasse);

	public Classe miseAJourClasse(Classe c);

	public void supprimerClasse(String libelleClasse);

	public void supprimerToutesLesClasses();

	public void supprimerToutesLesClassesDUnNiveau(String libelleNiveau);

	// Gestion des Devoir
	public Devoir consulterDevoirParId(int id);

	public List<Devoir> consulterDevoirParClasse(String libelleClasse);

	public List<Devoir> consulterDevoirParEleve(String login);

	public List<Devoir> consulterDevoirParMatiereEtClasse(String libelleMatiere, String libelleClasse);

	public List<Devoir> consulterDevoirParProfesseur(String login);

	public Devoir ajouterDevoir(Devoir d);

	public Devoir miseAJourDevoir(Devoir d);

	public void supprimerDevoir(Devoir d);

	public void supprimerTousLesDevoirs();

	// Gestion des Etablissements
	public Etablissement consulterEtablissementparId(int id);

	public Etablissement ajouterEtablissement(Etablissement e);

	public Etablissement miseAJourEtablissement(Etablissement e);

	public void supprimerEtablissement(Etablissement e);

	public void supprimerTousLesEtablissements();

	// Gestion des Matieres
	public void ajouterProfesseurAMatiere(String login, String libelle);

	public void ajouterMatiereAProfesseur(String libelle, String login);

	public Matiere consulterMatiereParId(int id);

	public Matiere consulterMatiereParLibelle(String libelle);

	public List<Matiere> consulterToutesLesMatieres();

	public List<Matiere> consulterToutesLesMatieresParProfesseur(String login);

	public List<Matiere> consulterToutesLesMatieresParClasse(String libelleClasse);

	public Matiere ajouterMatiere(Matiere m);

	public Matiere miseAJourMatiere(Matiere m);

	public void supprimerMatiere(Matiere m);

	public void supprimerToutesLesMatieres();

	// Gestion des Questions
	public Question consulterQuestionParId(int id);

	public Question ajouterQuestion(Question question);

	public Question miseAJourQuestion(Question question);

	public Question consulterQuestionParLibelle(String libelle);

	public List<Question> consulterQuestionsParProfesseur(String loginProf);

	public void supprimerQuestion(Question question);

	public void supprimerListeQuestions(List<Question> questions);

	// Gestion des Competences

	public Competence consulterCompetenceParId(int id);

	public Competence ajouterCompetence(Competence competence);

	public Competence miseAJourCompetence(Competence competence);

	public Competence consulterCompetenceParLibelle(String libelle);

	public void supprimerCompetence(Competence competence);

	public void supprimerListeCompetences(List<Competence> competences);
}
