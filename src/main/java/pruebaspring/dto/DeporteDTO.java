package pruebaspring.dto;
import pruebaspring.Model.*;
import lombok.Data;

@Data
public class DeporteDTO {
    private String nombre;
    private String nivel;
    public DeporteDTO(Deporte deporte){
        this.nombre = deporte.getNombre();;
        this.nivel = deporte.getNivel();
    }

}
