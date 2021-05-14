package david.carprokat.services;

import david.carprokat.models.Client;
import david.carprokat.repositorys.CarRepository;
import david.carprokat.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void add(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElseGet(Client::new);
    }

    @Override
    public void remove(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return clientRepository.existsById(id);
    }
}
