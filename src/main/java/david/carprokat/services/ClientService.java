package david.carprokat.services;

import david.carprokat.models.Client;
import david.carprokat.models.Contract;

import java.util.List;

public interface ClientService {
    public List<Client> getAll();
    public void add(Client client);
    public void update(Client client);
    public Client getById(Long id);
    public void remove(Long id);
    public boolean exists(Long id);
}
