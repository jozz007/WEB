package net.madinpro.evaleasy.models;

import java.util.List;

import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Niveau;

public class NiveauForm {

	private String exception;


	private String libelle;
	
	private int id;

	private List<Niveau> niveaux;

	List<Classe> classes;

	public NiveauForm() {
		this.libelle = "Cp";
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(List<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
}
