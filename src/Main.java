import java.util.Scanner;

import interfaces.IPizzaService;
import interfaces.PizzaService;
import model.Pizza;
import model.TaillePizza;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IPizzaService service = new PizzaService();
		
		System.out.println("Bonjour bienvenue sur notre pizzeria");
		System.out.println("Que voulez vous faire");
		System.out.println("1: Ajouter une pizza");
		System.out.println("2: Voir les pizzas");
		
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
		}
		return new Pizza(nom, prix, taille);
	}
}
