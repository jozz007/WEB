package net.madinpro.evaleasy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.madinpro.evaleasy.entities.Adresse;
import net.madinpro.evaleasy.entities.Classe;
import net.madinpro.evaleasy.entities.Competence;
import net.madinpro.evaleasy.entities.Devoir;
import net.madinpro.evaleasy.entities.Eleve;
import net.madinpro.evaleasy.entities.Etablissement;
import net.madinpro.evaleasy.entities.Matiere;
import net.madinpro.evaleasy.entities.Niveau;
import net.madinpro.evaleasy.entities.Privilege;
import net.madinpro.evaleasy.entities.Professeur;
import net.madinpro.evaleasy.entities.Question;
import net.madinpro.evaleasy.entities.Utilisateur;
import net.madinpro.evaleasy.exceptions.DaoException;

/**
 *
 * @author jozz007
 */
@SuppressWarnings("unchecked")
public class EvaleasyDao implements IEvaleasyDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Adresse consulterAdresseparId(int id) {
		if ((em.find(Adresse.class, id)) != null) {
			Adresse a = em.find(Adresse.class, id);
			return a;
		}
		throw new DaoException("Aucune information trouvée");

	}

	/**
	 * ******************************************************************************
	 * Gestion des adresses *
	 * *****************************************************************************
	 */
	@Override
	public Adresse AjouterAdresse(Adresse adresse) {
		em.persist(adresse);
		return adresse;
	}

	@Override
	public Adresse miseAJourAdresse(Adresse adresse) {
		try {
			return em.merge(adresse);
		} catch (RuntimeException ex) {
			System.err.println("Aucune information trouvée, mise ajour impossible ");
		}
		return adresse;
	}

	@Override
	public void supprimerAdresse(Adresse adresse) {
		em.remove(em.merge(adresse));
	}

	@SuppressWarnings("null")
	@Override
	public Adresse consulterAdresseParUtilisateur(Utilisateur u) {
		Adresse adresse = new Adresse();
		if (u != null) {
			String requete = "SELECT a FROM Adresse a JOIN a.utilisateurs au WHERE au.login ='" + u.getLogin() + "'";
			adresse = (Adresse) em.createQuery(requete).getSingleResult();
			return adresse;
		} else {
			throw new DaoException("Adresse inexistante pour l'utilisateur " + u.getNom() + " " + u.getPrenom());
		}
	}

	@Override
	public void supprimerToutesAdresses() {
		String requete = "DELETE FROM Adresse";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des privilèges *
	 * *****************************************************************************
	 */

	/**
	 * 
	 * @param libelle
	 * @return
	 */

	@Override
	public Privilege consulterPrivilegeParLibelle(String libelle) {
		Privilege privilege = null;
		try {
			String requete = "SELECT p FROM Privilege p WHERE p.libelle = :libelle";
			Query q = em.createQuery(requete);
			privilege = (Privilege) q.setParameter("libelle", libelle).getSingleResult();
			return privilege;
		} catch (RuntimeException e) {
			throw new DaoException("Privilege inexistant \n" + e.getMessage());
		}
	}

	@Override
	public Privilege consulterPrivilegeParID(int id) {
		try {
			Privilege privilege = em.find(Privilege.class, id);
			return privilege;
		} catch (RuntimeException e) {
			throw new DaoException("Privilege inexistant \n" + e.getMessage());
		}
	}

	@Override
	public List<Privilege> consulterTousLesPrivileges() {
		List<Privilege> privileges = null;
		try {
			String requete = "SELECT p FROM Privilege p";
			Query q = em.createQuery(requete);
			privileges = (List<Privilege>) q.getResultList();
			return privileges;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

	@Override
	public Privilege ajouterPrivilege(Privilege p) {
		em.persist(p);
		return p;
	}

	@Override
	public Privilege miseAJourPrivilege(Privilege p) {
		return em.merge(p);
	}

	@Override
	public void supprimerPrivilege(Privilege p) {
		em.remove(p);
	}

	@Override
	public void supprimerTousLesPrivileges() {
		String requete = "DELETE FROM Privilege";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des Utilisateurs *
	 * *****************************************************************************
	 */
	@Override
	public Utilisateur consulterUtilisateurId(int id) {
		if ((em.find(Utilisateur.class, id)) != null) {
			Utilisateur a = em.find(Utilisateur.class, id);
			return a;
		}
		throw new DaoException("Aucune information trouvée");
	}

	@Override
	public Utilisateur AjouterUtilisateur(Utilisateur u) {
		em.merge(u);
		return u;
	}

	@Override
	public Utilisateur miseAJourUtilisateur(Utilisateur u) {
		return em.merge(u);
	}

	@Override
	public List<Utilisateur> consulterUtilisateurParNom(String nom) {
		// List<Utilisateur> utilisateurs = null;
		String requete = "SELECT u FROM Utilisateur u WHERE u.nom like :nom";
		Query q = em.createQuery(requete);
		List<Utilisateur> utilisateurs = (List<Utilisateur>) q.setParameter("nom", "%" + nom + "%").getResultList();
		if (!utilisateurs.isEmpty()) {
			return utilisateurs;
		}
		throw new DaoException("Utilisateur " + nom + " introuvable");
	}

	@Override
	public List<Utilisateur> consulterUtilisateurParPrivilege(String libelle) {
		try {

			String requete = "SELECT u FROM Utilisateur u JOIN u.droitUtilisateur ud WHERE ud.libelle = :libelle";
			System.out.println(requete);
			Query q = em.createQuery(requete);
			List<Utilisateur> utilisateurs = q.getResultList();
			return utilisateurs;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

	@Override
	public List<Eleve> consulterTousLesLelevesDuneClasse(String libelle) {
		try {

			String requete = "select p from Classe c join c.eleves p where c.libelle = :libelle";
			System.out.println(requete);
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			List<Eleve> eleves = q.getResultList();
			return eleves;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

	@Override
	public Utilisateur ajouterPrivilegeAUtilisateur(Privilege p, Utilisateur u) {
		u.setPrivilege(p);
		p.getUtilisateurs().add(u);
		em.merge(p);
		return em.merge(u);
	}

	@Override
	public List<Utilisateur> consulterTousLesUtilisateur() {
		List<Utilisateur> utilisateurs = null;
		try {
			String requete = "SELECT u FROM Utilisateur u";
			Query q = em.createQuery(requete);
			utilisateurs = (List<Utilisateur>) q.getResultList();
			return utilisateurs;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

	@Override
	public Utilisateur consulterUtilisateurParLogin(String login) {
		try {
			String requete = "SELECT u FROM Utilisateur u WHERE u.login= :login";
			Query q = em.createQuery(requete).setParameter("login", login);
			Utilisateur utilisateur = (Utilisateur) q.getSingleResult();
			return utilisateur;
		} catch (RuntimeException e) {
			throw new RuntimeException(
					"Utilisateur \"" + login + "\" non trouv&eacute;. " + "Vérifiez l'orthographe\n");
		}

	}

	@Override
	public void supprimerUtilisateur(Utilisateur u) {
		em.remove(u);
	}

	@Override
	public void supprimerTousLesUtilisateurs() {
		String requete = "DELETE FROM Utilisateur";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des niveaux *
	 * *****************************************************************************
	 */
	@Override
	public Niveau consulterNiveauParId(int id) {
		Niveau niveau = new Niveau();
		if (em.find(Niveau.class, id) != null) {
			niveau = em.find(Niveau.class, id);
			return niveau;
		}
		throw new DaoException("Aucune information trouvée");
	}

	@Override
	public Niveau consulterNiveauParLibelle(String libelle) {
		try {
			String requete = "SELECT n FROM Niveau n WHERE n.libelle = :libelle";
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			Niveau niveau = (Niveau) q.getSingleResult();
			return niveau;
		} catch (RuntimeException e) {
			throw new DaoException("Niveau non trouvé Vérifier l'orthographe" + e.getMessage());
		}
	}

	@Override
	public List<Niveau> consulterTousLesNiveaux() {
		List<Niveau> niveaux = null;
		try {
			String requete = "SELECT n FROM Niveau n";
			Query q = em.createQuery(requete);
			niveaux = (List<Niveau>) q.getResultList();
			return niveaux;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

	@Override
	public Niveau ajouterNiveau(Niveau n) {
		em.persist(n);
		return n;
	}

	@Override
	public Niveau ajouterClasseANiveau(Classe c, Niveau n) {
		c.setNiveauClasse(n);
		n.getClasses().add(c);
		em.persist(n);
		em.persist(c);
		return n;
	}

	@Override
	public Niveau supprimerClasseANiveau(Classe c, Niveau n) {
		em.merge(n.getClasses().remove(c));
		return n;
	}

	@Override
	public Niveau miseAJourNiveau(Niveau n) {
		return em.merge(n);
	}

	@Override
	public void supprimerNiveau(Niveau n) {
		em.remove(n);
	}

	@Override
	public void supprimerTousLesNiveaux() {
		String requete = "DELETE FROM Niveau";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des classes *
	 * *****************************************************************************
	 */
	@Override
	public Classe consulterClasseParId(int id) {
		if ((em.find(Classe.class, id)) != null) {
			Classe c = em.find(Classe.class, id);
			return c;
		}
		throw new DaoException("Aucune information trouvée");
	}

	@Override
	public void AjouterProfPrincipal(String libelleClasse, String login) {
		Professeur professeur = (Professeur) consulterUtilisateurParLogin(login);
		Classe classe = consulterClasseParLibelle(libelleClasse);
		if (classe.getProfesseurs().contains(professeur)) {
			classe.getProfesseurs().remove(professeur);
		}

		if (professeur.getClasses().contains(classe)) {
			professeur.getClasses().remove(classe);
		}
		classe.setProfPrincipal(professeur);
		professeur.setClassePrincipale(classe);
		ajouterProfesseurAClasse(login, libelleClasse);
		em.merge(classe);
		em.merge(professeur);
	}

	@Override
	public void ajouterProfesseurAClasse(String login, String libelleClasse) {
		Professeur professeur = (Professeur) consulterUtilisateurParLogin(login);
		Classe classe = consulterClasseParLibelle(libelleClasse);
		classe.getProfesseurs().add(professeur);
		professeur.getClasses().add(classe);
		em.merge(classe);
		em.merge(professeur);
	}

	@Override
	public Classe consulterClasseParLibelle(String libelle) {
		try {
			String requete = "SELECT c FROM Classe c WHERE c.libelle = :libelle";
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			Classe classe = (Classe) q.getSingleResult();
			if (classe != null) {
				return classe;
			}
			else {
				throw new DaoException("Element non trouvé Vérifier l'orthographe");
			}
		} catch (RuntimeException e) {
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public List<Classe> consulterToutesLesClasses() {
		List<Classe> classes = null;
		try {
			String requete = "SELECT c FROM Classe c";
			Query q = em.createQuery(requete);
			classes = (List<Classe>) q.getResultList();
			return classes;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

	@Override
	public List<Classe> consulterToutesLesClassesDUnNiveau(String libelle) {
		try {
			String requete = "SELECT c FROM Classe c JOIN c.niveauClasse cn WHERE cn.libelle = :libelle";
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			List<Classe> classes = (List<Classe>) q.getResultList();
			if (!classes.isEmpty()) {
				return classes;
			} else {
				throw new DaoException("Le niveau \"" + libelle + "\" ne contient pas de classes!!!! ");
			}
		} catch (RuntimeException re) {
			throw new DaoException("Liste vide: \t" + re.getMessage());
		}
	}

	@Override
	public Classe ajouterClasse(Classe c) {

		em.persist(c);
		return c;
	}

	@Override
	public Classe ajouterEleveAClasse(Classe c, Eleve e) {
		c.getEleves().add(e);
		e.setClasse(c);
		em.merge(e);
		em.merge(c);
		return c;
	}

	@Override
	public Classe ajouterMatiereAClasse(Matiere m, Classe c) {
		m.getClasses().add(c);
		c.getMatieres().add(m);
		em.merge(m);
		em.merge(c);
		return c;
	}

	@Override
	public Classe miseAJourClasse(Classe c) {
		return em.merge(c);
	}

	@Override
	public void supprimerClasse(Classe c) {
		em.remove(c);
	}

	@Override
	public void supprimerToutesLesClasses() {
		String requete = "DELETE FROM Classe";
		em.createQuery(requete).executeUpdate();
	}

	@Override
	public void supprimerToutesLesClassesDUnNiveau(List<Classe> classes) {
		for (Classe classe : classes) {
			supprimerClasse(classe);
		}
	}

	/**
	 * ******************************************************************************
	 * Gestion des devoirs *
	 * *****************************************************************************
	 */
	@Override
	public Devoir consulterDevoirParId(int id) {
		Devoir d = em.find(Devoir.class, id);
		return d;
	}

	@Override
	public List<Devoir> consulterDevoirParClasse(String libelleClasse) {
		try {
			String requete = "SELECT d FROM Devoir d JOIN d.classes dc WHERE dc.libelle = :libelleClasse";
			Query q = em.createQuery(requete).setParameter("libelleClasse", libelleClasse);
			List<Devoir> devoirs = (List<Devoir>) q.getResultList();
			return devoirs;
		} catch (RuntimeException e) {
			throw new DaoException(
					"Devoir non trouvé pour cette classe\n" + "Vérifier l'orthographe de \n" + e.getMessage());
		}
	}

	@Override
	public List<Devoir> consulterDevoirParEleve(String login) {
		try {
			String requete = "SELECT d FROM Devoir d JOIN d.eleves de WHERE de.login = :login";
			Query q = em.createQuery(requete).setParameter("login", login);
			List<Devoir> devoirs = (List<Devoir>) q.getResultList();
			return devoirs;
		} catch (RuntimeException ex) {
			throw new DaoException("Devoir non trouvé pour cette classe\n" + ex.getMessage());
		}
	}

	@Override
	public List<Devoir> consulterDevoirParMatiereEtClasse(String libelleMatiere, String libelleClasse) {
		try {
			String requete = "SELECT d FROM Devoir d JOIN d.matiere dm JOIN d.classes dc "
					+ "WHERE dm.libelle = :libelleMatiere AND dc.libelle = :libelleClasse";
			Query q = em.createQuery(requete);
			List<Devoir> devoirs = (List<Devoir>) q.getResultList();
			return devoirs;
		} catch (RuntimeException ex) {
			throw new DaoException("Devoir non trouvé pour cette classe\n" + ex.getMessage());
		}
	}

	@Override
	public List<Devoir> consulterDevoirParProfesseur(String login) {
		try {
			String requete = "SELECT d FROM Devoir d JOIN d.professeur dp WHERE dp.login = :login";
			Query q = em.createQuery(requete).setParameter("login", login);
			List<Devoir> devoirs = (List<Devoir>) q.getResultList();
			return devoirs;
		} catch (RuntimeException ex) {
			throw new DaoException("Devoir non trouvé pour cette classe\n" + ex.getMessage());
		}
	}

	@Override
	public Devoir ajouterDevoir(Devoir d) {
		em.persist(d);
		return d;
	}

	@Override
	public Devoir miseAJourDevoir(Devoir d) {
		em.merge(d);
		return d;
	}

	@Override
	public void supprimerDevoir(Devoir d) {
		em.remove(d);
	}

	@Override
	public void supprimerTousLesDevoirs() {
		String requete = "DELETE FROM Devoir";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des Etablissements *
	 * *****************************************************************************
	 */
	@Override
	public Etablissement consulterEtablissementparId(int id) {
		if ((em.find(Etablissement.class, id)) != null) {
			Etablissement a = em.find(Etablissement.class, id);
			return a;
		}
		throw new DaoException("Aucune information trouvée");
	}

	@Override
	public Etablissement ajouterEtablissement(Etablissement e) {
		em.persist(e);
		return e;
	}

	@Override
	public Etablissement miseAJourEtablissement(Etablissement e) {
		return em.merge(e);
	}

	@Override
	public void supprimerEtablissement(Etablissement e) {
		em.remove(e);
	}

	@Override
	public void supprimerTousLesEtablissements() {
		String requete = "DELETE FROM Etablissement";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des matières *
	 * *****************************************************************************
	 */

	@Override
	public void ajouterProfesseurAMatiere(String login, String libelle) {
		Professeur professeur = (Professeur) consulterUtilisateurParLogin(login);
		Matiere matiere = consulterMatiereParLibelle(libelle);
		professeur.getMatieres().add(matiere);
		matiere.getProfesseurs().add(professeur);
		miseAJourMatiere(matiere);
		miseAJourUtilisateur(professeur);
	}

	@Override
	public Matiere consulterMatiereParId(int id) {
		if ((em.find(Matiere.class, id)) != null) {
			Matiere m = em.find(Matiere.class, id);
			return m;
		}
		throw new DaoException("Impossible de sauvegarder cette matière");
	}

	@Override
	public Matiere consulterMatiereParLibelle(String libelle) {
		try {
			String requete = "SELECT m from Matiere m WHERE m.libelle = :libelle";
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			Matiere matiere = (Matiere) q.getSingleResult();
			return matiere;
		} catch (RuntimeException ex) {
			throw new DaoException("Matiere non trouvée pour cette classe\n" + ex.getMessage());
		}
	}

	@Override
	public List<Matiere> consulterToutesLesMatieres() {
		try {
			String requete = "SELECT m from Matiere m";
			Query q = em.createQuery(requete);
			List<Matiere> matieres = (List<Matiere>) q.getSingleResult();
			return matieres;
		} catch (RuntimeException ex) {
			throw new DaoException("Matieres non trouvées pour cette classe\n" + ex.getMessage());
		}
	}

	@Override
	public List<Matiere> consulterToutesLesMatieresParProfesseur(String login) {
		try {
			String requete = "SELECT m FROM Matiere m JOIN m.professeurs mp WHERE mp.login = :login";
			Query q = em.createQuery(requete).setParameter("login", login);
			List<Matiere> matieres = (List<Matiere>) q.getResultList();
			return matieres;
		} catch (RuntimeException ex) {
			throw new DaoException("Matieres non trouvée pour ce profvesseur\n" + ex.getMessage());
		}
	}

	@Override
	public List<Matiere> consulterToutesLesMatieresParClasse(String libelleClasse) {
		try {
			String requete = "SELECT m FROM Matiere m JOIN m.classes mc WHERE mc.libelle = :libelleClasse";
			Query q = em.createQuery(requete).setParameter("libelleClasse", libelleClasse);
			List<Matiere> matieres = (List<Matiere>) q.getSingleResult();
			return matieres;
		} catch (RuntimeException ex) {
			throw new DaoException("Matieres non trouvée pour cette classe\n" + ex.getMessage());
		}
	}

	@Override
	public Matiere ajouterMatiere(Matiere m) {
		em.persist(m);
		return m;
	}

	@Override
	public Matiere miseAJourMatiere(Matiere m) {
		return em.merge(m);
	}

	@Override
	public void supprimerMatiere(Matiere m) {
		em.remove(m);
	}

	@Override
	public void supprimerToutesLesMatieres() {
		String requete = "DELETE FROM Matiere";
		em.createQuery(requete).executeUpdate();
	}

	/**
	 * ******************************************************************************
	 * Gestion des questions *
	 * *****************************************************************************
	 */
	@Override
	public Question consulterQuestionParId(int id) {
		if ((em.find(Question.class, id)) != null) {
			Question question = em.find(Question.class, id);
			return question;
		}
		throw new DaoException("Impossible de sauvegarder cette question");
	}

	@Override
	public Question ajouterQuestion(Question question) {
		em.persist(question);
		return question;
	}

	@Override
	public Question miseAJourQuestion(Question question) {
		return em.merge(question);
	}

	@Override
	public Question consulterQuestionParLibelle(String libelle) {
		try {
			String requete = "SELECT q FROM Question q WHERE q.libelle = :libelle";
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			Question question = (Question) q.getSingleResult();
			return question;
		} catch (RuntimeException ex) {
			throw new DaoException("question non trouvée\n" + ex.getMessage());
		}
	}

	@Override
	public void supprimerQuestion(Question question) {
		em.remove(question);
	}

	@Override
	public void supprimerListeQuestions(List<Question> questions) {
		for (Question question : questions) {
			em.remove(question);
		}
	}

	@Override
	public List<Question> consulterQuestionsParProfesseur(String loginProf) {
		try {
			String requete = "SELECT q FROM Question q JOIN q.professeur p WHERE p.login = :loginProf";
			Query q = em.createQuery(requete).setParameter("loginProf", loginProf);
			List<Question> question = (List<Question>) q.getSingleResult();
			return question;
		} catch (RuntimeException ex) {
			throw new DaoException("question non trouvée\n" + ex.getMessage());
		}
	}

	/**
	 * ******************************************************************************
	 * Gestion des compétences *
	 * *****************************************************************************
	 */
	@Override
	public Competence consulterCompetenceParId(int id) {
		if ((em.find(Competence.class, id)) != null) {
			Competence competence = em.find(Competence.class, id);
			return competence;
		}
		throw new DaoException("Impossible de sauvegarder cette compétence");
	}

	@Override
	public Competence ajouterCompetence(Competence competence) {
		em.persist(competence);
		return competence;
	}

	@Override
	public Competence miseAJourCompetence(Competence competence) {
		em.merge(competence);
		return competence;
	}

	@Override
	public Competence consulterCompetenceParLibelle(String libelle) {
		try {
			String requete = "SELECT q FROM Question q WHERE q.libelle = :libelle";
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			Competence competence = (Competence) q.getSingleResult();
			return competence;
		} catch (RuntimeException ex) {
			throw new DaoException("question non trouvée\n" + ex.getMessage());
		}
	}

	@Override
	public void supprimerCompetence(Competence competence) {
		if (competence != null) {
			em.remove(competence);
		}
		throw new DaoException("Compétence non trouvée");
	}

	@Override
	public void supprimerListeCompetences(List<Competence> competences) {
		for (Competence c : competences) {
			supprimerCompetence(c);
		}
	}

	/*********************************************************************************
	 * Gestion des prof*
	 */

	@Override
	public List<Professeur> consulterTousLesProfesseursDuneClasse(String libelle) {
		try {

			String requete = "select p from Classe c join c.professeurs p where c.libelle = :libelle";
			System.out.println(requete);
			Query q = em.createQuery(requete).setParameter("libelle", libelle);
			List<Professeur> professeurs = q.getResultList();
			return professeurs;
		} catch (RuntimeException e) {
			throw new DaoException("Liste vide \n" + e.getMessage());
		}
	}

}
