package Interfaces;

import java.awt.Color;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import DAO.UserDAO;
import metier.User;

public class UserModifier {
	JTextField tnom,tprenom,tlogin ,tpassword ,ttype,tnumtel,tadresse;
	JPasswordField password;
	JComboBox<Integer> tidUser;
	JButton modifier,Supprimer,chercher;
	public JPanel getContenu() {
		
		

		
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(Color.LIGHT_GRAY);
		contenu.setLayout(null);
		
		JLabel ModifierUtilisateur= new JLabel("Modifier/Supprimer Utilisateur");
		ModifierUtilisateur.setForeground(Color.black);
		ModifierUtilisateur.setBackground(Color.CYAN);
		ModifierUtilisateur.setOpaque(true);
		ModifierUtilisateur.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		
		ModifierUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 36));
		ModifierUtilisateur.setHorizontalTextPosition(SwingConstants.CENTER);
		ModifierUtilisateur.setPreferredSize(new Dimension(200, 100));
		ModifierUtilisateur.setLocation(new Point(200, 200));
		ModifierUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		ModifierUtilisateur.setIgnoreRepaint(true);
		ModifierUtilisateur.setBounds(30, 24, 650, 46);
		contenu.add(ModifierUtilisateur);
		

		
		JLabel LidUser = new JLabel("idUser :");
		LidUser .setFont(new Font("Tahoma", Font.PLAIN, 14));
		LidUser .setBounds(151, 105, 46, 24);
		contenu.add(LidUser );
		
		tidUser = new JComboBox<>();
		tidUser.setBounds(300, 105, 208, 27);
		contenu.add(tidUser);
	 
		 UserDAO usr=new UserDAO();
	     
	     ArrayList  <User>  lstuser=usr.listesUsers();
	
	     for (User u :  lstuser ) {
	       int id= u.getIdUser();
	       tidUser.addItem(id);}
	       
		
		JLabel lnom = new JLabel("Nom :");
		lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnom.setBounds(149, 164, 76, 22);
		contenu.add(lnom);
		
		tnom = new JTextField();
		tnom.setBounds(300, 159, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		
		JLabel lprenom = new JLabel("Prenom:");
		lprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprenom.setBounds(151, 211, 106, 22);
		contenu.add(lprenom);
		
		 tprenom = new JTextField();
		 tprenom.setBounds(300, 211, 208, 27);
		contenu.add(tprenom);
		tprenom.setColumns(10);
		
		JLabel llogin = new JLabel("Login :");
		llogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		llogin.setBounds(151, 263, 80, 14);
		contenu.add(llogin);
		
		 tlogin = new JTextField(); 
		tlogin.setBounds(300, 263, 208, 27);
		contenu.add(tlogin);
		tlogin.setColumns(10);
		
		JLabel lpassword = new JLabel("Password :");
		lpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lpassword.setBounds(151, 319, 70, 14);
		contenu.add(lpassword);
		
		password = new JPasswordField(); 
		password.setBounds(300, 319, 208, 27);
		contenu.add(password);
		password.setColumns(10);
		
		JLabel ltype = new JLabel("Type :");
		ltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ltype.setBounds(151, 380, 63, 14);
		contenu.add(ltype);
		
        ButtonGroup g1=new ButtonGroup();
      JRadioButton ch1 =new JRadioButton ("employé");
      JRadioButton ch2 =new JRadioButton("gérant");
        
        ch1.setBounds(300, 380, 80, 30);
        ch2.setBounds(430,380, 80, 30);
        g1.add(ch1);
        g1.add(ch2);
        contenu.add(ch1);
        contenu.add(ch2);
        
        JLabel Lnumtel = new JLabel("numTel :");
		Lnumtel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnumtel .setBounds(151, 430, 90, 24);
		contenu.add(Lnumtel );
		
		JLabel Ladresse = new JLabel("Adresse:");
		Ladresse .setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ladresse .setBounds(151, 480, 90, 24);
		contenu.add(Ladresse );
		
			
		tnumtel = new JTextField();
		
		tnumtel.setBounds(300, 430, 208, 27);
		contenu.add(tnumtel);
		
		tadresse = new JTextField();
		tadresse.setBounds(300, 480, 208, 27);
		contenu.add(tadresse);
		tadresse.setColumns(10);
        
		
         chercher = new JButton("Chercher");
        chercher.setBounds(530, 105, 100, 23);
		contenu.add(chercher);
		
        modifier = new JButton("Modifier");
		modifier.setBounds(280, 530, 100, 23);
		contenu.add(modifier);
		 Supprimer= new JButton("Supprimer");
		Supprimer.setBounds(430, 530, 100, 23);
		contenu.add(Supprimer);
		contenu.setBounds(80, 100, 696, 592);
		modifier.addActionListener(new ActionListener () {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evn) {
				Object source=evn.getSource();
				if(source.equals(modifier)) {
					
				UserDAO tst=new UserDAO();
				int idUser=Integer.parseInt(tidUser.getSelectedItem().toString());
				
				String type="";
				if(ch1.isSelected()) {
					type="employe";
				}else if(ch2.isSelected()) {
					type="gerant";
				}
				User use=new User(idUser,tnom.getText(),tprenom.getText(),tlogin.getText(),password.getText(),type,
						tnumtel.getText(),tadresse.getText());
				

				
				
				 
		  
		
			if (tst.modifier(use)) {
		    	 JOptionPane.showMessageDialog(null, " Ok Utilisateur modifié","message ok",2);
		     }else {
		    	 JOptionPane.showMessageDialog(null, " !!!! Utilisateur non modifiér","erreur",2);
		    	 
		     }
		}
		
				}}

		
           );
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				
				// TODO Auto-generated method stub
		Object source=evn.getSource();
				
				if(source.equals(Supprimer)) {
					
				
					UserDAO tst=new UserDAO();
					@SuppressWarnings("unused")
					User use=new User();
					
         int idUser=Integer.parseInt(tidUser.getSelectedItem().toString());
					
					int rep=-2;
					rep= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer l'utilisateur N°:"+idUser, "Confirmer", 1, 3);
					
					
					 if(rep==0) {
					if (tst.supprimer(idUser)==true) {
				    	 JOptionPane.showMessageDialog(null, " Ok utilisateur supprimer","message ok",2);
				    	 
				    	 tidUser.removeItem(idUser);
				    	    tnom.setText("");
							tprenom.setText("");
							tlogin.setText("");
							password.setText("");
							tnumtel.setText("");
							tadresse.setText("");
							ch1.setSelected(false);
							ch2.setSelected(false);  
							tnumtel.setText("");
							tadresse.setText("");
							}else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Utilisateur non supprimer","erreur",2);
				    	 
				     
					 }}}
				
			
				
			}
		});
		chercher.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				Object source=evn.getSource();
				
				if(source.equals(chercher)) {
					UserDAO tst=new UserDAO();
					
				
					
					int idUser=Integer.parseInt(tidUser.getSelectedItem().toString());
				User U=tst.chercher(idUser);
					if(U.getIdUser()>0 ) {
						
						
							tnom.setText(U.getNom());
							tprenom.setText(U.getPrenom());
							tlogin.setText(U.getLogin());
							password.setText(U.getPassword());
			                 tnumtel.setText(U.getNumTel());
			                 tadresse.setText(U.getAdresse());
							String type =U.getType();
						    if (type.equals("gerant")) {
						    	  ch1.setSelected(false);
						    	  ch2.setSelected(true);
						      }else {
						    	  ch2.setSelected(false);
						    	  ch1.setSelected(true);
						      }

					    
						   


					   	
				 
					}}}});
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
		
		return contenu;


          }

	}

