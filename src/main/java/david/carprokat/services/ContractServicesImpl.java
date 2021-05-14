package david.carprokat.services;

import david.carprokat.models.Car;
import david.carprokat.models.Client;
import david.carprokat.models.Contract;
import david.carprokat.repositorys.CarRepository;
import david.carprokat.repositorys.ClientRepository;
import david.carprokat.repositorys.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServicesImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private  CarService carService;

    @Autowired
    private  ClientService clientService;

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    @Override
    public void add(Contract contractD) {
        Car car = carService.getById(contractD.getCar().getId());
        Client client = clientService.getById(contractD.getClient().getId());

        contractD.setCar(car);
        contractD.setClient(client);
        contractRepository.save(contractD);
    }

    @Override
    public void update(Contract contract) {
        this.add(contract);

    }

    @Override
    public Contract getById(Long id) {
        return contractRepository.findById(id).orElseGet(Contract::new);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return contractRepository.existsById(id);
    }
}
