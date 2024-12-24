package Interfaces;

import java.awt.Font;





import java.awt.Dimension;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import metier.Client;
import metier.Medicament;
import DAO.ClientDAO;
import DAO.MedicamentDAO;





public class ClientAjout {
	
	JTextField tnom,tprenom,tNumTel,tAdresse,tsomme,tdateNaissance;

	JComboBox<Integer> tcodeBarre;
	
	
	JButton ajouter,annuler;
	JRadioButton g1,g2;
	ButtonGroup groupsx;
	
	public JPanel getContenu() {
		
		
		
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setBounds(80, 100, 696, 592);
		contenu.setLayout(null);
		
		
		
		
		JLabel AjouterClient= new JLabel("Ajouter Client");
		AjouterClient.setForeground(Color.black);
		AjouterClient.setBackground(Color.CYAN);
		AjouterClient.setOpaque(true);
		AjouterClient.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		
		AjouterClient.setFont(new Font("Tahoma", Font.BOLD, 36));
		AjouterClient.setHorizontalTextPosition(SwingConstants.CENTER);
		AjouterClient.setPreferredSize(new Dimension(200, 100));
		AjouterClient.setLocation(new Point(200, 200));
		AjouterClient.setHorizontalAlignment(SwingConstants.CENTER);
		AjouterClient.setIgnoreRepaint(true);
		AjouterClient.setBounds(100, 24, 525, 46);
		contenu.add(AjouterClient);
		
		JLabel Lnom = new JLabel("Nom :");
		Lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnom.setBounds(151, 105, 46, 24);
		contenu.add(Lnom);
		
		tnom = new JTextField();
		tnom.setBounds(300, 102, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		
		JLabel lprenom = new JLabel("Prenom :");
		lprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprenom.setBounds(149, 164, 76, 22);
		contenu.add(lprenom);
		
		tprenom = new JTextField();
		tprenom.setBounds(300, 159, 208, 27);
		contenu.add(tprenom);
		tprenom.setColumns(10);
		
		JLabel lDateNaissance = new JLabel("DateNaissance:");
		lDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDateNaissance.setBounds(151, 211, 106, 22);
		contenu.add(lDateNaissance);
		  
		 tdateNaissance = new JTextField();
		tdateNaissance.setBounds(300, 211, 208, 27);
	    contenu.add(tdateNaissance);
		tdateNaissance.setColumns(10);
		
		JLabel lnumTel = new JLabel("numTel :");
		lnumTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnumTel.setBounds(151, 263, 63, 14);
		contenu.add(lnumTel);
		
		tNumTel = new JTextField();
		tNumTel.setBounds(300, 259, 208, 27);
		contenu.add(tNumTel);
		tNumTel.setColumns(10);
		
		JLabel lAdresse = new JLabel("Adresse :");
		lAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lAdresse.setBounds(151, 319, 63, 14);
		contenu.add(lAdresse);
		
		tAdresse = new JTextField();
		tAdresse.setBounds(300, 315, 208, 27);
		contenu.add(tAdresse);
		tAdresse.setColumns(10);
		
		JLabel lSexe = new JLabel("sexe :");
		lSexe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lSexe.setBounds(151, 374, 46, 14);
		contenu.add(lSexe);
		
		
		
		 g1 = new JRadioButton("Femme");
		g1.setBounds(300, 374, 76, 23);
		contenu.add(g1);
		
		 g2 = new JRadioButton("Homme");
		g2.setBounds(430, 374, 76, 23);
		contenu.add(g2);
		
		groupsx=new ButtonGroup();
		
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
		
			
		tcodeBarre = new JComboBox<>();
		
		tcodeBarre.setBounds(300, 420, 208, 27);
		contenu.add(tcodeBarre);
		 MedicamentDAO mdc=new MedicamentDAO();
		    ArrayList<Medicament>lstmed=mdc.listesMedicaments();
		    
		  
		   for(Medicament m:lstmed) {
			      int code= m.getCodeBarre();
			      tcodeBarre.addItem(code);
		   }
		
		   tsomme = new JTextField();
			tsomme.setBounds(300, 470, 208, 27);
			contenu.add(tsomme);
			tsomme.setColumns(10);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBounds(245, 520, 89, 23);
		contenu.add(ajouter);
		JButton quitter =new JButton("Quitter");
	    quitter.setBounds(463, 520, 89, 23);
	    quitter.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent evn) {
	    		 Object source =evn.getSource();
	    		 if(source.equals(quitter)) {
	    			 System.exit(0);
	    		 }
	    		 
	    	 }
	    });
		contenu.add(quitter);
		
		ajouter.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				String sexe="";
	            if(g1.isSelected()) {
					sexe="femme";
				}else {
					sexe="homme";
				}
				ClientDAO tst=new ClientDAO();
				int somme=Integer.parseInt(tsomme.getText());
				Client clt=new Client(1,tnom.getText(),tprenom.getText(),tdateNaissance.getText(),tNumTel.getText(),
						tAdresse.getText(),sexe,tcodeBarre.getSelectedItem().toString(),somme);
				

				if(source.equals(ajouter)) {
					if(tnom.getText().isEmpty() || tprenom.getText().isEmpty() || tdateNaissance.getText().isEmpty()
							|| tNumTel.getText().isEmpty() || tAdresse.getText().isEmpty() || (g1.isSelected()==false && g2.isSelected()==false)) {
					     JOptionPane.showMessageDialog(null, " veuillez remplir tous les champs","Avertissement",2);}
					
					else {
					
					if (tst.inserer(clt)>0) {
				    	 JOptionPane.showMessageDialog(null, " Ok Client inserer","message ok",1);
				    	 
				     }else  {
				    	 JOptionPane.showMessageDialog(null, " !!!! Client non inserer","erreur",4);
				    	 
				     }
				
					}
					}
			}}

		);
		
	
		
		JButton vider =new JButton("vider");
		vider.setBounds(354, 520, 89, 23);
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
		return contenu;}
		
		public void vider() {
			tnom.setText("");
			tprenom.setText("");
			tdateNaissance.setText("");
			g1.setSelected(false);
			g2.setSelected(false);
			tNumTel.setText("");
			tAdresse.setText("");
			tsomme.setText("");}
			
			
			}
			
			
		
		
		
		
		
		
		

        
	
        
        
        
		
		
	


