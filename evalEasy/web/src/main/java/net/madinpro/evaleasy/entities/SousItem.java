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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="SOUS_ITEM")
public class SousItem implements Serializable {

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
	
	@OneToMany(mappedBy = "sousItem", cascade = { CascadeType.ALL })
	private List<Palier> paliers;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ITEM", nullable = true)
	private Item item;
	
	public SousItem() {
		
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

	public List<Palier> getPaliers() {
		return paliers;
	}

	public void setPaliers(List<Palier> paliers) {
		this.paliers = paliers;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
