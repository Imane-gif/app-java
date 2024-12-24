package Interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import DAO.FournisseurDAO;
import metier.Fournisseur;

public class FournisseurAjout  {
	 
JTextField tnom,tprenom,tNumTel,tAdresse;
	
	JButton valider;
	
	
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setLayout(null);
		contenu.setBounds(80, 100, 696, 592);
		
		JLabel AjouterFournisseur= new JLabel("Ajouter Fournisseur");
		AjouterFournisseur.setForeground(Color.black);
		AjouterFournisseur.setBackground(Color.CYAN);
		AjouterFournisseur.setOpaque(true);
		AjouterFournisseur.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		AjouterFournisseur.setFont(new Font("Tahoma", Font.BOLD, 36));
		AjouterFournisseur.setHorizontalTextPosition(SwingConstants.CENTER);
		AjouterFournisseur.setPreferredSize(new Dimension(200, 100));
		AjouterFournisseur.setLocation(new Point(200, 200));
		AjouterFournisseur.setHorizontalAlignment(SwingConstants.CENTER);
		AjouterFournisseur.setIgnoreRepaint(true);
		AjouterFournisseur.setBounds(100, 24, 525, 46);
		contenu.add(AjouterFournisseur);
		
		JLabel Lnom = new JLabel("Nom :");
		Lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnom.setBounds(151, 120, 46, 24);
		contenu.add(Lnom);
		
		tnom = new JTextField();
		tnom.setBounds(300, 120, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		
		JLabel lprenom = new JLabel("Prenom :");
		lprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprenom.setBounds(151, 180, 76, 22);
		contenu.add(lprenom);
		
		tprenom = new JTextField();
		tprenom.setBounds(300, 180, 208, 27);
		contenu.add(tprenom);
		tprenom.setColumns(10);
		
		
		
		JLabel lnumTel = new JLabel("numTel :");
		lnumTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnumTel.setBounds(151, 240, 63, 14);
		contenu.add(lnumTel);
		
		tNumTel = new JTextField();
		tNumTel.setBounds(300, 240, 208, 27);
		contenu.add(tNumTel);
		tNumTel.setColumns(10);
		
		JLabel lAdresse = new JLabel("Adresse :");
		lAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lAdresse.setBounds(151, 300, 63, 14);
		contenu.add(lAdresse);
		
		tAdresse = new JTextField();
		tAdresse.setBounds(300, 300, 208, 27);
		contenu.add(tAdresse);
		tAdresse.setColumns(10);
		
		JButton quitter =new JButton("Quitter");
	    quitter.setBounds(420, 390, 89, 23);
	    quitter.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent evn) {
	    		 Object source =evn.getSource();
	    		 if(source.equals(quitter)) {
	    			 System.exit(0);
	    		 }
	    		 
	    	 }
	    });
		contenu.add(quitter);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBounds(180, 390, 89, 23);
		contenu.add(ajouter);
		ajouter.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				FournisseurDAO tst=new FournisseurDAO();
				Fournisseur four=new Fournisseur(1,tnom.getText(),tprenom.getText(),tNumTel.getText(),tAdresse.getText());
				

				if(source.equals(ajouter)) {
					if(tnom.getText().isEmpty() || tprenom.getText().isEmpty() || tNumTel.getText().isEmpty()
					|tAdresse.getText().isEmpty() ) {
					     JOptionPane.showMessageDialog(null, " veuillez remplir tous les champs","erreur d'authentification",2);}
					
					else {
					
				
				     if (tst.inserer(four)>0) {
				    	 JOptionPane.showMessageDialog(null, " Ok Fournisseur inserer","message ok",2);
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Fournisseur non inserer","erreur",2);
				    	 
				     }
				}}
				
			}

		});JButton vider =new JButton("vider");
		vider.setBounds(300, 390, 89, 23);
		contenu.add(vider);
		vider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				Object source=evn.getSource();
				if(source.equals(vider)) {
					vider();
			
				}
				
			}
		});
		
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
		return contenu;
		}
		
		public void vider() {
			tnom.setText("");
			tprenom.setText("");
			tNumTel.setText("");
			tAdresse.setText("");}
		
			
			

        
	}
		
	
