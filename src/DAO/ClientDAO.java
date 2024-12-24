package DAO;

import java.util.ArrayList;


import java.sql.*;

import metier.*;


public class ClientDAO {

	

	
	
////////////////insertion  client////////////////////////
	public int inserer(Client clt) {
		 
		int drapo=0;
		String req="INSERT INTO  client(nom, prenom, dateNaissance, numTel, adresse,sexe,codeBarre,somme)  "
				+ "VALUES ('"+clt.getNom()+"','"+clt.getPrenom()+"','"+clt.getDateNaissance()+"','"+clt.getNumTel()+"','"+clt.getAdresse()+"',"
						+ "'"+clt.getSexe()+"','"+clt.getCodeBarre()+"','"+clt.getSomme()+"')";
		
		
		
		MaConnexion conn=new MaConnexion();
		try {
			Statement stat=conn.connexion.createStatement();
			  drapo= stat.executeUpdate(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

		return drapo;
		
	}
	
///////////////////////supprimer/////////////////
	public boolean supprimer(int idClient) {
		
		String sql="DELETE FROM client where idClient = '"+idClient+"'";
		MaConnexion conn=new MaConnexion();
	   try {
				Statement stat= conn.connexion.createStatement();
	    	    return stat.executeUpdate(sql)>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
		
		
	
	////////////////modifier////////////////
	public boolean modifier(Client clt) {
		
			String req="UPDATE client "
					+ "SET nom='" +clt.getNom()+"',"
					+ "prenom ='"+clt.getPrenom()+"',"
					+ "dateNaissance ='"+clt.getDateNaissance()+"',"
					+ "numTel='"+clt.getNumTel()+"',"
					+ "adresse= '"+clt.getAdresse()+"',"
					+ "sexe='"+clt.getSexe()+"', "
				    + "	codeBarre='"+clt.getCodeBarre()+"',"
				    + "somme="+clt.getSomme()+ " WHERE idClient = "+clt.getIdClient();
					
			MaConnexion conn=new MaConnexion();
			try {
				Statement stat=conn.connexion.createStatement();
				boolean rep=  stat.executeUpdate(req)>0;
				conn.fermer();
				  return rep;

			} catch (SQLException e) {

				e.printStackTrace();
			}

			return false;

		}

////////////////chercher////////////////
	public Client chercher(int idClient) {
		MaConnexion conn=new MaConnexion();
        String nom="",prenom="",dateNaissance="",numTel="",adresse="",sexe="",codeBarre="";
        int idClient1=0,somme=0;
        Client clt=null;

	try {
		
		String query="SELECT * FROM client WHERE idClient="+idClient;
		
		      Statement stm = conn.connexion.createStatement();
		      ResultSet res = stm.executeQuery(query);
		    
		
		      
		      while (res.next()) {
		         idClient1 = res.getInt("idClient");
		         nom = res.getString("nom");
		         prenom = res.getString("prenom");
		         dateNaissance = res.getString("dateNaissance");
		         numTel = res.getString("numTel");
		         adresse = res.getString("adresse");
		         sexe = res.getString("sexe");
		         codeBarre=res.getString("codeBarre");
		         somme=res.getInt("somme");
		        
		        
		      }
		    
		    clt=new Client(idClient1,nom,prenom,dateNaissance,numTel,adresse,sexe,codeBarre,somme);
		    conn.fermer(); 
		    
		} catch (SQLException e) {
		      e.printStackTrace();}
		    
	        return clt;
	        }

		  
	
//////////////////////////
	public ArrayList<Client> listesClients(){
		MaConnexion con = new MaConnexion();
		ArrayList<Client>listClt=new ArrayList<Client>();

			try {
		
			Statement stat =con. connexion.createStatement();
			String sql ="SELECT * FROM client";
			ResultSet rst=(ResultSet)stat.executeQuery(sql);
				while (rst.next()) {
					Client clt = new Client(rst.getInt("idClient"),rst.getString("nom"),rst.getString("prenom"),rst.getString("dateNaissance"),
				rst.getString("numTel"),rst.getString("adresse"),rst.getString("sexe"),rst.getString("codeBarre"),rst.getInt("somme"));
			

				 listClt.add(clt);}
				con.fermer();}
				 catch (SQLException e) {
				e.printStackTrace();
			}
			return listClt;
	
	}}




