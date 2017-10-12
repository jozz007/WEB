package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DEVOIR")
public class Devoir implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	@Column(name = "VERSION", nullable = false, unique = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false)
	private String libelle;

	@Column(name = "TOTAL_NOTE", nullable = false)
	private Double noteTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATIERE", nullable = false)
	private Matiere matiere;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFESSEUR", nullable = false)
	private Professeur professeur;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "DEVOIRS_ELEVES", joinColumns = @JoinColumn(name = "ID_ELEVE"), inverseJoinColumns = @JoinColumn(name = "ID_DEVOIR"))
	List<Eleve> eleves;

	@ManyToMany(mappedBy = "devoirs")
	private List<Classe> classes;

	@ManyToMany(mappedBy = "devoirs")
	private List<Question> questions;

	public Devoir() {
	}

	public Devoir(String libelle, Matiere matiere, Professeur professeur, Double note) {
		this.libelle = libelle;
		this.matiere = matiere;
		this.professeur = professeur;
		this.noteTotal = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle.toLowerCase();
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Double getNoteTotal() {
		return noteTotal;
	}

	public void setNoteTotal(Double noteTotal) {
		this.noteTotal = noteTotal;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Devoir{" + "id=" + id + ", version=" + version + ", libelle=" + libelle + ", matiere=" + matiere
				+ ", professeur=" + professeur.getNom() + '}';
	}

}