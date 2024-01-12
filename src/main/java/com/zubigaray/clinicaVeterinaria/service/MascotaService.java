package com.zubigaray.clinicaVeterinaria.service;

import com.zubigaray.clinicaVeterinaria.dto.DuenioMascotaDTO;
import com.zubigaray.clinicaVeterinaria.model.Mascota;
import com.zubigaray.clinicaVeterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService{
    
    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public void saveMascota(Mascota m) {
        mascoRepo.save(m);
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepo.deleteById(id);
    }

    @Override
    public void modifyMascota(Mascota m) {
        this.saveMascota(m);
    }

    @Override
    public Mascota getMascota(Long id) {
        return mascoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascoRepo.findAll();
    }

    /*@Override
    public List<Mascota> getMascotasConFiltro(String especie, String raza) {
        
        List<Mascota> mascotas = new ArrayList<>();
        mascotas = this.getMascotas();
        
        List<Mascota> resultado = new ArrayList<>();
        
        if(mascotas != null){
            for(Mascota m : mascotas){
                if((m.getEspecie() != null && m.getEspecie().contains(especie))&&(m.getRaza() != null && m.getRaza().contains(raza))){
                    resultado.add(m);
                }
            }
        }
        
        return resultado;
    }*/
    
    @Override
    public List<Mascota> getMascotasConFiltro(String especie) {
        List<Mascota> todasLasMascotas = new ArrayList<>();
        todasLasMascotas = this.getMascotas();
        
        List<Mascota> resultado = new ArrayList<>();
        
        for(Mascota masco : todasLasMascotas){
            if( masco.getEspecie().contains(especie)){
                resultado.add(masco);
            }
        }
        
        return resultado;
    }

    @Override
    public List<DuenioMascotaDTO> getMascoDuenios() {
        
        List<Mascota> listaMascotas = this.getMascotas();
        List<DuenioMascotaDTO> listaMascoDuenio = new ArrayList<DuenioMascotaDTO>();
        DuenioMascotaDTO masco_duenio = new DuenioMascotaDTO();
        
        for (Mascota masco : listaMascotas) {
            
            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());
            
            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new DuenioMascotaDTO();//reseteo
        }
        return listaMascoDuenio;
    }
}
