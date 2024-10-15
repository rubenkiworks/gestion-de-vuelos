package com.example;

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
        vuelos.stream().filter(v -> v.getPasajeros().stream().count() == 3).forEach(System.out::println);

        
    }
}
