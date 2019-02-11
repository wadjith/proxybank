/**
 * 
 */
package cm.objis.promo3.proxybank.service;

import cm.objis.promo3.proxybank.domaine.Client;

/**
 * @author thierry WADJI
 *
 */
public interface IConseillerService {
	
	public boolean enregistreClient(Client client);
	
	public boolean modifieClient(Client client);
	
	public boolean supprimeClient(Client client);
	
	public Client consulterInfoClient(Client client);
	
	

}
