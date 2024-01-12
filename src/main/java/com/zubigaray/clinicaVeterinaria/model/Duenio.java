package com.zubigaray.clinicaVeterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Duenio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_duenio;
    
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    
    @OneToMany(mappedBy="duenio")
    private List<Mascota> listaMascotas;
       
}
