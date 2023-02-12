package org.agoncal.quarkus.panache.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CD extends Item {

    @Column(name = "music_company")
    public String musicCompany;
    @Column(length = 100)
    public String genre;
}
