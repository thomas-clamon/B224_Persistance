package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String request = String.format("SELECT TOP(%d) * FROM Pizzas", nbPizza);
		System.out.println(request);
		List<Pizza> list = new ArrayList();
		ResultSet rs = dao.ExecuteQuery(request);
		try {
			while (rs.next()) {
				String nom = rs.getString(2);
				float prix = rs.getFloat(3);
				String taille = rs.getString(4);
				Pizza p = new Pizza(nom, prix, taille);
				
				// on ajoute l'ID
				p.setID(rs.getInt(1));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean existByID(int id) {
		
		String request = String.format("SELECT count(*) FROM Pizzas WHERE ID = %d", id);
		
		ResultSet rs = dao.ExecuteQuery(request);
		try {
			while(rs.next()) {
				return (rs.getInt(1) == 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public int deleteByID(int id) {
		// on verifit que l'ID exite
		boolean exist = this.existByID(id);
		
		// si il existe pas on renvoi -2
		if (!exist)
			return -2;
		else
			{ 
				String request = String.format("Delete FROM Pizzas WHERE ID = %d", id);
				System.out.println(request);
				try {
					dao.getStatement().executeUpdate(request);
					return 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return -1;
				}
			}
	}

}
