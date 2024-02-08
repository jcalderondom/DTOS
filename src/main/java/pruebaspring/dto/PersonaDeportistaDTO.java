package pruebaspring.dto;
import pruebaspring.Model.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private List<String> Nombredeportes = new ArrayList<String>();


    public PersonaDeportistaDTO(Persona persona){
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        persona.getDeportes().forEach(deporte -> this.Nombredeportes.add(deporte.getNombre()));
    }


}
