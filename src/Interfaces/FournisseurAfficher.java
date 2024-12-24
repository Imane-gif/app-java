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
import DAO.FournisseurDAO;
import metier.Fournisseur;

public class FournisseurAfficher {
	
	public JPanel getContenu() {
    JPanel contenu=new JPanel();
    
 JTextField tidFournisseur;
	
	JButton Chercher;
	


	contenu.setForeground(new Color(0, 0, 0));
	contenu.setBackground(SystemColor.control);
	contenu.setLayout(null);
	 contenu.setBounds(80, 100, 696, 592);
	
	JLabel ChercherFournisseur= new JLabel("Afficher Fournisseur");
	ChercherFournisseur.setForeground(Color.black);
	ChercherFournisseur.setBackground(Color.CYAN);
	ChercherFournisseur.setOpaque(true);
	ChercherFournisseur.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
	
	ChercherFournisseur.setFont(new Font("Tahoma", Font.BOLD, 36));
	ChercherFournisseur.setHorizontalTextPosition(SwingConstants.CENTER);
	ChercherFournisseur.setPreferredSize(new Dimension(200, 100));
	ChercherFournisseur.setLocation(new Point(200, 200));
	ChercherFournisseur.setHorizontalAlignment(SwingConstants.CENTER);
	ChercherFournisseur.setIgnoreRepaint(true);
	ChercherFournisseur.setBounds(110, 10, 525, 46);
	contenu.add(ChercherFournisseur);
	/////////////////////////////////////
	String columns[] = { "idFournisseur", "nom", "prenom","numTel","adresse"};
    String data[][] = new String[8][7];
    
  FournisseurDAO fourn=new FournisseurDAO();
    
    ArrayList  <Fournisseur>  listFour=fourn.listesFournisseurs();
   int i = 0;
    
	for (Fournisseur F:  listFour ) {
      int id= F.getIdFournisseur();
      String nom = F.getNom();
      String prenom = F.getPrenom();
      String num = F.getNumTel();
      String adresse = F.getAdresse();
     
  
	  data[i][0] = id + "";
      data[i][1] = nom;
      data[i][2] = prenom;
      data[i][3] = num;
      data[i][4] = adresse;
 
      i++;
    }
  
    DefaultTableModel model = new DefaultTableModel(data, columns);
  

    JTable table = new JTable(model);
    table.setShowGrid(true);
    table.setShowVerticalLines(true);
    JScrollPane pane_table = new JScrollPane(table);
    pane_table.setBounds(0, 70, 750, 400);
    
    contenu.add(pane_table);

   
	//////////////////////////////////////////
	
	JLabel LidFournisseur = new JLabel("idFournisseur :");
	LidFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 12));
	LidFournisseur.setBounds(151, 490, 80, 24);
	contenu.add(LidFournisseur);
	
	tidFournisseur= new JTextField();
	tidFournisseur.setBounds(290, 490, 208, 27);
	contenu.add(tidFournisseur);
	tidFournisseur.setColumns(10);
	contenu.add(tidFournisseur);
	 Chercher=new JButton("chercher");
	 Chercher.setBounds(550, 490, 100, 30);
	 contenu.add(Chercher);
	
		Chercher.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent evn) {
				Object source=evn.getSource();
				if(source.equals(Chercher)) {
				FournisseurDAO tst=new FournisseurDAO();
				int idFournisseur=Integer.parseInt(tidFournisseur.getText());
				Fournisseur four=tst.chercher(idFournisseur);
				     if (four.getIdFournisseur()>0) {
				    	
				    	 
				    	 int nbrlign=model.getRowCount();
							for (int i=0;i<nbrlign-1;i++)
							     model.removeRow(0);
							
							
								
								
								    model.setValueAt(four.getIdFournisseur(), 0, 0);
									model.setValueAt(four.getNom(), 0, 1);
									model.setValueAt(four.getPrenom(), 0, 2);
									model.setValueAt(four.getAdresse(), 0, 3);
									model.setValueAt(four.getNumTel(), 0, 4);
									

				    	 
				    	 
				    	 
				    	 
				    	 
				    	 
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Fournisseur n'existe pas","erreur",2);
				    	 
				     }
				}
				
			}

		});
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
		return contenu;

        
	}}