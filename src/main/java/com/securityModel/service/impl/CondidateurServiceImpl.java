package com.securityModel.service.impl;


import com.securityModel.models.Condidateur;
import com.securityModel.repository.CondidateurRepository;
import com.securityModel.service.CondidateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondidateurServiceImpl implements CondidateurService {
    @Autowired
    CondidateurRepository condidateurRepository;
    @Override
    public Condidateur
    createCondidateur(Condidateur condidateur){
        return condidateurRepository.save(condidateur);
    }
    @Override
    public List<Condidateur>allCondidateurs(){
        return condidateurRepository.findAll();
    }
    @Override
    public Condidateur
    condidateurById(Long id){
        return condidateurRepository.findById(id).orElseThrow(null);
    }
    @Override
    public Condidateur
    updatecondidateur(Long id,Condidateur condidateur){
        Condidateur cat=condidateurRepository.findById(id).orElseThrow(null);
        if (cat!=null){
            condidateur.setId(id);
            return condidateurRepository.save(condidateur);
        }else {
            throw new RuntimeException("Error!");
        }

    }
    @Override
    public void deletecondidateur(Long id){
        condidateurRepository.deleteById(id);
    }
}
