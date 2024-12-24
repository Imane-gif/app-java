package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import metier.Medicament;

public class MedicamentDAO {

////////////inserer///////////
	public int inserer(Medicament mdc) {
		 
		int drapo=0;
		String req="INSERT INTO  medicament(codeBarre, nom, type, datePeremption, prix,quantite)  "
				+ "VALUES ("+mdc.getCodeBarre()+",'"+mdc.getNom()+"','"+mdc.getType()+"','"+mdc.getDatePeremption()+"','"+mdc.getPrix()+"','"+mdc.getQuantite()+"')";
		
		
		MaConnexion conn=new MaConnexion();
		try {
			Statement stat=conn.connexion.createStatement();
			  drapo=  stat.executeUpdate(req);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return drapo;
		
	}
	//////////supprimer////////////////
public boolean supprimer(int codeBarre) {
		
		String sql="DELETE FROM medicament where codeBarre = "+codeBarre;
		MaConnexion conn=new MaConnexion();
	   try {
				Statement stat=conn.connexion.createStatement();
	    	    return stat.executeUpdate(sql)>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
////////////////////chercher////////////////////
       public Medicament chercher(int codeBarre) {
	MaConnexion conn=new MaConnexion();
    String  nom="",type="",datePeremption="",prix="";
    int quantite=0, codeBarre1=0;
    Medicament mdc=null;

     try {
	String query="SELECT * FROM medicament WHERE codeBarre ="+codeBarre;

	Statement stm = conn.connexion.createStatement();
	 ResultSet res = stm.executeQuery(query);
	 
	 while (res.next()) {
	      codeBarre1 = res.getInt("codeBarre");
	      nom = res.getString("nom");
	      type = res.getString("type");
	      datePeremption = res.getString("datePeremption");
	       prix = res.getString("prix");
	      quantite = res.getInt("quantite");}
   
      mdc=new Medicament(codeBarre1,nom,type,datePeremption,prix,quantite);
   
  
} catch (SQLException e) {
    e.printStackTrace();}
  
  return mdc;
  }

///////////modifier/////////////
public boolean modifier(Medicament mdc) {
	

	String req="UPDATE medicament "+"SET nom ='" +mdc.getNom()+"',"+"type='"+mdc.getType()+"',"+"datePeremption='"+mdc.getDatePeremption()+"',"
			+ "prix='"+mdc.getPrix()+"',"+ "quantite= '"+mdc.getQuantite()+"'"
			+ "WHERE codeBarre=" +mdc.getCodeBarre();
			
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
////////////////////////////////////////////////////
     public ArrayList<Medicament> listesMedicaments(){
    	 ArrayList <Medicament> listmdc=new ArrayList<Medicament>();
	 MaConnexion con = new MaConnexion();

	try {
		
	Statement stat =con. connexion.createStatement();
	String sql ="SELECT * FROM medicament";
	ResultSet rst=(ResultSet)stat.executeQuery(sql);
		while (rst.next()) {
		
			Medicament mdc = new Medicament(rst.getInt("codeBarre"),rst.getString("nom"),rst.getString("type"),rst.getString("datePeremption"),
		rst.getString("prix"),rst.getInt("quantite"));
	

		 listmdc.add(mdc);}
		con.fermer();}
		 catch (SQLException e) {
		e.printStackTrace();
	}
	return listmdc;


}
   /*  public void updateQuantite() {
    	 MaConnexion con = new MaConnexion();
    	 Medicament m =new Medicament();
    	 try {
    		 Statement stat =con. connexion.createStatement();
    		 int newQtt=30;
    		// newQtt=m.getQuantite()-1;
    		 String sql="UPDATE 'Medicament' SET 'quantite'="+ newQtt+" WHERE 'codeBarre'='"+m.getCodeBarre()+"'";
    	 ResultSet rst =stat.executeQuery(sql);
    	 stat.close();
    	 rst.close();
    	 con.connexion.close();
    	 }catch(SQLException ex) {
    		 ex.printStackTrace();
    	 }
     }**/
     



}
