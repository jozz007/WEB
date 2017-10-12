package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MATIERE")
public class Matiere implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Version
	@Column(name = "VERSION", nullable = false, unique = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false, unique = true)
	private String libelle;

	@OneToMany(mappedBy = "matiere", cascade = { CascadeType.ALL })
	private List<Devoir> devoirs;

	@ManyToMany(mappedBy = "matieres", cascade = { CascadeType.ALL })
	private List<Classe> classes;

	@ManyToMany(mappedBy = "matieres", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	private List<Professeur> professeurs;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "MATIERE_COMPETENCE", joinColumns = @JoinColumn(name = "MATIERE_ID"), inverseJoinColumns = @JoinColumn(name = "COMPETENCE_ID"))
	private List<Competence> competences;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "MATIERES_ELEVES", joinColumns = @JoinColumn(name = "ID_ELEVE"), inverseJoinColumns = @JoinColumn(name = "ID_MATIERE"))
	List<Eleve> eleves;

	public Matiere() {
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
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

	public List<Classe> getClasses() {
		return classes;
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

	public List<Devoir> getDevoirs() {
		return devoirs;
	}

	public void setDevoirs(List<Devoir> devoirs) {
		this.devoirs = devoirs;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	@Override
	public String toString() {
		return libelle;
	}

}
