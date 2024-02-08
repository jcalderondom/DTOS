package pruebaspring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pruebaspring.Model.Deporte;
import pruebaspring.Model.Persona;
import pruebaspring.dto.DeporteDTO;
import pruebaspring.dto.PersonaDeportistaDTO;
import pruebaspring.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pruebaspring.service.*;

@RestController
public class Controller {
    Service service =new Service();

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        return ResponseEntity.ok().body(service.getAllDeportes());

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {

        DeporteDTO existDeport = service.GetDeporte(name);

        if(existDeport != null) {
            return new ResponseEntity<String>(existDeport.getNivel(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("no existe deporte", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        List<PersonaDeportistaDTO> personadeportista = service.findSportsPersons();
        return new ResponseEntity<>(personadeportista, HttpStatus.OK);

    }






}
