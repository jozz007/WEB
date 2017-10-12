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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "NIVEAU")
public class Niveau implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false, unique = true)
	private String libelle;

	@OneToMany(mappedBy = "niveauClasse", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	private List<Classe> classes;

	public Niveau() {
	}

	public Niveau(String libelle) {
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

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Niveau{" + "libelle=" + libelle + '}';
	}

}
