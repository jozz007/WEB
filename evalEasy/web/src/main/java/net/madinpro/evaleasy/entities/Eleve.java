package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author jozz007
 */
@Entity
@Table(name = "ELEVE")
@PrimaryKeyJoinColumn(name = "ID")
@SuppressWarnings("serial")
public class Eleve extends Utilisateur implements Serializable {

	@ManyToMany(mappedBy = "eleves")
	private List<Devoir> devoirs;
	
	@ManyToMany(mappedBy = "eleves")
	private List<Matiere> matieres;
	
	@ManyToMany(mappedBy = "eleves")
	private List<Competence> competences ;

	@Column(name = "MOY_GENERALE", nullable = true, unique = false)
	private Double moyenneGenerale;

	@Column(name = "MOY_PAR_MATIERE", nullable = true, unique = false)
	private Double moyenneParMatiere;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CLASSE", nullable = true)
	private Classe classe;

	public Eleve() {
		super();
	}



	public Eleve(String login, String nom, String prenom, String email, String telephone, Privilege droitUtilisateur,
			String motDePasse, Date dateDeNaissance, Adresse adresse, List<Devoir> devoirs, Double moyenneGenerale,
			Double moyenneParMatiere, Classe classe) {
		super(login, nom, prenom, email, telephone, droitUtilisateur, motDePasse, dateDeNaissance, adresse);
		this.devoirs = devoirs;
		this.moyenneGenerale = moyenneGenerale;
		this.moyenneParMatiere = moyenneParMatiere;
		this.classe = classe;
	}



	public List<Devoir> getDevoirs() {
		return devoirs;
	}

	public void setDevoirs(List<Devoir> devoirs) {
		this.devoirs = devoirs;
	}

	public Double getMoyenneGenerale() {
		return moyenneGenerale;
	}

	public void setMoyenneGenerale(Double moyenneGenerale) {
		this.moyenneGenerale = moyenneGenerale;
	}

	public Double getMoyenneParMatiere() {
		return moyenneParMatiere;
	}

	public void setMoyenneParMatiere(Double moyenneParMatiere) {
		this.moyenneParMatiere = moyenneParMatiere;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}



	public List<Competence> getCompetences() {
		return competences;
	}



	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}



	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}



	@Override
	public String toString() {
		return "Eleve{ " + super.toString() + " moyenneGenerale=" + moyenneGenerale + ", moyenneParMatiere="
				+ moyenneParMatiere + '}';
	}

}