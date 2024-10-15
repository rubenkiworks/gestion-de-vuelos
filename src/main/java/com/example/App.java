package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Ejercicio 1
        List<Vuelo> vuelos = Vuelo.getVuelos();
        vuelos.stream().filter(v -> v.getPasajeros().stream().count() == v.getNumeroPlazas())
        .collect(Collectors.toList());

        //Ejercicio 2
        vuelos.stream().filter(v -> v.getFechaSalida().equals(LocalDate.now()))
        .collect(Collectors.toList());

        //Ejercicio 3
        vuelos.stream().filter(v -> v.getDuracionVuelo() > 10)
        .collect(Collectors.toList());

        //Ejercicio 4
        vuelos.stream().filter(v -> v.getDuracionVuelo() > 24)
        .collect(Collectors.toList());

        //Ejercicio 5
        vuelos.stream().max(Comparator.comparing(v -> v)).ifPresent(maxInt->System.out.println(maxInt));
        
        
    }
}
