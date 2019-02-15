/**
 * 
 */
package cm.objis.promo3.proxybank.service;

import java.util.List;

import cm.objis.promo3.proxybank.domaine.Agence;
import cm.objis.promo3.proxybank.domaine.Utilisateur;

/**
 * Les exceptions seront logges dans un fichier 
 * 
 * @author thierry WADJI
 *
 */
public interface IParametrageService {
	
	/**
	 *  Enregistrer une agence dans la BD
	 *  
	 * @param agence
	 * @return boolean
	 */
	public boolean enregistreAgence(Agence agence);
	
	/**
	 * @param user
	 * @return boolean
	 */
	public boolean enregistreUtilisateur(Utilisateur user);
	
	/**
	 * Liste des utilisateurs d'une agence
	 * 
	 * @param agence
	 * @return List<Utilisateur>
	 */
	public List<Utilisateur> listUtilisateurs(Agence agence);
	
	/**
	 * @param user
	 * @return boolean
	 */
	public boolean modifieUtilisateur(Utilisateur user);
	
	/**
	 * @param login
	 * @param password
	 * @return Utilisateur
	 */
	public Utilisateur connecteUtilisateur(String login, String password);
	
	/**
	 * Vérifie que le login renseigne existe dejà ou pas
	 * 
	 * @param login : Nom d'utilisateur 
	 * @return boolean
	 */
	public boolean utilisateurExist(String login);

}
