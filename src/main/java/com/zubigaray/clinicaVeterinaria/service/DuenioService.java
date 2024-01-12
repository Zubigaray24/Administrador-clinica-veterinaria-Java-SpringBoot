package com.zubigaray.clinicaVeterinaria.service;

import com.zubigaray.clinicaVeterinaria.dto.DuenioMascotaDTO;
import com.zubigaray.clinicaVeterinaria.model.Duenio;
import com.zubigaray.clinicaVeterinaria.repository.IDuenioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{
    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public void saveDuenio(Duenio d) {
        duenioRepo.save(d);
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepo.deleteById(id);
    }

    @Override
    public void modifyDuenio(Duenio d) {
        this.saveDuenio(d);
        }

    @Override
    public Duenio getDuenio(Long id) {
        Duenio duenio = duenioRepo.findById(id).orElse(null);
        return duenio;
    }

    @Override
    public List<Duenio> getDuenios() {
        List<Duenio> duenios = new ArrayList<>();
        duenios = duenioRepo.findAll();
        return duenios;
    }
}
