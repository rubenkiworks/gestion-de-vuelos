package com.example;

import java.time.LocalDate;
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
        List<Vuelo> vuelosLlenos = vuelos.stream().filter(v -> v.getPasajeros().stream().count() == v.getNumeroPlazas())
                .collect(Collectors.toList());
        System.out.println("ejercicio 1 (vuelos llenos): " + vuelosLlenos);

        //Ejercicio 2
        List<Vuelo> vuelosHoy = vuelos.stream().filter(v -> v.getFechaSalida().equals(LocalDate.now()))
                .collect(Collectors.toList());
        System.out.println("ejercicio 2 (vuelos hoy): " + vuelosHoy);

        //Ejercicio 3
        List<Vuelo> vuelosMasDiezHoras = vuelos.stream().filter(v -> v.getDuracionVuelo() > 10)
                .collect(Collectors.toList());
        System.out.println("ejercicio 3 (vuelos +10 horas): " + vuelosMasDiezHoras);

        //Ejercicio 4
        List<Vuelo> vuelosMasVenticuatroHoras = vuelos.stream().filter(v -> v.getDuracionVuelo() > 24)
                .collect(Collectors.toList());
        System.out.println("ejercicio 4 (vuelos +24 horas): " + vuelosMasVenticuatroHoras);

        //Ejercicio 5
        System.out.println("ejercicio 5 (vuelo mas caro): ");
        vuelos.stream().max(Comparator.comparing(v -> v)).ifPresent(maxInt -> System.out.println(maxInt));

        //Ejercicio 6
        System.out.println("Ejercicio 6");
        Map<String, List<Vuelo>> pasajerosPorDestino = vuelos.stream()
                .collect(Collectors.groupingBy(vuelo -> vuelo.getDestino()));

        pasajerosPorDestino.entrySet().stream().forEach(entry -> {
            System.out.println("Para el destino " + entry.getKey());

            entry.getValue().stream().
                    forEach(entry2 -> entry2.getPasajeros().stream().forEach(System.out::println));
        });

        // Ejercicio 7
        List<Vuelo> vuelosUltimosDiezDiasDelMes = vuelos.stream().filter(v -> v.getFechaSalida().getMonth().
                equals(v.getFechaSalida().plusDays(11).getMonth()) == false)
                .collect(Collectors.toList());
        System.out.println("ejercicio 7 (vuelos que salen en los ultimos 10 dias del mes): " + vuelosUltimosDiezDiasDelMes);

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

        // Ejercicio 9
        //pasajerosPorEdadSexo.entrySet()

    }
}
