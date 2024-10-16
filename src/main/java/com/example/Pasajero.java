package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Pasajero implements Comparable<Pasajero>{
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private Sexo sexo;

    public Long edad(){
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    public static List<Pasajero> getPasajeros()  {

        List<Pasajero> pasajeros = new ArrayList<>();

        pasajeros.add(
            Pasajero.builder()
                .nombre("Ruben")
                .primerApellido("Gomez")
                .segundoApellido("Sabio")
                .sexo(Sexo.HOMBRE)
                .fechaNacimiento(LocalDate.of(2000, Month.SEPTEMBER,23))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Juan")
                .primerApellido("Guerrero")
                .segundoApellido("Leon")
                .sexo(Sexo.HOMBRE)
                .fechaNacimiento(LocalDate.of(1997, Month.MAY,23))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Ivan")
                .primerApellido("Reina")
                .segundoApellido("Galvez")
                .sexo(Sexo.HOMBRE)
                .fechaNacimiento(LocalDate.of(2001, Month.OCTOBER, 10))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Antonio")
                .primerApellido("Saez")
                .segundoApellido("Vagace")
                .sexo(Sexo.HOMBRE)
                .fechaNacimiento(LocalDate.of(1990, Month.DECEMBER,3))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Marcos")
                .primerApellido("Perez")
                .segundoApellido("Serrano")
                .sexo(Sexo.HOMBRE)
                .fechaNacimiento(LocalDate.of(1996, Month.APRIL, 23))
                .build()
        );
        pasajeros.add(
            Pasajero.builder()
                .nombre("Elli")
                .primerApellido("Fdez")
                .segundoApellido("Hdez")
                .sexo(Sexo.MUJER)
                .fechaNacimiento(LocalDate.of(2005, Month.SEPTEMBER,14))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Paca")
                .primerApellido("Fdez")
                .segundoApellido("Hdez")
                .sexo(Sexo.MUJER)
                .fechaNacimiento(LocalDate.of(2004, Month.JULY,14))
                .build()
        );
        pasajeros.add(
            Pasajero.builder()
                .nombre("Elli")
                .primerApellido("Fdez")
                .segundoApellido("Mtnez")
                .sexo(Sexo.MUJER)
                .fechaNacimiento(LocalDate.of(2005, Month.SEPTEMBER,14))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Paca")
                .primerApellido("Mtnez")
                .segundoApellido("Hdez")
                .sexo(Sexo.MUJER)
                .fechaNacimiento(LocalDate.of(2004, Month.JULY,14))
                .build()
        );

        pasajeros.add(
            Pasajero.builder()
                .nombre("Marcos")
                .primerApellido("Serrano")
                .segundoApellido("Serrano")
                .sexo(Sexo.HOMBRE)
                .fechaNacimiento(LocalDate.of(1996, Month.APRIL, 23))
                .build()
        );

        return pasajeros;
    }

    @Override
    public int compareTo(Pasajero pasajero) {
        int cmpPrimerApellido = this.primerApellido.compareTo(pasajero.getPrimerApellido());
        int cmpSegundoApellido = this.segundoApellido.compareTo(pasajero.getSegundoApellido());
        int cmpNombre = this.nombre.compareTo(pasajero.getNombre());

        return cmpNombre != 0 ? cmpNombre : 
                       cmpPrimerApellido != 0 ? cmpPrimerApellido : cmpSegundoApellido;
    }
}
