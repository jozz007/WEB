package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PRIVILEGE")
public class Privilege implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, unique = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false, unique = true)
	private String libelle;

	@Column(name = "NIVEAU", nullable = false, unique = true)
	private int niveauDroit;

	@OneToMany(mappedBy = "privilege", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public Privilege() {
	}

	public Privilege(String libelleDroit, int niveauDroit) {
		this.libelle = libelleDroit;
		this.niveauDroit = niveauDroit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNiveauDroit() {
		return niveauDroit;
	}

	public void setNiveauDroit(int niveauDroit) {
		this.niveauDroit = niveauDroit;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 */
	@Override
	public String toString() {
		return "Privilege{" + "libelleDroit=" + libelle + ", niveauDroit=" + niveauDroit + '}';
	}
}
