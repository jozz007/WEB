package net.madinpro.evaleasy.models;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Niveau;

public class NiveauClasseForm {
	
	@NotEmpty
	private String libelle;
	
	private Niveau niveau;
	
	private List<Classe> classes;
	
	private String exception;

	public NiveauClasseForm() {
		this.libelle = "Cp";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	
	
}
