package com.zubigaray.clinicaVeterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mascota {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_mascota;
    
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    
    @ManyToOne
    @JoinColumn(name = "id_duenio")
    private Duenio duenio;
    
}
