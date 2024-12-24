package Interfaces;

	import java.awt.BorderLayout;

	import java.awt.Dimension;
	import java.awt.Image;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.*;



		public class PrincipaleAdmin {
			
			JFrame fenetre;
			
			public PrincipaleAdmin() {
				 int larg_fenetre = 750, haut_fenetre = 630;
				
				 fenetre=new JFrame("Pharmae Gestion");
				 
				 fenetre.setSize(800, 625);
				 fenetre.setLayout(null);
				 fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 JFrame.setDefaultLookAndFeelDecorated(true);
				Image icon = Toolkit.getDefaultToolkit().getImage(".\\figures\\image.png");
			    fenetre.setIconImage(icon );
				
				 fenetre.setResizable(false); 
				 fenetre.setSize(larg_fenetre, haut_fenetre);
				 //mettre la fenetre au centre de l'écran
				 Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
				 int X=(int) (dim.getWidth()/2 - fenetre.getWidth()/2);
				 int Y=(int) (dim.getHeight()/2 - fenetre.getHeight()/2);
				 fenetre.setLocation(X, Y);
		
				 JPanel panel =new JPanel();
					fenetre.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(null);
					
					
					
					JMenuBar barre=new JMenuBar();
					
					JMenu ClientMenu = new JMenu("Client");
					ClientMenu.setHorizontalAlignment(SwingConstants.CENTER);
					ClientMenu.setBounds(120, 0, 115, 26);
					panel.add(ClientMenu);
					barre.add(ClientMenu);
					JMenuItem ClientAjouter = new JMenuItem("Ajouter");
					ClientMenu.add(ClientAjouter);
					ClientAjouter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(ClientAjouter)) {
								 ClientAjout pageClientAjout=new ClientAjout();
								 fenetre.setContentPane(pageClientAjout.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}	}});
				     JMenuItem ClientModifier = new JMenuItem("Modifier/Supprimer");
					ClientMenu.add(ClientModifier);
					ClientModifier.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(ClientModifier)) {
								 ClientModifier pageClientModify=new ClientModifier();
								 fenetre.setContentPane(pageClientModify.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}	}});
					JMenuItem ClientAfficher = new JMenuItem("Afficher");
					ClientMenu.add(ClientAfficher);
					ClientAfficher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(ClientAfficher)) {
								 ClientAfficher pageClientAfficher=new ClientAfficher();
								 fenetre.setContentPane(pageClientAfficher.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}	}});
					JMenu FournisseurMenu = new JMenu("Fournisseur ");
					FournisseurMenu.setBounds(412, 0, 127, 26);
					panel.add(FournisseurMenu);
					barre.add(FournisseurMenu);
					JMenuItem FournisseurAjouter = new JMenuItem("Ajouter");
					FournisseurMenu.add(FournisseurAjouter);
					FournisseurAjouter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(FournisseurAjouter)) {
								 FournisseurAjout pageClientAfficher=new FournisseurAjout();
								 fenetre.setContentPane(pageClientAfficher.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}}});
					
					JMenuItem FournisseurModifier = new JMenuItem("Modifier/Supprimer");
					FournisseurModifier.setBounds(200, 0, 137, 26);
				     FournisseurMenu.add(FournisseurModifier);
				     FournisseurModifier.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(FournisseurModifier)) {
								 FournisseurModifier pageFournisseurModify=new FournisseurModifier();
								 fenetre.setContentPane(pageFournisseurModify.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}	}});
				     
					JMenuItem FournisseurAfficher = new JMenuItem("Afficher");
					FournisseurMenu.add(FournisseurAfficher);
					FournisseurAfficher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(FournisseurAfficher)) {
								 FournisseurAfficher pageFournisseurAfficher=new FournisseurAfficher();
								 fenetre.setContentPane(pageFournisseurAfficher.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}	}
							
							
						});
					JMenu MedicamentMenu = new JMenu("Medicament ");
					MedicamentMenu.setBounds(262, 0, 127, 26);
					panel.add(MedicamentMenu);
					barre.add(MedicamentMenu);
					MedicamentMenu.setHorizontalAlignment(SwingConstants.CENTER);
					JMenuItem MedicamentAjouter = new JMenuItem("Ajouter");
					MedicamentMenu.add(MedicamentAjouter);
					MedicamentAjouter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
				             MedicamentAjout pageMedicamentAjout=new MedicamentAjout();
				             fenetre.setContentPane(pageMedicamentAjout.getContenu());
							 fenetre.setVisible(true);
							
						}
						
					});
					JMenuItem MedicamentModifier = new JMenuItem("Modifier/Supprimer");
					MedicamentModifier.setBounds(200, 0, 137, 26);
					MedicamentMenu.add(MedicamentModifier);
					MedicamentModifier.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							  MedicamentModifier pageMedicamentModify=new MedicamentModifier();
					             fenetre.setContentPane(pageMedicamentModify.getContenu());
								 fenetre.setVisible(true);}});
					JMenuItem MedicamentAfficher = new JMenuItem("Afficher");
					MedicamentMenu.add(MedicamentAfficher);
					MedicamentAfficher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(MedicamentAfficher)) {
								 MedicamentAfficher pageMedicamentAfficher=new MedicamentAfficher();
								 fenetre.setContentPane(pageMedicamentAfficher.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}
							
						}
						
					});
					JMenu UtilisateurMenu = new JMenu("Utilisateur");
					UtilisateurMenu.setHorizontalAlignment(SwingConstants.CENTER);
					UtilisateurMenu.setBounds(0, 0, 127, 26);
					panel.add(UtilisateurMenu);
					barre.add(UtilisateurMenu);
					JMenuItem UtilisateurAjouter = new JMenuItem("Ajouter");
					UtilisateurMenu.add(UtilisateurAjouter);
					UtilisateurAjouter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(UtilisateurAjouter)) {
								 UserAjout pageUserAjout=new UserAjout();
								 fenetre.setContentPane(pageUserAjout.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}
								 } });
				     JMenuItem UtilisateurModifier = new JMenuItem("Modifier/Supprimer");
					UtilisateurMenu.add(UtilisateurModifier);
					UtilisateurModifier.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(UtilisateurModifier)) {
								 UserModifier pageUserModify=new UserModifier();
								 fenetre.setContentPane(pageUserModify.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}}});
					
					JMenuItem UtilisateurAfficher = new JMenuItem("Afficher");
					UtilisateurMenu.add(UtilisateurAfficher);
					UtilisateurAfficher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource().equals(UtilisateurAfficher)) {
								 UserAfficher pageUserAfficher=new UserAfficher();
								 fenetre.setContentPane(pageUserAfficher.getContenu());
								 fenetre.setVisible(true);
								 } else {
								JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}}});
					JMenu VenteMenu = new JMenu("Commande");
					VenteMenu.setHorizontalAlignment(SwingConstants.CENTER);
					VenteMenu.setBounds(579, 0, 115, 26);
					panel.add(VenteMenu);
					barre.add(VenteMenu);
				     JMenuItem venteAjouter = new JMenuItem("ajouter");
				     venteAjouter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(e.getSource().equals(venteAjouter)) {
									 CommandeAjout pageVenteAjout=new CommandeAjout();
									 fenetre.setContentPane(pageVenteAjout.getContenu());
									 fenetre.setVisible(true);
									 } else {
									JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}
									 } });
				     VenteMenu.add(venteAjouter);
				     
				     JMenuItem venteModify = new JMenuItem("modifier/supprimer");
				     venteModify.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(e.getSource().equals(venteModify)) {
									 CommandeModifier pageVenteModify=new CommandeModifier();
									 fenetre.setContentPane(pageVenteModify.getContenu());
									 fenetre.setVisible(true);
									 } else {
									JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}
									 } });
				     VenteMenu.add(venteModify);
				     
				     JMenuItem venteAfficher = new JMenuItem("afficher");
				     venteAfficher.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(e.getSource().equals(venteAfficher)) {
									 CommandeAfficher pageVenteAfficher=new CommandeAfficher();
								     fenetre.setContentPane(pageVenteAfficher.getContenu());
									 fenetre.setVisible(true);
									 } else {
									JOptionPane.showMessageDialog(null,"on ne peux pas l'affichée",null, 2);}
									 } });
				     VenteMenu.add(venteAfficher);
					 fenetre.setJMenuBar(barre);
					 
					 
					 JLabel background = new JLabel("");
						background.setIcon(new ImageIcon(".\\figures\\ph.jpg"));
						background.setBounds(0, 0, 750, 630);
						fenetre.getContentPane().add(background);
						
				
						
						
						
						
						fenetre.setVisible(true);
				
					 
					
					 
					    
					
				
			
				 
		
			}

			

		 

}
