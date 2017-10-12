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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADRESSE")
public class Adresse implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;

	@Column(name = "IMMEUBLE", nullable = true, unique = false)
	private String immeuble;

	@Column(name = "NUMERO_RUE", nullable = true, unique = false)
	private String numeroRue;

	@Column(name = "NOM_RUE", nullable = false, unique = false)
	private String nomRue;

	@Column(name = "CODE_POSTAL", nullable = false, unique = false)
	private Integer codePostal;

	@Column(name = "VILLE", nullable = false, unique = false)
	private String ville;

	@Column(name = "PAYS", nullable = false, unique = false)
	private String pays = "France";

	@OneToMany(mappedBy = "adresse", cascade = {CascadeType.ALL})
	private List<Utilisateur> utilisateurs;

	@OneToOne(mappedBy = "adresse", fetch = FetchType.EAGER)
	private Etablissement etablissement;

	public Adresse() {

	}

	public Adresse(Integer id, int version, String immeuble, String numeroRue, String nomRue, Integer codePostal,
			String ville, String pays, List<Utilisateur> utilisateurs, Etablissement etablissement) {
		super();
		this.id = id;
		this.version = version;
		this.immeuble = immeuble;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.utilisateurs = utilisateurs;
		this.etablissement = etablissement;
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



	public String getImmeuble() {
		return immeuble;
	}



	public void setImmeuble(String immeuble) {
		this.immeuble = immeuble;
	}



	public String getNumeroRue() {
		return numeroRue;
	}



	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}



	public String getNomRue() {
		return nomRue;
	}



	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}



	public Integer getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}



	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}



	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}



	public Etablissement getEtablissement() {
		return etablissement;
	}



	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}



	@Override
	public String toString() {
		return "Adresse [id=" + id + ", version=" + version + ", immeuble=" + immeuble + ", numeroRue=" + numeroRue
				+ ", nomRue=" + nomRue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + "]";
	}

}
