package interfaces;

import java.util.List;

import model.Pizza;

public interface IPizzaService {

	int ajouterPizza(Pizza p);
	List<Pizza> getPizza(int nbPizza);
	
}