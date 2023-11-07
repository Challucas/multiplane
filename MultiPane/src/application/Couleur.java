package application;

public class Couleur extends Option{

	private String urlImg;
	
	
	Couleur(String libelle, Float prix, String urlImg) {
		super(libelle, prix);
		this.urlImg = urlImg;
	}


	public String getUrlImg() {
		return urlImg;
	}


	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

}
