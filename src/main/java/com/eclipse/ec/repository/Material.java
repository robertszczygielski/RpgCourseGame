package com.eclipse.ec.repository;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Material {

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    private Integer id;
    private String name;
    private Integer initiative;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getInitiative() {
        return initiative;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, initiative, name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Material other = (Material) obj;
        return id == other.id && initiative == other.initiative && Objects.equals(name, other.name);
    }
    @Override
    public String toString() {
        return "Material [id=" + id + ", name=" + name + ", initiative=" + initiative + "]";
    }

}

