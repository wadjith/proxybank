/**
 * 
 */
package cm.objis.promo3.proxybank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.objis.promo3.proxybank.dao.IParametrageDAO;
import cm.objis.promo3.proxybank.dao.ParametrageDaoImpl;
import cm.objis.promo3.proxybank.domaine.Agence;
import cm.objis.promo3.proxybank.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageServiceImpl implements IParametrageService {
	
	private IParametrageDAO dao;

	public ParametrageServiceImpl() {
		super();
		this.dao = new ParametrageDaoImpl();
	}

	@Override
	public boolean enregistreAgence(Agence agence) {
		boolean result = false;
		try {
			dao.enregistreAgence(agence);
			result = true;
		} catch (SQLException e) {
			// TODO: Log exception message
			
		}
		return result;
	}

	@Override
	public boolean enregistreUtilisateur(Utilisateur user) {
		boolean result = false;
		try {
			dao.enregistreUtilisateur(user);
			result = true;
		} catch (SQLException e) {
			// TODO: Log exception message
			
		}
		return result;
	}

	@Override
	public List<Utilisateur> listUtilisateurs(Agence agence) {
		List<Utilisateur> users = null;
		try {
			users = dao.listUtilisateurs(agence);
		} catch (SQLException e) {
			// TODO: Log Exception
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean modifieUtilisateur(Utilisateur user) {
		boolean result = false;
		try {
			dao.modifieUtilisateur(user);
			result = true;
		} catch (SQLException e) {
			// TODO: Log exception message
			
		}
		return result;
	}

	@Override
	public Utilisateur connecteUtilisateur(String login, String password) {
		Utilisateur user = null;
		try {
			user = dao.rechercheUtilisateur(login, password);
		} catch (SQLException e) {
			// TODO Log execption message
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean utilisateurExist(String login) {
		boolean result = false;
		try {
			if(dao.verifieLogin(login) != 0) result = true;
		} catch (SQLException e) {
			// TODO Log exception message
			e.printStackTrace();
		} 
		return result;
	}

}
