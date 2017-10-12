package net.madinpro.evaleasy.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ETABLISSEMENT")
public class Etablissement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;

	@Column(name = "IDENTIFIANT", unique = true, nullable = false)
	private String id_ets;

	@Column(name = "NOM", unique = false, nullable = false)
	private String nom;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ADRESSE", unique = true, nullable = false)
	private Adresse adresse;

	public Etablissement() {
	}

	public Etablissement(Integer id, int version) {
		this.id = id;
		this.version = version;
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

	public String getId_ets() {
		return id_ets;
	}

	public void setId_ets(String id_ets) {
		this.id_ets = id_ets;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Etablissement{" + "id_ets=" + id_ets + ", nom=" + nom + '}';
	}

}