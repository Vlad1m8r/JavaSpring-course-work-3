package david.carprokat.controller;

import david.carprokat.models.Car;
import david.carprokat.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/car",  produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    @Autowired
    private CarService carService;

    //    Get
    @GetMapping()
    public ResponseEntity<?> getAllCar() {
        List<?> allCar = carService.getAll();
        return new ResponseEntity<>(allCar, HttpStatus.OK);
    }

    //get car
    @GetMapping("/static")
    public Map<String, Integer> getCarStatic() {
        Map<String, Integer> response = new HashMap<>();;

        for (Car c : this.carService.getAll()) {
            if (response.containsKey(c.getType())){
                response.put(c.getType(), response.get(c.getType())+1);
            } else
                response.put(c.getType(),1);
        }
        return response;
    }

    //    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Car car = carService.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }


    //    Post
    @PostMapping(value = "")
    public ResponseEntity<?> setCar(@RequestBody Car car){
        if (car == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        carService.add(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }


    //    Put
    @PutMapping(value = "")
    public ResponseEntity<?> updateCar(@RequestBody Car car){
        if (car == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        carService.update(car);
        return new ResponseEntity<>(car, HttpStatus.UPGRADE_REQUIRED);
    }


    //    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        carService.remove(id);
        return new ResponseEntity<>("Deleted Ok", HttpStatus.OK);
    }

}
