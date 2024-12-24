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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


import DAO.CommandeDAO;
import DAO.FournisseurDAO;
import DAO.MedicamentDAO;
import metier.Commande;
import metier.Fournisseur;
import metier.Medicament;

public class CommandeModifier {
	JTextField  tprix,tdateCommande;
    JSpinner tquantite;
	JComboBox<Integer> tidcmd, tidfour,tcodeBarre;

	
		
		JButton valider;
		
		public JPanel getContenu() {
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setBounds(80, 100, 696, 592);
		contenu.setLayout(null);
		
		
		
		
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(Color.LIGHT_GRAY);
		contenu.setLayout(null);
		contenu.setBounds(80, 100, 696, 592);
		
		JLabel ModifierCommande= new JLabel("Modifier/Supprimer Commande");
		ModifierCommande.setForeground(Color.black);
		ModifierCommande.setBackground(Color.CYAN);
		ModifierCommande.setOpaque(true);
		ModifierCommande.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
	
		ModifierCommande.setFont(new Font("Tahoma", Font.BOLD, 36));
		ModifierCommande.setHorizontalTextPosition(SwingConstants.CENTER);
		ModifierCommande.setPreferredSize(new Dimension(200, 100));
		ModifierCommande.setLocation(new Point(200, 200));
		ModifierCommande.setHorizontalAlignment(SwingConstants.CENTER);
		ModifierCommande.setIgnoreRepaint(true);
		ModifierCommande.setBounds(70, 24,600, 46);
		contenu.add(ModifierCommande);

		
		
		JLabel Lidcmd = new JLabel("idCommande :");
		 Lidcmd .setFont(new Font("Tahoma", Font.PLAIN, 14));
		 Lidcmd .setBounds(130, 105, 90, 24);
		contenu.add( Lidcmd );
		
		tidcmd = new JComboBox<>();
		
		 CommandeDAO cmd=new CommandeDAO();
		    ArrayList<Commande>lstcmd=cmd.listesCommandes();
		    
		    
		   for(Commande c:lstcmd) {
			      int idcmd= c.getIdCommande();
			      tidcmd.addItem(idcmd);}
		   tidcmd .setBounds(270, 102, 208, 27);
			contenu.add(tidcmd );
			
		
		JLabel lidFour = new JLabel("idFournisseur :");
		lidFour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lidFour.setBounds(130, 164, 120, 22);
		contenu.add(lidFour);
		
		tidfour = new JComboBox<>();
		tidfour.setBounds(270, 164, 208, 27);
		 FournisseurDAO four=new FournisseurDAO();
		    ArrayList<Fournisseur>lstfour=four.listesFournisseurs();
		    
		    
		   for(Fournisseur f:lstfour) {
			      int idfour= f.getIdFournisseur();
			      tidfour.addItem(idfour);}
		   
			contenu.add(tidfour );
		////////////////////////////////////////////////////
		JLabel lcodeBarre = new JLabel("codeBarre:");
		lcodeBarre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lcodeBarre.setBounds(130, 211, 76, 22);
		contenu.add(lcodeBarre);
		
		 tcodeBarre = new JComboBox<>();
		 tcodeBarre.setBounds(270, 211, 208, 27);
		
		MedicamentDAO medic=new MedicamentDAO();
	    ArrayList<Medicament>lstmedic=medic.listesMedicaments();
	    
	    
	   for(Medicament m:lstmedic) {
		      int codeBarre= m.getCodeBarre();
		      tcodeBarre.addItem(codeBarre);}
	     
	   contenu.add(tcodeBarre);
	////////////////////////////////////////////////////
		
		JLabel lquantite = new JLabel("Quantite :");
		lquantite .setFont(new Font("Tahoma", Font.PLAIN, 14));
		lquantite .setBounds(130, 263, 110, 14);
		contenu.add(lquantite);
		SpinnerModel model=new SpinnerNumberModel(3,0,1000,1);
		tquantite = new JSpinner(model);
		tquantite  .setBounds(270, 259, 208, 27);
		contenu.add(tquantite );
		
		
		JLabel lprix = new JLabel("Prix :");
		lprix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprix.setBounds(130, 319, 63, 14);
		contenu.add(lprix);
		
		tprix = new JTextField();
		tprix.setBounds(270, 315, 208, 27);
		contenu.add(tprix);
		tprix.setColumns(10);
		
		JLabel ldateCommande = new JLabel("dateCommande :");
		ldateCommande .setFont(new Font("Tahoma", Font.PLAIN, 14));
		ldateCommande .setBounds(130, 374, 120, 40);
		contenu.add(ldateCommande );
		
		 tdateCommande =new JTextField();
		tdateCommande .setBounds(270, 374, 208, 27);
		contenu.add(tdateCommande );
		
	
		
		JButton Modifier = new JButton("Modifier");
		Modifier.setBounds(250, 460, 95, 23);
		contenu.add(Modifier);
		JButton chercher=new JButton("Chercher");
		chercher.setBounds(520,105, 95, 23);
		contenu.add(chercher);
		JButton supprimer=new JButton("Supprimer");
		supprimer.setBounds(400,460, 95, 23);
		contenu.add(supprimer);
		Modifier.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				
				if(source.equals(Modifier)) {
					
					CommandeDAO tst=new CommandeDAO();
					int qte=(int)tquantite.getValue();
				
					int codeBarre = Integer.parseInt(tcodeBarre.getSelectedItem().toString());
					int idcmd=Integer.parseInt(tidcmd.getSelectedItem().toString());
					int idfour=Integer.parseInt(tidcmd.getSelectedItem().toString());
					Commande cmd=new Commande(idcmd,idfour,codeBarre,qte,tprix.getText(),tdateCommande.getText());
					

				     if (tst.modifier(cmd)) {
				    	 JOptionPane.showMessageDialog(null, " Ok commande modifie","message ok",2);
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! commande non modifie","erreur",2);
				    	 
				     }
				
				
				}}

				});
		
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
		   Object source=evn.getSource();
				
				if(source.equals(supprimer)) {
					
					CommandeDAO tst=new CommandeDAO();	
					int idCommande=Integer.parseInt(tidcmd.getSelectedItem().toString());
		
					int rep=-2;
					rep= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le commande N°:"+idCommande, "Confirmer", 1, 3);
					
					// JOptionPane.showMessageDialog(null, " choix"+rep,"message ok",2);
					
					 if(rep==0) {
			        
			         
					if (tst.supprimer(idCommande)==true) {
				    	 JOptionPane.showMessageDialog(null, " Ok commande supprimé","message ok",2);
				    
						    	 
						    	 tidcmd.setSelectedItem("");
						    	 tidfour.setSelectedItem("");
									tcodeBarre.setSelectedItem("");
									tquantite.setValue(0);
									tprix.setText("");
									tdateCommande.setText("");
									
					 }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! commande non supprimé","erreur",2);
					 }
				     }
					
				}
			}
		});
		 chercher.addActionListener(new ActionListener() {

				public  void actionPerformed(ActionEvent evn) {
					// TODO Auto-generated method stub
			Object source=evn.getSource();
					
					if(source.equals(chercher)) {
						CommandeDAO tst=new CommandeDAO();
			       		int idCommande=Integer.parseInt(tidcmd.getSelectedItem().toString());
						//String codeBarre=tcodeBarre.getSelectedItem().toString();
						
						Commande cmd=tst.chercher(idCommande);
						if(cmd.getIdCommande()>0 ) {
							
							
						//	JOptionPane.showMessageDialog(null, " Ok  medicament existe"+tst.chercher(codeBarre).getCodeBarre,"message ok",2);
							 tidfour.setSelectedItem(cmd.getIdFournisseur());
							 tcodeBarre.setSelectedItem(cmd.getCodeBarre());
							 tquantite.setValue(cmd.getQuantite());
							// tquantite.setValue(cmd.getQuantite());
							 tprix.setText(cmd.getPrix());
							 tdateCommande.setText(cmd.getDateCommande());
							 

						
						
						
				
						  }else {
					    	 //JOptionPane.showMessageDialog(null, " !!!! medicament n'existe","erreur",2);
						
							}
						
							}} 
							
						});
			ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
			JLabel lblNewLabel = new JLabel(background);
			lblNewLabel.setBounds(0, 0, 750, 630);
			contenu.add(lblNewLabel);  

		return contenu;

     
	}}


