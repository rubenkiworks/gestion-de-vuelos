package com.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Vuelo implements Comparable<Vuelo>{
    private String destino;
    private Double precio;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private LocalDate fechaLlegada;
    private LocalTime horaLlegada;
    private int numeroPlazas;
    private List<Pasajero> pasajeros;

    public static List<Vuelo> getVuelos() {
        List<Vuelo> vuelos = new ArrayList<>();

        List<Pasajero> pasajeros1 = new ArrayList<>();
        
        pasajeros1.add(Pasajero.builder()
        .nombre("Ruben")
        .primerApellido("Gomez")
        .segundoApellido("Sabio")
        .fechaNacimiento(LocalDate.of(1991, Month.APRIL, 2))
        .sexo(Sexo.HOMBRE)
        .build());

        pasajeros1.add(Pasajero.builder()
        .nombre("Maria")
        .primerApellido("Sanchez")
        .segundoApellido("Perez")
        .fechaNacimiento(LocalDate.of(1994, Month.JUNE, 27))
        .sexo(Sexo.MUJER)
        .build());

        pasajeros1.add(Pasajero.builder()
        .nombre("Martina")
        .primerApellido("Jimenez")
        .segundoApellido("Lopez")
        .fechaNacimiento(LocalDate.of(1990, Month.SEPTEMBER, 12))
        .sexo(Sexo.MUJER)
        .build());

        List<Pasajero> pasajeros2 = new ArrayList<>();
        
        pasajeros2.add(Pasajero.builder()
        .nombre("Antonio")
        .primerApellido("Saez")
        .segundoApellido("Vegace")
        .fechaNacimiento(LocalDate.of(1980, Month.JANUARY, 2))
        .sexo(Sexo.HOMBRE)
        .build());

        pasajeros2.add(Pasajero.builder()
        .nombre("Micaela")
        .primerApellido("Jimenez")
        .segundoApellido("Lopez")
        .fechaNacimiento(LocalDate.of(1990, Month.SEPTEMBER, 12))
        .sexo(Sexo.MUJER)
        .build());


        vuelos.add(Vuelo.builder().destino("Tokyo")
        .precio(600.99)
        .fechaSalida(LocalDate.of(2024, Month.NOVEMBER, 1))
        .horaSalida(LocalTime.of(7, 45))
        .fechaLlegada(LocalDate.of(2024, Month.NOVEMBER, 2))
        .horaLlegada(LocalTime.of(7, 50))
        .numeroPlazas(3)
        .pasajeros(pasajeros1)
        .build());

        vuelos.add(Vuelo.builder().destino("Barcelona")
        .precio(100.99)
        .fechaSalida(LocalDate.of(2024, Month.OCTOBER, 18))
        .horaSalida(LocalTime.of(7, 45))
        .fechaLlegada(LocalDate.of(2024, Month.OCTOBER, 18))
        .horaLlegada(LocalTime.of(9, 50))
        .numeroPlazas(3)
        .pasajeros(pasajeros2)
        .build());

        vuelos.add(Vuelo.builder().destino("Roma")
        .precio(125.99)
        .fechaSalida(LocalDate.of(2024, Month.OCTOBER, 17))
        .horaSalida(LocalTime.of(7, 45))
        .fechaLlegada(LocalDate.of(2024, Month.OCTOBER, 17))
        .horaLlegada(LocalTime.of(10, 50))
        .numeroPlazas(3)
        .pasajeros(pasajeros1)
        .build());

        vuelos.add(Vuelo.builder().destino("Roma")
        .precio(125.99)
        .fechaSalida(LocalDate.now())
        .horaSalida(LocalTime.of(18, 20))
        .fechaLlegada(LocalDate.now())
        .horaLlegada(LocalTime.of(21, 50))
        .numeroPlazas(3)
        .pasajeros(pasajeros2)
        .build());
        
        return vuelos;
    }

    public Long getDuracionVuelo(){
        return ChronoUnit.HOURS.between(fechaSalida.atTime(horaSalida), fechaLlegada.atTime(horaLlegada));
    }

    @Override
    public int compareTo(Vuelo vuelo) {
        int cmpPrecio = this.precio.compareTo(vuelo.getPrecio());

        return cmpPrecio != 0 ? cmpPrecio : 0;
    }
}
