package com.lesson4.homework.entity;

import javax.persistence.*;

@Entity
@Table(name = "FILES")
public class File {
    private long id;
    private String name;
    private String format;
    private long size;
    private Storage storage;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME_F")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FORMAT_F")
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Column(name = "SIZE_F")
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @JoinColumn(name = "STORAGE_ID")
    @OneToOne(cascade = CascadeType.ALL)
    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
