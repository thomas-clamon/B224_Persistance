package model;

public class Pizza {
	
	private Integer ID;
	private String nom;
	private float prix;
	private String taille;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	/**
	 * @param iD
	 * @param nom
	 * @param prix
	 * @param taille
	 */
	public Pizza(String nom, float prix, String taille) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.taille = taille;
	}
	@Override
	public String toString() {
		return "Pizza [ID=" + ID + ", nom=" + nom + ", prix=" + prix + ", taille=" + taille + "]";
	}
	
	
	
	

}
