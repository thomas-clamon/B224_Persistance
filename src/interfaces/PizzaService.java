package interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import model.Pizza;
import model.PizzaDao;

public class PizzaService implements IPizzaService {
	
	private PizzaDao dao = new PizzaDao();

	@Override
	public int ajouterPizza(Pizza p) {
		String sql = String.format(Locale.US, 
				"Insert into Pizzas(nom, prix, taille) "
		+ "values ('%s', %.2f, '%s')", 
		p.getNom(), 
		p.getPrix(), 
		p.getTaille());
		System.out.println(sql);
		try {
			dao.getStatement().executeUpdate(sql);
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public List<Pizza> getPizza(int nbPizza) {
		// TODO Auto-generated method stub
		return null;
	}

}
