package Interfaces;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


import DAO.ClientDAO;
import DAO.MedicamentDAO;
import metier.Client;
import metier.Medicament;

public class ClientModifier {
JTextField  tnom,tprenom,tNumTel,tdateNaissance,tAdresse,tsomme;
JComboBox tidClient,tcodeBarre;
JRadioButton g1,g2;
ButtonGroup groupsx;
	
	JButton Modifier,Supprimer,chercher;
	
	
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setLayout(null);
		
		JLabel ModifierClient= new JLabel("Modifier/Supprimer client");
		ModifierClient.setForeground(Color.black);
		ModifierClient.setBackground(Color.CYAN);
		ModifierClient.setOpaque(true);
		ModifierClient.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		
		ModifierClient.setFont(new Font("Tahoma", Font.BOLD, 36));
		ModifierClient.setHorizontalTextPosition(SwingConstants.CENTER);
		ModifierClient.setPreferredSize(new Dimension(200, 100));
		ModifierClient.setLocation(new Point(200, 200));
		ModifierClient.setHorizontalAlignment(SwingConstants.CENTER);
		ModifierClient.setIgnoreRepaint(true);
		ModifierClient.setBounds(120, 24, 500, 46);
		contenu.add(ModifierClient);

		
		
		JLabel Lnom = new JLabel("Nom :");
		Lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnom.setBounds(150, 160, 46, 24);
		contenu.add(Lnom);
		
