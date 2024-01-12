package com.zubigaray.clinicaVeterinaria.controller;

import com.zubigaray.clinicaVeterinaria.dto.DuenioMascotaDTO;
import com.zubigaray.clinicaVeterinaria.model.Mascota;
import com.zubigaray.clinicaVeterinaria.service.IMascotaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascoService;
    
    //alta
    @PostMapping("/mascota/alta")
    public String saveMascota(@RequestBody Mascota masco){
        mascoService.saveMascota(masco);
        return "La mascota se ha creado con exito!";
    }
    
    //baja
    @DeleteMapping("/mascota/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascoService.deleteMascota(id);
        return "La mascota se ha borrado con exito!";
    }
    
    //modificacion
    @PutMapping("/mascota/modificar")
    public String modifyMascota(@RequestBody Mascota masco){
        mascoService.saveMascota(masco);
        return "La mascota se ha modificado con exito!";
    }
    
    //lectura de un objeto
    @GetMapping("/mascota/traer/{id}")
    @ResponseBody
    public Mascota getMascota(@PathVariable Long id){
        return mascoService.getMascota(id);
    }
    
    //lectura de muchos objetos
    @GetMapping("/mascota/traerTodas")
    @ResponseBody
    public List<Mascota> getMascotas(){
        return  mascoService.getMascotas();
    }
    
    /*//lectura de objetos con "filtro"
    @GetMapping("/mascota/traerTodas/{palabraEspecie}/{palabraRaza}")
    public List<Mascota> getMascotasConFiltro(  @PathVariable String palabraEspecie, 
                                                @PathVariable String palabraRaza
                                             ){
        
        List<Mascota> listaMascotas = new ArrayList<>();
        listaMascotas = mascoService.getMascotasConFiltro(palabraEspecie, palabraRaza);
        
        return listaMascotas;
    }*/
    
    @GetMapping("/mascota/traerConFiltro/{especie}")
    public List<Mascota> getMascotasConFiltro(@PathVariable String especie) {
        return mascoService.getMascotasConFiltro(especie);
    }
    
    @GetMapping ("mascota/traerDuenios")
    public List<DuenioMascotaDTO> traerMascoDuenios () {
        return mascoService.getMascoDuenios();
    
    }

    
}
