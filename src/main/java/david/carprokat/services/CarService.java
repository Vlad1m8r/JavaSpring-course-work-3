package david.carprokat.services;

import david.carprokat.models.Car;
import david.carprokat.models.Client;

import java.util.List;

public interface CarService {
    public List<Car> getAll();
    public void add(Car car);
    public void update(Car car);
    public Car getById(Long id);
    public void remove(Long id);
    public boolean exists(Long id);
}
