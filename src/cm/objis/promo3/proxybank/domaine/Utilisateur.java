package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String telephone;
	private String login;
	private String password;
	private TypeUtilisateur fonction;
	
	private Agence agence;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TypeUtilisateur getFonction() {
		return fonction;
	}
	public void setFonction(TypeUtilisateur fonction) {
		this.fonction = fonction;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	
	

}
