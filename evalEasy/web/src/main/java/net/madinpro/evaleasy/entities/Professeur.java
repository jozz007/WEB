package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PROFESSEUR")
@PrimaryKeyJoinColumn(name = "ID")
public class Professeur extends Utilisateur implements Serializable {

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CLASSE", unique = true, nullable = true)
	private Classe classePrincipale;

	@ManyToMany(mappedBy = "professeurs", cascade = { CascadeType.ALL })
	private List<Classe> classes;

	@OneToMany(mappedBy = "professeur", cascade = { CascadeType.ALL })
	private List<Devoir> devoirs;

	@OneToMany(mappedBy = "professeur", cascade = { CascadeType.ALL })
	private List<Question> questions;

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch=FetchType.EAGER)
	@JoinTable(name = "PROF_MATIERE", joinColumns = @JoinColumn(name = "PROF_ID"), inverseJoinColumns = @JoinColumn(name = "MATIERE_ID"))
	private List<Matiere> matieres;

	public Professeur() {
		super();
	}



	public Professeur(String login, String nom, String prenom, String email, String telephone,
			Privilege droitUtilisateur, String motDePasse, Date dateDeNaissance, Adresse adresse, Classe classe,
			List<Classe> classes, List<Devoir> devoirs, List<Question> questions, List<Matiere> matieres) {
		super(login, nom, prenom, email, telephone, droitUtilisateur, motDePasse, dateDeNaissance, adresse);
		this.classePrincipale = classe;
		this.classes = classes;
		this.devoirs = devoirs;
		this.questions = questions;
		this.matieres = matieres;
	}



	public Classe getClassePrincipale() {
		return classePrincipale;
	}

	public void setClassePrincipale(Classe classe) {
		this.classePrincipale = classe;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Devoir> getDevoirs() {
		return devoirs;
	}

	public void setDevoirs(List<Devoir> devoirs) {
		this.devoirs = devoirs;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Professeur{ " + super.toString() + " }";
	}
	
	

}
