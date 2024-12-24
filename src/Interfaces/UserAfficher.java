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


import DAO.UserDAO;

import metier.User;



public class UserAfficher {

JTextField tidUser;
	
	JButton chercher;

	
	public JPanel getContenu() {
	JPanel contenu=new JPanel();
	contenu.setForeground(new Color(0, 0, 0));
	contenu.setBackground( Color.LIGHT_GRAY);
	contenu.setLayout(null);
	
	JLabel ChercherUser= new JLabel("Afficher Utilisateur");
	ChercherUser.setForeground(Color.black);
	ChercherUser.setBackground(Color.CYAN);
	ChercherUser.setOpaque(true);
	ChercherUser.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
	ChercherUser.setFont(new Font("Tahoma", Font.BOLD, 36));
	ChercherUser.setHorizontalTextPosition(SwingConstants.CENTER);
	ChercherUser.setPreferredSize(new Dimension(200, 100));
	ChercherUser.setLocation(new Point(200, 50));
	ChercherUser.setHorizontalAlignment(SwingConstants.CENTER);
	ChercherUser.setIgnoreRepaint(true);
	ChercherUser.setBounds(85, 20, 580, 45);
	contenu.add(ChercherUser);
	////////////////////////////////////////////////////////////////////////////////////////////////
	 String columns[] = { "idUser", "nom", "prenom","Login","PassWord","Type","numTel","adresse"};
     String data[][] = new String[7][8];
   
     //charger la lsite de tous  user
     
     
     UserDAO usr=new UserDAO();
     
     ArrayList  <User>  lstuser=usr.listesUsers();
    int i = 0;
     for (User u :  lstuser ) {
       int id= u.getIdUser();
       String nom = u.getNom();
       String prenom = u.getPrenom();
       String log = u.getLogin();
       String pass = u.getPassword();
       String type = u.getType();
       String tel=u.getNumTel();
       String adresse=u.getAdresse();

       
       data[i][0] = id + "";
       data[i][1] = nom;
       data[i][2] = prenom;
       data[i][3] = log;
       data[i][4] = pass;
       data[i][5] = type;
       data[i][6] = tel;
       data[i][7] = adresse;
       
       
       i++;
     }
    
     
     DefaultTableModel model = new DefaultTableModel(data, columns);
	 JTable table = new JTable(model);
     table.setShowGrid(true);
     table.setShowVerticalLines(true);
     JScrollPane pane_table = new JScrollPane(table);
     pane_table.setBounds(0, 70, 750, 400);
     
     contenu.add(pane_table);
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	JLabel LidUser = new JLabel("idUser :");
	LidUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
	LidUser.setBounds(151, 480, 60, 24);
	contenu.add(LidUser);
	
	tidUser= new JTextField();
	tidUser.setBounds(260, 480, 208, 27);
	contenu.add(tidUser);
	tidUser.setColumns(10);
	contenu.add(tidUser);
	 chercher=new JButton("chercher");
	 chercher.setBounds(550, 480, 100, 30);
	 contenu.add(chercher);
	chercher.addActionListener(new ActionListener() {
		public  void actionPerformed(ActionEvent evn) {
			// TODO Auto-generated method stub
	Object source=evn.getSource();
			
			if(source.equals(chercher)) {
				
				UserDAO tst=new UserDAO();
				int idUser=Integer.parseInt(tidUser.getText());

				User use=tst.chercher(idUser);
				if(use.getIdUser()>0 ) {
					
					
					//JOptionPane.showMessageDialog(null, " Ok Utilisateur existe"+tst.chercher(idUser).getIdUser(),"message ok",2);
				
					int nbrlign=model.getRowCount();
					for (int i=0;i<nbrlign-1;i++)
					     model.removeRow(0);
					
					
					
					
					    model.setValueAt(use.getIdUser(), 0, 0);
						model.setValueAt(use.getNom(), 0, 1);
						model.setValueAt(use.getPrenom(), 0, 2);
						model.setValueAt(use.getLogin(), 0, 3);
						model.setValueAt(use.getPassword(), 0, 4);
						model.setValueAt(use.getType(), 0, 5);
						model.setValueAt(use.getNumTel(), 0, 6);
						model.setValueAt(use.getAdresse(), 0, 7);
						


				   
				     
			     }else {
			    	 JOptionPane.showMessageDialog(null, " !!!! Utilisateur n'existe pas","erreur",2);
				
				}
			
		}} 
		
	});
	 
	
	 
	
	ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
	JLabel lblNewLabel = new JLabel(background);
	lblNewLabel.setBounds(0, 0, 750, 630);
	contenu.add(lblNewLabel);
	  
	 

     
	  
	 return contenu;}
		
	 
	 






	
	
	}
