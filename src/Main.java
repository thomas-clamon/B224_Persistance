import java.time.LocalDate;
import java.util.Scanner;

import enumation.TypeClient;
import interfaces.ClientService;
import interfaces.IClientService;
import interfaces.IPizzaService;
import interfaces.PizzaService;
import model.ClientDto;
import model.Pizza;
import model.TaillePizza;

public class Main {

	static IPizzaService service = new PizzaService();
	static IClientService service_client = new ClientService();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bonjour bienvenue sur notre pizzeria");
		System.out.println("Que voulez vous faire");
		System.out.println("1: Ajouter une pizza");
		System.out.println("2: Voir les pizzas");
		System.out.println("3: Supprimer une pizza");
		System.out.println("4: Ajouter Client");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
			case 1 : // Ajouter Pizza
				Pizza p = GenererPizza(sc);
				int result = service.ajouterPizza(p);
				if (result == -1)
					System.out.println("un probleme est survenue");
				else
					System.out.println("Pizza ajouté");
				
			break;
			case 2 : // Lister Pizza
				System.out.println("combien de pizza voulez vous voir?");
				int nb = sc.nextInt();
				System.out.println(service.getPizza(nb));
			case 3 :
				System.out.println("veuillez indiquer l'ID");
				int id = sc.nextInt();
				int deleted = service.deleteByID(id);
				switch (deleted) {
				
					case 0 :
						System.out.println("pizza supprimé");
					break;
					case -2 :
						System.out.println("pizza n'existe pas");
					break;
					case -1 :
						System.out.println("erreur");
					
				}
			case 4 : // Ajouter Client
				ClientDto dto = GenererClient(sc);
				service_client.ajouterClient(dto);
				
		}
	}
	
	public  static Pizza  GenererPizza(Scanner sc) {
		System.out.println("quel est le nom de la pizza");
		String nom = sc.next();
		System.out.println("quel est le prix de la pizza");
		float prix = sc.nextFloat();
		System.out.println("quel est la taille de la pizza");
		int choice = sc.nextInt();
		String taille = null;
		switch (choice) {
		
			case 1 : 
				taille = TaillePizza.PETITE.name();
			break;
			case 2 :
				taille = TaillePizza.MOYENNE.name();
			break;
			case 3 :
				taille = TaillePizza.GRANDE.name();
			break;
		}
		return new Pizza(nom, prix, taille);
	}
	public static ClientDto GenererClient (Scanner sc) {
		
		System.out.println("Quel est le nom du clients");
		String nom = sc.next();
		System.out.println("Quel est le prenom du clients");
		String prenom = sc.next();
		System.out.println("Jour de naissance");
		int jour = sc.nextInt();
		System.out.println("Mois de naissance");
		int mois = sc.nextInt();
		System.out.println("Annee de naissance");
		int annee = sc.nextInt();
		LocalDate date = LocalDate.of(annee, mois, jour);
		
		System.out.println("quel est la type client");
		System.out.println("1 - NORMAL, 2 - ETUDIANT, 3 - PRENIUM");
		int choice = sc.nextInt();
		String type = null;
		switch (choice) {
		
			case 1 : 
				type = TypeClient.NORMAL.name();
			break;
			case 2 :
				type = TypeClient.ETUDIANT.name();
			break;
			case 3 :
				type = TypeClient.PRENIUM.name();
			break;
		}
		ClientDto dto = new ClientDto();
		dto.setNom(nom);
		dto.setPrenom(prenom);
		dto.setDate_naissance(date);
		dto.setType_client(TypeClient.valueOf(type) );
		return dto;
		
		
	}
}
