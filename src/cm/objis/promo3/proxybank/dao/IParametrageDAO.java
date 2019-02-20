/**
 * 
 */
package cm.objis.promo3.proxybank.dao;

import java.sql.SQLException;
import java.util.List;

import cm.objis.promo3.proxybank.domaine.Agence;
import cm.objis.promo3.proxybank.domaine.Bank;
import cm.objis.promo3.proxybank.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public interface IParametrageDAO {
		
	/**
	 *  Enregistrer une agence dans la BD
	 *  
	 * @param agence
	 * @throws SQLException
	 */
	public void enregistreAgence(Agence agence) throws SQLException;
	
	/**
	 * @param idBank
	 * @return
	 * @throws SQLException
	 */
	public List<Agence> listAgence(Bank bank) throws SQLException;
	
	/**
	 * @param user
	 * @throws SQLException
	 */
	public void enregistreUtilisateur(Utilisateur user) throws SQLException;
	
	/**
	 * Liste des utilisateurs d'une agence
	 * 
	 * @param idAgence
	 * @return List<Utilisateur>
	 * @throws SQLException
	 */
	public List<Utilisateur> listUtilisateurs(Agence agence) throws SQLException;
	
	/**
	 * @param user
	 * @throws SQLException
	 */
	public void modifieUtilisateur(Utilisateur user) throws SQLException;
	
	/**
	 * @param login
	 * @param password
	 * @return Utilisateur
	 * @throws SQLException
	 */
	public Utilisateur rechercheUtilisateur(String login, String password) throws SQLException;
	
	/**
	 * Vérifie que le login renseigne existe dejà, en renvoyant un nombre entier qui représente le nombre d'occurence dans la BD
	 * 
	 * @param login : Nom d'utilisateur 
	 * @return
	 * @throws SQLException
	 */
	public int verifieLogin(String login) throws SQLException;
}
