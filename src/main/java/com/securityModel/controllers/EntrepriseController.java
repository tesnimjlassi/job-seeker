package com.securityModel.controllers;

import com.securityModel.models.Entreprise;
import com.securityModel.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("entreprises")
@CrossOrigin("*")
public class EntrepriseController {
    @Autowired
    private EntrepriseService entrepriseService;
    @PostMapping("/add")
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise){return entrepriseService.createEntreprise(entreprise);}
    @GetMapping("/all")
    public List<Entreprise> entrepriseList(){
        return entrepriseService.allEntreprises();
    }
    @GetMapping("getone/{id}")
    public Entreprise entrepriseById(@PathVariable Long id){ return entrepriseService.entrepriseById(id);}
    @PutMapping("update/{id}")
    public Entreprise updateEntreprise(@PathVariable Long id,@RequestBody Entreprise entreprise){
        return entrepriseService.updateEntreprise(id,entreprise);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteEntreprise(@PathVariable Long id){
        Entreprise ent=entrepriseService.entrepriseById(id);
        HashMap message =new HashMap();
        if (ent!=null){
            try {
                entrepriseService.deleteEntreprise(id);
                message.put("etat","entreprise deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","entreprise not found");
            return message;
        }
    }
}
