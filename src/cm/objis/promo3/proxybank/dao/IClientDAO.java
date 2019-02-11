/**
 * 
 */
package cm.objis.promo3.proxybank.dao;

import java.sql.SQLException;
import java.util.List;

import cm.objis.promo3.proxybank.domaine.CarteBancaire;
import cm.objis.promo3.proxybank.domaine.Client;
import cm.objis.promo3.proxybank.domaine.CompteBancaire;

/**
 * @author thierry WADJI
 *
 */
public interface IClientDAO {
	
	/**
	 * Enregistre un client dans la BD
	 * @param client
	 * @throws SQLException
	 */
	public void enregistreClient(Client client) throws SQLException;
	
	public void modifieClient(Client client) throws SQLException;
	
	/**
	 * Avoir les informations détaillées sur un Client: Comptes bancaires et solde, cartes bancaires 
	 * 
	 * @param idClient
	 * @return
	 * @throws SQLException
	 */
	public Client consulterInfoClient(int idClient) throws SQLException;
	
	/**
	 * Liste des clients rattachés à un conseiller
	 * 
	 * @param idConseil : l'identifiant du conseiller
	 * @return
	 * @throws SQLException
	 */
	public List<Client> listClients(int idConseil) throws SQLException;
	
	/**
	 * Supprime un client et par ricochet ses comptes
	 * 
	 * @param idClient
	 * @throws SQLException
	 */
	public void supprimeClient(int idClient) throws SQLException;
	
	public void enregistreCompte(CompteBancaire compte) throws SQLException;
	
	public void supprimeCompte(int idCompte) throws SQLException;
	
	/**
	 * @param idCompte est la clé primaire du compte
	 * @param solde 
	 * @return le nouveau solde du compte
	 * @throws SQLException
	 */
	public double modifieSoldeCompte(int idCompte, double solde) throws SQLException;
	
	/**
	 * Calcule le solde d'un compte
	 * 
	 * @param idCompte est la clé primaire du Compte
	 * @return le solde
	 * @throws SQLException
	 */
	public double calculSoldeCompte(int idCompte) throws SQLException;
	
	/**
	 * Vire l'argent d'un compte source vers un compte de destination
	 * @param idCompteSource est la clé primaire du compte source
	 * @param idCompteDest est la clé primaire du compte de destination
	 * @param montant à virer d'un compte à l'autre
	 * @throws SQLException
	 */
	public void virement(int idCompteSource, int idCompteDest, double montant) throws SQLException;
	
	/**
	 * Liste des comptes dont le solde est supérieure au montant
	 * 
	 * @param montant
	 * @return
	 * @throws SQLException
	 */
	public List<CompteBancaire> listCompteASolde(double montant) throws SQLException;
	
	/**
	 * Liste de comptes d'un client
	 * 
	 * @param idClient est la clé primaire du client
	 * @return
	 * @throws SQLException
	 */
	public List<CompteBancaire> listCompteClient(int idClient) throws SQLException;
	
	public void enregistreCarte(CarteBancaire carte) throws SQLException;
	
	public void modifieCarte(CarteBancaire carte) throws SQLException;
	
	
	
	

}
