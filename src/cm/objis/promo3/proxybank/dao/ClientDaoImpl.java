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
import java.util.List;

import cm.objis.promo3.proxybank.domaine.CarteBancaire;
import cm.objis.promo3.proxybank.domaine.Client;
import cm.objis.promo3.proxybank.domaine.CompteBancaire;
import cm.objis.promo3.proxybank.domaine.CompteCourant;
import cm.objis.promo3.proxybank.domaine.CompteEpargne;

/**

 *
 */
public class ClientDaoImpl implements IClientDAO {

	@Override
	public void enregistreClient(Client client) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "insert into `client`('nom',`prenom`,`profession`,`telephone`,'email','ville','code_postal','adresse','utilisateur_id')" 
					+"values (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			ps.setString(1, client.getNom());
			ps.setString(2,client.getPrenom());
			ps.setString(3,client.getProfession());
			ps.setString(4,client.getTelephone());
			ps.setString(5,client.getEmail());
			ps.setString(6,client.getVille());
			ps.setString(7,client.getCodePostal());
			ps.setString(8,client.getAdresse());
			ps.setInt(9,client.getid_conseiller());
			
			
			
		
			// Etape 3 : ex�cution requ�te
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		} 
		
	}

	@Override
	public void modifieClient(Client client) throws SQLException {
		// TODO by Jamal
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "update client set nom='"+client.getNom()+"' ,prenom='"+client.getPrenom()+"' ,profession='"+client.getProfession()+"' ,profession='"+client.getProfession()+"', telephone='"+client.getTelephone()+"' ,email='"+client.getEmail()+"' ,ville='"+client.getEmail()+"',	code_postal='"+client.getCodePostal()+"' ,adresse='"+client.getAdresse()+"' ,utilisateur_id='"+client.getid_conseiller()+"'";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			
			
		
			// Etape 3 : ex�cution requ�te
			
			ps.execute(sql);
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		
	}

	@Override
	public Client consulterInfoClient(int idClient) throws SQLException {
		// TODO by JAMAL
		Client client = new Client();
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "select solde from  compte where id=?" ;
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			ps.setInt(1,idClient);
			
			
			

			

			// Etape 3 : ex�cution requ�te
			ResultSet rs = ps.executeQuery(sql);
			
			client.setId(rs.getInt("solde"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getNString("prenom"));
			client.setProfession(rs.getString("profession"));
			client.setTelephone(rs.getString("telephone"));
			client.setAdresse(rs.getString("adresse"));
			client.setCodePostal(rs.getString("codePostal"));
			client.setEmail(rs.getString("email"));
			client.setid_conseiller(rs.getInt("utilisateur_id"));
			client.setVille(rs.getString("ville"));
			
			
			return client  ;
		
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		
		
		
		return null;
	}

	@Override
	public List<Client> listClients(int idConseil) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : pr�paration requ�te
			
			String sql = "SELECT * FROM client WHERE utilisateur_id='"+idConseil+"' ";
			
			Statement st = cn.createStatement();

			List<Client> maListclient= new ArrayList<Client>();

			// Etape 3 : ex�cution requ�te
			ResultSet rs = st.executeQuery(sql);

			// Etape 4 :parcours Resultset (optionnel)
			while (rs.next()) {
				//recuperation des valeurs d'une ligne de la table client, pour initialiser dans un objet client
				
				
				Client client =new Client();
				
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getNString("prenom"));
				client.setProfession(rs.getString("profession"));
				client.setTelephone(rs.getString("telephone"));
				client.setAdresse(rs.getString("adresse"));
				client.setCodePostal(rs.getString("codePostal"));
				client.setEmail(rs.getString("email"));
				client.setid_conseiller(rs.getInt("utilisateur_id"));
				client.setVille(rs.getString("ville"));
				
				
				//ajout de le compte dans List maListclient
				maListclient.add(client); // cette instruction permet d'inserer l'objet client dans ma liste client
				return maListclient;
			}
			
			// Etape 5 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		
		
		return null;
	}

	@Override
	public void supprimeClient(int idClient) throws SQLException {
		// TODO by Jamal
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "delete from  client where id=?" ;
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			ps.setInt(1,idClient);
			
			
			
			
			
			
		
			// Etape 3 : ex�cution requ�te
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		
	}

	@Override
	public void enregistreCompte(CompteBancaire compte) throws SQLException {
		// TODO by JAMAL
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "insert into `compte`('date_ouverture',`numero_compte`,`solde`,`client_id`,`decouvert`,`remuneration`)" 
					+"values (?,?,?,?,?,?)";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			ps.setString(1, compte.getDateOuverture());
			ps.setString(2, compte.getNumCompte());
			ps.setDouble(3, compte.getSolde());
			ps.setInt(4, compte.getClient().getId());
			
			if(compte instanceof CompteEpargne) {
				ps.setNull(5, java.sql.Types.INTEGER);
				ps.setFloat(6, ((CompteEpargne)compte).getRenumeration());
				
			}
			if(compte instanceof CompteCourant) {
				ps.setInt(5, ((CompteCourant)compte).getDecouvert());
				ps.setNull(6, java.sql.Types.FLOAT);
				
			}
			
			
			
		
			// Etape 3 : ex�cution requ�te
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		} 
		
	}

	@Override
	public void supprimeCompte(int idCompte) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "delete from  compte where id=?" ;
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			ps.setInt(1,idCompte);
			
			
			
			
			
			
		
			// Etape 3 : ex�cution requ�te
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
	}

	@Override
	public double modifieSoldeCompte(int idCompte, double solde) throws SQLException {
		
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "update compte set id='"+idCompte+"' ,solde='"+solde+"'";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			
			
		
			// Etape 3 : ex�cution requ�te
			
			ps.execute(sql);
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		return 0;
	}

	@Override
	public double calculSoldeCompte(int idCompte) throws SQLException {
		// TODO by JAMAL
		
		try {

			
			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "select solde from  compte where id= ?" ;
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			ps.setInt(1,idCompte);
			
			
			

			

			// Etape 3 : ex�cution requ�te
			ResultSet rs = ps.executeQuery(sql);
			
			
			return  (float) rs.getInt("solde") ;
		
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		return 0 ;
		
	}

	@Override
	public void virement(int idCompteSource, int idCompteDest, double montant) throws SQLException {
		// TODO by WADJI
		
	}

	@Override
	public List<CompteBancaire> listCompteASolde(double montant) throws SQLException {
		// TODO by JAMAL
		
		
		
		
		//cr�ation d'une collection des compte_bancaire
				List<CompteBancaire> maListcomptesolde= new ArrayList<CompteBancaire>();
			
				try {

					// Etape 1 : r�cup�ration de la connexion
					Connection cn = ConnectionMYSQL.getInstance();

					// Etape 2 : pr�paration requ�te
					
					String sql = "SELECT * FROM compte WHERE solde='"+montant+"' ";
					
					Statement st = cn.createStatement();

					

					// Etape 3 : ex�cution requ�te
					ResultSet rs = st.executeQuery(sql);

					// Etape 4 :parcours Resultset (optionnel)
					while (rs.next()) {
						//recuperation des valeurs d'une ligne de la table compte, pour initialiser dans un objet compte
						
						
						CompteBancaire comptesolde =new CompteBancaire(rs.getInt("id"),rs.getString("numero_compte"),rs.getInt("solde"),rs.getString("date_ouverture"),rs.getInt("client_id"),rs.getInt("remuneration"));
						
						
						//ajout de le compte dans List maListcompte
						maListcomptesolde.add(comptesolde); // cette instruction permet d'inserer l'objet compte dans ma liste compte
						return maListcomptesolde;
					}
					
					// Etape 5 : gestion des exceptions et lib�ration 'automatique' des ressources
				} catch (SQLException e) {
					e.printStackTrace();
					
				} 
				
				
				

		
		
		
		return null;
	}

	@Override
	public List<CompteBancaire> listCompteClient(int idClient) throws SQLException {
		// TODO by JAMAL
		//cr�ation d'une collection des compte_bancaire
		List<CompteBancaire> maListcompte= new ArrayList<CompteBancaire>();
	
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : pr�paration requ�te
			
			String sql = "SELECT * FROM compte WHERE id='"+idClient+"' ";
			
			Statement st = cn.createStatement();

			
			// Etape 3 : ex�cution requ�te
			ResultSet rs = st.executeQuery(sql);

			// Etape 4 :parcours Resultset (optionnel)
			while (rs.next()) {
				//recuperation des valeurs d'une ligne de la table compte, pour initialiser dans un objet compte
				
				
				CompteBancaire compte = new CompteBancaire();

				
				
				compte.setId(rs.getInt("id"));
				compte.setNumCompte(rs.getString("numero_compte"));
				compte.setSolde(rs.getInt("solde"));
				compte.setDateOuverture(rs.getString("date_ouverture"));
				compte.setClient_id(rs.getInt("client_id"));
				compte.setRemuneration(rs.getInt("remuneration"));
				
				//ajout de le compte dans List maListcompte
				maListcompte.add(compte); // cette instruction permet d'inserer l'objet compte dans ma liste compte
				
			}
			
			// Etape 5 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		
		return maListcompte;
		

}
		
		
		
		
		
	

	@Override
	public void enregistreCarte(CarteBancaire carte) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "insert into `carte_bancaire `('type',`actif`,`numero`,`client_id`)" 
					+"values (?,?,?,?)";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			ps.setString(1, carte.getType());
			ps.setBoolean(2,  carte.isActif());
			ps.setInt(3, carte.getNumero());
			ps.setInt(4,carte.getclient_id());
			
			
			
			
			
		
			// Etape 3 : ex�cution requ�te
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		
	}

	@Override
	public void modifieCarte(CarteBancaire carte) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : r�cup�ration de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
			

			String sql = "update carte_bancaire set type='"+carte.getType()+"' ,actif='"+carte.isActif()+"' ,numero='"+carte.getNumero()+"' ,client_id='"+carte.getclient_id()+"'";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			
			
		
			// Etape 3 : ex�cution requ�te
			
			ps.execute(sql);
			
			// Etape 4 : gestion des exceptions et lib�ration 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
	}
	
	

}
