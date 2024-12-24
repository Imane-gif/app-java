package Interfaces;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.net.CacheResponse;

import javax.swing.*;
	import javax.swing.border.LineBorder;


	public class Acceuil {
		JFrame fen;
		JTextField tlogin;
		JPasswordField tpassword;
		ButtonGroup btn;

		public Acceuil() { 
			 int larg_fenetre = 750, haut_fenetre = 630;
			fen = new JFrame("Acceuil");
			fen.setBounds(100, 100, 750, 630);
			fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fen.getContentPane().setLayout(null);
			
			
			 fen.setResizable(false); 
			 fen.setSize(larg_fenetre, haut_fenetre);
			 
			 //mettre la fenetre au centre de l'écran
			 Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
			 int X=(int) (dim.getWidth()/2 - fen.getWidth()/2);
			 int Y=(int) (dim.getHeight()/2 - fen.getHeight()/2);
			 fen.setLocation(X, Y);  
			 
			 
			   
	 		  JPanel contenu = new JPanel();
	 		  
	 		  
	 			contenu.setBorder(new LineBorder(new Color(0, 0, 0)));
	 			contenu.setBounds(154, 134, 443, 321);
	 			fen.getContentPane().add(contenu);
	 			/////
	 			Image icon = Toolkit.getDefaultToolkit().getImage(".\\figures\\image.png");
			    fen.setIconImage(icon );
	 			/////////
	 			contenu.setBackground(new Color(255, 255, 255));
	 			contenu.setLayout(null);
	 			fen.getContentPane().add(contenu, BorderLayout.CENTER);
	 			JLabel lconnexion = new JLabel("Connexion");
	 			lconnexion.setHorizontalAlignment(SwingConstants.CENTER);
	 			lconnexion.setBounds(27, 11, 379, 31);
	 			lconnexion.setFont(new Font("Tahoma", Font.BOLD, 27));
	 			contenu.add(lconnexion);
	 			
	 			JLabel llogin = new JLabel("Login :");
	 			llogin.setFont(new Font("Tahoma", Font.BOLD, 14));
	 			llogin.setBounds(27, 103, 59, 22);
	 			contenu.add(llogin);
	 			
	 			JLabel lpassword = new JLabel("Mot de passe :");
	 			lpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	 			lpassword.setBounds(27, 160, 104, 22);
	 			contenu.add(lpassword);
	 			
	 			JLabel ltype = new JLabel("Type :");
	 			ltype.setFont(new Font("Tahoma", Font.BOLD, 14));
	 			ltype.setBounds(27, 218, 46, 22);
	 			contenu.add(ltype);
	 			
	 			tlogin = new JTextField();
	 			tlogin.setBounds(143, 105, 217, 22);
	 			contenu.add(tlogin);
	 			tlogin.setColumns(10);
	 			
	 			tpassword = new JPasswordField();
	 			tpassword.setBounds(143, 163, 217, 22);
	 			contenu.add(tpassword);
	 			tpassword.setColumns(10);
	 			ButtonGroup btn=new ButtonGroup();
	 			JRadioButton g1 = new JRadioButton("gérant");
	 			g1.setBounds(143, 220, 84, 23);
	 			contenu.add(g1);
	 			btn.add(g1);
	 			
	 			JRadioButton g2 = new JRadioButton("Employé");
	 			g2.setBounds(269, 220, 91, 23);
	 			btn.add(g2);
	 			contenu.add(g2);
			JButton Bconnexion = new JButton("connexion");
			Bconnexion.setFont(new Font("Tahoma", Font.BOLD, 12));
			Bconnexion.setBounds(189, 275, 100, 23);
			contenu.add(Bconnexion);
			Bconnexion.addActionListener(new ActionListener() {
			
			
				
				
				public void actionPerformed(ActionEvent e) {
				    Object source=e.getSource();
				    if(source.equals(Bconnexion)) {
				    	if(tlogin.getText().isEmpty() || tpassword.getPassword().length==0) {
				     JOptionPane.showMessageDialog(null, " veuillez remplir tous les champs","Avertissement",2);}
				    	else {
				    		String login=tlogin.getText();
				    		String password=new String(tpassword.getPassword());
				    		if(login.equals("Meryem") && password.equals("admin123")) {
				    	if(g1.isSelected()) {
				    		new PrincipaleAdmin();
				    	}}
				    		else if(login.equals("Imane") && password.equals("2002") || login.equals("Salma") && password.equals("1999")) {
				    	if(g2.isSelected()) {
				    		new PrincipaleEmploye();
				    	}}
				    		else {
				    			JOptionPane.showMessageDialog(null, "login ou mot de passe incorrect","Erreur",2);
				    		}
				    			
				    		}
				    }}
				
				
			
				}
				
			);
			
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon(".\\figures\\acc.jpg"));
			background.setBounds(0, 0, 750, 630);
			fen.getContentPane().add(background);
			fen.setVisible(true);
			
		}
	        public static void main(String[] args) {
	        	new Acceuil();
	        	

	 } }


