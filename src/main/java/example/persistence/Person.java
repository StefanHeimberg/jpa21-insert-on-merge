/*
 * Copyright 2015 Stefan Heimberg <kontakt@stefanheimberg.ch>.
 * 
 * All rights reserved.
 */
package example.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
@Entity
@NamedQueries(
        @NamedQuery(name = Person.FIND_ALL, query = "SELECT b FROM Person b")
)
public class Person implements Serializable {
    
    public static final String FIND_ALL = "Person.findAll";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName())
                .append("id=").append(id).append(", ")
                .append("name=").append(name)
                .toString();
    }
    
}
