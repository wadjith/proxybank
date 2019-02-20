package cm.objis.promo3.proxybank.presentation;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cm.objis.promo3.proxybank.domaine.Utilisateur;
import cm.objis.promo3.proxybank.service.IParametrageService;
import cm.objis.promo3.proxybank.service.ParametrageServiceImpl;
import cm.objis.promo3.proxybank.util.FrameParameter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginFrame {

	private JFrame frmLoginFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					FrameParameter.centered(window.frmLoginFrame); // Je centre l'affichage de la fenêtre
					window.frmLoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private IParametrageService service;
	private JTextField textUserName;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public LoginFrame() {
		service = new ParametrageServiceImpl();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginFrame = new JFrame();
		frmLoginFrame.setTitle("ProxyBank - Connection Utilisateur");
		frmLoginFrame.setBounds(100, 100, 613, 317);
		frmLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(168, 49, 113, 20);
		frmLoginFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de Passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(168, 104, 110, 20);
		frmLoginFrame.getContentPane().add(lblNewLabel_1);
		
		textUserName = new JTextField();
		textUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textUserName.setBounds(303, 42, 273, 35);
		frmLoginFrame.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Connexion");
		/* Placer une icone sur le bouton */
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img));
		/* Fin ajout de l'icone */
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = "";
				String password = "";
				
				/******    VERIFICATION DE N'AVOIR PAS DE CHAMPS VIDES    *****/
				if(textUserName.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Ce champ ne doit pas être vide", "Info", 1);
					textUserName.requestFocus();
					return;
				}else {
					login = textUserName.getText();
				}
				password = passwordToString(passwordField.getPassword());
				
				// Connexion de l'utilisateur
				Utilisateur user = service.connecteUtilisateur(login, password);
				if(user == null) {
					JOptionPane.showMessageDialog(null, "Utilisateur ou Mot de passe incorrect", "Erreur", 0);
					textUserName.requestFocus();
					return;
					
				}else {
					
					frmLoginFrame.dispose(); //J'efface la fenêtre login
					new MainFrame(user); // J'ouvre la fenêtre principale
					
					
				}
				
				
			}
		});
		btnLogin.setBounds(168, 184, 146, 47);
		frmLoginFrame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setEchoChar('+');
		passwordField.setBounds(303, 97, 273, 35);
		frmLoginFrame.getContentPane().add(passwordField);
		
		JLabel lblLogin = new JLabel("");
		/* Ajout d'une image icone sur le bouton */
		Image imgLogin = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblLogin.setIcon(new ImageIcon(imgLogin));
		/* Fin de l'ajout de l'image icône */
		lblLogin.setBounds(15, 33, 138, 198);
		frmLoginFrame.getContentPane().add(lblLogin);
	}
	
	// Récuprère la chaîne de caractère du tableau de caractère du mot de passe
	private String passwordToString(char[] password) {
		StringBuilder sb = new StringBuilder();
		for(char p : password) {
			sb.append(p);
		}
		return sb.toString();
	}
}
