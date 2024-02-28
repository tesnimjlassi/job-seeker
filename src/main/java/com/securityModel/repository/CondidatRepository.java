package com.securityModel.repository;

import com.securityModel.models.Condidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondidatRepository  extends JpaRepository<Condidat,Long> {
}
