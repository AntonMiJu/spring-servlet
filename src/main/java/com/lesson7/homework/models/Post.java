package com.lesson7.homework.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POSTS")
public class Post {
    private Long id;
    private String name;
    private String description;
    private int price;
    private Currency currency;
    private Category category;
    private Subcategory subcategory;
    private String city;
    private String phone;
    private Date dateAvailableFrom;
    private Date dateAvailableTo;
    private Date dateCreated;
    private User userPosted;

    @Id
    @SequenceGenerator(name = "POST_SEQ", sequenceName = "SEQUENCE_ID",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY")
    public Currency getCurrency() {
        return currency;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    public Category getCategory() {
        return category;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "SUBCATEGORY")
    public Subcategory getSubcategory() {
        return subcategory;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    @Column(name = "DATE_FROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    @Column(name = "DATE_TO")
    public Date getDateAvailableTo() {
        return dateAvailableTo;
    }

    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUserPosted() {
        return userPosted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setDateAvailableTo(Date dateAvailableTo) {
        this.dateAvailableTo = dateAvailableTo;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setUserPosted(User userPosted) {
        this.userPosted = userPosted;
    }
}
