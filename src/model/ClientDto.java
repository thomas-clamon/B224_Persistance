package model;

import java.time.LocalDate;

import enumation.TypeClient;

public class ClientDto {
	
	private int ID;
	private String nom;
	private String prenom; 
	private LocalDate date_naissance;
	private TypeClient type_client;
	
	public ClientDto()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public TypeClient getType_client() {
		return type_client;
	}

	public void setType_client(TypeClient type_client) {
		this.type_client = type_client;
	}

	@Override
	public String toString() {
		return "ClientDto [ID=" + ID + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance
				+ ", type_client=" + type_client + "]";
	}
	
	
}