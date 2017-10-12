package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Domaine
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "DOMAINE")
public class Domaine implements Serializable {


	@Id
	@Column(name="ID", nullable =false, unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;
	
	@Column(name="LIBELLE")
	private String libelle;
	
	@ManyToMany(mappedBy = "domaines")
	private List<Competence> competences ;
	
	public Domaine() {
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
		this.libelle = libelle;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
   
}
