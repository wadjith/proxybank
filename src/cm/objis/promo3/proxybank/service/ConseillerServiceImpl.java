/**
 * 
 */
package cm.objis.promo3.proxybank.service;

import java.sql.*;
import java.util.List;

import cm.objis.promo3.proxybank.dao.ConnectionMYSQL;
import cm.objis.promo3.proxybank.domaine.Client;
import cm.objis.promo3.proxybank.domaine.CompteBancaire;
import cm.objis.promo3.proxybank.domaine.Utilisateur;
import cm.objis.promo3.proxybank.dao.* ;



public abstract class ConseillerServiceImpl implements IConseillerService {
    
	private IClientDAO clientdao;
	
	
	public ConseillerServiceImpl() {
		super();
		this.clientdao = new ClientDaoImpl();
	}

	@Override
	public boolean enregistreClient(Client client) {
		// TODO by JAMAL
		
		
		
		try {

			// Etape 1 : appel de la methode enregistrer client du dao
			
			clientdao.enregistreClient(client);
			
			return true ;
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		} 
		
		
		return false;
		
	}

	@Override
	public boolean modifieClient(Client client) {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			clientdao.modifieClient(client);
			return true ;
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		return false;
	}

	public boolean supprimeClient(Client client) {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de l id client et suppression
			
			clientdao.supprimeClient(client.getId());
			
			
			return true ;
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		return false;
	}

	@Override
	public Client consulterInfoClient(int idclient) {
		// TODO by JAMAL
		
		
		try {

			//retourne directement le client � consulter
			
			
			return clientdao.consulterInfoClient(idclient)  ;
		
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		return null;
	}

	@Override
	public double virement(CompteBancaire compteS, CompteBancaire compteD, double montant) {
		// TODO by WADJI
		return 0;
	}

	@Override
	public List<Client> listClient(Utilisateur conseiller) {
		// TODO by JAMAL
	try {
		
		
		return	clientdao.listClients(conseiller.getId()) ;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return null ;	
		
	}

	@Override
	public List<Client> listClientFortune(Utilisateur conseiller) {
		// TODO by JAMAL
		
		
		
		
		
		
		return null;
	}

}
