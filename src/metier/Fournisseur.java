package metier;

public class Fournisseur {
	int idFournisseur  ;
	String nom;
	String prenom;
	String numTel;
	String adresse;
	public Fournisseur(int idFournisseur, String nom,String prenom, String numTel, String adresse) {
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.prenom=prenom;
		this.numTel = numTel;
		this.adresse = adresse;
	}
	public Fournisseur() {
	
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
     
	

}