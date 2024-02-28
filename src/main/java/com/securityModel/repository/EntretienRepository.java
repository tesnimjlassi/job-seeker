package com.securityModel.repository;

import com.securityModel.models.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienRepository  extends JpaRepository<Entretien,Long> {
}
