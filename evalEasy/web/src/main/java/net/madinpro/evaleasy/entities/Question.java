package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Question")
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Version
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VSERION", unique = false, nullable = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false, unique = false)
	private String libelle;

	@Column(name = "ENONCE", nullable = false, unique = false)
	private String enonce;

	@Column(name = "NOTE", nullable = true, unique = false)
	private Double note;

	@Column(name = "BAREME", nullable = true, unique = false)
	private Double bareme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROF_ID", nullable = false)
	private Professeur professeur;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "QUESTION_DEVOIR", joinColumns = @JoinColumn(name = "QUESTION_ID"), inverseJoinColumns = @JoinColumn(name = "DEVOIR_ID"))
	private List<Devoir> devoirs;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "QUESTION_COMPETENCE", joinColumns = @JoinColumn(name = "QUESTION_ID"), inverseJoinColumns = @JoinColumn(name = "COMPETENCE_ID"))
	private List<Competence> competences;

	public Question() {

	}

	public Question(String libelle, String enonce, Double note, Double bareme) {
		this.libelle = libelle;
		this.enonce = enonce;
		this.note = note;
		this.bareme = bareme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		this.libelle = libelle;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Double getBareme() {
		return bareme;
	}

	public void setBareme(Double bareme) {
		this.bareme = bareme;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public List<Devoir> getDevoirs() {
		return devoirs;
	}

	public void setDevoirs(List<Devoir> devoirs) {
		this.devoirs = devoirs;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

}
