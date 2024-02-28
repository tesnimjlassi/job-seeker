package com.securityModel.service;

import com.securityModel.models.Entreprise;

import java.util.List;

public interface EntrepriseService {
    Entreprise createEntreprise(Entreprise entreprise);
    List<Entreprise> allEntreprises();
    Entreprise entrepriseById(Long id);
    Entreprise updateEntreprise(Long id,Entreprise entreprise);
    void deleteEntreprise(Long id);
}