		tnom = new JTextField();
		tnom.setBounds(250, 160, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		JLabel LidClient = new JLabel("idClient:");
		LidClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LidClient.setBounds(150, 120, 70, 24);
		contenu.add(LidClient);
		
		tidClient = new JComboBox();
		///charger la list des id des clients
		
	    ClientDAO cli=new ClientDAO();
	    
	    ArrayList  <Client>  listCli=cli.listesClients();
	   int i = 0;
	    
		for (Client C:  listCli ) {
	      int id= C.getIdClient();
	      tidClient.addItem(id);
		}

	    
		
		///////////////////////////////////
		
		
		
		tidClient.setBounds(250, 120, 208, 27);
		contenu.add(tidClient);
		//tidClient.setColumns(10);
		
		JLabel lprenom = new JLabel("Prenom :");
		lprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprenom.setBounds(150, 200, 76, 22);
		contenu.add(lprenom);
		
		tprenom = new JTextField();
		tprenom.setBounds(250, 200, 208, 27);
		contenu.add(tprenom);
		tprenom.setColumns(10);
		
		JLabel lDateNaissance = new JLabel("DateNaissance:");
		lDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDateNaissance.setBounds(150, 240, 120, 22);
		contenu.add(lDateNaissance);
		
		 tdateNaissance = new JTextField();
		tdateNaissance.setBounds(250, 240, 208, 27);
		contenu.add(tdateNaissance);
		tdateNaissance.setColumns(10);
		
		JLabel lnumTel = new JLabel("numTel :");
		lnumTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnumTel.setBounds(150, 280, 63, 14);
		contenu.add(lnumTel);
		
		tNumTel = new JTextField();
		tNumTel.setBounds(250, 280, 208, 27);
		contenu.add(tNumTel);
		tNumTel.setColumns(10);
		
		JLabel lAdresse = new JLabel("Adresse :");
		lAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lAdresse.setBounds(150, 320, 63, 14);
		contenu.add(lAdresse);
		
		tAdresse = new JTextField();
		tAdresse.setBounds(250, 320, 208, 27);
		contenu.add(tAdresse);
		tAdresse.setColumns(10);
		
		JLabel lSexe = new JLabel("sexe :");
		lSexe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lSexe.setBounds(150, 370, 46, 14);
		contenu.add(lSexe);
		
		groupsx=new ButtonGroup();
		 g1 = new JRadioButton("Femme");
		g1.setBounds(250, 370, 76, 23);
		contenu.add(g1);
		
		 g2 = new JRadioButton("Homme");
		g2.setBounds(370, 370, 76, 23);
		contenu.add(g2);
		groupsx.add(g1);
		groupsx.add(g2);
		
		

		JLabel LcodeBarre = new JLabel("Code-a-Barre :");
		LcodeBarre .setFont(new Font("Tahoma", Font.PLAIN, 14));
		LcodeBarre .setBounds(151, 420, 90, 24);
		contenu.add(LcodeBarre );
		
		JLabel Lsomme = new JLabel("Somme:");
		Lsomme .setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lsomme .setBounds(151, 470, 90, 24);
		contenu.add(Lsomme );
		
			
		 tcodeBarre = new JComboBox();
		
		tcodeBarre.setBounds(250, 420, 208, 27);
		contenu.add(tcodeBarre);
		 MedicamentDAO mdc=new MedicamentDAO();
		    ArrayList<Medicament>lstmed=mdc.listesMedicaments();
		    
		    int j= 0;
		   for(Medicament m:lstmed) {
			      int code= m.getCodeBarre();
			      tcodeBarre.addItem(code);
		   }
		
		   tsomme = new JTextField();
			tsomme.setBounds(250, 470, 208, 27);
			contenu.add(tsomme);
			tsomme.setColumns(10);
		
		
		JButton modifier = new JButton("Modifier");
		JButton supprimer= new JButton("Supprimer");
		JButton chercher= new JButton("Chercher");
		modifier.setBounds(250, 510, 100, 23);
		supprimer.setBounds(370, 510, 100, 23);
		chercher.setBounds(500, 120, 100, 23);
		contenu.add(modifier);
		contenu.add(supprimer);
		contenu.add(chercher);
		contenu.setBounds(80, 100, 696, 592);
		
	///////////////////////////////////////////////////////////////////////////////////
		modifier.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				Object source=evn.getSource();
				
				if(source.equals(modifier)) {
			
			ClientDAO tst=new ClientDAO();
			int idClient=Integer.parseInt(tidClient.getSelectedItem().toString());
			int somme=Integer.parseInt(tsomme.getText());
			String sexe="";
			if(g1.isSelected()) {
				sexe="femme";
			}else {
				sexe="homme";
			}
			Client clt=new Client(idClient,tnom.getText(),tprenom.getText(),tdateNaissance.getText(),tNumTel.getText(),tAdresse.getText(),sexe,
					tcodeBarre.getSelectedItem().toString(),somme);
			

		     if (tst.modifier(clt)) {
		    	 JOptionPane.showMessageDialog(null, " Ok Client modifié","message ok",1);
		     }else {
		    	 JOptionPane.showMessageDialog(null, " !!!! Client non modifiér","erreur",2);
		    	 
		     }
		}
		
	 }

           });
		///////////////////////////////////////////////////
		chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				
					
		Object source=evn.getSource();
				
				if(source.equals(chercher)) {
				
					ClientDAO tst=new ClientDAO();
					int idClient=Integer.parseInt(tidClient.getSelectedItem().toString());
					Client C=tst.chercher(idClient);
					//int somme=Integer.parseInt(tsomme.getSlectedItem().toString());
					if(C.getIdClient()>0 ) {
						
						
						//JOptionPane.showMessageDialog(null, " Ok Client existe"+tst.chercher(idClient).getIdClient(),"message ok",2);
						//JOptionPane.showMessageDialog(null, " nbr lign"+model.getRowCount(),"message ok",2);
						
						
							tnom.setText(C.getNom());
							tprenom.setText(C.getPrenom());
							tNumTel.setText(C.getNumTel());
							tdateNaissance.setText(C.getDateNaissance());
							tAdresse.setText(C.getAdresse());
						    tcodeBarre.setSelectedItem(C.getCodeBarre());
						    tsomme.setText(String.valueOf(C.getSomme()));
							 
					    
					      String sexe =C.getSexe();
					      if (sexe.equals("femme")) {
					    	  g1.setSelected(true);
					    	  g2.setSelected(false);
					      }else {
					    	  g2.setSelected(true);
					    	  g1.setSelected(false);
					      }

					}
				
			}
				
			}
		});
		////////////////////////CHERCHER CLIENT PAR ID/////////////////////////
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				
				// TODO Auto-generated method stub
		Object source=evn.getSource();
				
				if(source.equals(supprimer)) {
					
					@SuppressWarnings("unused")
					ClientDAO tst=new ClientDAO();
					@SuppressWarnings("unused")
					Client clt=new Client();
					

				
					int idClient=Integer.parseInt(tidClient.getSelectedItem().toString());
					
					int rep=-2;
					rep= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le client N°:"+idClient, "Confirmer", 1, 3);
					
					// JOptionPane.showMessageDialog(null, " choix"+rep,"message ok",2);
					
					 if(rep==0) {
					if (tst.supprimer(idClient)==true) {
				    	 JOptionPane.showMessageDialog(null, " Ok Client supprimer","message ok",2);
				    	 
				    	 tidClient.removeItem(idClient);
				    	 tnom.setText("");
							tprenom.setText("");
							tNumTel.setText("");
							tdateNaissance.setText("");
							tAdresse.setText("");
							g1.setSelected(false);
							g2.setSelected(false);
				    	    tcodeBarre.setSelectedItem("");
				    	    tsomme.setText("");
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Client non supprimer","erreur",2);
				    	 
				     }
				     }
				     
					
				
			}
				
			}
		});
		
		//////////////////////////////////////////////
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
		return contenu;


          }}

