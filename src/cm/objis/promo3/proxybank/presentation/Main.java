package cm.objis.promo3.proxybank.presentation;

import java.sql.SQLException;
import java.util.Calendar;
import cm.objis.promo3.proxybank.dao.IParametrageDAO;
import cm.objis.promo3.proxybank.dao.ParametrageDaoImpl;
import cm.objis.promo3.proxybank.domaine.CompteBancaire;
import cm.objis.promo3.proxybank.domaine.CompteCourant;
import cm.objis.promo3.proxybank.domaine.CompteEpargne;
import cm.objis.promo3.proxybank.domaine.TypeCarte;
import cm.objis.promo3.proxybank.domaine.TypeTransaction;

/**
 * Elle est utilisée afin de réaliser les tests de nos méthodes sur la console
 * 
 * @author thierry WADJI
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String typeTranscation = TypeTransaction.RETRAIT.toString();
		CompteBancaire cc = new CompteCourant();
		CompteBancaire ce = new CompteEpargne();
		if (cc instanceof CompteCourant) {
			System.out.println(((CompteCourant)cc).getDecouvert());
		}
		System.out.println("Le type de transction est: "+typeTranscation);
		System.out.println("Le type de carte est: "+TypeCarte.VISAE.toString());
		System.out.println("La date du jour est: "+ Calendar.DATE);
		
		IParametrageDAO dao = new ParametrageDaoImpl();
		try {
			System.out.println(dao.verifieLogin("wtt"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
