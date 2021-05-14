package david.carprokat.controller;

import david.carprokat.models.Contract;
import david.carprokat.services.ContractService;
import david.carprokat.services.ContractServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/contract", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractController {

    @Autowired
    private ContractService contractService;

    //    Get
    @GetMapping()
    public ResponseEntity<?> getAllContract() {
        List<?> allContract = contractService.getAll();
        return new ResponseEntity<>(allContract, HttpStatus.OK);
    }


    //    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getContractById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contract contract = contractService.getById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


    //    Post
    @PostMapping(value = "")
    public ResponseEntity<?> setContract(@RequestBody Contract contract){
        if (contract == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        contractService.add(contract);
        return new ResponseEntity<>(contract, HttpStatus.CREATED);
    }


    //    Put
    @PutMapping(value = "")
    public ResponseEntity<?> updateContract(@RequestBody Contract contract){
        if (contract == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        contractService.update(contract);
        return new ResponseEntity<>(contract, HttpStatus.UPGRADE_REQUIRED);
    }


    //    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        contractService.remove(id);
        return new ResponseEntity<>("Deleted Ok", HttpStatus.OK);
    }

}
