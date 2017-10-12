package net.madinpro.evaleasy.models;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.entities.Professeur;

public class ClasseForm {

	@NotEmpty
	@Size(min = 5, max = 9)
	private String libelle;
	
	private Classe classe;
	
	List<Professeur> professeurs;
	
	List<Eleve> eleves;

	private Niveau niveau;

	private String exception;

	public String getLibelle() {
		return libelle;
	}
	
	public Classe getClasse() {
		return classe;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public String getException() {
		return exception;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs2) {
		this.professeurs = professeurs2;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	
}
