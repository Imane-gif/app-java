package metier;



public class Commande {
	 private int idCommande;
	 private int idFournisseur;
	 private int codeBarre;
	    private int quantite;
	    private String prix;
	    private String dateCommande;
		public Commande(int idCommande, int idFournisseur,int codeBarre, int quantite, String prix, String dateCommande) {
			super();
			this.idCommande = idCommande;
			this.idFournisseur = idFournisseur;
			this.codeBarre=codeBarre;
			this.quantite = quantite;
			this.prix = prix;
			this.dateCommande = dateCommande;
		}
		public int getIdCommande() {
			return idCommande;
		}
		public void setIdCommande(int idCommande) {
			this.idCommande = idCommande;
		}
		public int getIdFournisseur() {
			return idFournisseur;
		}
		public void setIdFournisseur(int idFournisseur) {
			this.idFournisseur = idFournisseur;
		}
		public int getCodeBarre() {
			return codeBarre;
		}
		public void setCodeBarre(int codeBarre) {
			this.codeBarre = codeBarre;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		public String getPrix() {
			return prix;
		}
		public void setPrix(String prix) {
			this.prix = prix;
		}
		public String getDateCommande() {
			return dateCommande;
		}
		public void setDateCommande(String dateCommande) {
			this.dateCommande = dateCommande;
		}
		
	    
}