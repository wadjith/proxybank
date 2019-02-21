/**
 * 
 */
package cm.objis.promo3.proxybank.domaine;

import java.util.List;

/**
 * @author thierry WADJI
 *
 */
public class Client {
	private int id;
	private int id_conseiller;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private String profession;
	
	private Utilisateur conseiller;
	
	/**
	 * Les comptes bancaires d'un Client 
	 */
	private List<CompteBancaire> comptes;

	public int getId() {
		return id;
	}

	public void setid_conseiller(int id_conseiller) {
		this.id_conseiller = id_conseiller;
	}
	public int getid_conseiller() {
		return this.id_conseiller ;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public List<CompteBancaire> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteBancaire> comptes) {
		this.comptes = comptes;
	}

	public Utilisateur getConseiller() {
		return conseiller;
	}

	public void setConseiller(Utilisateur conseiller) {
		this.conseiller = conseiller;
	}
	
	

}
