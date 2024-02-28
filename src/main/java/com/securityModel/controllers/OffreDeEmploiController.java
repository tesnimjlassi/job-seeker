package com.securityModel.controllers;

import com.securityModel.models.OffreDeEmploi;
import com.securityModel.service.OffreDeEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("offresdemploi")
@CrossOrigin("*")
public class OffreDeEmploiController {
    @Autowired
    private OffreDeEmploiService offreDeEmploiService;
    @PostMapping("/add")
    public OffreDeEmploi createOffre(@RequestBody OffreDeEmploi offreDeEmploi){
        return  offreDeEmploiService.createOffre(offreDeEmploi);
    }
    @GetMapping("/all")
    public List<OffreDeEmploi> offreDeEmploiList(){
        return  offreDeEmploiService.allOffres();
    }
    @GetMapping("getone/{id}")
    public OffreDeEmploi offreById(@PathVariable Long id){
        return offreDeEmploiService.offreById(id);
    }
    @PutMapping("update/{id}")
    public OffreDeEmploi updateOffre(@PathVariable Long id,@RequestBody OffreDeEmploi offreDeEmploi){
        return offreDeEmploiService.updateOffre(id,offreDeEmploi);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteOffre(@PathVariable Long id){
        OffreDeEmploi off=offreDeEmploiService.offreById(id);
        HashMap message=new HashMap();
        if (off!=null){
            try {
                offreDeEmploiService.deleteOffre(id);
                message.put("etat","offre d'emploi deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","offre d'emploi not found");
            return message;
        }
    }
}
