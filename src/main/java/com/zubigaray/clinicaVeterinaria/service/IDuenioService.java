package com.zubigaray.clinicaVeterinaria.service;

import com.zubigaray.clinicaVeterinaria.model.Duenio;
import java.util.List;

public interface IDuenioService {
    
    //agregar
    public void saveDuenio(Duenio d);
    
    //borrar
    public void deleteDuenio(Long id);
    
    //modificar
    public void modifyDuenio(Duenio d);
    
    //leer 1 elemento
    public Duenio getDuenio(Long id);
    
    //leer muchos elementos
    public List<Duenio> getDuenios();
    
}
