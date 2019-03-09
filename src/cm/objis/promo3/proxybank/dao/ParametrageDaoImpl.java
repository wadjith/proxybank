/**
 * 
 */
package cm.objis.promo3.proxybank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cm.objis.promo3.proxybank.domaine.Agence;
import cm.objis.promo3.proxybank.domaine.Bank;
import cm.objis.promo3.proxybank.domaine.TypeUtilisateur;
import cm.objis.promo3.proxybank.domaine.Utilisateur;

/**
 * @author thierry WADJI
 *
 */
public class ParametrageDaoImpl implements IParametrageDAO {


	@Override
	public void enregistreAgence(Agence agence) throws SQLException {
		
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : Création d'un objet  statement et preparation de la requete
		String sql = "INSERT INTO agence(`numero_id`,`date_creation`,`bank_id`)" 
				+"VALUES (?,?,?)";
		
		PreparedStatement ps=  cn.prepareStatement(sql);
		ps.setString(1, agence.getNumId());
		ps.setDate(2, getCurrentDate());
		ps.setInt(3, agence.getBank().getId());
		
	
		// Etape 3 : exécution de la requête
		ps.executeUpdate();
		
		System.out.println(getCurrentDate());
	}

	@Override
	public void enregistreUtilisateur(Utilisateur user) throws SQLException {
		
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : Création d'un objet  statement et preparation de la requete
		String sql = "INSERT INTO `utilisateur`(`nom`,`prenom`,`telephone`,`fonction`,`login`,`password`,`agence_id`)" 
				+"VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement ps=  cn.prepareStatement(sql);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getTelephone());
		ps.setString(4, user.getFonction().toString());
		ps.setString(5, user.getLogin());
		ps.setString(6, user.getPassword());
		ps.setInt(7, user.getAgence().getId());
		
	
		// Etape 3 : exécution de la requête
		ps.executeUpdate();
		
	}

	@Override
	public List<Utilisateur> listUtilisateurs(Agence agence) throws SQLException {
		
		//création d'une collection des utilisateurs
		List<Utilisateur> userList = new ArrayList<Utilisateur>();
	
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation de la requête
		String sql = "SELECT * FROM utilisateur WHERE utilisateur.agence_id = ?";
		
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setInt(1, agence.getId());

		// Etape 3 : exécution de la requête
		ResultSet rs = pst.executeQuery();

		// Etape 4 :parcours Resultset (optionnel)
		while (rs.next()) {
			
			//recuperation des valeurs d'une ligne de la table, pour initialiser dans un objet Agence
			Utilisateur user =  new Utilisateur();
			user.setId(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setTelephone(rs.getString("telephone"));
			user.setFonction(TypeUtilisateur.valueOf(rs.getString("fonction").toUpperCase()));
			user.setLogin(rs.getString("login"));
			user.setAgence(agence);
			
			//ajout d'une agence dans List
			userList.add(user); 
			
		}
		
		return userList;
	}

	@Override
	public void modifieUtilisateur(Utilisateur user) throws SQLException {
		// TODO by WADJI
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : Création d'un objet  statement et preparation de la requete
		String sql = "UPDATE Utilisateur SET prenom = ?, telephone = ?, fonction = ? WHERE id = ?";
		
		PreparedStatement ps=  cn.prepareStatement(sql);
		ps.setString(1, user.getPrenom());
		ps.setString(2, user.getTelephone());
		ps.setString(3, user.getFonction().toString());
		
		// Etape 3 : exécution de la requête
		ps.executeUpdate();
		
	}

	@Override
	public Utilisateur rechercheUtilisateur(String login, String password) throws SQLException {
		//création d'un objet utilisateur null
		Utilisateur user = null;
	
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation de la requête
		String sql = "SELECT * FROM utilisateur WHERE utilisateur.login = ? AND utilisateur.password = ?";
		
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setString(1, login);
		pst.setString(2, password);

		// Etape 3 : exécution de la requête
		ResultSet rs = pst.executeQuery();

		// Etape 4 :parcours Resultset (optionnel)
		if (rs.next()) {
			
			//recuperation des valeurs du résultat, pour initialiser l'objet Utilisateur
			user = new Utilisateur();
			user.setId(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setTelephone(rs.getString("telephone"));
			user.setFonction(TypeUtilisateur.valueOf(rs.getString("fonction").toUpperCase()));
			user.setLogin(rs.getString("login"));
			Agence agence = new Agence();
			agence.setId(rs.getInt("agence_id"));
			user.setAgence(agence);
			
		}
		
		return user;
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
	
	/**
	 * @return
	 */
	private static java.sql.Date getCurrentDate() {
		
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Override
	public List<Agence> listAgence(Bank bank) throws SQLException {
		//création d'une collection des agences
		List<Agence> maListAgence= new ArrayList<Agence>();
	
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation de la requête
		String sql = "SELECT * FROM agence WHERE agence.bank_id = ?";
		
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setInt(1, bank.getId());

		// Etape 3 : exécution de la requête
		ResultSet rs = pst.executeQuery();

		// Etape 4 :parcours Resultset (optionnel)
		while (rs.next()) {
			
			//recuperation des valeurs d'une ligne de la table, pour initialiser dans un objet Agence
			Agence ag =  new Agence();
			ag.setId(rs.getInt("id"));
			ag.setNumId(rs.getString("numero_id"));
			ag.setCreation(rs.getDate("date_creation"));
			
			//ajout d'une agence dans List
			maListAgence.add(ag); 
			
		}
		
		return maListAgence;
	}

	@Override
	public List<Utilisateur> listUtilisateurs() throws SQLException {
		//création d'une collection des utilisateurs
				List<Utilisateur> userList = new ArrayList<Utilisateur>();
			
				// Etape 1 : récupération de la connexion
				Connection cn = ConnectionMYSQL.getInstance();

				// Etape 2 : préparation de la requête
				String sql = "SELECT * FROM utilisateur";
				
				Statement st = cn.createStatement();

				// Etape 3 : exécution de la requête
				ResultSet rs = st.executeQuery(sql);

				// Etape 4 :parcours Resultset (optionnel)
				while (rs.next()) {
					
					//recuperation des valeurs d'une ligne de la table, pour initialiser dans un objet Agence
					Utilisateur user =  new Utilisateur();
					Agence agence = new Agence();
					agence.setId(rs.getInt("agence_id"));
					
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setTelephone(rs.getString("telephone"));
					user.setFonction(TypeUtilisateur.valueOf(rs.getString("fonction").toUpperCase()));
					user.setLogin(rs.getString("login"));
					user.setAgence(agence);
					
					//ajout d'une agence dans List
					userList.add(user); 
					
				}
				
				return userList;
	}

	@Override
	public Map<Integer, String> listAgence() throws SQLException {
		//création d'une collection des agences
		Map<Integer, String> maMapAgence= new HashMap<>();
	
		// Etape 1 : récupération de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : préparation de la requête
		String sql = "SELECT * FROM agence";
		
		Statement st = cn.createStatement();

		// Etape 3 : exécution de la requête
		ResultSet rs = st.executeQuery(sql);

		// Etape 4 :parcours Resultset (optionnel)
		while (rs.next()) {
			
			//recuperation des valeurs d'une ligne de la table, pour initialiser dans un objet Agence
			maMapAgence.put(rs.getInt("id"), rs.getString("numero_id"));
			
		}
		
		return maMapAgence;
	}


}
