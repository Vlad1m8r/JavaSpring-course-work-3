package david.carprokat.services;

import david.carprokat.models.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> getAll();
    public void add(Contract contract);
    public void update(Contract contract);
    public Contract getById(Long id);
    public void remove(Long id);
    public boolean exists(Long id);
}
