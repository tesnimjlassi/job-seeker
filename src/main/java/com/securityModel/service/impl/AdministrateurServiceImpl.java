package com.securityModel.service.impl;

import com.securityModel.models.Administrateur;
import com.securityModel.repository.AdministrateurRepository;
import com.securityModel.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {
    @Autowired
    AdministrateurRepository administrateurRepository;
    @Override
    public Administrateur createAdmin(Administrateur administrateur){ return administrateurRepository.save(administrateur);}
    @Override
    public List<Administrateur> allAdmins(){ return administrateurRepository.findAll();}
    @Override
    public Administrateur adminById(Long id){ return administrateurRepository.findById(id).orElseThrow(null);}
    @Override
    public Administrateur updateAdmin(Long id,Administrateur administrateur){
        Administrateur ad=administrateurRepository.findById(id).orElseThrow(null);
        if(ad!=null){
            administrateur.setId(id);
            return administrateurRepository.save(administrateur);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteAdmin(Long id){
        administrateurRepository.deleteById(id);
    }
}

