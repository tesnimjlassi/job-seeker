package com.securityModel.controllers;

import com.securityModel.models.Entretien;
import com.securityModel.service.EntertienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("entretiens")
@CrossOrigin("*")
public class EntretienController {
    @Autowired
    private EntertienService entertienService;
    @PostMapping("/add")
    public Entretien createEntretien(@RequestBody Entretien entretien){
        return entertienService.createEntretien(entretien);
    }
    @GetMapping("/all")
    public List<Entretien> entretienList()
    {return  entertienService.allEntretiens();}
    @GetMapping("getone/{id}")
    public Entretien entretienById(@PathVariable Long id){
        return entertienService.entretienById(id);
    }
    @PutMapping("update/{id}")
    public Entretien updateEntretien(@PathVariable Long id,@RequestBody Entretien entretien){
        return entertienService.updateEntretien(id,entretien);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String>deleteEntretien(@PathVariable Long id){
        Entretien ett=entertienService.entretienById(id);
        HashMap message=new HashMap();
        if (ett!=null){
            try {
                entertienService.deleteEntretien(id);
                message.put("etat","entretien deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","entretien not found");
            return message;
        }
    }
}
