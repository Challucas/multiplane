package application;

public class Option {

	private String libelle;
	private Float prix;
	
	Option(String libelle, Float prix) {
		this.libelle = libelle;
		this.prix = prix;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	
}
