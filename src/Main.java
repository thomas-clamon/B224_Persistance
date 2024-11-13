import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.IPizzaService;
import interfaces.PizzaService;
import model.Pizza;
import model.PizzaDao;
import model.TaillePizza;

public class Main {
		private static PizzaDao dao = new PizzaDao();

	public static void main(String[] args) {
		Pizza p = new Pizza("Royal", 20F, TaillePizza.GRANDE.name());
		
		IPizzaService service = new PizzaService();
		
		int result = service.ajouterPizza(p);
		
		if (result == 0) {
			System.out.println("Pizza ajouté");
		}
		else
			System.out.println("une erreur");
		
	}
	
	}
