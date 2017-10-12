package net.madinpro.evaleasy.models;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import net.madinpro.evaleasy.entities.Utilisateur;

public class ListUserForm {

	@NotEmpty
	private String nom;

	private String exception;

	private int page = 0;

	private int nbUser = 5;
	
	private int nbPages = 0;

	private List<Utilisateur> utilisateurs;

	public String getNom() {
		return nom;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbUser() {
		return nbUser;
	}

	public void setNbUser(int nbUser) {
		this.nbUser = nbUser;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

}
