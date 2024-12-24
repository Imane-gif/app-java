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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.CommandeDAO;


import metier.Commande;


public class CommandeAfficher  {
 
	public JPanel getContenu() {
		JTextField tidCommande;
		JButton chercher;
		
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setLayout(null);
		contenu.setBounds(80, 100, 696, 592);
		
		JLabel ChercherCommande= new JLabel("Afficher Commande");
		ChercherCommande.setForeground(Color.black);
		ChercherCommande.setBackground(Color.CYAN);
		ChercherCommande.setOpaque(true);
		ChercherCommande.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		ChercherCommande.setFont(new Font("Tahoma", Font.BOLD,36));
		ChercherCommande.setHorizontalTextPosition(SwingConstants.CENTER);
		ChercherCommande.setPreferredSize(new Dimension(200, 100));
		ChercherCommande.setLocation(new Point(200, 200));
		ChercherCommande.setHorizontalAlignment(SwingConstants.CENTER);
		ChercherCommande.setIgnoreRepaint(true);
		ChercherCommande.setBounds(110, 10, 525, 46);
		contenu.add(ChercherCommande);
		/////////////////////////////////
		 String columns[] = { "idCommande", "idFournisseur", "codeBarre","quantite","prix","dateCommande"};
		    String data[][] = new String[6][7];
		    CommandeDAO cmd=new CommandeDAO();
		    ArrayList<Commande>lstcmd=cmd.listesCommandes();
		    
		    int i = 0;
		   for(Commande c:lstcmd) {
			      int idCmd=c.getIdCommande();
			      int idFour=c.getIdFournisseur();
			      int code= c.getCodeBarre();
			      int quantite  = c.getQuantite();
			      String prix = c.getPrix();
			      String date = c.getDateCommande();
			     
			
		    
		      
		      data[i][0] = idCmd+"";
		      data[i][1] = idFour+"";
		      data[i][2] = code+"";
		      data[i][3] = quantite+"";
		      data[i][4] = prix;
		      data[i][5] = date;
		      
		      i++;}
		     
		     DefaultTableModel model = new DefaultTableModel(data, columns);
			 JTable table = new JTable(model);
		     table.setShowGrid(true);
		     table.setShowVerticalLines(true);
		     JScrollPane pane_table = new JScrollPane(table);
		     pane_table.setBounds(0, 70, 750, 400);
		     
		     contenu.add(pane_table);
		/////////////////////////////////
		
		JLabel lidcommande = new JLabel("idCommande:");
		lidcommande.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lidcommande.setBounds(151, 470, 100, 24);
		contenu.add(lidcommande);
		
		 tidCommande = new JTextField();
		tidCommande.setBounds(290, 470, 208, 27);
		contenu.add(tidCommande);
		tidCommande.setColumns(10);
		contenu.add(tidCommande);
		 chercher=new JButton("chercher");
		 chercher.setBounds(550, 470, 100, 30);
	
		 contenu.add(chercher);
		 
		chercher.addActionListener(new ActionListener() {

			public  void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
		Object source=evn.getSource();
				
				if(source.equals(chercher)) {
					
					CommandeDAO tst=new CommandeDAO();
					int idCommande=Integer.parseInt(tidCommande.getText());
					Commande cmd=tst.chercher(idCommande);
					//Commande cmd=tst.chercher(tidCommande.getText());
					if(cmd.getIdCommande()>0) {
						// JOptionPane.showMessageDialog(null, " Ok commande existe","message ok",2);
						 

						 int nbrlign=model.getRowCount();
							for (int i=0;i<nbrlign-1;i++)
							     model.removeRow(0);
							
							
							
							
							    model.setValueAt(cmd.getIdCommande(), 0, 0);
								model.setValueAt(cmd.getIdFournisseur(), 0, 1);
								model.setValueAt(cmd.getCodeBarre(), 0, 2);
								model.setValueAt(cmd.getQuantite(), 0, 3);
								model.setValueAt(cmd.getPrix(), 0, 4);
								model.setValueAt(cmd.getDateCommande(), 0, 5);

							
									
						 
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Commande n'existe pas","erreur",2);
					
					}
					
			}}

		
			
		});
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
     return contenu;
	}}

