package com.eclipse.ec.repository;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "enemy_type")
@Entity
public class EnemyType {

    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    private Integer id;
    private String name;
    @JoinColumn(name = "origin_id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Origin origin;

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

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnemyType other = (EnemyType) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(origin, other.origin);
    }

    @Override
    public String toString() {
        return "EnemyType [id=" + id + ", name=" + name + ", origin=" + origin + "]";
    }
}

