package com.securityModel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "administrateurs")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "administrateur",cascade =CascadeType.ALL)
    @JsonIgnoreProperties("administrateur")
    @JoinColumn(name = "admin_id")
    private OffreDeEmploi offreDeEmploi;

    public OffreDeEmploi getOffreDeEmploi() {
        return offreDeEmploi;
    }

    public void setOffreDeEmploi(OffreDeEmploi offreDeEmploi) {
        this.offreDeEmploi = offreDeEmploi;
    }
}
