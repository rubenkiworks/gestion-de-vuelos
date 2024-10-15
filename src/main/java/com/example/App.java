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
public class App {

    public static void main(String[] args) {
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
        vuelos.stream().max(Comparator.comparing(v -> v)).ifPresent(maxInt -> System.out.println(maxInt));

        //Ejercicio 6
        Map<String, List<Vuelo>> pasajerosPorDestino = vuelos.stream()
                .collect(Collectors.groupingBy(vuelo -> vuelo.getDestino()));

        pasajerosPorDestino.entrySet().stream().forEach(entry -> {
            System.out.println("Para el destino " + entry.getKey());

            entry.getValue().stream().
                    forEach(entry2 -> entry2.getPasajeros().stream().forEach(System.out::println));
        });

        // Ejercicio 7
        vuelos.stream().filter(v -> v.getFechaSalida().getMonth().
                equals(v.getFechaSalida().plusDays(10).getMonth()))
                .collect(Collectors.toList());

        //Ejercicio 8
        System.out.println("ejeercicio 8");
        List<Pasajero> pasajeros = Pasajero.getPasajeros();
        var pasajerosPorEdadSexo = pasajeros.stream()
                .collect(Collectors.groupingBy(p -> p.getSexo(), Collectors.groupingBy(Pasajero::edad)));
        
            pasajerosPorEdadSexo.entrySet().stream().forEach(entry1 -> {
            System.out.println("Por sexo: " + entry1.getKey());
            Map<Long, List<Pasajero>> entry2 = entry1.getValue();

            entry2.entrySet().stream().forEach(entry -> {
                System.out.println("Por edad: " + entry.getKey());

                entry.getValue().stream().forEach(System.out::println);

            });
        });

        
    }
}
