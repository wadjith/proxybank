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
public class ConseillerServiceImpl implements IConseillerService {

	@Override
	public boolean enregistreClient(Client client) {
		// TODO by ALAIN
		return false;
	}

	@Override
	public boolean modifieClient(Client client) {
		// TODO by ALAIN
		return false;
	}

	@Override
	public boolean supprimeClient(Client client) {
		// TODO by ALAIN
		return false;
	}

	@Override
	public Client consulterInfoClient(Client client) {
		// TODO by ALAIN
		return null;
	}

	@Override
	public double virement(CompteBancaire compteS, CompteBancaire compteD, double montant) {
		// TODO by WADJI
		return 0;
	}

	@Override
	public List<Client> listClient(Utilisateur conseiller) {
		// TODO by ALAIN
		return null;
	}

	@Override
	public List<Client> listClientFortune(Utilisateur conseiller) {
		// TODO by JAMAL
		return null;
	}

}
