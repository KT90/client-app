package com.test.assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Sector {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_sector_id")
    private Sector parentSector;

    @OneToMany(mappedBy = "parentSector")
    private List<Sector> subSectors;

    @ManyToMany(mappedBy = "sectors")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
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

    public Sector getParentSector() {
        return parentSector;
    }

    public void setParentSector(Sector parentSector) {
        this.parentSector = parentSector;
    }

    public List<Sector> getSubSectors() {
        return subSectors;
    }

    public void setSubSectors(List<Sector> subSectors) {
        this.subSectors = subSectors;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        if (this.name.equals(((Sector) object).name) && this.id == ((Sector) object).id) {
            return true;
        } else {
            return false;
        }
    }
}
