package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom_serie")
    private String name;
    @Column(name="nb_episode_serie")
    private int nbepisode;
    @Column(name="nb_saison_serie")
    private int nbsaison;

    public Serie(){

    }

    public Serie(String name, int nbepisode, int nbsaison) {
        this.name = name;
        this.nbepisode = nbepisode;
        this.nbsaison = nbsaison;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbepisode() {
        return nbepisode;
    }

    public void setNbepisode(int nbepisode) {
        this.nbepisode = nbepisode;
    }

    public int getNbsaison() {
        return nbsaison;
    }

    public void setNbsaison(int nbsaison) {
        this.nbsaison = nbsaison;
    }
}
