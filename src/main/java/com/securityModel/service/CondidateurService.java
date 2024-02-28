package com.securityModel.service;


import com.securityModel.models.Condidateur;

import java.util.List;

public interface CondidateurService {

    Condidateur
    createCondidateur(Condidateur condidateur);
    List<Condidateur> allCondidateurs();
    Condidateur condidateurById(Long id);
    Condidateur updatecondidateur(Long id, Condidateur condidateur);
    void deletecondidateur(Long id);

}
