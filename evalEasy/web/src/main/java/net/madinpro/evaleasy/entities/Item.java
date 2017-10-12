package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.lang.Integer;
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
import javax.persistence.Version;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
@Table(name="ITEM")
public class Item implements Serializable {

	   
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
	
	@OneToMany(mappedBy = "item", cascade = { CascadeType.ALL })
	private List<SousItem>sousItems ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COMPETENCE", nullable = true)
	private Item competence;
	

	public Item() {
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


	public List<SousItem> getSousItems() {
		return sousItems;
	}


	public void setSousItems(List<SousItem> sousItems) {
		this.sousItems = sousItems;
	}


	public Item getCompetence() {
		return competence;
	}


	public void setCompetence(Item competence) {
		this.competence = competence;
	}   
   
}
