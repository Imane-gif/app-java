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

import DAO.ClientDAO;
import DAO.MedicamentDAO;
import metier.Client;
import metier.Medicament;


public class MedicamentAfficher {
JTextField tcodeBarre;
	
	JButton chercher;
	
	
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(SystemColor.control);
		contenu.setLayout(null);
		contenu.setBounds(80, 100, 696, 592);
		
		JLabel ChercherMedicament= new JLabel("Afficher Medicament");
		ChercherMedicament.setForeground(Color.black);
		ChercherMedicament.setBackground(Color.CYAN);
		ChercherMedicament.setOpaque(true);
		ChercherMedicament.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		ChercherMedicament.setFont(new Font("Tahoma", Font.BOLD, 36));
		ChercherMedicament.setHorizontalTextPosition(SwingConstants.CENTER);
		ChercherMedicament.setPreferredSize(new Dimension(200, 100));
		ChercherMedicament.setLocation(new Point(200, 200));
		ChercherMedicament.setHorizontalAlignment(SwingConstants.CENTER);
		ChercherMedicament.setIgnoreRepaint(true);
		ChercherMedicament.setBounds(110, 10, 525, 46);
		contenu.add(ChercherMedicament);
		/////////////////////////////////
		 String columns[] = { "codeBarre", "nom", "type","datePeremprtion","prix","quantite"};
		    String data[][] = new String[15][7];
		    MedicamentDAO mdc=new MedicamentDAO();
		    ArrayList<Medicament>lstmed=mdc.listesMedicaments();
		    
		    int i = 0;
		   for(Medicament m:lstmed) {
			   
			      int code= m.getCodeBarre();
			      String nom = m.getNom();
			      String type = m.getType();
			      String date = m.getDatePeremption();
			      String prix = m.getPrix();
			      int quantite = m.getQuantite();
			
		    
		      
		      data[i][0] = code +"";
		      data[i][1] = nom;
		      data[i][2] = type;
		      data[i][3] = date;
		      data[i][4] = prix;
		      data[i][5] = quantite +"";
		      
		      i++;}
		     
		     DefaultTableModel model = new DefaultTableModel(data, columns);
			 JTable table = new JTable(model);
		     table.setShowGrid(true);
		     table.setShowVerticalLines(true);
		     JScrollPane pane_table = new JScrollPane(table);
		     pane_table.setBounds(0, 70, 750, 400);
		     
		     contenu.add(pane_table);
		/////////////////////////////////
		
		JLabel lcodeBarre = new JLabel("codeBarre:");
		lcodeBarre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lcodeBarre.setBounds(151, 470, 80, 24);
		contenu.add(lcodeBarre);
		
		tcodeBarre= new JTextField();
		tcodeBarre.setBounds(290, 470, 208, 27);
		contenu.add(tcodeBarre);
		tcodeBarre.setColumns(10);
		contenu.add(tcodeBarre);
		 chercher=new JButton("chercher");
		 chercher.setBounds(550, 470, 100, 30);
	
		 contenu.add(chercher);
		 
		chercher.addActionListener(new ActionListener() {

			public  void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
		Object source=evn.getSource();
				
				if(source.equals(chercher)) {
					
					MedicamentDAO tst=new MedicamentDAO();
				
					int codeBarre=Integer.parseInt(tcodeBarre.getText());
					
					Medicament mdc=tst.chercher(codeBarre);
					if(mdc.getCodeBarre()>0) {
					
						 

						 int nbrlign=model.getRowCount();
							for (int i=0;i<nbrlign-1;i++)
							     model.removeRow(0);
							
							
							
							
							    model.setValueAt(mdc.getCodeBarre(), 0, 0);
								model.setValueAt(mdc.getNom(), 0, 1);
								model.setValueAt(mdc.getType(), 0, 2);
								model.setValueAt(mdc.getDatePeremption(), 0, 3);
								model.setValueAt(mdc.getPrix(), 0, 4);
								model.setValueAt(mdc.getQuantite(), 0, 5);

							
									
									
						 
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Medicament n'existe pas","erreur",2);
					
					}
					
			}}

		
			
		});
		
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
     return contenu;
	}}

