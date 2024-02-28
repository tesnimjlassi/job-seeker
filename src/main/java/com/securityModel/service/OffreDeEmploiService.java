package com.securityModel.service;

import com.securityModel.models.OffreDeEmploi;

import java.util.List;

public interface OffreDeEmploiService {
    OffreDeEmploi createOffre(OffreDeEmploi offreDeEmploi);
    List<OffreDeEmploi> allOffres();
    OffreDeEmploi offreById(Long id);
    OffreDeEmploi updateOffre(Long id,OffreDeEmploi offreDeEmploi);
    void deleteOffre(Long id);
}
