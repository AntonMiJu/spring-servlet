package com.lesson5;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {
    private Long id;
    private String description;

    @Id
    @SequenceGenerator(name = "HOT_SEQ", sequenceName = "SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOT_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
