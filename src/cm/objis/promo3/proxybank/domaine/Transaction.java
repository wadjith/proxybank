/**
 * 
 */
package cm.objis.promo3.proxybank.domaine;

/**
 * @author thierry WADJI
 *
 */
public class Transaction {

	private CompteBancaire compteSource;
	private CompteBancaire compteDestination;
	private String dateheure;
	private double montant;
	private TypeTransaction type;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public CompteBancaire getCompteSource() {
		return compteSource;
	}

	public void setCompteSource(CompteBancaire compteSource) {
		this.compteSource = compteSource;
	}

	public CompteBancaire getCompteDestination() {
		return compteDestination;
	}

	public void setCompteDestination(CompteBancaire compteDestination) {
		this.compteDestination = compteDestination;
	}

	public String getDateheure() {
		return dateheure;
	}

	public void setDateheure(String dateheure) {
		this.dateheure = dateheure;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}
	

}
