package com.securityModel.service.impl;

import com.securityModel.models.Entreprise;
import com.securityModel.repository.EnterpriseRepository;
import com.securityModel.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Override
    public Entreprise createEntreprise(Entreprise entreprise){ return enterpriseRepository.save(entreprise);}
    @Override
    public List<Entreprise> allEntreprises(){return enterpriseRepository.findAll();}
    @Override
    public Entreprise entrepriseById(Long id){return enterpriseRepository.findById(id).orElseThrow(null);}
    @Override
    public Entreprise updateEntreprise(Long id,Entreprise entreprise){
        Entreprise prs=enterpriseRepository.findById(id).orElseThrow(null);
        if (prs!=null){
            entreprise.setId(id);
            return enterpriseRepository.save(entreprise);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteEntreprise(Long id){ enterpriseRepository.deleteById(id);}
}
