package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.User;
public class UserDAO {
	/////////inserer////////
	public int inserer(User use) {
		 
		int drapo=0;
		String req="INSERT INTO  user(nom, prenom,login, password,type, numTel, adresse)  "
				+ "VALUES ('"+use.getNom()+"','"+use.getPrenom()+"','"+use.getLogin()+"','"+use.getPassword()+"','"+use.getType()+"','"+use.getNumTel()+"', '"+use.getAdresse()+"')";
		
		
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
	
/////////////supprimer////////////
	public boolean supprimer(int idUser) {
		
		String sql="DELETE FROM user where idUser = "+idUser;
		MaConnexion conn=new MaConnexion();
	   try {
				Statement stat= conn.connexion.createStatement();
	    	    return stat.executeUpdate(sql)>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
		
		
	
	//////////modifier///////////
	public   boolean modifier(User use) {
		

			String req="UPDATE user"+" SET nom ='" +use.getNom()+"',"+"prenom ='"+use.getPrenom()+"',"+"login ='"+use.getLogin()+"',"
					+ "password='"+use.getPassword()+"',"+"type='"+use.getType()+"',"+"numTel='"+use.getNumTel()+"',"+"adresse='"+use.getAdresse()+"'" +"WHERE idUser=" +use.getIdUser();
		
		
			MaConnexion conn=new MaConnexion();
			try {
				Statement stat=conn. connexion.createStatement();
				
			
				boolean rep=  stat.executeUpdate(req)>0;
				conn.fermer();
				  return rep;

			
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return false;

		}

//////////////chercher////////////
	public User chercher(int idUser) {
		MaConnexion conn=new MaConnexion();
         String  nom="",  prenom="",  login="",  password="",  type="" , numTel="" ,adresse="";
         int idser=0;
         User use=null;
        try {
	      String query = "SELECT * FROM user WHERE idUser = "+idUser;
	      
	      Statement stm = conn.connexion.createStatement();
	      ResultSet res = stm.executeQuery(query);
	    
	      
	    
	      
	      while (res.next()) {
	         idser = res.getInt("idUser");
	         nom = res.getString("nom");
	         prenom = res.getString("prenom");
	         login = res.getString("login");
	         password = res.getString("password");
	         type = res.getString("type");
	         numTel=res.getString("numTel");
	         adresse=res.getString("adresse");
	        
	        
	        
	      }
	       use=new User( idser,  nom,  prenom,  login,  password,  type,numTel,adresse);
	      	
        } catch (SQLException e) {
	      e.printStackTrace();
	      }	      

	    
        return use;
        }

	  
	
//////////////////////////
	public ArrayList<User> listesUsers(){
		
		ArrayList<User> listesUs=new 	ArrayList<User>();
		MaConnexion con = new MaConnexion();

			try {
				//ArrayList <User> list=new ArrayList<User>();
			Statement stat =con. connexion.createStatement();
			String sql ="SELECT * FROM user";
			ResultSet rst=(ResultSet)stat.executeQuery(sql);
				while (rst.next()) {
					User use = new User(rst.getInt("idUser"),rst.getString("nom"),rst.getString("prenom"),rst.getString("login"),
				rst.getString("password"),rst.getString("type"),rst.getString("numTel"),rst.getString("adresse"));
			

					listesUs.add(use);
				 
				}
			con.fermer();	
			}
				 catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listesUs;
	}
	
}




