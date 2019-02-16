package cm.objis.promo3.proxybank.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.promo3.proxybank.domaine.TypeUtilisateur;
import cm.objis.promo3.proxybank.domaine.Utilisateur;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Utilisateur user;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MainFrame(Utilisateur u) {
		this.user = u;
		setTitle("ProxyBank "+ " - Bienvenue "+u.getNom()+" "+u.getPrenom());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 527);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setJMenuBar(menuBar);
		
		JMenu mnParamtrage = new JMenu("Paramétrage");
		mnParamtrage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnParamtrage);
		
		JMenuItem mntmUtilisateurs = new JMenuItem("Utilisateurs");
		mnParamtrage.add(mntmUtilisateurs);
		
		JMenu mnClients = new JMenu("Clients");
		mnClients.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnClients);
		
		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mnClients.add(mntmNouveau);
		
		JMenuItem mntmListe = new JMenuItem("Liste");
		mnClients.add(mntmListe);
		
		JMenuItem mntmVirement = new JMenuItem("Virement");
		mnClients.add(mntmVirement);
		
		JMenuItem mntmPatrimoine = new JMenuItem("Patrimoine");
		mnClients.add(mntmPatrimoine);
		
		JMenu mnAudit = new JMenu("Audit");
		mnAudit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnAudit);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Contrôle Utilisateur
		if(!user.getFonction().equals(TypeUtilisateur.ADMIN)) {
			mnParamtrage.setEnabled(false);
		}
		if(!user.getFonction().equals(TypeUtilisateur.CONSEILLER)) {
			mnClients.setEnabled(false);
		}
		if(!user.getFonction().equals(TypeUtilisateur.GERANT)) {
			mnAudit.setEnabled(false);
		}
		
		//Je maximise et le rend visible
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

}
