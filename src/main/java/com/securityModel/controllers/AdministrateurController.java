package com.securityModel.controllers;

import com.securityModel.models.Administrateur;
import com.securityModel.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("administrateurs")
@CrossOrigin("*")
public class AdministrateurController {
    @Autowired
    private AdministrateurService administrateurService;
    @PostMapping("/add")
    public Administrateur createAdmin(@RequestBody Administrateur administrateur){
        return administrateurService.createAdmin(administrateur);

    }
    @GetMapping("/all")
    public List<Administrateur> administrateurList(){
        return administrateurService.allAdmins();
    }
    @GetMapping("getone/{id}")
    public Administrateur adminById(@PathVariable Long id){
        return administrateurService.adminById(id);
    }
    @PutMapping("update/{id}")
    public Administrateur updateAdmin(@PathVariable Long id,@RequestBody Administrateur administrateur){
        return administrateurService.updateAdmin(id,administrateur);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteAdmin(@PathVariable Long id){
        Administrateur ad=administrateurService.adminById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                administrateurService.deleteAdmin(id);
                message.put("etat"," admin deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","admin nit found");
            return message;
        }
    }
}
