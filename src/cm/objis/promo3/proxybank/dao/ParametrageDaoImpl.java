/**
 * 
 */
package cm.objis.promo3.proxybank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cm.objis.promo3.proxybank.domaine.Agence;
import cm.objis.promo3.proxybank.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageDaoImpl implements IParametrageDAO {


	@Override
	public void enregistreAgence(Agence agence) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enregistreUtilisateur(Utilisateur user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> listUtilisateurs(int idAgence) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifieUtilisateur(Utilisateur user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur rechercheUtilisateur(String login, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int verifieLogin(String login) throws SQLException {
		
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation requête
		String sql = "SELECT COUNT(*) as nbuser FROM utilisateur WHERE login = ?";

		PreparedStatement ps= cn.prepareStatement(sql);
		ps.setString(1, login);
		ResultSet rs=ps.executeQuery();

		rs.next();

		return rs.getInt("nbuser");
	}

	@Override
	public List<Agence> listAgence(int idBank) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
