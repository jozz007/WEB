package net.madinpro.evaleasy.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "UTILISATEUR")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private int version;

	@Column(name = "LOGIN", nullable = false, unique = true)
	private String login;

	@Column(name = "NOM", nullable = false, unique = false)
	private String nom;

	@Column(name = "PRENOM", nullable = false, unique = false)
	private String prenom;
	
	@Column(name = "SEXE", nullable = true, unique = false)
	private String sexe;

	@Column(name = "MAIL", nullable = false, unique = true)
	private String email;
	
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "DROIT_ID")
	private Privilege privilege;

	@Column(name = "PASSWORD", nullable = false, unique = false)
	private String motDePasse;

	@Column(name = "DATENAISSANCE", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDeNaissance;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ADRESSE", unique = true, nullable = false)
	private Adresse adresse;

	public Utilisateur() {
	}

	public Utilisateur(String login, String nom, String prenom, String email, String telephone, Privilege privilege,
			String motDePasse, Date dateDeNaissance, Adresse adresse) {
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.privilege = privilege;
		this.motDePasse = motDePasse;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public String getLogin() {
		return login;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public java.util.Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setNom(String nom) {
		String debutNom = nom.substring(0,1).toUpperCase();
		String finNom = nom.substring(1).toLowerCase();
		this.nom = debutNom+finNom;
	}

	public void setPrenom(String prenom) {
		String debutNom = prenom.substring(0,1).toUpperCase();
		String finNom = prenom.substring(1).toLowerCase();
		this.prenom = debutNom+finNom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setDateDeNaissance(java.util.Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		if(sexe == "f" ||sexe == "F") {
			this.sexe = "Mme ";
		}
		if(sexe == "m" ||sexe == "M") {
			this.sexe = "M ";
		}
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", version=" + version + ", login=" + login + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", privilege=" + privilege.getLibelle()
				+ ", motDePasse=" + motDePasse + ", dateDeNaissance=" + dateDeNaissance + "]";
	}


}
