package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "COMPETENCE")
public class Competence implements Serializable {

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
	
	
	@ManyToMany(mappedBy="competences")
	@Column(name = "MATIERE")
	private List<Matiere> matieres;


	@ManyToMany(mappedBy = "competences")
	private List<Question> questions;
	
	@OneToMany(mappedBy = "competence", cascade = { CascadeType.ALL })
	private List<Item>items ;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "COMPETENCES_DOMAINES", joinColumns = @JoinColumn(name = "ID_DOMAINE"), inverseJoinColumns = @JoinColumn(name = "ID_COMPETENCE"))
	List<Domaine> domaines;
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "COMPETENCES_ELEVES", joinColumns = @JoinColumn(name = "ID_ELEVE"), inverseJoinColumns = @JoinColumn(name = "ID_COMPETENCE"))
	List<Eleve> eleves;

	public Competence() {
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

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	
	
}
