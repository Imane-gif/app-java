package Interfaces;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.ClientDAO;
import DAO.FournisseurDAO;
import metier.Client;
import metier.Fournisseur;

public class FournisseurModifier {
	 

JComboBox tidFournisseur;

JTextField tnom,tprenom,tNumTel,tAdresse;
	
	JButton modifier,supprimer;
	
	
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setLayout(null);
		
		JLabel ModifierFournisseur= new JLabel("Modifier/Supprimer Fournisseur");
		
		ModifierFournisseur.setFont(new Font("Tahoma", Font.BOLD, 36));
		ModifierFournisseur.setHorizontalTextPosition(SwingConstants.CENTER);
		ModifierFournisseur.setPreferredSize(new Dimension(200, 100));
		ModifierFournisseur.setLocation(new Point(200, 200));
		ModifierFournisseur.setHorizontalAlignment(SwingConstants.CENTER);
		ModifierFournisseur.setForeground(Color.black);
		ModifierFournisseur.setBackground(Color.CYAN);
		ModifierFournisseur.setOpaque(true);
		ModifierFournisseur.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		ModifierFournisseur.setIgnoreRepaint(true);
		ModifierFournisseur.setBounds(60, 24, 600, 46);
		contenu.add(ModifierFournisseur);

		
		JLabel LidFournisseur = new JLabel("idFournisseur:");
		LidFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LidFournisseur.setBounds(130, 120, 100, 24);
		contenu.add(LidFournisseur);
		

		tidFournisseur = new JComboBox();
		tidFournisseur.setBounds(250, 120, 208, 27);
		contenu.add(tidFournisseur);
		FournisseurDAO fourn=new FournisseurDAO();
	    
	    ArrayList  <Fournisseur>  listFour=fourn.listesFournisseurs();
	   int i = 0;
	    
		for (Fournisseur F:  listFour ) {
	      int id= F.getIdFournisseur();
	     tidFournisseur.addItem(id);
			}

		
		
		JLabel Lnom = new JLabel("Nom :");
		Lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnom.setBounds(130, 180, 46, 24);
		contenu.add(Lnom);
		
		tnom = new JTextField();
		tnom.setBounds(250, 180, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		
		JLabel lprenom = new JLabel("Prenom :");
		lprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprenom.setBounds(130, 240, 76, 22);
		contenu.add(lprenom);
		
		tprenom = new JTextField();
		tprenom.setBounds(250, 240, 208, 27);
		contenu.add(tprenom);
		tprenom.setColumns(10);
		
		
		
		JLabel lnumTel = new JLabel("numTel :");
		lnumTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnumTel.setBounds(130, 300, 63, 14);
		contenu.add(lnumTel);
		
		tNumTel = new JTextField();
		tNumTel.setBounds(250, 300, 208, 27);
		contenu.add(tNumTel);
		tNumTel.setColumns(10);
		
		JLabel lAdresse = new JLabel("Adresse :");
		lAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lAdresse.setBounds(130, 360, 63, 14);
		contenu.add(lAdresse);
		
		tAdresse = new JTextField();
		tAdresse.setBounds(250, 360, 208, 27);
		contenu.add(tAdresse);
		tAdresse.setColumns(10);
		
		JButton modifier = new JButton("modifier");
		modifier.setBounds(220, 450, 100, 23);
		contenu.add(modifier);
		contenu.setBounds(80, 100, 696, 592);
		JButton chercher= new JButton("Chercher");
		chercher.setBounds(500, 120, 100, 23);
		contenu.add(chercher);
		JButton supprimer= new JButton("Supprimer");
		supprimer.setBounds(390, 450, 100, 23);
		contenu.add(supprimer);
		chercher.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				
				if(source.equals(chercher)) {
					
					FournisseurDAO tst=new FournisseurDAO();
					
					
					int idFournisseur=Integer.parseInt(tidFournisseur.getSelectedItem().toString());
					Fournisseur F=tst.chercher(idFournisseur);
					if(F.getIdFournisseur()>0 ) {
						
						tnom.setText(F.getNom());
						tprenom.setText(F.getPrenom());
						tNumTel.setText(F.getNumTel());
						tAdresse.setText(F.getAdresse());
						
				   
					}
				}
				
			}

		});
		

		    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		modifier.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				
				if(source.equals(modifier)) {
					
					FournisseurDAO tst=new FournisseurDAO();
					int idFournisseur=Integer.parseInt(tidFournisseur.getSelectedItem().toString());
					Fournisseur four=new Fournisseur(idFournisseur,tnom.getText(),tprenom.getText(),tNumTel.getText(),tAdresse.getText());
				

				     if (tst.modifier(four)) {
				    	 JOptionPane.showMessageDialog(null, " Ok fournisseur bien modifié","message ok",2);
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! fournisseur non modifié","erreur",2);
				    	  
				    	 
				    
	
				 			

				 		    	 
				     }
				}
				
			}

		});
		supprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evn) {
		// TODO Auto-generated method stub
Object source=evn.getSource();
		
		if(source.equals(supprimer)) {
			
			FournisseurDAO tst=new FournisseurDAO();

			@SuppressWarnings("unused")
			Fournisseur four =new Fournisseur();
			
			int idFournisseur=Integer.parseInt(tidFournisseur.getSelectedItem().toString());
			
			int rep=-2;
			rep= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le fournisseur N°:"+idFournisseur, "Confirmer", 1, 3);
			
			// JOptionPane.showMessageDialog(null, " choix"+rep,"message ok",2);
			
			 if(rep==0) {
			if (tst.supprimer(idFournisseur)==true) {
		    	 JOptionPane.showMessageDialog(null, " Ok Fournisseur supprimer","message ok",2);
		    	 tidFournisseur.removeItem(idFournisseur);
		    	 tnom.setText("");
					tprenom.setText("");
					tNumTel.setText("");
					tAdresse.setText("");
		    	 
		     }else {
		    	 JOptionPane.showMessageDialog(null, " !!!! Fourniseur non supprimer","erreur",2);
		    	 
		     }
		    	 
		     }}

	}});
		
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
		
		return contenu;

        
	}
}

