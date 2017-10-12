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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CLASSE")
public class Classe implements Serializable {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false, unique = true)
	private String libelle;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_NIVEAU", nullable = false)
	private Niveau niveauClasse;

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinTable(name = "CLASSE_PROF", joinColumns = @JoinColumn(name = "CLASSE_ID"), inverseJoinColumns = @JoinColumn(name = "PROFESSEUR_ID"))
	private List<Professeur> professeurs;

	@OneToMany(mappedBy = "classe", cascade = { CascadeType.ALL })
	private List<Eleve> eleves;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "CLASSE_DEVOIR", joinColumns = @JoinColumn(name = "CLASSE_ID"), inverseJoinColumns = @JoinColumn(name = "DEVOIR_ID"))
	private List<Devoir> devoirs;

	@OneToOne(mappedBy = "classePrincipale", fetch=FetchType.LAZY)
	private Professeur profPrincipal;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "CLASSE_MATIERE", joinColumns = @JoinColumn(name = "CLASSE_ID"), inverseJoinColumns = @JoinColumn(name = "MATIERE_ID"))
	private List<Matiere> matieres;

	public Classe() {

	}

	public Classe(String libelleClasse, Niveau niveauClasse, Professeur profPrincipal) {
		this.libelle = libelleClasse;
		this.niveauClasse = niveauClasse;
		this.profPrincipal = profPrincipal;
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
		this.libelle = libelle.toUpperCase();
	}

	public Niveau getNiveauClasse() {
		return niveauClasse;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setNiveauClasse(Niveau niveauClasse) {
		this.niveauClasse = niveauClasse;
	}

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	public List<Devoir> getDevoirs() {
		return devoirs;
	}

	public void setDevoirs(List<Devoir> devoirs) {
		this.devoirs = devoirs;
	}

	public Professeur getProfPrincipal() {
		return profPrincipal;
	}

	public void setProfPrincipal(Professeur profPrincipal) {
		this.profPrincipal = profPrincipal;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Classe{" + "libelleClasse=" + this.getLibelle() + ", niveauClasse=" + niveauClasse.getLibelle()
				+ ", profPrincipal=" + profPrincipal.getNom() + " " + profPrincipal.getPrenom() + "}\n";
	}

}
