package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.Client;
import metier.Commande;
import metier.Medicament;


public class CommandeDAO {

//////////inserer/////////////
	public int inserer(Commande cmd) {
		 
		int drapo=0;
		String req="INSERT INTO  Commande(idFournisseur,codeBarre,quantite,prix, dateCommande)  "
				+ "VALUES ('"+cmd.getIdFournisseur()+"','"+cmd.getCodeBarre()+"','"+cmd.getQuantite()+"','"+cmd.getPrix()+"',"
						+ "'"+cmd.getDateCommande()+"')";
		
		
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
	//////////supprimer//////////
public boolean supprimer(int idCommande) {
		
		String sql="DELETE FROM commande where idCommande = '"+idCommande+"'";
		MaConnexion conn=new MaConnexion();
	   try {
			 Statement stat=conn.connexion.createStatement();
	    	    return stat.executeUpdate(sql)>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}

	
///////////modifier///////////////		

public boolean modifier(Commande cmd) {
	
	String req="UPDATE commande "
			+ "SET idFournisseur=" +cmd.getIdFournisseur()+","
			+ "codeBarre = "+cmd.getCodeBarre()+","
			+ "quantite ="+cmd.getQuantite()+","
			+ "prix='"+cmd.getPrix()+"',"
			+ "dateCommande= '"+cmd.getDateCommande()+"' "
			+ " WHERE idCommande = "+cmd.getIdCommande();
			
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
/////////chercher///////
public Commande chercher(int idCommande) {
		MaConnexion conn=new MaConnexion();
        
		String prix="",dateCommande="";
        int idCommande1=0 ,idFournisseur1=0,quantite=0,codeBarre=0;
        Commande cmd=null;

	try {
		
		String query="SELECT * FROM commande WHERE idCommande="+idCommande;
		
		      Statement stm = conn.connexion.createStatement();
		      ResultSet res = stm.executeQuery(query);
		    
		
		      
		      while (res.next()) {
		         idCommande1 = res.getInt("idCommande");
		         idFournisseur1= res.getInt("idFournisseur");
		         codeBarre = res.getInt("codeBarre");
		         quantite = res.getInt("quantite");
		         prix = res.getString("prix");
		         dateCommande = res.getString("dateCommande");
		       
		        
		        
		      }
		    
		    cmd=new Commande(idCommande1,idFournisseur1,codeBarre,quantite,prix,dateCommande);
		    conn.fermer(); 
		    
		} catch (SQLException e) {
		      e.printStackTrace();}
		    
	        return cmd;
	        }


public ArrayList<Commande> listesCommandes(){
	MaConnexion con = new MaConnexion();
	ArrayList <Commande> listcmd=new ArrayList<Commande>();
		try {
			
		Statement stat =con. connexion.createStatement();
		String sql ="SELECT * FROM commande";
		ResultSet rst=(ResultSet)stat.executeQuery(sql);
			while (rst.next()) {
			Commande cmd = new Commande(rst.getInt("idCommande"),rst.getInt("idFournisseur"),rst.getInt("codeBarre"),rst.getInt("quantite"),rst.getString("prix"),
					rst.getString("dateCommande"));
			
		

		   listcmd.add(cmd);}
        con.fermer();}
			 catch (SQLException e) {
			e.printStackTrace();
		}
		return listcmd;
	
	
					

				

}
}

		


