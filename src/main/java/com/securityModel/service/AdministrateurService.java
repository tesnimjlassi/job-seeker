package com.securityModel.service;

import com.securityModel.models.Administrateur;

import java.util.List;

public interface AdministrateurService {
    Administrateur createAdmin(Administrateur administrateur);
    List<Administrateur> allAdmins();
    Administrateur adminById(Long id);
    Administrateur updateAdmin(Long id,Administrateur administrateur);
    void deleteAdmin(Long id);
}
