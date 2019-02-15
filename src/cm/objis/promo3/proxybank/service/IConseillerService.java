/**
 * 
 */
package cm.objis.promo3.proxybank.service;

import java.util.List;

import cm.objis.promo3.proxybank.domaine.Client;
import cm.objis.promo3.proxybank.domaine.CompteBancaire;
import cm.objis.promo3.proxybank.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public interface IConseillerService {
	
public boolean enregistreClient(Client client);
	
	public boolean modifieClient(Client client);
	
	public boolean supprimeClient(Client client);
	
	public Client consulterInfoClient(Client client);
	
	public double virement(CompteBancaire compteS, CompteBancaire compteD, double montant);
	
	/**
	 * Liste des clients d'un client
	 * 
	 * @param conseiller
	 * @return
	 */
	public List<Client> listClient(Utilisateur conseiller);
	
	/**
	 * Liste des clients Fortunés d'un conseiller (solde de compte > 300 000 000)
	 * 
	 * @param conseiller est Utilisateur
	 * @return
	 */
	public List<Client> listClientFortune(Utilisateur conseiller);
	
	

}
