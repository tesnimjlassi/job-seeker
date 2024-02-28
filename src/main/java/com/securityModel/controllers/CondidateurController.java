package com.securityModel.controllers;

import com.securityModel.models.Condidateur;
import com.securityModel.service.CondidateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("condidateurs")
@CrossOrigin("*")
public class CondidateurController {
    @Autowired
    private CondidateurService condidateurService;
    @PostMapping("/add")
    public Condidateur createCondidateur(@RequestBody Condidateur condidateur){return condidateurService.createCondidateur(condidateur);}
    @GetMapping("/all")
    public List<Condidateur> condidateurList(){
        return condidateurService.allCondidateurs();

    }
    @GetMapping("getone/{id}")
    public Condidateur condidateurById(@PathVariable Long id ){return condidateurService.condidateurById(id);}

    @PutMapping("update/{id}")
    public  Condidateur updatecondidateur(@PathVariable Long id,@RequestBody Condidateur condidateur){
        return condidateurService.updatecondidateur(id,condidateur);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deletecondidateur (@PathVariable Long id){
        Condidateur con=condidateurService.condidateurById(id);
        HashMap message = new HashMap();
        if (con!=null){
            try{
                condidateurService.deletecondidateur(id);
                message.put("etat","condidateur deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","condidateur not found");
            return message;
        }
    }
}
