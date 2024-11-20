package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enumation.TypeClient;
import model.ClientDto;
import model.PizzaDao;

public class ClientService implements IClientService {

	private PizzaDao dao = new PizzaDao();
	
	@Override
	public int ajouterClient(String nom, String prenom, LocalDate date_naissance, String type) {
		ClientDto dto = new ClientDto();
		dto.setNom(nom);
		dto.setPrenom(prenom);
		dto.setDate_naissance(date_naissance);
		dto.setType_client(TypeClient.valueOf(type));
		return ajouterClient(dto);
	}

	@Override
	public int ajouterClient(ClientDto client) {
		// TODO Auto-generated method stub
		String date = client.getDate_naissance().toString();
		String SQL = "INSERT INTO [dbo].[Clients]\r\n"
				+ "           ([nom]\r\n"
				+ "           ,[prenom]\r\n"
				+ "           ,[date_naissance]\r\n"
				+ "           ,[type])\r\n"
				+ "     VALUES\r\n"
				+ "           ('%s'\r\n"
				+ "           ,'%s'\r\n"
				+ "           ,'%s'\r\n"
				+ "           ,'%s')\r\n";
		SQL = String.format(SQL, client.getNom(), client.getPrenom(), date, client.getType_client().name());
		System.out.println(SQL);
		
		try {
			dao.getStatement().executeUpdate(SQL);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<ClientDto> getClients(int limit) {
		List<ClientDto> result = new ArrayList<>();
		// Faire une requete pour recuperer tout les client selon la limit
		String SQL = "Select top(%d) * FROM Clients";
		SQL = String.format(SQL, limit);
		System.out.println(SQL);
		try {
		ResultSet rs = dao.ExecuteQuery(SQL);
		while(rs.next()) {
			ClientDto dto = new ClientDto();
			dto.setNom(rs.getString("nom"));
			
				dto.setPrenom(rs.getString("prenom"));
		 	// cas date on convertie en LocalDate
			dto.setDate_naissance(rs.getDate("date_naissance").toLocalDate());
			dto.setID(rs.getInt("ID"));
			// cas enum on convertie le string en enum
			dto.setType_client(TypeClient.valueOf(rs.getString("type")));
			result.add(dto);
		} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return result;
	}

	@Override
	public float getAvgAgeByStatus(TypeClient type) {
		String SQL = "Select AVG (DATEDIFF (YEAR, date_naissance, GETDATE()))  "
				+ "from Clients GROUP BY type HAVING Clients.type = '%s'";
		SQL = String.format(SQL, type.name());
		System.out.println(SQL);
		ResultSet rs = dao.ExecuteQuery(SQL);
		
		try {
			if (rs.next())
				return rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
