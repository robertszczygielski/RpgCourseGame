package com.eclipse.ec.repository;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Weapon {

    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    private Integer id;
    private String name;
    @Column(name = "hit_points")
    private Integer hitPoints;
    @JoinColumn(name = "material_id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.MERGE)
    private Material material;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitPoints, id, material, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Weapon other = (Weapon) obj;
        return hitPoints == other.hitPoints && id == other.id && Objects.equals(material, other.material)
                && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Wapen [id=" + id + ", name=" + name + ", hitPoints=" + hitPoints + ", material=" + material + "]";
    }

}
