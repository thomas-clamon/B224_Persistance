package interfaces;

import java.time.LocalDate;
import java.util.List;

import enumation.TypeClient;
import model.ClientDto;

public interface IClientService {
	
	int ajouterClient(String nom, String prenom, LocalDate date_naissance, String type );
	int ajouterClient(ClientDto client);
	List<ClientDto> getClients(int limit);
	float getAvgAgeByStatus (TypeClient type);

}
