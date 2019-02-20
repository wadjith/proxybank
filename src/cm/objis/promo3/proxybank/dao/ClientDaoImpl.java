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

/**

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
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Création d'un objet  statement et preparation de la requete
			

			String sql = "insert into `compte`('date_ouverture',`numero_compte`,`solde`,`client_id`,'decouvert','remuneration')" 
					+"values (?,?,?,?,?,?)";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			ps.setString(1, compte.getDateOuverture());
			ps.setString(2, compte.getNumCompte());
			ps.setInt(3, (int) compte.getSolde());
			
			ps.setInt(4, compte.getClient_id());
			ps.setInt(5, compte.getDecouvert());
			ps.setInt(6, compte.getRemuneration());
			
			
		
			// Etape 3 : exécution requête
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		} 
		
	}

	@Override
	public void supprimeCompte(int idCompte) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Création d'un objet  statement et preparation de la requete
			

			String sql = "delete from  compte where id=?" ;
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			ps.setInt(1,idCompte);
			
			
			
			
			
			
		
			// Etape 3 : exécution requête
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
	}

	@Override
	public double modifieSoldeCompte(int idCompte, double solde) throws SQLException {
		
		
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Création d'un objet  statement et preparation de la requete
			

			String sql = "update compte set id='"+idCompte+"' ,solde='"+solde+"'";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			
			
		
			// Etape 3 : exécution requête
			
			ps.execute(sql);
			
			// Etape 4 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
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
		
		
		
		
		//création d'une collection des compte_bancaire
				List<CompteBancaire> maListcomptesolde= new ArrayList<CompteBancaire>();
			
				try {

					// Etape 1 : récupération de la connexion
					Connection cn = ConnectionMYSQL.getInstance();

					// Etape 2 : préparation requête
					
					String sql = "SELECT * FROM compte WHERE solde='"+montant+"' ";
					
					Statement st = cn.createStatement();

					

					// Etape 3 : exécution requête
					ResultSet rs = st.executeQuery(sql);

					// Etape 4 :parcours Resultset (optionnel)
					while (rs.next()) {
						//recuperation des valeurs d'une ligne de la table compte, pour initialiser dans un objet compte
						
						
						CompteBancaire comptesolde =new CompteBancaire(rs.getInt("id"),rs.getString("numero_compte"),rs.getInt("solde"),rs.getString("date_ouverture"),rs.getInt("client_id"),rs.getInt("remuneration"));
						
						
						//ajout de le compte dans List maListcompte
						maListcomptesolde.add(comptesolde); // cette instruction permet d'inserer l'objet compte dans ma liste compte
						return maListcomptesolde;
					}
					
					// Etape 5 : gestion des exceptions et libération 'automatique' des ressources
				} catch (SQLException e) {
					e.printStackTrace();
					
				} 
				
				
				

		
		
		
		return null;
	}

	@Override
	public List<CompteBancaire> listCompteClient(int idClient) throws SQLException {
		// TODO by JAMAL
		//création d'une collection des compte_bancaire
		List<CompteBancaire> maListcompte= new ArrayList<CompteBancaire>();
	
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : préparation requête
			
			String sql = "SELECT * FROM compte WHERE id='"+idClient+"' ";
			
			Statement st = cn.createStatement();

			

			// Etape 3 : exécution requête
			ResultSet rs = st.executeQuery(sql);

			// Etape 4 :parcours Resultset (optionnel)
			while (rs.next()) {
				//recuperation des valeurs d'une ligne de la table compte, pour initialiser dans un objet compte
				
				
				CompteBancaire compte =new CompteBancaire(rs.getInt("id"),rs.getString("numero_compte"),rs.getInt("solde"),rs.getString("date_ouverture"),rs.getInt("client_id"),rs.getInt("remuneration"));
				
				
				//ajout de le compte dans List maListcompte
				maListcompte.add(compte); // cette instruction permet d'inserer l'objet compte dans ma liste compte
				
			}
			
			// Etape 5 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		
		return maListcompte;
		

}
		
		
		
		
		
	

	@Override
	public void enregistreCarte(CarteBancaire carte) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Création d'un objet  statement et preparation de la requete
			

			String sql = "insert into `carte_bancaire `('type',`actif`,`numero`,`client_id`)" 
					+"values (?,?,?,?)";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			ps.setString(1, carte.getType());
			ps.setBoolean(2,  carte.isActif());
			ps.setInt(3, carte.getNumero());
			ps.setInt(4,carte.getclient_id());
			
			
			
			
			
		
			// Etape 3 : exécution requête
			ps.executeUpdate();
			
			
			
			// Etape 4 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
		
	}

	@Override
	public void modifieCarte(CarteBancaire carte) throws SQLException {
		// TODO by JAMAL
		
		try {

			// Etape 1 : récupération de la connexion
			Connection cn = ConnectionMYSQL.getInstance();

			// Etape 2 : Création d'un objet  statement et preparation de la requete
			

			String sql = "update carte_bancaire set type='"+carte.getType()+"' ,actif='"+carte.isActif()+"' ,numero='"+carte.getNumero()+"' ,client_id='"+carte.getclient_id()+"'";
			
			PreparedStatement ps=  cn.prepareStatement(sql);
			
			
			
			
			
		
			// Etape 3 : exécution requête
			
			ps.execute(sql);
			
			// Etape 4 : gestion des exceptions et libération 'automatique' des ressources
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
			
		}
		
	}
	
	

}
