package com.zubigaray.clinicaVeterinaria.repository;

import com.zubigaray.clinicaVeterinaria.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio, Long>{
    
}
