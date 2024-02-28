package com.securityModel.service.impl;

import com.securityModel.models.OffreDeEmploi;
import com.securityModel.repository.OffreDeEmploiRepository;
import com.securityModel.service.OffreDeEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreDeEmploiServiceImpl implements OffreDeEmploiService {
@Autowired
    OffreDeEmploiRepository offreDeEmploiRepository;
@Override
    public OffreDeEmploi createOffre(OffreDeEmploi offreDeEmploi){ return offreDeEmploiRepository.save(offreDeEmploi);}
    @Override
    public List<OffreDeEmploi> allOffres(){ return offreDeEmploiRepository.findAll();}
    @Override
    public  OffreDeEmploi offreById(Long id){ return offreDeEmploiRepository.findById(id).orElseThrow(null);}
    @Override
    public OffreDeEmploi updateOffre(Long id,OffreDeEmploi offreDeEmploi){
    OffreDeEmploi off=offreDeEmploiRepository.findById(id).orElseThrow(null);
    if (off!=null){
        offreDeEmploi.setId(id);
        return offreDeEmploiRepository.save(offreDeEmploi);
    }else {
        throw new RuntimeException("Error!");
    }
    }
    @Override
    public void deleteOffre(Long id){
    offreDeEmploiRepository.deleteById(id);
    }
}
