
package metier;
public class Client {

    private	int idClient  ;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String numTel;
    private String adresse;
    private String sexe;
    private String codeBarre;
    private int somme;
	
	///////////////
	public Client(int idClient, String nom, String prenom, String dateNaissance, String numTel, String adresse,String sexe,
			
		String codeBarre,int somme) {
		
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.adresse = adresse;
		this.sexe=sexe;
		this.codeBarre=codeBarre;
		this.somme=somme;
	}
	////////////////////
	public String getCodeBarre() {
		return codeBarre;
	}
	public void setCodeBarre(String codeBarre) {
		this.codeBarre = codeBarre;
	}
	public int getSomme() {
		return somme;
	}
	public void setSomme(int somme) {
		this.somme = somme;
	}
	public Client(int  idClient) {
		this.idClient=idClient;
	}
	public Client() {
		
	
	}
	public int getIdClient() {
		return idClient;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public String getNumTel() {
		return numTel;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getSexe() {
		return sexe;
	}
	/////////////
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setSexe(String sexe) {
		this.sexe=sexe;
	}

	}
	
	
	
	
	
	

