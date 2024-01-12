package com.zubigaray.clinicaVeterinaria.service;

import com.zubigaray.clinicaVeterinaria.dto.DuenioMascotaDTO;
import com.zubigaray.clinicaVeterinaria.model.Mascota;
import java.util.List;

public interface IMascotaService {
        
    //agregar
    public void saveMascota(Mascota m);
    
    //borrar
    public void deleteMascota(Long id);
    
    //modificar
    public void modifyMascota(Mascota m);
    
    //leer 1 elemento
    public Mascota getMascota(Long id);
    
    //leer muchos elementos
    public List<Mascota> getMascotas();
    
    //traer duenio con filtro
    public List<Mascota> getMascotasConFiltro(String especie);
    
    //dto
    public List<DuenioMascotaDTO> getMascoDuenios();
}
