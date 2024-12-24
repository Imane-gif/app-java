package Interfaces;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Principale {
	
	JFrame fenetre;
	int larg_fenetre=750, haut_fenetre=630;
	public static JTabbedPane tab;
	
	public Principale() {
		
		 fenetre=new JFrame("Pharmae Gestion");

		 
		 fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 JFrame.setDefaultLookAndFeelDecorated(true);
		    fenetre.setSize(larg_fenetre, haut_fenetre);
		   

			///mettre la fenetre au centre de l'écran
	        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	        int X=(int) (dim.getWidth()/2 - fenetre.getWidth()/2);
	        int Y=(int) (dim.getHeight()/2 - fenetre.getHeight()/2);
	        fenetre.setLocation(X, Y);
		 
		 //fenetre.setSize(1000, 600);
		 fenetre.setLayout(null);
		    Image icon = Toolkit.getDefaultToolkit().getImage(".\\figures\\images.png");
		    fenetre.setIconImage(icon );
		 fenetre.setResizable(false);
		// fenetre.setCursor(Cursor.HAND_CURSOR);

		 

		 
	
		 
		 
		 
		JMenuBar barre=new JMenuBar();
		 
		 JMenu ClientMenu = new JMenu("Client");
			ClientMenu.setHorizontalAlignment(SwingConstants.CENTER);
			ClientMenu.setBounds(120, 20, 115, 26);
			barre.add(ClientMenu);
			
			JMenuItem ClientAjouter = new JMenuItem("Ajouter");
			ClientMenu.add(ClientAjouter);
			ClientAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(ClientAjouter)) {
							ClientAjout pageClientAjout=new ClientAjout();
							fenetre.setContentPane(pageClientAjout.getContenu());
							fenetre.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
		     JMenuItem ClientModifier = new JMenuItem("supprimer/modifier");
			ClientMenu.add(ClientModifier);
			ClientModifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(ClientModifier)) {
							ClientModifier pageClientModifier=new ClientModifier();
							fenetre.setContentPane(pageClientModifier.getContenu());
							fenetre.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			JMenuItem ClientChercher = new JMenuItem("afficher");
			ClientChercher.setBounds(200, 20, 137, 26);
		     ClientMenu.add(ClientChercher);
		     ClientChercher.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(ClientChercher)) {
								ClientAfficher pageClientChercher=new ClientAfficher();
								fenetre.setContentPane(pageClientChercher.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
					
		     
		     


			JMenu FournisseurMenu = new JMenu("Fournisseur ");
			FournisseurMenu.setBounds(412, 20, 127, 26);
			barre.add(FournisseurMenu);
			JMenuItem FournisseurAjouter = new JMenuItem("Ajouter");
			FournisseurMenu.add(FournisseurAjouter);
			FournisseurAjouter.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(FournisseurAjouter)) {
								FournisseurAjout pageFournisseurAjouter=new FournisseurAjout();
								fenetre.setContentPane(pageFournisseurAjouter.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			JMenuItem FournisseurModifier= new JMenuItem("supprimer/modifier");
			FournisseurModifier.setBounds(200, 20, 137, 26);
		     FournisseurMenu.add(FournisseurModifier);
		     FournisseurModifier.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(FournisseurModifier)) {
								FournisseurModifier pageFournisseurModifier=new FournisseurModifier();
								fenetre.setContentPane(pageFournisseurModifier.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
		     JMenuItem FournisseurChercher = new JMenuItem("afficher");
			FournisseurMenu.add(FournisseurChercher);
			FournisseurChercher.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(FournisseurChercher)) {
								FournisseurAfficher pageFournisseurChercher=new FournisseurAfficher();
								fenetre.setContentPane(pageFournisseurChercher.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
		
	
			JMenu MedicamentMenu = new JMenu("Medicament ");
			MedicamentMenu.setBounds(262, 20, 127, 26);
			barre.add(MedicamentMenu);
			
			MedicamentMenu.setHorizontalAlignment(SwingConstants.CENTER);
			JMenuItem MedicamentAjouter = new JMenuItem("Ajouter");
			MedicamentMenu.add(MedicamentAjouter);
			MedicamentAjouter.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(MedicamentAjouter)) {
								MedicamentAjout pageMedicamentAjouter=new MedicamentAjout();
								fenetre.setContentPane(pageMedicamentAjouter.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			
			JMenuItem MedicamentModifier = new JMenuItem("modifier/supprimer");
			MedicamentMenu.add(MedicamentModifier);
			 MedicamentModifier.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(MedicamentModifier)) {
								MedicamentModifier pageMedicamentModifier=new MedicamentModifier();
								fenetre.setContentPane(pageMedicamentModifier.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			JMenuItem MedicamentChercher = new JMenuItem("Afficher");
			MedicamentMenu.add(MedicamentChercher);
			MedicamentChercher.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(MedicamentChercher)) {
								MedicamentAfficher pageMedicamentChercher=new MedicamentAfficher();
								fenetre.setContentPane(pageMedicamentChercher.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
		
			JMenu UtilisateurMenu = new JMenu("Utilisateur");
			UtilisateurMenu.setHorizontalAlignment(SwingConstants.CENTER);
			UtilisateurMenu.setBounds(0, 20, 127, 26);
			barre.add(UtilisateurMenu);
			JMenu VenteMenu = new JMenu("Vente");
			VenteMenu.setHorizontalAlignment(SwingConstants.CENTER);
			VenteMenu.setBounds(350, 20, 127, 26);
			barre.add(VenteMenu);
			
			JMenuItem CommandeAjouter = new JMenuItem("Ajouter");
			VenteMenu.add(CommandeAjouter);
			CommandeAjouter.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(CommandeAjouter)) {
								CommandeAjout pageCommandeAjouter=new CommandeAjout();
								fenetre.setContentPane(pageCommandeAjouter.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			JMenuItem CommandeModifier = new JMenuItem("Modifier/supprimer");
			VenteMenu.add(CommandeModifier);
			CommandeModifier.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(CommandeModifier)) {
							CommandeModifier pageCommandeModifier=new CommandeModifier();
								fenetre.setContentPane(pageCommandeModifier.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			JMenuItem CommandeAfficher = new JMenuItem("Afficher");
			VenteMenu.add(CommandeAfficher);
			CommandeAfficher.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(CommandeAfficher)) {
							CommandeAfficher pageCommandeAfficher=new CommandeAfficher();
								fenetre.setContentPane(pageCommandeAfficher.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			
			
			JMenuItem UtilisateurAjouter = new JMenuItem("Ajouter");
			UtilisateurMenu.add(UtilisateurAjouter);
			UtilisateurAjouter.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(UtilisateurAjouter)) {
								UserAjout pageUtilisateurAjouter=new UserAjout();
								fenetre.setContentPane(pageUtilisateurAjouter.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
			
			
		     JMenuItem UtilisateurModifier = new JMenuItem("modifier/supprimer");
			UtilisateurMenu.add(UtilisateurModifier);
			UtilisateurModifier.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(UtilisateurModifier)) {
								UserModifier pageUtilisateurModifier=new UserModifier();
								fenetre.setContentPane(pageUtilisateurModifier.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			JMenuItem UtilisateurChercher = new JMenuItem("Afficher");
			UtilisateurMenu.add(UtilisateurChercher);
			UtilisateurChercher.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(UtilisateurChercher)) {
								UserAfficher pageUtilisateurChercher=new UserAfficher();
								fenetre.setContentPane(pageUtilisateurChercher.getContenu());
								fenetre.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"erreur",null,2);}}});
			
		fenetre.setJMenuBar(barre);
		fenetre.setVisible(true);
		/*JPanel pane=new JPanel();
		pane.setSize(1000, 900);
		
		fenetre.add(panel);
		*/ 
   ////////////////
		
		JPanel panel = new JPanel();
		panel.setSize(750, 630);
		panel.setBackground(SystemColor.control);
		panel.setForeground(new Color(0, 0, 0));
		
		
		ImageIcon background=new ImageIcon(".\\figures\\bg.jpg");
		JLabel lblNewLabel = new JLabel(background);
		/*lblNewLabel.setBounds(0, 0, 750, 630);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0,0,0),null));
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 100, 698, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Login :");
		lblNewLabel_1.setBounds(160, 190, 67, 23);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(279, 190, 248, 26);
		textField.setBackground(Color.WHITE);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(160, 255, 97, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel_2);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(279, 251, 248, 26);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setBounds(279, 428, 105, 23);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(btnNewButton);
		////////////////////////////
		panel.setVisible(true);
		 

		fenetre.add(panel);*/
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
			
		 
		 
		 
	
		 
		 
		 
		 
	
	
	

	public static void main(String[] args) {
		
		/*new Principale();
		// TODO Auto-generated method stub*/
		

	     

	}}


