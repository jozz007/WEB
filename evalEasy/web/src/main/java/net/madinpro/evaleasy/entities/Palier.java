package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Palier
 *
 */
@Entity
@Table(name="PALIER")
public class Palier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Version
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VSERION", unique = false, nullable = false)
	private int version;

	@Column(name = "LIBELLE", nullable = false, unique = true)
	private String libelle;
	
	@Column(name = "NIVEAU", nullable = false, unique = true)
	private String niveau;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SOUS_ITEM", nullable = true)
	private SousItem sousItem;
	
	public Palier() {
		
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

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public SousItem getSousItem() {
		return sousItem;
	}

	public void setSousItem(SousItem sousItem) {
		this.sousItem = sousItem;
	}
	
	
}
