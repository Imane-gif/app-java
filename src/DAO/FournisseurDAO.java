package DAO;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import metier.Fournisseur;


public class FournisseurDAO {

///////////inserer//////////////////
	public int inserer(Fournisseur four) {
		 
		int drapo=0;
		String req="INSERT INTO  fournisseur(nom,prenom, numTel, adresse)  "
				+ "VALUES ('"+four.getNom()+"','"+four.getPrenom()+"','"+four.getNumTel()+"','"+four.getAdresse()+"')";
		
		
		MaConnexion conn=new MaConnexion();
		try {
			Statement stat=conn.connexion.createStatement();
			  drapo=  stat.executeUpdate(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return drapo;
		
	}
	///////////supprimer////////////
public boolean supprimer(int idFournisseur) {
		
		String sql="DELETE FROM fournisseur where idFournisseur = '"+idFournisseur+"'";
		MaConnexion conn=new MaConnexion();
	   try {
				Statement stat=conn.connexion.createStatement();
	    	    return stat.executeUpdate(sql)>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
///////////modifier/////////////
public boolean modifier(Fournisseur four) {
	

	String req="UPDATE fournisseur " +"SET nom ='" +four.getNom()+"',"+"prenom='"+four.getPrenom()+"',"+"numTel='"+four.getNumTel()+"',"+"adresse='"+four.getAdresse()+"'"
			+"WHERE idFournisseur="+four.getIdFournisseur();
			
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
//////////////////////////////////////////////
public ArrayList<Fournisseur> listesFournisseurs(){
	MaConnexion con = new MaConnexion();
	ArrayList<Fournisseur>listFour=new ArrayList<Fournisseur>();

		try {
		Statement stat =con. connexion.createStatement();
		String sql ="SELECT * FROM fournisseur";
		ResultSet rst=(ResultSet)stat.executeQuery(sql);
			while (rst.next()) {
				Fournisseur four = new Fournisseur(rst.getInt("idFournisseur"),rst.getString("nom"),rst.getString("prenom"),rst.getString("numTel"),rst.getString("adresse"));
		

			 listFour.add(four);}
			con.fermer();}
			 catch (SQLException e) {
			e.printStackTrace();
		}
		return listFour;

		
   } 
///////////////////chercher///////////////////
   public Fournisseur chercher(int idFournisseur) {
	MaConnexion conn=new MaConnexion();
	String nom="",prenom="",numTel="",adresse="";
    int idFournisseur1=0;
    Fournisseur four=null;

 try {
	
	String query="SELECT * FROM fournisseur WHERE idFournisseur="+idFournisseur;
	
	      Statement stm = conn.connexion.createStatement();
	      ResultSet res = stm.executeQuery(query);
	    
	      
	      
	      while (res.next()) {
	        idFournisseur1 = res.getInt("idFournisseur");
	        nom = res.getString("nom");
	         prenom = res.getString("prenom");
	         numTel = res.getString("numTel");
	         adresse = res.getString("adresse");
	        
	      }
	      four =new Fournisseur(idFournisseur1,nom,prenom,numTel,adresse);
	   
	} catch (SQLException e) {
	      e.printStackTrace();}
	    
        return four;
        }
}


