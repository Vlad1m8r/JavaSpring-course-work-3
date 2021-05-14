package david.carprokat.controller;


import david.carprokat.models.Client;
import david.carprokat.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/client",  produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientService clientService;

    //    Get
    @GetMapping()
    public ResponseEntity<?> getAllClient() {
        List<?> allClient = clientService.getAll();
        return new ResponseEntity<>(allClient, HttpStatus.OK);
    }


    //    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Client client = clientService.getById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    //    Post
    @PostMapping(value = "")
    public ResponseEntity<?> setClient(@RequestBody Client client){
        if (client == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clientService.add(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }


    //    Put
    @PutMapping(value = "")
    public ResponseEntity<?> updateClient(@RequestBody Client client){
        if (client == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clientService.update(client);
        return new ResponseEntity<>(client, HttpStatus.UPGRADE_REQUIRED);
    }


    //    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clientService.remove(id);
        return new ResponseEntity<>("Deleted Ok", HttpStatus.OK);
    }
}
