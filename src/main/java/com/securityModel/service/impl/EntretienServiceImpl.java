package com.securityModel.service.impl;

import com.securityModel.models.Entretien;
import com.securityModel.repository.EntretienRepository;
import com.securityModel.service.EntertienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienServiceImpl implements EntertienService {
    @Autowired
    EntretienRepository entretienRepository;
    @Override
    public Entretien createEntretien(Entretien entretien){ return entretienRepository.save(entretien);}
    @Override
    public List<Entretien> allEntretiens(){ return entretienRepository.findAll();}
    @Override
    public Entretien entretienById(Long id){ return entretienRepository.findById(id).orElseThrow(null);}
    @Override
    public Entretien updateEntretien(Long id,Entretien entretien){
        Entretien ent=entretienRepository.findById(id).orElseThrow(null);
        if (ent!=null){
            entretien.setId(id);
            return entretienRepository.save(entretien);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteEntretien(Long id){ entretienRepository.deleteById(id);}
}
