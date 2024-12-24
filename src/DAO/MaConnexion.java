package DAO;

import java.sql.*;


import javax.swing.JOptionPane;

import java.io.*;


public class MaConnexion {

	   public Connection connexion;
	   public String msg="azrour";
/////////////////////////////////////////////////////////////////////////////  
	   public MaConnexion() {
		 
		   msg="";
	      
		   try {
	          		          	
	          	Class.forName("com.mysql.jdbc.Driver");
	          	connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/BDPharmacie","root","");
	
	      }      
	      catch (ClassNotFoundException ex) {
	    	  
	    	  msg =" Problème de chargement de pilote \n";
	    	  JOptionPane.showMessageDialog(null, " "+msg,"message",2);
	      }
	      catch (SQLException ex) {
	    	  
	    	 msg= "la base données est intouvable \n ou requête incorrecte";
	    	 JOptionPane.showMessageDialog(null, " "+msg,"message",2);
	      }
		   
	   }
		   
		   public void fermer() {
			   
			   try {
				connexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	   }
