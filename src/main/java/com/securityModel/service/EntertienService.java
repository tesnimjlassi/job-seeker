package com.securityModel.service;

import com.securityModel.models.Entretien;

import java.util.List;

public interface EntertienService {
    Entretien createEntretien( Entretien entretien);
    List<Entretien> allEntretiens();
    Entretien entretienById(Long id);
    Entretien updateEntretien(Long id ,Entretien entretien);
    void deleteEntretien(Long id);
}
