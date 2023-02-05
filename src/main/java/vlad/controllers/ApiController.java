package vlad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlad.controllers.exceptions.SimpleWrapperForExceptions;
import vlad.entities.TransportType;
import vlad.services.Service;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private Service service;

    @GetMapping("/transport-types")
    private List<TransportType> showAllTransportTypes() {
        List<TransportType> result = service.getAllTranportTypes();
        return result;
    }

    @GetMapping("/transport-types/{id}")
    private TransportType showTransportTypeById(@PathVariable("id") long id) {
        TransportType result = service.getTransportTypeById(id);
        return result;
    }

    @PostMapping("/transport-types")
    private String postTransportType(@RequestBody TransportType transportType) {
        if(transportType.getId() != 0) {
            throw new RuntimeException("Body must be without id field");
        }
        service.save(transportType);
        return "Updated transport type";
    }

    @PutMapping("/transport-types")
    private String putTransportType(@RequestBody TransportType transportType) {
        service.save(transportType);
        return "Save a new transport type";
    }

    @DeleteMapping("/transport-types/{id}")
    private String deleteTransportType(@PathVariable("id") long id) {
        service.delete(id);
        return "Deleted transport type.";
    }
}
