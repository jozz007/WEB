package net.madinpro.evaleasy.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Devoir;
import net.madinpro.evaleasy.entities.Matiere;
import net.madinpro.evaleasy.entities.Privilege;
import net.madinpro.evaleasy.entities.Question;
import net.madinpro.evaleasy.entities.Utilisateur;

public class UserForm {

	@NotEmpty
	@Size(min = 6, max = 15)
	private String login;

	private Utilisateur utilisateur;

	private Devoir devoir;

	private Classe classe;

	private Matiere matiere;

	private Privilege privilege;

	private Question question;

	private String typeUtilisateur;

	private String exception;

	private Adresse adresse;

	public UserForm() {
	}

	public String getLogin() {
		return login;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public Devoir getDevoir() {
		return devoir;
	}

	public Classe getClasse() {
		return classe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public Question getQuestion() {
		return question;
	}

	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public String getException() {
		return exception;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
