package com.zubigaray.clinicaVeterinaria.controller;

import com.zubigaray.clinicaVeterinaria.model.Duenio;
import com.zubigaray.clinicaVeterinaria.service.IDuenioService;
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
public class DuenioController {
    
    @Autowired
    private IDuenioService duenioService;
    
    //alta
    @PostMapping("/duenio/alta")
    public String saveDuenio(@RequestBody Duenio duenio){
        duenioService.saveDuenio(duenio);
        return "El dueño ha sido creado con exito!";
    }
    
    //baja
    @DeleteMapping("/duenio/borrar/{id}")
    public String deleteDuenio(@PathVariable Long id){
        duenioService.deleteDuenio(id);
        return "El dueño ha sido borrado con exito!";
    }
    
    //modificacion
    @PutMapping("/duenio/modificar")
    public String modifyDuenio(@RequestBody Duenio duenio){
        duenioService.saveDuenio(duenio);
        return "El dueño ha sido modificado con exito!";
    }
    
    //lectura de un objeto
    @GetMapping("/duenio/traer/{id}")
    @ResponseBody
    public Duenio getDuenio(@PathVariable Long id){
        return duenioService.getDuenio(id);
    }
    
    //lectura de muchos objetos
    @GetMapping("/duenio/traerTodos")
    @ResponseBody
    public List<Duenio> getDuenios(){
        List<Duenio> listaDuenios = new ArrayList<>();
        listaDuenios = duenioService.getDuenios();
        return listaDuenios;
    }
    
}
