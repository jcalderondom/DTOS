package pruebaspring.service;

import pruebaspring.Model.Deporte;
import pruebaspring.Model.Persona;
import pruebaspring.dto.DeporteDTO;
import pruebaspring.dto.PersonaDeportistaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public static List<Deporte> listaDeportes = new ArrayList<>();
    public static List<Persona> listaPersonas =new ArrayList<>();
    public List<DeporteDTO> getAllDeportes() {
        Deporte deporte1 = new Deporte("basquet", "Principiante");
        Deporte deporte2 = new Deporte("futbol", "Intermedio");
        listaDeportes.add(deporte1);
        listaDeportes.add(deporte2);
        return listaDeportes.stream().map(DeporteDTO::new).collect(Collectors.toList());

    }

    public DeporteDTO GetDeporte(String name){
        Deporte deporte1 = new Deporte("basquet", "Principiante");
        Deporte deporte2 = new Deporte("futbol", "Intermedio");
        listaDeportes.add(deporte1);
        listaDeportes.add(deporte2);
        Deporte existDeport = listaDeportes.stream()
                .filter(deporte -> deporte.getNombre().equals(name))
                .findFirst()
                .orElse(null);

        return new DeporteDTO(existDeport);

    }

    public List<PersonaDeportistaDTO> findSportsPersons() {
        Deporte deporte1 = new Deporte("basquet", "Principiante");
        Deporte deporte2 = new Deporte("futbol", "Intermedio");
        listaDeportes.add(deporte1);
        listaDeportes.add(deporte2);
        Persona persona1 = new Persona("sergio", "mancilla", 24, listaDeportes);
        listaPersonas.add(persona1);
        return listaPersonas.stream().filter(p -> !p.getDeportes().isEmpty()).map(PersonaDeportistaDTO::new).collect(Collectors.toList());

       // List<PersonaDeportistaDTO> listaDeportistas = new ArrayList<>();
        //listaDeportistas.add(personaDeportistaDTO1);

        //return listaDeportistas;
    }
}
