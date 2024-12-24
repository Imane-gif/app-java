package metier;

public class Medicament {
	   private int codeBarre;
	    private String nom;
	    private String type;
	    private String datePeremption;
	    private String prix;
	    private int quantite;
	    
	    public Medicament(int codeBarre,String nom,String type,String datePeremption,String prix,int quantite){
	        this.codeBarre=codeBarre;
	        this.nom=nom;
	        this.type=type;
	        this.datePeremption=datePeremption;
	        this.prix=prix;
	        this.quantite=quantite;
	    }
	   
		public Medicament() {
			
			
			
		}

		//getters and setters
	    public int getCodeBarre() {
	        return codeBarre;
	    }
	    public String getNom() {
	        return nom;
	    }
	    public String getType() {
	        return type;
	    }
	    public String getDatePeremption() {
	        return datePeremption;
	    }
	    public String getPrix() {
	        return prix;
	    }
	    public int getQuantite() {
	        return quantite;
	    }
	    public void setCodeBare(int codeBarre) {
	        this.codeBarre = codeBarre;
	    }
	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    public void setType(String type) {
	        this.type = type;
	    }
	    public void setDatePeremption(String datePeremption) {
	        this.datePeremption = datePeremption;
	    }
	    public void setPrix(String prix) {
	        this.prix = prix;
	    }
	    public void setQuantite(int quantite) {
	        this.quantite = quantite;
	    }

	    

}
