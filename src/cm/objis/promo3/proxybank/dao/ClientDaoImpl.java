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
public class ClientDaoImpl implements IClientDAO {

	@Override
	public void enregistreClient(Client client) throws SQLException {
		// TODO by ALAIN
		
	}

	@Override
	public void modifieClient(Client client) throws SQLException {
		// TODO by ALAIN
		
	}

	@Override
	public Client consulterInfoClient(int idClient) throws SQLException {
		// TODO by ALAIN
		
		return null;
	}

	@Override
	public List<Client> listClients(int idConseil) throws SQLException {
		// TODO by ALAIN
		return null;
	}

	@Override
	public void supprimeClient(int idClient) throws SQLException {
		// TODO by ALAIN
		
	}

	@Override
	public void enregistreCompte(CompteBancaire compte) throws SQLException {
		// TODO by JAMAL
		
	}

	@Override
	public void supprimeCompte(int idCompte) throws SQLException {
		// TODO by JAMAL
		
	}

	@Override
	public double modifieSoldeCompte(int idCompte, double solde) throws SQLException {
		// TODO by JAMAL
		return 0;
	}

	@Override
	public double calculSoldeCompte(int idCompte) throws SQLException {
		// TODO by JAMAL
		return 0;
	}

	@Override
	public void virement(int idCompteSource, int idCompteDest, double montant) throws SQLException {
		// TODO by WADJI
		
	}

	@Override
	public List<CompteBancaire> listCompteASolde(double montant) throws SQLException {
		// TODO by JAMAL
		return null;
	}

	@Override
	public List<CompteBancaire> listCompteClient(int idClient) throws SQLException {
		// TODO by JAMAL
		return null;
	}

	@Override
	public void enregistreCarte(CarteBancaire carte) throws SQLException {
		// TODO by JAMAL
		
	}

	@Override
	public void modifieCarte(CarteBancaire carte) throws SQLException {
		// TODO by JAMAL
		
	}
	
	

}
