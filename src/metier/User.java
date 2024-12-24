package metier;

public class User {
	private int idUser;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String type;
	private String numTel;
	private String adresse;
	public User(int idUser, String nom, String prenom, String login, String password, String type, String numTel,
			String adresse) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.type = type;
		this.numTel = numTel;
		this.adresse = adresse;
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


	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
		
	}
	


