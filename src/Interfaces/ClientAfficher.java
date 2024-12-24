package Interfaces;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
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

import metier.Client;



public class ClientAfficher  {
	
JTextField tidClient;
	
	JButton chercher;
	
	
	public JPanel getContenu() {
	JPanel contenu=new JPanel();
	
	contenu.setForeground(new Color(0, 0, 0));
	//contenu.setBackground(SystemColor.control);
	contenu.setLayout(null);
	contenu.setBounds(80, 100, 696, 592);
	
	
	ImageIcon background=new ImageIcon(".\\figures\\arp1.jpg");
	JLabel lblNewLabel = new JLabel(background);
	lblNewLabel.setBounds(0, 0, 750, 630);
	//contenu.setb
	
	
	
	JLabel ChercherClient= new JLabel("Afficher Client");
	ChercherClient.setFont(new Font("Tahoma", Font.BOLD, 36));
	ChercherClient.setHorizontalTextPosition(SwingConstants.CENTER);
	ChercherClient.setPreferredSize(new Dimension(200, 100));
	ChercherClient.setLocation(new Point(200, 200));
	ChercherClient.setHorizontalAlignment(SwingConstants.CENTER);
	ChercherClient.setIgnoreRepaint(true);
	ChercherClient.setBounds(100, 10, 525, 46);
	ChercherClient.setForeground(Color.black);
	ChercherClient.setBackground(Color.CYAN);
	ChercherClient.setOpaque(true);
	ChercherClient.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
	
	contenu.add(ChercherClient);
	///////////////////////
	String columns[] = { "idClient", "nom", "prenom","dateNaissance","numTel","adresse","sexe","codeBarre","somme"};
    String data[][] = new String[8][11];
  
    //charger la lsite de tous  client
    
    
    ClientDAO cli=new ClientDAO();
    
    ArrayList  <Client>  listCli=cli.listesClients();
   int i = 0;
    
	for (Client C:  listCli ) {
      int id= C.getIdClient();
      String nom = C.getNom();
      String prenom = C.getPrenom();
      String date = C.getDateNaissance();
      String num = C.getNumTel();
      String adresse = C.getAdresse();
      String sexe =C.getSexe();
      String codeBarre=C.getCodeBarre();
      int somme=C.getSomme();

      
      data[i][0] = id +"";
      data[i][1] = nom;
      data[i][2] = prenom;
      data[i][3] = date;
      data[i][4] = num;
      data[i][5] = adresse;
      data[i][6] = sexe;
      data[i][7] = codeBarre;
      data[i][8] = somme+"";
      
      
      i++;
    }
   
    
    DefaultTableModel model = new DefaultTableModel(data, columns);
	 JTable table = new JTable(model);
    table.setShowGrid(true);
    table.setShowVerticalLines(true);
    JScrollPane pane_table = new JScrollPane(table);
    pane_table.setBounds(0, 60, 750, 400);
    
    contenu.add(pane_table);
	
	

	
	///////////////////////
	
	JLabel LidClient = new JLabel("idClient :");
	LidClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
	LidClient.setBounds(151, 470, 60, 24);
	contenu.add(LidClient);
	
	tidClient= new JTextField();
	tidClient.setBounds(270,470, 208, 27);
	contenu.add(tidClient);
	tidClient.setColumns(10);
	contenu.add(tidClient);
	 chercher=new JButton("chercher");
	 chercher.setBounds(550, 470, 100, 30);
	 contenu.add(chercher);
	 


  chercher.addActionListener(new ActionListener() {

	public  void actionPerformed(ActionEvent evn) {
		// TODO Auto-generated method stub
Object source=evn.getSource();
		
		if(source.equals(chercher)) {
			ClientDAO tst=new ClientDAO();
			int idClient=Integer.parseInt(tidClient.getText());
			Client clt=tst.chercher(idClient);
			if(clt.getIdClient()>0 ) {
				
				
				//JOptionPane.showMessageDialog(null, " Ok Client existe"+tst.chercher(idClient).getIdClient(),"message ok",2);
				//JOptionPane.showMessageDialog(null, " nbr lign"+model.getRowCount(),"message ok",2);
				
				int nbrlign=model.getRowCount();
				for (int i=0;i<nbrlign-1;i++)
				     model.removeRow(0);
				
				
				
				    model.setValueAt(clt.getIdClient(), 0, 0);
					model.setValueAt(clt.getNom(), 0, 1);
					model.setValueAt(clt.getPrenom(), 0, 2);
					model.setValueAt(clt.getDateNaissance(), 0, 3);
					model.setValueAt(clt.getNumTel(), 0, 4);
					model.setValueAt(clt.getAdresse(), 0, 5);
					model.setValueAt(clt.getSexe(),0,6);


			
			
			
	
			  }else {
		    	 JOptionPane.showMessageDialog(null, " !!!! Client n'existe","erreur",2);
			
				}
			
				}} 
				
			});
	ImageIcon background1=new ImageIcon(".\\figures\\bac.jpg");
	JLabel lblNewLabel1 = new JLabel(background1);
	lblNewLabel1.setBounds(0, 0, 750, 630);
	contenu.add(lblNewLabel1);

	 return contenu;
  }}
			 
			
