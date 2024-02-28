package com.securityModel.repository;


import com.securityModel.models.Condidateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondidateurRepository extends JpaRepository<Condidateur,Long> {
}
